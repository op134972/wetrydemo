package lc.q3;

import lc.util.treeNode.Node;

/**
 * @Author: tangwenchuan
 * @Date: 2020-09-15 22:01
 */
public class q116 {


    /*
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 51.88%
     * 的用户
     * 内存消耗：
     * 38.6 MB
     * , 在所有 Java 提交中击败了
     * 98.46%
     * 的用户
     */
    public Node connect(Node root) {

        if (root == null) {
            return null;
        }
        connect(root.left, root.right);

        return root;
    }

    public void connect(Node left, Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        connect(left.left, left.right);
        connect(right.left, right.right);
        connect(left.right, right.left);
    }

}
