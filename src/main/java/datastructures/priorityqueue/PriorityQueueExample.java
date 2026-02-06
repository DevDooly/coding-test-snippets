package datastructures.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // --- PriorityQueue: 우선순위 큐 ---
        System.out.println("--- PriorityQueue Examples ---");
        // 데이터가 우선순위에 따라 자동으로 정렬되는 큐. 기본은 최소 힙(Min Heap).
        // 1. 최소 힙 (기본)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(30);
        minHeap.add(10);
        minHeap.add(20);
        System.out.println("MinHeap poll: " + minHeap.poll()); // 10 (가장 작은 값)
        System.out.println("MinHeap poll: " + minHeap.poll()); // 20
        System.out.println("MinHeap poll: " + minHeap.poll()); // 30

        // 2. 최대 힙 (내림차순)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);
        System.out.println("MaxHeap poll: " + maxHeap.poll()); // 30 (가장 큰 값)
        System.out.println("MaxHeap poll: " + maxHeap.poll()); // 20
        System.out.println("MaxHeap poll: " + maxHeap.poll()); // 10


        // 3. 커스텀 객체 정렬
        class Node implements Comparable<Node> {
            int id;
            int cost;

            Node(int id, int cost) {
                this.id = id;
                this.cost = cost;
            }

            // cost가 낮은 순서로 정렬 (최소 힙)
            @Override
            public int compareTo(Node other) {
                return Integer.compare(this.cost, other.cost);
            }

            @Override
            public String toString() {
                return "Node{" + "id=" + id + ", cost=" + cost + '}';
            }
        }
        PriorityQueue<Node> pqNode = new PriorityQueue<>();
        pqNode.add(new Node(1, 100));
        pqNode.add(new Node(2, 50));
        pqNode.add(new Node(3, 150));
        System.out.println("PriorityQueue with custom objects (Node with lowest cost comes first):");
        System.out.println("Polled node: " + pqNode.poll()); // id: 2
        System.out.println("Polled node: " + pqNode.poll()); // id: 1
        System.out.println("Polled node: " + pqNode.poll()); // id: 3
    }
}
