package datastructures.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {

    public static void main(String[] args) {
        // Deque: 양쪽 끝에서 삽입/삭제 가능한 자료구조. 스택과 큐로 모두 활용 가능.
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        System.out.println("Deque state: " + deque);
        int first = deque.removeFirst();
        System.out.println("Removed first from deque: " + first);
        int last = deque.removeLast();
        System.out.println("Removed last from deque: " + last);
        System.out.println("Final deque state: " + deque);
        System.out.println();
    }
}
