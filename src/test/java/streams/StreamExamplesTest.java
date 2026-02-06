package streams;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class StreamExamplesTest {

    @Test
    @DisplayName("1. Filtering: 짝수만 걸러내기")
    void filterExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        assertThat(evenNumbers).containsExactly(2, 4, 6, 8, 10);
    }

    @Test
    @DisplayName("2. Mapping: 문자열 대문자로 변환")
    void mapExample() {
        List<String> names = List.of("apple", "banana", "cherry");

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertThat(upperCaseNames).containsExactly("APPLE", "BANANA", "CHERRY");
    }

    @Test
    @DisplayName("3. Sorting: 문자열 길이순 정렬")
    void sortExample() {
        List<String> names = List.of("apple", "banana", "kiwi", "fig");

        List<String> sortedByLength = names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        assertThat(sortedByLength).containsExactly("fig", "kiwi", "apple", "banana");
    }

    @Test
    @DisplayName("4. FlatMap: 중첩 리스트 평탄화")
    void flatMapExample() {
        List<List<String>> nestedList = List.of(
                List.of("a", "b"),
                List.of("c", "d"),
                List.of("e", "f")
        );

        List<String> flatList = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        assertThat(flatList).containsExactly("a", "b", "c", "d", "e", "f");
    }

    @Test
    @DisplayName("5. Reduce: 모든 숫자의 합 구하기")
    void reduceExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // 초기값 0부터 시작해서 더하기
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        assertThat(sum).isEqualTo(15);
    }

    @Test
    @DisplayName("6. GroupingBy: 문자열 길이에 따라 그룹핑")
    void groupingByExample() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        assertThat(groupedByLength)
                .contains(entry(3, List.of("fig")))
                .contains(entry(4, List.of("date")))
                .contains(entry(5, List.of("apple", "grape")))
                .contains(entry(6, List.of("banana", "cherry")));
    }

    @Test
    @DisplayName("7. PartitioningBy: 짝수와 홀수로 분리")
    void partitioningByExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        assertThat(partitioned.get(true)).containsExactly(2, 4, 6); // Even
        assertThat(partitioned.get(false)).containsExactly(1, 3, 5); // Odd
    }

    @Test
    @DisplayName("8. Statistics: IntStream 통계 (최대, 최소, 평균)")
    void statisticsExample() {
        int[] numbers = {1, 5, 10, 20, 50};

        IntSummaryStatistics stats = IntStream.of(numbers).summaryStatistics();

        assertThat(stats.getMax()).isEqualTo(50);
        assertThat(stats.getMin()).isEqualTo(1);
        assertThat(stats.getAverage()).isEqualTo(17.2);
        assertThat(stats.getSum()).isEqualTo(86);
        assertThat(stats.getCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("9. Distinct: 중복 제거")
    void distinctExample() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3, 4, 5);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        assertThat(distinctNumbers).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("10. Joining: 문자열 합치기")
    void joiningExample() {
        List<String> words = List.of("Java", "Stream", "API");

        String result = words.stream()
                .collect(Collectors.joining(" -> "));

        assertThat(result).isEqualTo("Java -> Stream -> API");
    }
}
