package lc.q3;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-14 20:55
 */
public class q98_递归中序遍历 {

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.7 MB
     * , 在所有 Java 提交中击败了
     * 27.91%
     * 的用户
     */
    private long pre = Long.MIN_VALUE;

    //递归中序遍历 全局 pre
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST2(root.left)) {
            return false;
        }

        if (root.val < pre) {
            return false;
        }
        pre = root.val;

        return isValidBST2(root.right);
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
