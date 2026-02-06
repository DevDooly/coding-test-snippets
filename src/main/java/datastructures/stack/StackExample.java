package datastructures.stack;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        // Stack: LIFO(Last-In, First-Out).
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // 데이터 추가
        stack.push(2);
        System.out.println("Stack state: " + stack);
        int top = stack.pop(); // 데이터 꺼내기 (2)
        System.out.println("Popped from stack: " + top);
        int peekStack = stack.peek(); // 맨 위 데이터 확인 (1)
        System.out.println("Peeked from stack: " + peekStack);
        System.out.println("Final stack state: " + stack);
    }
}
