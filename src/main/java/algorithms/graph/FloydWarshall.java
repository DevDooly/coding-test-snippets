package algorithms.graph;

import java.util.Arrays;

/**
 * 플로이드-워셜 (Floyd-Warshall) 알고리즘
 * - 모든 정점에서 다른 모든 정점까지의 최단 경로를 구하는 알고리즘입니다.
 * - 다이나믹 프로그래밍(DP)에 기반합니다.
 * - 시간 복잡도는 O(V^3)으로, 노드 개수가 적을 때 (보통 500개 이하) 효과적입니다.
 * - 음의 가중치를 가진 간선도 처리할 수 있지만, '음수 가중치 사이클'은 존재하면 안 됩니다.
 *
 * @author DevDooly
 */
public class FloydWarshall {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값
    public static int v, e; // 노드 개수, 간선 개수
    public static int[][] graph; // 2차원 최단 거리 테이블

    public static void main(String[] args) {
        // --- 입력 예시 ---
        v = 4; // 노드 개수
        e = 7; // 간선 개수

        // 그래프 초기화
        graph = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0; // 자기 자신으로 가는 비용은 0
        }

        // 간선 정보 (a -> b 비용 c)
        int[][] edges = {
                {1, 2, 4},
                {1, 4, 6},
                {2, 1, 3},
                {2, 3, 7},
                {3, 1, 5},
                {3, 4, 4},
                {4, 3, 2}
        };

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
        }

        // --- 플로이드-워셜 알고리즘 수행 ---
        // k = 거쳐가는 노드
        for (int k = 1; k <= v; k++) {
            // i = 출발 노드
            for (int i = 1; i <= v; i++) {
                // j = 도착 노드
                for (int j = 1; j <= v; j++) {
                    // 점화식: D[i][j] = min(D[i][j], D[i][k] + D[k][j])
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        // --- 결과 출력 ---
        System.out.println("--- 모든 노드 간의 최단 거리 ---");
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}