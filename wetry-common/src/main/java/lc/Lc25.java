//package lc;
//
//import lc.model.ListNode;
//
///**
// * Created by tangwc on 2019/3/19.
// * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
// * <p>
// * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
// * <p>
// * 示例 :
// * <p>
// * 给定这个链表：1->2->3->4->5
// * <p>
// * 当 k = 2 时，应当返回: 2->1->4->3->5
// * <p>
// * 当 k = 3 时，应当返回: 3->2->1->4->5
// * <p>
// * 说明 :
// * <p>
// * 你的算法只能使用常数的额外空间。
// * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
// */
//public class Lc25 {
//    public ListNode reverseKGroup(ListNode head, int k) {
//
//        if (k <= 1 || head == null || head.next == null) {
//            return head;
//        }
//
//        return reverse(head,k);
//    }
//
//    private ListNode reverse(ListNode head, int k) {
//        ListNode pre = null;
//        ListNode curr = head;
//        ListNode next = head.next;
//        ListNode last = head;
//        for (int i = 0; i < k; i++) {
//            if (next == null) {
//                return
//            }
//        }
//
//    }
//}
