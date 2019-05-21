package lc.question;

import lc.model.ListNode;

/**
 * Created by tangwc on 2019/3/19.
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Lc25_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        return reverse(head, k);
    }

    // 1-2-3-4-5-6   3-2-1-6-5-4

    /**
     * 递归
     *
     * 成功
     * 显示详情
     * 执行用时 : 2 ms, 在Reverse Nodes in k-Group的Java提交中击败了80.23% 的用户
     * 内存消耗 : 40.2 MB, 在Reverse Nodes in k-Group的Java提交中击败了39.92% 的用户
     */
    private ListNode reverse(ListNode headNode, int subSize) {
        if (headNode == null) {
            return null;
        }
        ListNode tailNode = getNodeAfter(headNode, subSize-1);
        if (tailNode == null) {
            return headNode;
        }

        ListNode pre = null;
        ListNode curr = headNode;
        ListNode next = null;
        for (int i = 0; i < subSize; i++) {
            if (i == 0) {
                pre = curr;
                curr = curr.next;
                pre.next = reverse(tailNode.next, subSize);
            } else if (i == subSize - 1) {
                curr.next = pre;
                return curr;
            } else {
                next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
        }

        return next;
    }

    private ListNode getNodeAfter(ListNode head, int index) {
        if (index == 0) {
            return head;
        }
        int start = 0;
        ListNode node = head;
        while (start < index) {
            node = node.next;
            start++;
            if (node == null) {
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3).setNext(new ListNode(4).setNext(new ListNode(5).setNext(new ListNode(6))))));
        Lc25_reverseKGroup lc25ReverseKGroup = new Lc25_reverseKGroup();
        ListNode listNode = lc25ReverseKGroup.reverseKGroup(head, 7);
        System.out.println(listNode);
    }
}
