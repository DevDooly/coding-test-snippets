package datastructures.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // --- Queue/Stack/Deque ---
        System.out.println("--- Queue/Stack/Deque Examples ---");
        // Queue: FIFO(First-In, First-Out). LinkedList로 구현.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 데이터 추가
        queue.offer(2);
        System.out.println("Queue state: " + queue);
        int front = queue.poll(); // 데이터 꺼내기 (1)
        System.out.println("Polled from queue: " + front);
        int peek = queue.peek(); // 맨 앞 데이터 확인 (2)
        System.out.println("Peeked from queue: " + peek);
        System.out.println("Final queue state: " + queue);
    }
}
