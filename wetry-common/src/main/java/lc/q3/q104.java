package lc.q3;

import lc.util.TreeNode;

import java.util.Stack;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-17 17:03
 */
public class q104 {

    /*

    迭代做法， 两个栈，一个保存node，一个保存深度。两个栈同步弹出弹入
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 6.47%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 89.98%
     * 的用户
     */
    public int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int max = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        int currDepth = 1;
        stack.push(root);
        depthStack.push(currDepth);
        TreeNode curr = root.left;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                depthStack.push(++currDepth);
                curr = curr.left;
            }
            //
            if (!stack.isEmpty()) {
                curr = stack.pop();
                currDepth = depthStack.pop();
                max = Math.max(max, currDepth);
                curr = curr.right;
            }
        }

        return max;
    }

    /**
     * 递归，超快
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        q104 q104 = new q104();
        TreeNode node0 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);
        node0.left = node1;
        node0.right = node2;
        node2.left = node5;
        node2.right = node6;
        System.out.println(q104.maxDepth2(node0));
    }
}
