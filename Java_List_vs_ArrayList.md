# Java: List vs. ArrayList 차이점

Java 컬렉션 프레임워크에서 `List`와 `ArrayList`는 매우 흔하게 사용되지만, 둘의 정확한 관계와 차이점을 아는 것은 중요합니다.

---

## 1. List (인터페이스)

`List`는 Java Collections Framework의 **인터페이스(Interface)**입니다. List 인터페이스는 다음과 같은 특징을 가집니다:

-   **순서가 있는(Ordered) 컬렉션**: 요소의 추가 순서가 유지됩니다. 즉, 인덱스를 통해 요소에 접근할 수 있습니다.
-   **중복 허용(Allows Duplicates)**: 동일한 요소를 여러 번 저장할 수 있습니다.
-   **구현체**: `List` 인터페이스는 그 자체로 객체를 생성할 수 없으며, 반드시 이를 구현하는 클래스를 통해 사용해야 합니다. 대표적인 구현체로는 `ArrayList`, `LinkedList`, `Vector` 등이 있습니다.

### 주요 메서드 (List 인터페이스에 정의):

-   `add(E element)`: 요소를 추가합니다.
-   `get(int index)`: 특정 인덱스의 요소를 반환합니다.
-   `set(int index, E element)`: 특정 인덱스의 요소를 교체합니다.
-   `remove(int index)`: 특정 인덱스의 요소를 삭제합니다.
-   `size()`: 리스트의 요소 수를 반환합니다.
-   `indexOf(Object o)`: 특정 요소의 첫 번째 등장 인덱스를 반환합니다.

### List 사용의 장점:

-   **추상화**: 실제 구현 클래스에 덜 의존적인 코드를 작성할 수 있습니다. 예를 들어, 메서드의 인자나 반환 타입으로 `List`를 사용하면, 나중에 `ArrayList` 대신 `LinkedList`로 구현을 변경하더라도 호출하는 코드에 영향을 주지 않습니다.
-   **유연성**: 다양한 `List` 구현체 중에서 특정 상황에 가장 적합한 것을 선택하여 사용할 수 있습니다.

**선언 및 초기화 예시**:

```java
List<String> myList = new ArrayList<>(); // List 인터페이스를 참조하지만, 실제 객체는 ArrayList
List<Integer> anotherList = new LinkedList<>(); // List 인터페이스를 참조하지만, 실제 객체는 LinkedList
```

---

## 2. ArrayList (클래스)

`ArrayList`는 `List` 인터페이스를 **구현(Implement)**한 **클래스(Class)**입니다. `ArrayList`는 내부적으로 **동적 배열(Dynamic Array)**을 사용하여 요소를 저장합니다.

-   **내부 구현**: 크기가 가변적인 배열을 기반으로 합니다. 배열이 가득 차면 더 큰 새 배열을 생성하고 기존 요소를 복사하는 방식으로 크기를 조절합니다.
-   **접근(Access) 속도**: 인덱스를 통한 요소 접근(`get(index)`)이 매우 빠릅니다. (O(1))
-   **삽입/삭제(Insertion/Deletion) 속도**: 중간에 요소를 삽입하거나 삭제할 경우, 그 이후의 모든 요소를 이동시켜야 하므로 성능 저하가 발생할 수 있습니다. (O(n))
-   **비동기(Non-synchronized)**: 여러 스레드가 동시에 `ArrayList`에 접근하여 수정할 경우, 데이터 불일치 문제가 발생할 수 있습니다. (Thread-safe 하지 않음). 멀티스레드 환경에서는 `Collections.synchronizedList()`를 사용하거나 `Vector`를 고려할 수 있습니다.

### ArrayList 사용 예시:

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(); // ArrayList로 직접 선언

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("첫 번째 요소: " + names.get(0)); // Alice
        System.out.println("리스트 크기: " + names.size()); // 3

        names.remove(1); // Bob 삭제
        System.out.println("삭제 후 리스트: " + names); // [Alice, Charlie]

        // List 인터페이스를 통해 참조하여 사용 (일반적으로 권장되는 방식)
        List<String> cities = new ArrayList<>();
        cities.add("Seoul");
        cities.add("Busan");
        System.out.println("도시 리스트: " + cities); // [Seoul, Busan]
    }
}
```

---

## 3. 주요 차이점 요약

| 특징         | List (인터페이스)                                    | ArrayList (클래스)                                     |
| :----------- | :--------------------------------------------------- | :------------------------------------------------------- |
| **정의**     | 순서가 있는 컬렉션의 동작을 정의하는 **규약(Interface)** | `List` 인터페이스를 구현하는 **클래스(Class)**           |
| **객체 생성**| 직접 객체 생성 불가 (`new List()` X)                 | 직접 객체 생성 가능 (`new ArrayList()` O)                |
| **구현 방식**| 없음 (규약만 정의)                                   | 동적 배열을 사용하여 요소 저장                           |
| **성능 특징**| 구현체에 따라 다름                                   | 인덱스 접근 빠름 (O(1)), 중간 삽입/삭제 느림 (O(n))      |
| **활용**     | 메서드 인자, 반환 타입 등 추상화 계층으로 사용 권장    | `List`의 대표적인 구현체로, 내부 구현이 동적 배열일 때 사용 |
| **Thread-safe** | 구현체에 따라 다름                                   | Not Thread-safe (동기화되지 않음)                        |

---

## 4. 언제 무엇을 사용해야 할까?

일반적으로 Java 코드를 작성할 때는 다음과 같은 원칙을 따르는 것이 좋습니다.

-   **선언 시에는 `List` 인터페이스를 사용하세요.**
    `List<String> myList = new ArrayList<>();`
    이렇게 하면 코드의 유연성이 높아지고, 나중에 필요에 따라 `ArrayList` 대신 `LinkedList`와 같은 다른 `List` 구현체로 쉽게 변경할 수 있습니다.

-   **`ArrayList`는 다음 상황에 적합합니다.**
    -   요소에 대한 **인덱스 기반의 빠른 접근**이 자주 필요한 경우.
    -   리스트의 **중간 삽입/삭제 작업이 드물고**, 주로 리스트의 끝에 요소를 추가하거나 전체를 순회하는 경우.

-   `LinkedList`는 리스트의 **중간 삽입/삭제가 빈번**하게 일어나는 경우에 더 적합합니다.

이해를 돕기 위해, `List`는 "탈 것"이라는 추상적인 개념이고, `ArrayList`는 "자동차"라는 구체적인 "탈 것"의 한 종류라고 비유할 수 있습니다. "탈 것"을 타겠다고 말할 때는 어떤 구체적인 탈 것(자동차, 자전거 등)을 탈지는 나중에 결정할 수 있는 유연성을 제공하는 것과 같습니다.
