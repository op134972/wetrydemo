package juc;

import java.util.concurrent.Semaphore;

/**
 * @Author: tangwenchuan
 * @Date: 2020-07-23 00:51
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        System.out.println("release call");
        semaphore.release();
        System.out.println(semaphore.availablePermits());
        semaphore.release();
        System.out.println(semaphore.availablePermits());
        semaphore.release();
        System.out.println(semaphore.availablePermits());
        semaphore.release();
        System.out.println(semaphore.availablePermits());
        semaphore.release();
        System.out.println(semaphore.availablePermits());
        semaphore.release();
        System.out.println(semaphore.availablePermits());

        System.out.println("release done");

        try {
            System.out.println(semaphore.availablePermits());
            System.out.println("acquire call");
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            System.out.println("acquire done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
