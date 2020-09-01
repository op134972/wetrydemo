package lc.q3;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-17 18:13
 */
public class q101 {
    public boolean isSymmetric(TreeNode root) {
        //3241423
        //1234243
        //3424321

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null || root.right==null) {
            return false;
        }

        return isMirror(root.left,root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return right.val == left.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
