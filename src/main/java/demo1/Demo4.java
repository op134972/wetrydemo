package demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo4 {
    ReadWriteLock rwl = new ReentrantReadWriteLock();
    Lock rlock = rwl.readLock();
    Lock wlock = rwl.writeLock();

    StringBuffer book = new StringBuffer();

    public static void main(String[] args) {
        final Demo4 d4 = new Demo4();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    d4.put(Thread.currentThread().getName()+Thread.currentThread().getId()+"ccc");
                }
            },"writer").start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+Thread.currentThread().getId()+d4.read());
                }
            },"reader").start();
        }

    }

    public void put(String str) {
        try {
            wlock.lock();
            book.append(str);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            wlock.unlock();
        }
    }

    public String read(){
        String co = null;
        try{
            rlock.lock();
            Thread.sleep(1000);
            co = book.toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rlock.unlock();
            return co;
        }
    }
}
