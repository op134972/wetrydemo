package lc.q5;

import lc.util.ListNode;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-27 00:42
 */
public class q206 {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.9 MB
     * , 在所有 Java 提交中击败了
     * 21.85%
     * 的用户
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode pre = null;
        ListNode next;
        while (curr!=null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

//        l1.next = l2;
//        l2.next = l3;

        q206 q206 = new q206();
        System.out.println(q206.reverseList(l1));
    }
}
