package demo1;

public class MyQueue {
    private int[] array;
    private int front = 0;
    private int back = 0;
    private int size = 0;

    MyQueue() {
        this.array = new int[10];
    }

    MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    public void offer(int value) {
        size++;
        array[back++] = value;
        if (back == array.length) back = 0;
    }

    public int poll() {
        if (size() == 0) {
            throw new RuntimeException("空");
        }
        size--;
        int val = array[front++];
        if (front == array.length) front = 0;
        return val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public static void main(String[] args) {
        MyQueue q = new MyQueue(100);
        q.offer(1);
        q.offer(3);
        q.offer(4);
        q.offer(6);
        q.offer(23);

        while (!q.isEmpty()) {
            System.out.println(q.poll() + "size is :" + q.size());
        }
    }
}
