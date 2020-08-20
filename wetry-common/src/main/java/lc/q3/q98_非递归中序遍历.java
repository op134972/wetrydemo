package lc.q3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-14 20:55
 */
public class q98_非递归中序遍历 {


    //此种方法错误 无法处理下面的问题
    /**
     *       10
     *     5   15
     *  nu  nu 6 20
     */
    public boolean isValidBST1(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null) {
            return root.val < root.right.val && isValidBST1(root.right);
        } else if (root.right == null) {
            return root.left.val < root.val && isValidBST1(root.left);
        } else {
            return root.val > root.left.val
                    && root.val < root.right.val
                    && isValidBST1(root.left)
                    && isValidBST1(root.right);
        }
    }

    //中序遍历
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        long pre = Long.MIN_VALUE;
        TreeNode curr = root.left;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (curr != null || !deque.isEmpty()) {
            if (curr == null) {
                curr = deque.pop();
                if (curr.val < pre) {
                    return false;
                }
                pre = curr.val;
                curr = curr.right;
            }else{
                deque.push(curr);
                curr = curr.left;
            }
        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *       10
     *     5   15
     *  nu  nu 6 20
     * @param args
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        q98_非递归中序遍历 q98_递归中序遍历 = new q98_非递归中序遍历();
        q98_递归中序遍历.isValidBST(t1);

    }

}
