package lc.q3;

import lc.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-17 20:09
 */
public class q102 {

    /*
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 91.92%
     * 的用户
     * 内存消耗：
     * 40.3 MB
     * , 在所有 Java 提交中击败了
     * 10.65%
     * 的用户
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        fun(res,root,0);

        return res;
    }

    private void fun(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        List<Integer> depList;
        if (depth < res.size()) {
            depList = res.get(depth);
        }else{
            depList = new ArrayList<>();
            res.add(depth, depList);
        }
        depList.add(root.val);
        fun(res, root.left, depth + 1);
        fun(res, root.right, depth + 1);
    }

    public static void main(String[] args) {
        q102 q102 = new q102();
        //[3,9,20,null,null,15,7]
        TreeNode node0 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);
        node0.left = node1;
        node0.right = node2;
        node2.left = node5;
        node2.right = node6;
        List<List<Integer>> res = q102.levelOrder(node0);
        System.out.println(res.toString());
    }

}
