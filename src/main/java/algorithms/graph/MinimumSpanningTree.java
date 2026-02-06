package algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 최소 신장 트리 (Minimum Spanning Tree, MST)
 * - 그래프의 모든 정점을 연결하되, 간선의 가중치 합을 최소로 만드는 트리.
 * - 대표적인 알고리즘으로 크루스칼(Kruskal)과 프림(Prim)이 있습니다.
 *
 * @author DevDooly
 */

// 간선 정보를 담는 클래스 (크루스칼용)
class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    // 비용이 낮은 순서로 정렬
    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

// 노드 정보를 담는 클래스 (프림용)
class Node_MST implements Comparable<Node_MST> {
    int to;
    int cost;

    public Node_MST(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node_MST other) {
        return this.cost - other.cost;
    }
}


public class MinimumSpanningTree {

    public static int v, e;
    public static int[] parent; // 부모 테이블 (크루스칼용 Union-Find)

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        // --- 입력 예시 ---
        v = 7;
        e = 9;

        // --- 크루스칼 알고리즘 ---
        System.out.println("--- 크루스칼 알고리즘 ---");
        ArrayList<Edge> edges = new ArrayList<>();
        int kruskalResult = 0;

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // 간선 정보
        edges.add(new Edge(1, 2, 29));
        edges.add(new Edge(1, 5, 75));
        edges.add(new Edge(2, 3, 35));
        edges.add(new Edge(2, 6, 34));
        edges.add(new Edge(3, 4, 7));
        edges.add(new Edge(4, 6, 23));
        edges.add(new Edge(4, 7, 13));
        edges.add(new Edge(5, 6, 53));
        edges.add(new Edge(6, 7, 25));

        // 간선을 비용순으로 정렬
        Collections.sort(edges);

        // 간선을 하나씩 확인하며 사이클이 발생하지 않는 경우에만 집합에 포함
        for (Edge edge : edges) {
            // 사이클이 발생하지 않는 경우 (루트 노드가 다를 때)
            if (findParent(edge.v1) != findParent(edge.v2)) {
                unionParent(edge.v1, edge.v2);
                kruskalResult += edge.cost;
            }
        }
        System.out.println("최소 비용 (Kruskal): " + kruskalResult);


        // --- 프림 알고리즘 ---
        System.out.println("\n--- 프림 알고리즘 ---");
        ArrayList<ArrayList<Node_MST>> graph = new ArrayList<>();
        boolean[] visited = new boolean[v + 1];
        int primResult = 0;

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 그래프 구성
        for (Edge edge : edges) {
            graph.get(edge.v1).add(new Node_MST(edge.v2, edge.cost));
            graph.get(edge.v2).add(new Node_MST(edge.v1, edge.cost));
        }

        PriorityQueue<Node_MST> pq = new PriorityQueue<>();
        pq.offer(new Node_MST(1, 0)); // 시작 노드 (1번, 비용 0)

        while (!pq.isEmpty()) {
            Node_MST node = pq.poll();
            int to = node.to;
            int cost = node.cost;

            if (visited[to]) continue;

            visited[to] = true;
            primResult += cost;

            for (Node_MST nextNode : graph.get(to)) {
                if (!visited[nextNode.to]) {
                    pq.offer(nextNode);
                }
            }
        }
        System.out.println("최소 비용 (Prim): " + primResult);
    }
}
