package lc.q4;

import lc.util.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-20 10:25
 */
public class q138 {
    /*
     * [[7,null],[13,0],[11,4],[10,2],[1,0]]
     */

    /*
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.9 MB
     * , 在所有 Java 提交中击败了
     * 7.26%
     * 的用户
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return copy(head, map);
    }

    private Node copy(Node head, Map<Node, Node> map) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            //这里需要返回复制节点
            return map.get(head);
        }
        Node node = new Node(head.val);
        map.put(head, node);
        node.next = copy(head.next, map);
        node.random = copy(head.random, map);
        return node;
    }


    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n1.random = null;
        n2.next = n3;
        n2.random = n1;
        n3.next = n4;
        n3.random = n5;
        n4.next = n5;
        n4.random = n3;
        n5.next = null;
        n5.random = n1;

        q138 q138 = new q138();
        Node node = q138.copyRandomList(n1);
        System.out.println(n1);
        System.out.println(node);

        System.out.println("==========");
    }

}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
