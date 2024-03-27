package 第一章_栈和队列.由两个栈组成的队列;

import java.util.Stack;

/**
 * @Author: mzh
 * @Description: TODO
 * @DateTime: 2024/3/20 9:06
 **/
public class TwoStacksQueue {

    private Stack<Integer> stackPush = new Stack<>();
    private Stack<Integer> stackPop = new Stack<>();

    private void add(Integer newValue) {
        stackPush.push(newValue);
    }

    private Integer poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    private Integer peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.add(1);
        twoStacksQueue.add(2);
        twoStacksQueue.add(3);
        twoStacksQueue.add(4);
        twoStacksQueue.add(5);
        twoStacksQueue.add(6);
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.peek());
        System.out.println(twoStacksQueue.poll());
    }
}
