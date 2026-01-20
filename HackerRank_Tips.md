# 해커랭크(HackerRank) Java 개발자를 위한 꿀팁

해커랭크 환경에 처음 입문하는 Java 개발자를 위한 가이드입니다. 일반적인 코딩 테스트 환경과 다른 해커랭크 특유의 방식을 익혀두면 당황하지 않고 문제에 집중할 수 있습니다.

---

## 1. 입력(Input) 처리 방식: 두 가지를 구분하세요!

해커랭크의 문제 유형은 크게 두 가지로 나뉩니다. **반드시 문제 설명과 초기 코드를 확인하여 어떤 방식인지 파악해야 합니다.**

###  방식 1: 함수 시그니처만 구현 (Solution 클래스 내부)

대부분의 문제가 이 방식에 해당합니다. 입출력 전체를 구현할 필요 없이, **주어진 메서드의 로직만 완성**하면 됩니다.

- **특징**:
  - `main` 함수가 숨겨져 있으며, 해커랭크 시스템이 `stdin`으로부터 입력을 받아와 파싱한 후, 우리가 작성할 함수의 인자(parameter)로 넘겨줍니다.
  - 리턴 타입에 맞춰 결과값을 `return`하면, 시스템이 알아서 `stdout`으로 출력합니다.
  - `BufferedReader`, `StringTokenizer` 등을 **사용할 필요가 없습니다.**

- **예시 코드 (`Result.java` 또는 `Solution.java`)**:
  ```java
  class Result {
      /*
       * 'a'와 'b'는 이미 파싱되어 들어옵니다.
       * 우리는 두 수의 합을 리턴하기만 하면 됩니다.
       */
      public static int solveMeFirst(int a, int b) {
          return a + b;
      }
  }
  ```

### 방식 2: 표준 입출력(stdin/stdout) 직접 처리

간혹 `main` 함수를 포함한 전체 코드를 직접 작성해야 하는 문제가 있습니다. "Input Format"에 명시된 대로 입력을 직접 읽고, "Output Format"에 맞춰 출력해야 합니다.

- **특징**:
  - `public static void main(String[] args)` 함수 내에서 모든 로직이 시작됩니다.
  - 대량의 데이터를 효율적으로 처리하기 위해 `Scanner`보다는 `BufferedReader`와 `StringTokenizer` 사용을 권장합니다.
  - `System.out.println()` 이나 `BufferedWriter`를 사용하여 직접 출력해야 합니다.

- **예시 코드 (`Solution.java`)**:
  ```java
  import java.io.*;
  import java.util.*;

  public class Solution {
      public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = new StringTokenizer(br.readLine());
          int n = Integer.parseInt(st.nextToken());
          // ... 이후 로직 직접 구현 ...
          System.out.println("결과");
      }
  }
  ```

---

## 2. 필수 Import 패키지

해커랭크는 기본적으로 몇몇 패키지를 자동으로 `import` 해주지만, 만약을 대비해 필요한 패키지를 명시적으로 선언하는 것이 안전합니다.

- **거의 항상 필요한 패키지**:
  ```java
  import java.io.*;      // BufferedReader, BufferedWriter 등
  import java.util.*;    // List, Map, Set, Scanner, StringTokenizer 등
  import java.text.*;    // 날짜/시간 포맷팅
  import java.math.*;    // BigInteger, BigDecimal 등
  import java.util.regex.*; // 정규 표현식
  ```
- **팁**: 일단 위 패키지들을 모두 복사해서 코드 상단에 붙여넣고 시작하면, `import` 관련 오류를 방지할 수 있습니다.

---

## 3. 기타 알아두면 좋은 팁

### 디버깅은 `System.out.println`? -> `System.err.println`!

- `System.out.println()`으로 디버깅 메시지를 출력하면, **정답 출력(stdout)으로 간주되어 오답 처리**될 수 있습니다.
- 대신, **`System.err.println()`**을 사용하세요. 표준 에러(stderr) 스트림으로 출력되는 내용은 채점 시 무시됩니다.
- **예시**:
  ```java
  public static List<Integer> gradingStudents(List<Integer> grades) {
      System.err.println("입력된 성적 리스트: " + grades);
      // ... 로직 ...
      int finalGrade = ...;
      System.err.println("최종 성적: " + finalGrade);
      return result;
  }
  ```

### 부족한 자동완성(Auto-completion)에 대비하기

- 해커랭크의 코드 에디터는 최신 IDE만큼 강력한 자동완성을 지원하지 않습니다.
- `List`, `Map` 등 주요 자료구조의 핵심 메서드명(`add`, `get`, `put`, `containsKey`, `size` 등)은 미리 숙지해두는 것이 좋습니다.
- 복잡한 로직이나 익숙하지 않은 API는 로컬 IDE(IntelliJ, Eclipse 등)에서 먼저 작성하고 테스트한 후, 해커랭크 에디터에 붙여넣는 것도 좋은 전략입니다.

### 실행 환경(Environment) 확인하기

- 해커랭크는 보통 **Java 8 또는 Java 15** 환경에서 코드를 실행합니다. (문제마다 상이할 수 있음)
- `var` 키워드(Java 10+), `record`(Java 14+) 등 최신 버전의 문법은 지원되지 않을 수 있으니, 가급적 안정적인 Java 8 문법을 사용하는 것이 안전합니다.
- 만약 `switch expression` 이나 `text block` 같은 최신 기능을 사용하고 싶다면, 먼저 코드 제출 화면 우측 상단에서 **Java 버전을 변경할 수 있는지 확인**해보세요.
