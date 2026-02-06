package datastructures.map;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        // --- Map: HashMap ---
        System.out.println("--- Map Examples ---");
        // Key-Value 쌍으로 데이터를 저장. Key는 중복될 수 없음.
        Map<String, Integer> map = new HashMap<>();

        // 데이터 추가/수정
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Apple", 3); // "Apple" 키의 값이 3으로 덮어씌워짐
        System.out.println("Map after puts: " + map);

        // 데이터 조회
        int value = map.get("Banana"); // 2
        System.out.println("Value for 'Banana': " + value);
        // 키가 없을 경우 기본값 반환
        int defaultValue = map.getOrDefault("Cat", 0); // 0
        System.out.println("Default value for 'Cat': " + defaultValue);

        // Map 순회
        System.out.println("Iterating through Map (EntrySet):");
        // EntrySet 순회 (더 효율적)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println();
    }
}
