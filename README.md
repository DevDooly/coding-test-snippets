# Coding Test Snippets & Algorithm Examples

이 프로젝트는 코딩 테스트 준비와 Java 학습을 위한 알고리즘 구현체, 자료구조 예제, 그리고 다양한 Java 문법 활용 패턴을 모아둔 저장소입니다.

최근 프로젝트 구조가 **Gradle 기반**으로 개편되어, 각 예제 코드를 독립적인 테스트 케이스로 실행하고 검증할 수 있습니다.

## 🛠 기술 스택 (Tech Stack)

- **Language:** Java 17
- **Build Tool:** Gradle
- **Testing:** JUnit 5, AssertJ

## 📂 프로젝트 구조 (Project Structure)

```
src/
├── main/java/          # 알고리즘 및 자료구조 구현 소스
│   ├── algorithms/     # DP, Graph, Search 등 알고리즘 예제
│   └── datastructures/ # List, Map, Set, Stack 등 자료구조 예제
└── test/java/          # 학습용 테스트 코드 및 예제 검증
    └── streams/        # Java Stream API 활용 패턴 예제
```

## 🚀 실행 방법 (How to Run)

이 프로젝트는 Gradle을 사용하여 테스트를 실행합니다. 터미널에서 아래 명령어를 사용하세요.

### 1. 전체 테스트 실행
모든 예제와 알고리즘 테스트를 수행합니다.
```bash
gradle test
```

### 2. 특정 테스트 클래스 실행
특정 주제(예: Stream API)의 테스트만 실행하고 싶을 때 사용합니다.
```bash
gradle test --tests "streams.StreamExamplesTest"
```

### 3. 특정 케이스(메서드) 실행
특정 메서드 하나만 콕 집어서 실행할 수 있습니다.
```bash
gradle test --tests "streams.StreamExamplesTest.filterExample"
```

## 📝 주요 포함 내용

- **Algorithms:** DP (Knapsack, LCS), Graph (Dijkstra, MST), Search, Sorting
- **Data Structures:** Custom implementations & usage examples of Stack, Queue, Map, etc.
- **Java Streams:** Filtering, Mapping, Grouping, Partitioning, Statistics 등 실무 및 테스트용 패턴

---
*Created by DevDooly*
