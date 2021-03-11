package lc.q4;

import utils.RandomUtils;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-21 17:04
 */
public class Heap {

    private static final int DEFAULT_SIZE = 4;

    //构建小顶堆
    private int[] arr;
    private int size;

    public void push(int val) {
        if (arr == null) {
            arr = new int[DEFAULT_SIZE];
        }
        if (size == arr.length) {
            //扩容
            expandSize();
        }
        int topVal = arr[0];
        if (val < topVal) {
            //比最顶小
            arr[0] = val;
            arr[size++] = topVal;
            //调整顺序
            up(size - 1);
        } else {
            arr[size++] = val;
            up(size - 1);
        }
    }

    private void expandSize() {
        int[] temp = arr;
        arr = new int[size * 2];
        if (temp.length >= 0) System.arraycopy(temp, 0, arr, 0, temp.length);
    }

    //小的往上冒
    private void up(int start) {
        while (start >= 1) {
            int parentIndex = (start - 1) / 2;
            if (parentIndex >= 0 && arr[parentIndex] > arr[start]) {
                exchange(arr, parentIndex, start);
                start = parentIndex;
            } else {
                break;
            }
        }
    }

    private void exchange(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public int get() {
        if (size <= 0) {
            throw new RuntimeException("arr emp");
        }
        if (size == 1) {
            return arr[--size];
        }
        int res = arr[0];
        arr[0] = arr[--size];
        down();
        return res;
    }

    //大的往下冒
    private void down() {
        int start = 0;
        while (start < size) {
            int left = start * 2 + 1;
            int right = start * 2 + 2;

            int exchangIndex;
            if (left >= size) {
                break;
            } else if (right >= size) {
                exchangIndex = left;
            } else if (arr[left] < arr[right]) {
                exchangIndex = left;
            } else {
                exchangIndex = right;
            }
            if (arr[start] > arr[exchangIndex]) {
                exchange(arr, start, exchangIndex);
                start = exchangIndex;
            }else{
                break;
            }
        }
    }


    public static void main(String[] args) {
        Heap heap = new Heap();
        for (int i = 0; i < 10000; i++) {
            int i1 = RandomUtils.nextInt(0, 10000);
            heap.push(i1);
            System.out.print(i1 + ",");
        }

        System.out.println();
        int pre = -1;
        for (int i = 0; i < 10000; i++) {
            int i1 = heap.get();
            System.out.print(i1 + ",");
            if (i1 < pre) {
                System.out.println("wrong");
            }
            pre = i1;
        }
    }
}
