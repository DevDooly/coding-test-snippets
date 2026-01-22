package algorithms.graph;

import java.util.*;

/**
 * 다익스트라 (Dijkstra) 최단 경로 알고리즘 예제
 * - 가중치가 있는 그래프에서 특정 시작 노드로부터 다른 모든 노드까지의 최단 거리를 찾는 알고리즘입니다.
 * - 음의 가중치를 가진 간선이 없어야 합니다.
 * - PriorityQueue (우선순위 큐)를 사용하면 O(E log V)의 시간 복잡도를 가집니다. (V: 정점 수, E: 간선 수)
 *
 * @author DevDooly
 */

// 노드 정보를 담는 클래스
class Node implements Comparable<Node> {
    int index; // 노드 번호
    int distance; // 시작 노드로부터의 거리

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    // 거리가 짧은 순서로 정렬 (우선순위 큐에서 사용)
    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}

public class Dijkstra {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값 (10억)
    public static int v, e, start; // 노드 개수, 간선 개수, 시작 노드
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); // 각 노드에 연결된 노드 정보를 담는 그래프
    public static int[] d; // 최단 거리 테이블

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여 큐에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.distance; // 현재 노드까지의 비용
            int now = node.index;     // 현재 노드

            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) {
                continue;
            }

            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                Node nextNode = graph.get(now).get(i);
                int cost = d[now] + nextNode.distance;

                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[nextNode.index]) {
                    d[nextNode.index] = cost;
                    pq.offer(new Node(nextNode.index, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        // --- 입력 예시 ---
        // (실제 코딩 테스트에서는 Scanner나 BufferedReader로 입력받습니다)
        v = 6; // 노드 개수
        e = 11; // 간선 개수
        start = 1; // 시작 노드 번호

        // 그래프 및 최단 거리 테이블 초기화
        d = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(d, INF);

        // 간선 정보 (a번 노드에서 b번 노드로 가는 비용이 c)
        // new int[][]{{1,2,2}, {1,3,5}, ...} 형태로 주어지는 경우가 많습니다.
        graph.get(1).add(new Node(2, 2));
        graph.get(1).add(new Node(3, 5));
        graph.get(1).add(new Node(4, 1));

        graph.get(2).add(new Node(3, 3));
        graph.get(2).add(new Node(4, 2));

        graph.get(3).add(new Node(2, 3));
        graph.get(3).add(new Node(6, 5));

        graph.get(4).add(new Node(3, 3));
        graph.get(4).add(new Node(5, 1));

        graph.get(5).add(new Node(3, 1));
        graph.get(5).add(new Node(6, 2));

        // --- 다익스트라 알고리즘 수행 ---
        dijkstra(start);

        // --- 결과 출력 ---
        System.out.println("시작 노드 " + start + "로부터 각 노드까지의 최단 거리:");
        for (int i = 1; i <= v; i++) {
            if (d[i] == INF) {
                System.out.println("노드 " + i + ": INFINITY");
            } else {
                System.out.println("노드 " + i + ": " + d[i]);
            }
        }
    }
}
