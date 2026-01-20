import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Java 코딩 테스트 만능 템플릿
 * HackerRank 및 일반적인 코딩 테스트 환경에서 바로 사용할 수 있도록 제작되었습니다.
 *
 * @version Java 17+
 * @author DevDooly
 */
public class Template {

    /**
     * 메인 함수: Fast I/O를 사용한 입력 처리
     * Scanner 대신 BufferedReader와 StringTokenizer를 사용하여 대량의 데이터를 빠르게 처리합니다.
     */
    public static void main(String[] args) throws IOException {
        // Fast I/O 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // --- 입력 처리 예시 ---
        // 1. 한 줄에 하나의 정수 입력
        int n = Integer.parseInt(br.readLine());

        // 2. 한 줄에 여러 개의 정수 입력 (공백 구분)
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // --- 알고리즘 로직 수행 ---
        // 예: 입력받은 배열을 정렬하고 출력
        Arrays.sort(nums);


        // --- 출력 처리 ---
        bw.write(Arrays.toString(nums));
        bw.newLine(); // 줄바꿈

        // --- 버퍼 비우기 및 스트림 닫기 ---
        bw.flush();
        bw.close();
        br.close();
    }


    /**
     * 자료구조 초기화 및 핵심 메소드 예제
     */
    public static void dataStructures() {

        // --- List: ArrayList, LinkedList ---
        // 동적 배열. 요소 추가/삭제 시 유연함.
        List<Integer> arrayList = new ArrayList<>();
        // 초기값 설정
        List<Integer> arrayListWithValues = new ArrayList<>(Arrays.asList(1, 2, 3));

        // 연결 리스트. 삽입/삭제가 빈번할 때 유리.
        List<String> linkedList = new LinkedList<>();

        // 요소 추가/삭제
        arrayList.add(10); // [10]
        arrayList.add(0, 5); // [5, 10]
        arrayList.remove(1); // [5]

        // 정렬
        // 1. 오름차순
        Collections.sort(arrayList);
        // 2. 내림차순
        Collections.sort(arrayList, Collections.reverseOrder());
        // 3. 커스텀 정렬 (Java 8+ 람다)
        List<String> strList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cat"));
        strList.sort(Comparator.comparingInt(String::length)); // 길이순 정렬


        // --- Map: HashMap ---
        // Key-Value 쌍으로 데이터를 저장. Key는 중복될 수 없음.
        Map<String, Integer> map = new HashMap<>();

        // 데이터 추가/수정
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Apple", 3); // "Apple" 키의 값이 3으로 덮어씌워짐

        // 데이터 조회
        int value = map.get("Banana"); // 2
        // 키가 없을 경우 기본값 반환
        int defaultValue = map.getOrDefault("Cat", 0); // 0

        // Map 순회
        // 1. KeySet 순회
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
        // 2. EntrySet 순회 (더 효율적)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


        // --- Set: HashSet ---
        // 중복을 허용하지 않는 데이터 집합. 순서를 보장하지 않음.
        Set<Integer> set = new HashSet<>();

        // 데이터 추가
        set.add(1);
        set.add(2);
        set.add(1); // 중복된 1은 추가되지 않음

        // 포함 여부 확인
        boolean containsTwo = set.contains(2); // true

        // 데이터 삭제
        set.remove(1);

        // List -> Set (중복 제거)
        List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        Set<Integer> uniqueNumbers = new HashSet<>(numberList); // {1, 2, 3}


        // --- Queue/Stack ---
        // Queue: FIFO(First-In, First-Out). LinkedList로 구현.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 데이터 추가
        queue.offer(2);
        int front = queue.poll(); // 데이터 꺼내기 (1)
        int peek = queue.peek(); // 맨 앞 데이터 확인 (2)

        // Stack: LIFO(Last-In, First-Out).
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // 데이터 추가
        stack.push(2);
        int top = stack.pop(); // 데이터 꺼내기 (2)
        int peekStack = stack.peek(); // 맨 위 데이터 확인 (1)

        // Deque: 양쪽 끝에서 삽입/삭제 가능한 자료구조. 스택과 큐로 모두 활용 가능.
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        int first = deque.removeFirst();
        int last = deque.removeLast();


        // --- PriorityQueue: 우선순위 큐 ---
        // 데이터가 우선순위에 따라 자동으로 정렬되는 큐. 기본은 최소 힙(Min Heap).
        // 1. 최소 힙 (기본)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(30);
        minHeap.add(10);
        minHeap.add(20);
        System.out.println(minHeap.poll()); // 10 (가장 작은 값)

        // 2. 최대 힙 (내림차순)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(20);
        System.out.println(maxHeap.poll()); // 30 (가장 큰 값)

        // 3. 커스텀 객체 정렬
        class Node implements Comparable<Node> {
            int cost;
            int id;

            Node(int id, int cost) {
                this.id = id;
                this.cost = cost;
            }

            // cost가 낮은 순서로 정렬 (최소 힙)
            @Override
            public int compareTo(Node other) {
                return this.cost - other.cost;
            }
        }
        PriorityQueue<Node> pqNode = new PriorityQueue<>();
        pqNode.add(new Node(1, 100));
        pqNode.add(new Node(2, 50));
        System.out.println(pqNode.poll().id); // 2 (cost가 가장 낮은 노드)
    }


    /**
     * 기타 유용한 유틸리티 함수
     */
    public static void utilityFunctions() {
        // --- 배열 출력 ---
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr)); // "[1, 2, 3, 4, 5]"

        // 2차원 배열 출력
        int[][] arr2d = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(arr2d)); // "[[1, 2], [3, 4]]"

        // --- 리스트/컬렉션 출력 ---
        List<Integer> list = List.of(1, 2, 3);
        System.out.println(list); // "[1, 2, 3]"

        // Stream API를 사용한 커스텀 출력
        String joinedString = list.stream()
                                  .map(String::valueOf)
                                  .collect(Collectors.joining(" -> ")); // "1 -> 2 -> 3"
        System.out.println(joinedString);


        // --- Math 관련 함수 ---
        int a = 10, b = 20;
        int maxVal = Math.max(a, b); // 20
        int minVal = Math.min(a, b); // 10
        int absVal = Math.abs(-15);  // 15
        long rounded = Math.round(10.5); // 11
    }
}
