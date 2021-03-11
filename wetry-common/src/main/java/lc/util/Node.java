package lc.util;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-20 10:25
 */
// Definition for a Node.
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + (random == null ? null : random.val) +
                '}';
    }
}