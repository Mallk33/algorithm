package 第一章_栈和队列.如何仅用递归函数和栈操作逆序一个栈;

import java.util.Stack;

/**
 * @Author: mzh
 * @Description: TODO
 * @DateTime: 2024/3/20 14:38
 **/
public class RevertStack {

    /**
     * 获取并移除栈底元素
     *
     * @param stack
     * @return
     */
    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    private static  void revert(Stack<Integer> stack) {
        // 边界
        if (stack.isEmpty()) {
            return;
        }
        // 分隔最小操作单元
        int lastElem = getAndRemoveLastElement(stack);
        // 调用递归函数
        revert(stack);
        // 最后一步操作
        stack.push(lastElem);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        revert(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
