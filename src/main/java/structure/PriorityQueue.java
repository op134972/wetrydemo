package structure;

public class PriorityQueue {

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.offer(2);
        queue.offer(3);
        queue.offer(1);

        System.out.println(queue.poll());
    }

    private static int[] arr;

    private int size;
    private static final int INITIAL_CAPACITY = 10;

    PriorityQueue() {
        this.arr = new int[INITIAL_CAPACITY];
    }

    private void percDown(int[] arr, int hole, int end) {
        int val = arr[hole];
        int child;
        for (; leftChild(hole) <= end; hole = child) {
            child = leftChild(hole);
            if (child + 1 <= end && arr[child + 1] > arr[child]) {
                child++;
            }
            if (arr[child] < val) {
                arr[hole] = arr[child];
            } else {
                break;
            }
        }
        arr[hole] = val;
    }

    private int leftChild(int child) {
        return child * 2 + 1;
    }

    private void percUp(int[] arr, int hole, int end) {
        int insert = arr[hole];
        int father;
        for (; father(hole) >= end; hole = father) {
            father = father(hole);
            if (arr[father] > insert) {
                arr[hole] = arr[father];
            } else {
                break;
            }
        }
        arr[hole] = insert;
    }

    private int father(int child) {
        return (child - 1) / 2;
    }

    public void offer(int val) {
//up
        arr[size++] = val;
        percUp(arr, size-1, 0);

    }

    public int poll() {
        int val = arr[0];
        arr[0] = arr[--size];
        percDown(arr, 0, size-1);
        return val;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size() == 0;
    }
}
