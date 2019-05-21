package lc.question;

import lc.model.ListNode;

/**
 * Created by tangwc on 2019/3/15.
 */
public class Lc23_mergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        try {
            if (lists.length == 0) {
                return null;
            }
            ListNode node = new ListNode(0);
            mergeK(null,node, lists);
            return node;
        } catch (Exception e) {
            return null;
        }
    }

    private void mergeK(ListNode pre, ListNode res, ListNode[] lists) {
        int minVal = Integer.MAX_VALUE;
        int minInd = -1;
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node == null) {
                continue;
            }
            if (node.val < minVal) {
                minVal = node.val;
                minInd = i;
            }
        }

        if (minInd == -1) {
            pre.next = null;
            return ;
        }
        res.val = minVal;
        ListNode next = new ListNode(0);
        res.next = next;
        pre = res;
        res = next;
        ListNode ln = lists[minInd];
        ln = ln.next;
        lists[minInd] = ln;
        mergeK(pre, res, lists);
    }

    public static void main(String[] args) {
        ListNode[] arr = new ListNode[3];
//        arr[0] = new ListNode(1).setNext(new ListNode(3).setNext(new ListNode(5).setNext(new ListNode(7))));
//        arr[1] = new ListNode(2).setNext(new ListNode(4).setNext(new ListNode(6).setNext(new ListNode(8))));
//        arr[2] = new ListNode(-1).setNext(new ListNode(1).setNext(new ListNode(5).setNext(new ListNode(10))));
        System.out.println(new Lc23_mergeKLists().mergeKLists(arr));
    }

}
