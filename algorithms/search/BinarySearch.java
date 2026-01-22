package algorithms.search;

import java.util.Arrays;

/**
 * 이진 탐색 (Binary Search)
 * - 정렬된 배열에서 특정 값을 찾는 데 사용되는 매우 효율적인 탐색 알고리즘입니다.
 * - 시간 복잡도는 O(log N)입니다.
 * - '결정 문제'를 해결하는 '파라메트릭 서치' 기법의 기반이 됩니다.
 *
 * @author DevDooly
 */
public class BinarySearch {

    /**
     * 기본적인 이진 탐색 (반복문 방식)
     *
     * @param arr    정렬된 배열
     * @param target 찾고자 하는 값
     * @return 찾은 값의 인덱스, 없으면 -1
     */
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // overflow 방지

            // 값을 찾은 경우
            if (arr[mid] == target) {
                return mid;
            }
            // 중간값이 타겟보다 작은 경우, 오른쪽 부분 탐색
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            // 중간값이 타겟보다 큰 경우, 왼쪽 부분 탐색
            else {
                end = mid - 1;
            }
        }
        // 값을 찾지 못한 경우
        return -1;
    }


    /**
     * 파라메트릭 서치 (Parametric Search) 예제
     * - '떡볶이 떡 자르기' 또는 '랜선 자르기'와 같은 최적화 문제를 해결하는 데 사용됩니다.
     * - 문제: N개의 랜선이 있을 때, 이들을 잘라 K개의 동일한 길이의 랜선을 만들 수 있는 최대 길이는?
     *
     * @param cables 가지고 있는 랜선들의 길이 배열
     * @param n      필요한 랜선의 개수
     * @return 만들 수 있는 랜선의 최대 길이
     */
    public static long parametricSearch(int[] cables, int n) {
        long start = 1; // 길이는 자연수이므로 1부터
        long end = Arrays.stream(cables).max().orElse(0); // 가장 긴 랜선 길이
        long result = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2; // 자르고자 하는 랜선의 길이
            if (mid == 0) mid = 1; // 0으로 나누는 것을 방지

            long count = 0; // mid 길이로 잘랐을 때 나오는 랜선의 총 개수
            for (int cable : cables) {
                count += (cable / mid);
            }

            // 만들어진 랜선이 필요한 개수보다 많거나 같은 경우 (길이를 늘려본다)
            if (count >= n) {
                result = mid; // 현재 길이는 가능한 길이이므로 저장
                start = mid + 1;
            }
            // 만들어진 랜선이 필요한 개수보다 적은 경우 (길이를 줄여야 한다)
            else {
                end = mid - 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        // --- 1. 기본 이진 탐색 예제 ---
        System.out.println("--- 기본 이진 탐색 ---");
        int[] sortedArr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 13;
        int index = binarySearch(sortedArr, target);

        System.out.println("배열: " + Arrays.toString(sortedArr));
        if (index != -1) {
            System.out.println("타겟 " + target + "은(는) 인덱스 " + index + "에 있습니다.");
        } else {
            System.out.println("타겟 " + target + "을(를) 찾을 수 없습니다.");
        }


        // --- 2. 파라메트릭 서치 예제 ---
        System.out.println("\n--- 파라메트릭 서치 (랜선 자르기) ---");
        int[] cables = {802, 743, 457, 539};
        int n = 11;
        long maxLength = parametricSearch(cables, n);
        System.out.println("가진 랜선: " + Arrays.toString(cables));
        System.out.println("필요한 개수: " + n);
        System.out.println("만들 수 있는 최대 랜선 길이: " + maxLength); // 예상 결과: 200
    }
}
