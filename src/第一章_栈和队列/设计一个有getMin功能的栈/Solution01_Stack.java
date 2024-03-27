package 第一章_栈和队列.设计一个有getMin功能的栈;

import java.util.Stack;

/**
 * @Author: mzh
 * @Description: 解法一
 * @DateTime: 2024/3/19 14:52
 **/
public class Solution01_Stack {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer data) {
        if (minStack.empty()) {
            minStack.push(data);
        } else {
            Integer minValue = minStack.peek();
            // 注：这里必须加 = 号，假设存在两个 3，minstack 只会存一个 3，
            // 当弹出一个 3 时，当前返回的最小元素就不为 3 了，实际应该还是 3
            if (data.compareTo(minValue) <= 0) {
                minStack.push(data);
            }
        }
        dataStack.push(data);
    }

    public Integer pop() {
        Integer pop = dataStack.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
        return pop;
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Solution01_Stack solution01Stack = new Solution01_Stack();
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
