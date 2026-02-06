package algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 최장 증가 부분 수열 (Longest Increasing Subsequence, LIS)
 * - 주어진 수열에서, 오름차순으로 정렬된 가장 긴 부분 수열을 찾는 문제입니다.
 * - 동적 계획법(DP)을 사용하는 O(n^2) 풀이와, 이진 탐색을 결합한 O(n log n) 풀이가 있습니다.
 *
 * @author DevDooly
 */
public class LIS {

    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 20, 50};
        System.out.println("원본 수열: " + Arrays.toString(arr));

        // --- 1. O(n^2) DP 풀이 ---
        // dp[i] = i번째 원소를 마지막으로 하는 가장 긴 증가 부분 수열의 길이
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1); // 모든 원소는 그 자체로 길이 1의 수열이므로 1로 초기화

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength_n2 = 0;
        for (int length : dp) {
            maxLength_n2 = Math.max(maxLength_n2, length);
        }
        System.out.println("LIS 길이 (O(n^2)): " + maxLength_n2);


        // --- 2. O(n log n) 이진 탐색 풀이 ---
        // lis 배열에는 '가장 긴 증가 부분 수열 그 자체'가 아니라,
        // '해당 길이를 만들 수 있는 가장 작은 마지막 값'이 저장됩니다.
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];

            // 현재 값이 lis의 마지막 값보다 크면, lis에 추가 (길이가 1 증가)
            if (current > lis.get(lis.size() - 1)) {
                lis.add(current);
            }
            // 현재 값이 lis의 마지막 값보다 작거나 같으면,
            // lis에서 current가 들어갈 수 있는 위치를 찾아 값을 교체.
            else {
                // Collections.binarySearch는 찾고자 하는 값이 없을 경우,
                // '( -(insertion point) - 1 )'을 반환합니다.
                int insertionPoint = Collections.binarySearch(lis, current);
                if (insertionPoint < 0) {
                    insertionPoint = -(insertionPoint + 1);
                }
                lis.set(insertionPoint, current);
            }
        }

        System.out.println("LIS 길이 (O(n log n)): " + lis.size());
        // 주의: lis 변수의 내용은 실제 최장 증가 부분 수열이 아닐 수 있습니다.
        // 예: [10, 20, 30, 50] (이 경우는 맞게 나옴)
        System.out.println("O(n log n) 풀이 후 lis 배열 내용: " + lis);
    }
}
