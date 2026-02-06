import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Fast I/O를 사용한 입력 처리 예제
 * Scanner 대신 BufferedReader와 StringTokenizer를 사용하여 대량의 데이터를 빠르게 처리합니다.
 */
public class FastIOExample {

    public static void main(String[] args) throws IOException {
        // Fast I/O 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // --- 입력 처리 예시 ---
        // 1. 한 줄에 하나의 정수 입력
        // 예시 입력:
        // 5
        // 1 5 2 4 3
        System.out.println("한 줄에 정수 하나, 다음 줄에 여러 개의 정수를 공백으로 구분하여 입력하세요.");
        System.out.println("예시:\n5\n1 5 2 4 3");

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
        bw.write("정렬된 배열: ");
        bw.write(Arrays.toString(nums));
        bw.newLine(); // 줄바꿈

        // --- 버퍼 비우기 및 스트림 닫기 ---
        bw.flush();
        bw.close();
        br.close();
    }
}
