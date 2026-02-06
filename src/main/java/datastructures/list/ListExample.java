package datastructures.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        // --- List: ArrayList, LinkedList ---
        System.out.println("--- List Examples ---");
        // 동적 배열. 요소 추가/삭제 시 유연함.
        List<Integer> arrayList = new ArrayList<>();
        // 초기값 설정
        List<Integer> arrayListWithValues = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("Initialized ArrayList with values: " + arrayListWithValues);


        // 연결 리스트. 삽입/삭제가 빈번할 때 유리.
        List<String> linkedList = new LinkedList<>();

        // 요소 추가/삭제
        arrayList.add(10); // [10]
        arrayList.add(0, 5); // [5, 10]
        System.out.println("After adding elements: " + arrayList);
        arrayList.remove(1); // [5]
        System.out.println("After removing an element: " + arrayList);


        // 정렬
        List<Integer> sortExampleList = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9));
        System.out.println("Original list for sorting: " + sortExampleList);
        // 1. 오름차순
        Collections.sort(sortExampleList);
        System.out.println("Sorted ascending: " + sortExampleList);
        // 2. 내림차순
        Collections.sort(sortExampleList, Collections.reverseOrder());
        System.out.println("Sorted descending: " + sortExampleList);

        // 3. 커스텀 정렬 (Java 8+ 람다)
        List<String> strList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cat"));
        System.out.println("Original string list: " + strList);
        strList.sort(Comparator.comparingInt(String::length)); // 길이순 정렬
        System.out.println("Sorted by length: " + strList);
        System.out.println();
    }
}
