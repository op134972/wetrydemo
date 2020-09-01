package lc.q3;

import lc.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-17 20:56
 */
public class q105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        boolean[] used = new boolean[preorder.length];
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        return fun(preorder, inorder, 0, preorder.length-1, inOrderIndexMap,used);
    }

    private TreeNode fun(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> inOrderIndexMap,boolean[] used) {

        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(inorder[start]);
        }

        int nextMid = findNextMid(preorder, start, end, inOrderIndexMap,used);

        TreeNode res = new TreeNode(inorder[nextMid]);
        res.left = fun(preorder, inorder, start, nextMid - 1, inOrderIndexMap, used);
        res.right = fun(preorder, inorder, nextMid + 1, end, inOrderIndexMap, used);
        return res;
    }

    private int findNextMid(int[] preorder, int start, int end, Map<Integer, Integer> inOrderIndexMap,boolean[] used) {
        for (int i = 0; i < preorder.length; i++) {
            if (used[i]) {
                continue;
            }
            Integer index = inOrderIndexMap.get(preorder[i]);
            if (index < start || index > end) {
                continue;
            }
            used[i] = true;
            return index;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {3,2,1};
        q105 q105 = new q105();
        TreeNode treeNode = q105.buildTree(arr1, arr2);
        System.out.println(treeNode);
    }
}
