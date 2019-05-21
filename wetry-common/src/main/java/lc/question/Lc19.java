package lc.question;

import lc.model.ListNode;

/**
 * Created by tangwc on 2019/3/13.
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class Lc19 {

    /**
     * 1. 先算链表长度，再删，需要扫描两次
     * 2. 一次扫描，怎么做？前后指针
     *
     * 成功
     显示详情
     执行用时 : 12 ms, 在Remove Nth Node From End of List的Java提交中击败了73.35% 的用户
     内存消耗 : 35.4 MB, 在Remove Nth Node From End of List的Java提交中击败了0.96% 的用户
     * <p>
     * 提交时间	状态	执行用时	内存消耗	语言
     * 几秒前	通过	16 ms	39.9 MB	java
     * 3 分钟前	解答错误	N/A	N/A	java
     * 5 分钟前	解答错误	N/A	N/A	java
     * 19 分钟前	解答错误	N/A	N/A	java
     * 30 分钟前	解答错误	N/A	N/A	java
     * 1 小时前	解答错误	N/A	N/A	java
     * 16 小时前	执行出错	N/A	N/A	java
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        try {
            /**
             * 两个指针，第一个先走n步，第一个走到底，第二个刚好到倒数第n个
             *
             * 题目有点坑。【1,2】 2 的输出 是2，按之前的理解应该是null
             */
            if (n == 0) {
                return head;
            }
            int i = 0;
            ListNode nd1 = head;
            ListNode pre = null;
            ListNode nd2 = head;
            while (i != n) {
                try {
                    nd1 = nd1.next;
                    i++;
                } catch (Exception e) {
                    //这种情况说明越界了
                    return null;
                }
            }

            if (nd1 == null) {
                return head.next;
            }

            while (nd1 != null) {
                nd1 = nd1.next;
                pre = nd2;
                nd2 = nd2.next;
            }

            pre.next = nd2.next;

            return head;
        } catch (Exception e) {
            //越界直接
            return null;
        }
    }
}
