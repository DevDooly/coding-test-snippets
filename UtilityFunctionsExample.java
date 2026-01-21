import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java의 기타 유용한 유틸리티 함수 예제
 */
public class UtilityFunctionsExample {

    public static void main(String[] args) {

        // --- 배열 출력 ---
        System.out.println("--- Array Printing Examples ---");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("1D Array: " + Arrays.toString(arr)); // "[1, 2, 3, 4, 5]"

        // 2차원 배열 출력
        int[][] arr2d = {{1, 2}, {3, 4}};
        System.out.println("2D Array: " + Arrays.deepToString(arr2d)); // "[[1, 2], [3, 4]]"
        System.out.println();


        // --- 리스트/컬렉션 출력 ---
        System.out.println("--- Collection Printing Examples ---");
        List<Integer> list = List.of(1, 2, 3);
        System.out.println("List: " + list); // "[1, 2, 3]"

        // Stream API를 사용한 커스텀 출력
        String joinedString = list.stream()
                                  .map(String::valueOf)
                                  .collect(Collectors.joining(" -> ")); // "1 -> 2 -> 3"
        System.out.println("Joined with Stream API: " + joinedString);
        System.out.println();


        // --- Math 관련 함수 ---
        System.out.println("--- Math Function Examples ---");
        int a = 10, b = 20;
        int maxVal = Math.max(a, b); // 20
        System.out.println("Max of " + a + " and " + b + " is: " + maxVal);

        int minVal = Math.min(a, b); // 10
        System.out.println("Min of " + a + " and " + b + " is: " + minVal);

        int absVal = Math.abs(-15);  // 15
        System.out.println("Absolute value of -15 is: " + absVal);

        long rounded = Math.round(10.5); // 11
        System.out.println("Rounding 10.5 results in: " + rounded);
        System.out.println();
    }
}
