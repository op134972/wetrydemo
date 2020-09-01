package lc.q3;

import java.util.*;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-14 11:42
 */
public class q94 {

    /**
     * 递归
     * <p>
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 37.8 MB
     * , 在所有 Java 提交中击败了
     * 78.62%
     * 的用户
     */
    public List<Integer> inorderTraversal2(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        printer(root, res);

        return res;
    }

    private void printer(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        printer(root.left, res);
        res.add(root.val);
        printer(root.right, res);
    }


    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 49.42%
     * 的用户
     * 内存消耗：
     * 37.7 MB
     * , 在所有 Java 提交中击败了
     * 88.15%
     * 的用户
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> deque = new ArrayDeque<>();

        if (root == null) {
            return res;
        }
        TreeNode curr = root.left;
        deque.push(root);
        while (curr != null || !deque.isEmpty()) {
            if (curr == null) {
                curr = deque.pop();
                //弹出来就要打印
                res.add(curr.val);
                curr = curr.right;
            } else {
                deque.push(curr);
                curr = curr.left;
            }
        }

        return res;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> deque = new ArrayDeque<>();

        if (root == null) {
            return res;
        }
        TreeNode curr = root.left;
        deque.push(root);
        while (!deque.isEmpty()) {
            if (curr == null) {
                curr = deque.pop();
                //弹出来就要打印
                res.add(curr.val);
                if (curr.right != null) {
                    deque.push(curr.right);
                    curr = curr.right.left;
                }else{
                    curr = null;
                }
            }else{
                deque.push(curr);
                curr = curr.left;
            }
        }

        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
