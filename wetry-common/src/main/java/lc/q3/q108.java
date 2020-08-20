package lc.q3;

import lc.util.TreeNode;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-18 19:35
 */
public class q108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null){
            return null;
        }
        return fun(nums, 0, nums.length - 1);
    }

    private TreeNode fun(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left = fun(nums, left, mid - 1);
        res.right = fun(nums, mid + 1, right);

        return res;
    }
}
