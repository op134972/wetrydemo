package lc.q4;

import lc.util.ListNode;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-21 15:27
 */
public class q148 {

    private static final int DEFAULT_SIZE = 4;

    //构建小顶堆
    private ListNode[] arr;
    private int size;

    public ListNode sortList(ListNode head) {

        if (head == null) {
            return null;
        }

        while (head != null) {
            push(head);
            head = head.next;
        }

        ListNode res = get();
        ListNode temp = res;
        while (size != 0) {
            ListNode node = get();
            temp.next = node;
            temp = node;
        }

        temp.next = null;

        return res;
    }

    public void push(ListNode val) {
        if (arr == null) {
            arr = new ListNode[DEFAULT_SIZE];
        }
        if (size == arr.length) {
            //扩容
            expandSize();
        }
        if (size == 0) {
            arr[size++] = val;
            return;
        }
        ListNode topVal = arr[0];
        if (val.val < topVal.val) {
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
        ListNode[] temp = arr;
        arr = new ListNode[size * 2];
        if (temp.length >= 0) System.arraycopy(temp, 0, arr, 0, temp.length);
    }

    //小的往上冒
    private void up(int start) {
        while (start >= 1) {
            int parentIndex = (start - 1) / 2;
            if (parentIndex >= 0 && arr[parentIndex].val > arr[start].val) {
                exchange(arr, parentIndex, start);
                start = parentIndex;
            } else {
                break;
            }
        }
    }

    private void exchange(ListNode[] arr, int i1, int i2) {
        ListNode temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public ListNode get() {
        if (size <= 0) {
            throw new RuntimeException("arr emp");
        }
        if (size == 1) {
            return arr[--size];
        }
        ListNode res = arr[0];
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
            } else if (arr[left].val < arr[right].val) {
                exchangIndex = left;
            } else {
                exchangIndex = right;
            }
            if (arr[start].val > arr[exchangIndex].val) {
                exchange(arr, start, exchangIndex);
                start = exchangIndex;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        q148 q148 = new q148();
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(2);

//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;

        System.out.println(n1);

        ListNode node = q148.sortList(n1);

        System.out.println(node);
    }
}
