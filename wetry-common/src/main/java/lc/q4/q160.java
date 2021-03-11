package lc.q4;

import lc.util.ListNode;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-23 18:25
 */
public class q160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode n1 = headA;
        ListNode n2 = headB;
        boolean aFirst = true;
        boolean bFirst = true;
        while (n1 != null && n2 != null) {
            if (n1 == n2) {
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next;
            if (n1 == null && aFirst) {
                n1 = headB;
                aFirst = false;
            }
            if (n2 == null && bFirst) {
                n2 = headA;
                bFirst = false;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(2);
        m1.next = m2;

        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n2.next = n3;
        n3.next = n4;

//        n1.next = n2;
//        m2.next = n2;

        q160 q160 = new q160();
        ListNode node = q160.getIntersectionNode(n1, m1);
        System.out.println(node);

    }
}
