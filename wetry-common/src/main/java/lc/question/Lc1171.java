package lc.question;

import lc.model.ListNode;

/**
 * @Author: tangwenchuan
 * @Date: 2020-04-02 16:58
 */
public class Lc1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode beforZero = null;
        ListNode curr = head;
        int sum = 0;
        while (curr.next != null) {
            sum += curr.getVal();
            if (sum == 0) {
                if (beforZero != null) {
                    //清除
                    beforZero.next = curr.next;
                }
            }
        }

        return null;
    }
}
