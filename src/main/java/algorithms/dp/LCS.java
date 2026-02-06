package algorithms.dp;

/**
 * 최장 공통 부분 수열 (Longest Common Subsequence, LCS)
 * - 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제입니다.
 * - 동적 계획법(DP)을 사용하여 O(n*m)의 시간 복잡도로 해결할 수 있습니다. (n, m은 각 수열의 길이)
 *
 * @author DevDooly
 */
public class LCS {

    public static void main(String[] args) {
        String str1 = "ACAYKP";
        String str2 = "CAPCAK";

        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        // DP 테이블 초기화
        // dp[i][j]: str1의 i번째 문자까지와 str2의 j번째 문자까지의 LCS 길이
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // --- DP 진행 ---
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                // 두 문자가 같은 경우
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // 대각선 위의 값 + 1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 두 문자가 다른 경우
                else {
                    // 왼쪽 값과 위쪽 값 중 더 큰 값을 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // --- 결과 출력 ---
        System.out.println("\nLCS 길이: " + dp[str1.length()][str2.length()]);


        // --- LCS 문자열 역추적 ---
        StringBuilder lcsString = new StringBuilder();
        int i = str1.length();
        int j = str2.length();
        while (i > 0 && j > 0) {
            // 두 문자가 같은 경우: 해당 문자를 LCS에 추가하고 대각선 위로 이동
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcsString.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            // 두 문자가 다른 경우: DP 테이블의 왼쪽과 위쪽 중 더 큰 값으로 이동
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        // StringBuilder에 역순으로 저장되었으므로 뒤집어서 출력
        System.out.println("LCS 문자열: " + lcsString.reverse().toString());


        // --- DP 테이블 내용 확인 (디버깅용) ---
        System.out.println("\n--- DP Table ---");
        // 헤더 출력
        System.out.print("\t\t");
        for (char c : str2.toCharArray()) System.out.print(c + "\t");
        System.out.println();

        for (int row = 0; row <= str1.length(); row++) {
            if (row > 0) System.out.print(str1.charAt(row - 1) + "\t");
            else System.out.print("\t");
            for (int col = 0; col <= str2.length(); col++) {
                System.out.print(dp[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
