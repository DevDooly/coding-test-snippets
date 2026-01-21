package datastructures.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        // --- Set: HashSet ---
        System.out.println("--- Set Examples ---");
        // 중복을 허용하지 않는 데이터 집합. 순서를 보장하지 않음.
        Set<Integer> set = new HashSet<>();

        // 데이터 추가
        set.add(1);
        set.add(2);
        set.add(1); // 중복된 1은 추가되지 않음
        System.out.println("Set after adds (duplicates ignored): " + set);

        // 포함 여부 확인
        boolean containsTwo = set.contains(2); // true
        System.out.println("Set contains 2: " + containsTwo);

        // 데이터 삭제
        set.remove(1);
        System.out.println("Set after removing 1: " + set);

        // List -> Set (중복 제거)
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        System.out.println("Original list with duplicates: " + numberList);
        Set<Integer> uniqueNumbers = new HashSet<>(numberList); // {1, 2, 3}
        System.out.println("Set from list (duplicates removed): " + uniqueNumbers);
        System.out.println();
    }
}
