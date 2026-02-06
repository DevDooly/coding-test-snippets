package algorithms.dp;

/**
 * 0/1 배낭 문제 (0/1 Knapsack Problem)
 * - 동적 계획법(DP)의 대표적인 문제 중 하나입니다.
 * - 무게 제한이 있는 배낭에, 각각 무게와 가치를 가진 N개의 물건을 담아 가치의 총합이 최대가 되도록 하는 문제입니다.
 * - 각 물건은 '담는다' 또는 '담지 않는다' 두 가지 선택만 가능합니다.
 *
 * @author DevDooly
 */
public class Knapsack {

    public static void main(String[] args) {
        // --- 입력 예시 ---
        int n = 4; // 물품의 수
        int k = 7; // 배낭의 최대 무게

        // 각 물품의 무게(w)와 가치(v)
        // items[i][0] = 무게, items[i][1] = 가치
        int[][] items = {
                {0, 0}, // 인덱스를 1부터 사용하기 위한 더미 데이터
                {6, 13},
                {4, 8},
                {3, 6},
                {5, 12}
        };

        // DP 테이블 초기화
        // dp[i][j]: i번째 물품까지 고려하고, 배낭 용량이 j일 때의 최대 가치
        int[][] dp = new int[n + 1][k + 1];

        // --- DP 진행 ---
        for (int i = 1; i <= n; i++) { // i: 현재 고려하는 물품
            int weight = items[i][0];
            int value = items[i][1];

            for (int j = 1; j <= k; j++) { // j: 현재 배낭 용량
                // 현재 물품을 배낭에 담을 수 없는 경우 (무게 초과)
                if (weight > j) {
                    dp[i][j] = dp[i - 1][j]; // 이전 물품까지의 최적해를 그대로 가져옴
                }
                // 현재 물품을 배낭에 담을 수 있는 경우
                else {
                    // 1. 현재 물품을 담지 않는 경우: dp[i-1][j]
                    // 2. 현재 물품을 담는 경우: dp[i-1][j-weight] + value
                    // 위 두 경우 중 더 큰 가치를 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                }
            }
        }

        // --- 결과 출력 ---
        System.out.println("최대 가치: " + dp[n][k]);

        // --- DP 테이블 내용 확인 (디버깅용) ---
        System.out.println("\n--- DP Table ---");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
