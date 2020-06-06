package lc.question;

import lc.model.ListNode;

/**
 * Created by tangwc on 2019/3/5.
 */
public class q2 {

    /**
     * 成功
     * 显示详情
     * 执行用时: 56 ms, 在Add Two Numbers的Java提交中击败了62.13% 的用户
     * 内存消耗: 55.5 MB, 在Add Two Numbers的Java提交中击败了0.95% 的用户
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode res = new ListNode(0);

        ListNode curr = res;
        ListNode pre = null;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            ListNode ln1 = l1 == null ? null : l1.next;
            ListNode ln2 = l2 == null ? null : l2.next;

            int sum = val1 + val2 + carry;
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            //key
            curr.val = sum;
            if (pre != null) {
                pre.next = curr;
            }
            pre = curr;
            curr = new ListNode(0);

            l1 = ln1;
            l2 = ln2;
        }

        if (carry == 1) {
            pre.next = new ListNode(1);
        }

        return res;
    }
}
