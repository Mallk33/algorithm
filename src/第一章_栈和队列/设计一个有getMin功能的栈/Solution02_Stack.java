package 第一章_栈和队列.设计一个有getMin功能的栈;

import java.util.Stack;

/**
 * @Author: mzh
 * @Description: 解法二
 * @DateTime: 2024/3/19 14:52
 **/
public class Solution02_Stack {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer data) {
        if (minStack.empty()) {
            minStack.push(data);
        } else {
            Integer minValue = minStack.peek();
            if (data.compareTo(minValue) <= 0) {
                minStack.push(data);
            } else {
                minStack.push(minValue);
            }
        }
        dataStack.push(data);
    }

    public Integer pop() {
        minStack.pop();
        return dataStack.pop();
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Solution02_Stack solution01Stack = new Solution02_Stack();
        solution01Stack.push(7);
        solution01Stack.push(8);
        solution01Stack.push(3);
        solution01Stack.push(3);
        System.out.println(solution01Stack.getMin());
        System.out.println(solution01Stack.pop());
        System.out.println(solution01Stack.getMin());
        System.out.println(solution01Stack.pop());
        System.out.println(solution01Stack.getMin());
        System.out.println(solution01Stack.pop());
    }
}
