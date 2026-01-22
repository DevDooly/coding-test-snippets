package algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 위상 정렬 (Topological Sort)
 * - 순서가 정해져 있는 작업들을 그 순서에 맞게 나열하는 알고리즘입니다.
 * - 사이클이 없는 방향 그래프(DAG, Directed Acyclic Graph)에서만 사용할 수 있습니다.
 * - 큐(Queue)를 이용하여 구현하며, 진입 차수(Indegree)라는 개념을 사용합니다.
 *   - 진입 차수: 특정 노드로 들어오는 간선의 개수
 *
 * @author DevDooly
 */
public class TopologicalSort {

    public static int v, e; // 노드 개수, 간선 개수
    public static int[] indegree; // 각 노드의 진입 차수 테이블
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프

    /**
     * 위상 정렬 함수
     */
    public static void topologySort() {
        ArrayList<Integer> result = new ArrayList<>(); // 알고리즘 수행 결과를 담을 리스트
        Queue<Integer> queue = new LinkedList<>();

        // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 원소 꺼내기
            int now = queue.poll();
            result.add(now);

            // 해당 원소와 연결된 노드들의 진입차수에서 1 빼기
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);
                indegree[nextNode]--;
                // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                if (indegree[nextNode] == 0) {
                    queue.offer(nextNode);
                }
            }
        }

        // 위상 정렬 결과 출력
        System.out.println("--- 위상 정렬 결과 ---");
        for (Integer node : result) {
            System.out.print(node + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // --- 입력 예시 ---
        v = 7; // 노드 개수
        e = 8; // 간선 개수

        // 그래프 및 진입 차수 테이블 초기화
        indegree = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        // 방향 그래프의 모든 간선 정보를 입력 받기
        int[][] edges = {
                {1, 2}, {1, 5},
                {2, 3},
                {3, 4},
                {4, 6},
                {5, 6},
                {6, 7}
        };
        // e = 7개로 수정
        e = 7;

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b); // 정점 A에서 B로 이동 가능
            indegree[b] += 1;    // 진입 차수를 1 증가
        }

        topologySort();
    }
}
