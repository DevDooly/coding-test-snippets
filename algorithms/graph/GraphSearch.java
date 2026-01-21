package algorithms.graph;

import java.util.*;

/**
 * 그래프 탐색 알고리즘인 DFS(깊이 우선 탐색)와 BFS(너비 우선 탐색) 예제 코드입니다.
 *
 * @author DevDooly
 */
public class GraphSearch {

    private static boolean[] visited; // 방문 여부를 체크하는 배열
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 인접 리스트 방식의 그래프

    /**
     * 깊이 우선 탐색 (Depth First Search)
     * - 스택(또는 재귀)을 이용하여 가장 깊은 노드부터 우선적으로 탐색하는 방식.
     *
     * @param startNode 시작 노드
     */
    public static void dfs(int startNode) {
        // 현재 노드를 방문 처리
        visited[startNode] = true;
        System.out.print(startNode + " ");

        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for (int i = 0; i < graph.get(startNode).size(); i++) {
            int nextNode = graph.get(startNode).get(i);
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }

    /**
     * 너비 우선 탐색 (Breadth First Search)
     * - 큐를 이용하여 시작 노드에 가까운 노드부터 우선적으로 탐색하는 방식.
     *
     * @param startNode 시작 노드
     */
    public static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        // 현재 노드를 방문 처리
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                int nextNode = graph.get(currentNode).get(i);
                if (!visited[nextNode]) {
                    queue.offer(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // --- 그래프 초기화 (인접 리스트) ---
        // 노드의 개수 + 1 만큼 초기화 (인덱스를 1부터 사용하기 위함)
        int numberOfNodes = 8;
        for (int i = 0; i <= numberOfNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 추가 (양방향)
        // 노드 1
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6
        graph.get(6).add(7);

        // 노드 7
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // 노드 8
        graph.get(8).add(1);
        graph.get(8).add(7);

        // --- DFS 실행 ---
        visited = new boolean[numberOfNodes + 1];
        System.out.println("DFS 탐색 결과:");
        dfs(1);
        System.out.println("\n");

        // --- BFS 실행 ---
        visited = new boolean[numberOfNodes + 1]; // 방문 기록 초기화
        System.out.println("BFS 탐색 결과:");
        bfs(1);
        System.out.println();
    }
}
