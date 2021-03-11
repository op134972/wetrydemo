package lc.q4;

import java.util.Stack;

/**
 * @Author: tangwenchuan
 * @Date: 2020-08-22 16:30
 */
public class q150 {

    public int evalRPN(String[] tokens) {

        if (tokens == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (String val : tokens) {
            switch (val) {
                case "+": {
                    Integer n1 = stack.pop();
                    Integer n2 = stack.pop();
                    int res = n1 + n2;
                    stack.push(res);
                    break;
                }
                case "-": {
                    Integer n1 = stack.pop();
                    Integer n2 = stack.pop();
                    int res = n1 - n2;
                    stack.push(res);
                    break;
                }
                case "*": {
                    Integer n1 = stack.pop();
                    Integer n2 = stack.pop();
                    int res = n1 * n2;
                    stack.push(res);
                    break;
                }
                case "/": {
                    Integer n2 = stack.pop();
                    Integer n1 = stack.pop();
                    int res = n1 / n2;
                    stack.push(res);
                    break;
                }
                default:
                    stack.push(Integer.valueOf(val));
                    break;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        q150 q150 = new q150();
        String[] arr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = q150.evalRPN(arr);
        System.out.println(res);
    }
}
