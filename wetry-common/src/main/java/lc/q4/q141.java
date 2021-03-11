package lc.q4;

import lc.util.ListNode;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-21 09:24
 */
public class q141 {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode after = head;
        ListNode pre = head.next;

        while (after != null && pre != null) {
            if (after == pre) {
                return true;
            }
            after = after.next;
            if (pre.next == null) {
                return false;
            }else{
                pre = pre.next.next;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n1;

        q141 q141 = new q141();
        System.out.println(q141.hasCycle(n1));

    }
}
