package lc.q3;

import lc.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-17 20:53
 */
public class q103 {

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.2 MB
     * , 在所有 Java 提交中击败了
     * 96.98%
     * 的用户
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        fun(res, root, 0);

        return res;
    }

    private void fun(List<List<Integer>> res, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        LinkedList<Integer> depList;
        if (depth < res.size()) {
            depList = (LinkedList<Integer>) res.get(depth);
        } else {
            depList = new LinkedList<>();
            res.add(depth, depList);
        }
        if (depth % 2 == 0) {
            depList.addLast(root.val);
        }else{
            depList.addFirst(root.val);
        }
        fun(res, root.left, depth + 1);
        fun(res, root.right, depth + 1);
    }
}
