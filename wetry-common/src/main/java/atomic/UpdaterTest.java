package atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.UnaryOperator;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-05 21:01
 */
public class UpdaterTest {

    static class Node{
        int val;
        volatile Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        AtomicReferenceFieldUpdater<Node, Node> updater = AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "next");

        Node originNode = new Node(1);

        Node node = updater.updateAndGet(originNode, new UnaryOperator<Node>() {
            @Override
            public Node apply(Node node) {
                return new Node(2);
            }
        });

        System.out.println(originNode);
        System.out.println(node);
    }
}
