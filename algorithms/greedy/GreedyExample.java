package algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 그리디 알고리즘 (Greedy Algorithm, 탐욕법)
 * - '현재 상황에서 가장 좋은 것만 고르는' 방식으로 동작하는 알고리즘입니다.
 * - 각 단계에서의 최적의 선택이 전체적으로도 최적의 결과로 이어지는 경우에만 유효합니다.
 * - 정당성 분석(왜 이 방법이 최적해를 보장하는가?)이 중요합니다.
 *
 * @author DevDooly
 */
public class GreedyExample {

    /**
     * 예제 1: 거스름돈 문제
     * - 가장 적은 수의 동전으로 거스름돈을 주는 문제입니다.
     * - 조건: 가지고 있는 동전이 항상 배수 관계일 때 그리디 해법이 통합니다. (e.g., 500, 100, 50, 10)
     */
    public static void coinChange() {
        System.out.println("--- 예제 1: 거스름돈 문제 ---");
        int n = 1260; // 거슬러 줘야 할 돈
        int count = 0; // 동전의 총 개수

        int[] coinTypes = {500, 100, 50, 10};

        System.out.println("거스름돈: " + n);

        // 큰 단위의 동전부터 차례대로 확인
        for (int coin : coinTypes) {
            int coinCount = n / coin; // 해당 동전으로 거슬러 줄 수 있는 개수
            n %= coin;
            count += coinCount;
            System.out.println(coin + "원짜리 " + coinCount + "개");
        }
        System.out.println("필요한 동전의 총 개수: " + count);
    }

    /**
     * 예제 2: 회의실 배정 문제
     * - 한 개의 회의실을 사용할 N개의 회의에 대하여, 회의실 사용표를 최대로 만드는 문제입니다.
     * - 핵심 아이디어: '종료 시간이 빠른 순서'로 정렬하여, 겹치지 않는 회의를 선택합니다.
     */
    public static void meetingRoom() {
        System.out.println("\n--- 예제 2: 회의실 배정 ---");
        int[][] meetings = {{1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 8}, {5, 9}, {6, 10}, {8, 11}, {8, 12}, {2, 13}, {12, 14}};

        // 1. 종료 시간을 기준으로 오름차순 정렬
        // 2. 종료 시간이 같다면, 시작 시간을 기준으로 오름차순 정렬
        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 0;
        int lastEndTime = 0;

        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];

            // 이전 회의의 종료 시간보다 현재 회의의 시작 시간이 늦거나 같으면
            if (startTime >= lastEndTime) {
                lastEndTime = endTime; // 현재 회의를 선택하고, 종료 시간을 업데이트
                count++;
                System.out.println("선택된 회의: " + Arrays.toString(meeting));
            }
        }
        System.out.println("최대 사용할 수 있는 회의의 수: " + count);
    }


    public static void main(String[] args) {
        coinChange();
        meetingRoom();
    }
}
