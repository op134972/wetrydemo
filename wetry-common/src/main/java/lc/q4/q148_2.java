package lc.q4;

import lc.util.ListNode;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-21 15:27
 */
public class q148_2 {

    public ListNode sortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode n1 = null;
        ListNode n2 = null;

        ListNode n1Pre;
        ListNode n2Pre;

        boolean first = true;
        while (head != null) {
            if (first) {
                n1Pre = n1;
                n1 = head;
                n1.next = n1Pre;
                first = false;
            }else{
                n2Pre = n2;
                n2 = head;
                n2.next = n2Pre;
                first = true;
            }
            head = head.next;
        }



        return null;
    }

    public static void main(String[] args) {
        q148_2 q148 = new q148_2();
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
