package lc.question;

import lc.model.ListNode;

/**
 * Created by tangwc on 2019/3/14.
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class q21_mergeTwoLists {

    /**
     * 成功
     * 显示详情
     * 执行用时 : 13 ms, 在Merge Two Sorted Lists的Java提交中击败了70.86% 的用户
     * 内存消耗 : 40.9 MB, 在Merge Two Sorted Lists的Java提交中击败了0.97% 的用户
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

}
