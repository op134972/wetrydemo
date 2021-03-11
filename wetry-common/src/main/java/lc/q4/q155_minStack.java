package lc.q4;

import java.util.Stack;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-23 16:28
 */
public class q155_minStack {

    private Stack<Integer> minStack;
    private Stack<Integer> dataStack;

    /** initialize your data structure here.
     *
     * data    :    1,3,-5,7,-9,11
     * datStack:    1,3,-5,7,-9,11
     * minStack:    1...-5...-9...
     *最小值覆盖区域: |--->|--->|-->
     *
     * */
    public q155_minStack() {
        minStack = new Stack<>();
        dataStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        Integer val = dataStack.pop();
        if (!minStack.isEmpty() && minStack.peek().equals(val)) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {

    }
}
