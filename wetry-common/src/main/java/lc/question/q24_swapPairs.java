package lc.question;

import lc.model.ListNode;

/**
 * Created by tangwc on 2019/3/15.
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class q24_swapPairs {

    /**
     * 成功
     * 显示详情
     * 执行用时 : 5 ms, 在Swap Nodes in Pairs的Java提交中击败了35.37% 的用户
     * 内存消耗 : 35.4 MB, 在Swap Nodes in Pairs的Java提交中击败了0.91% 的用户
     *
     *
     * 还可以通过递归来做，下一次review时候实现一下！！！！！！！！
     * 还可以通过递归来做，下一次review时候实现一下！！！！！！！！
     * 还可以通过递归来做，下一次review时候实现一下！！！！！！！！
     */
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode next;
        ListNode preCurr = null;
        ListNode realHead = null;

        while (curr != null && curr.next != null) {
            next = curr.next;//curr = 1, next = 2
            ListNode nn = next.next;//nn = 3
            next.next = curr;//
            if (realHead == null) {
                realHead = next;
            }
            if (preCurr != null) {
                preCurr.next = next;
            }
            curr.next = nn;
            preCurr = curr;
            curr = nn;
        }

        return realHead == null ? head : realHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(5).setNext(new ListNode(6))))));
        System.out.println(head);
        System.out.println(new q24_swapPairs().swapPairs(head));

        ListNode h2 = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3)));
        System.out.println(h2);
        System.out.println(new q24_swapPairs().swapPairs(h2));
    }

}
