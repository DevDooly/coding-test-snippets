import java.util.function.Predicate;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Java 8에 도입된 함수형 인터페이스 중 하나인 Predicate 사용 예제입니다.
 *
 * Predicate<T>는 T 타입의 객체를 인자로 받아 boolean을 반환하는 함수형 인터페이스입니다.
 * 주로 '어떤 조건을 테스트'하는 데 사용되며, stream의 filter() 메서드와 궁합이 좋습니다.
 *
 * @version Java 8+
 * @author DevDooly
 */
public class PredicateExample {

    public static void main(String[] args) {

        // --- 1. 기본 Predicate 사용법 ---
        // 문자열의 길이가 5보다 큰지 확인하는 Predicate
        Predicate<String> isLengthGreaterThan5 = str -> str.length() > 5;

        // 테스트
        String testString1 = "hello";
        String testString2 = "helloworld";

        System.out.println("'" + testString1 + "'의 길이는 5보다 큰가? " + isLengthGreaterThan5.test(testString1)); // false
        System.out.println("'" + testString2 + "'의 길이는 5보다 큰가? " + isLengthGreaterThan5.test(testString2)); // true
        System.out.println("---");


        // --- 2. Stream.filter()와 함께 사용하기 ---
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 짝수만 필터링하는 Predicate
        Predicate<Integer> isEven = number -> number % 2 == 0;

        List<Integer> evenNumbers = numbers.stream()
                                           .filter(isEven)
                                           .collect(Collectors.toList());
        System.out.println("원본 리스트: " + numbers);
        System.out.println("짝수만 필터링: " + evenNumbers); // [2, 4, 6, 8, 10]
        System.out.println("---");


        // --- 3. 여러 Predicate 조합하기 (and, or, negate) ---
        // 5보다 큰 수를 찾는 Predicate
        Predicate<Integer> isGreaterThan5 = number -> number > 5;

        // and(): 두 조건을 모두 만족 (짝수이면서 5보다 큰 수)
        Predicate<Integer> isEvenAndGreaterThan5 = isEven.and(isGreaterThan5);
        List<Integer> evenAndGreaterNumbers = numbers.stream()
                                                      .filter(isEvenAndGreaterThan5)
                                                      .collect(Collectors.toList());
        System.out.println("짝수이면서 5보다 큰 수: " + evenAndGreaterNumbers); // [6, 8, 10]

        // or(): 두 조건 중 하나라도 만족 (짝수이거나 5보다 큰 수)
        Predicate<Integer> isEvenOrGreaterThan5 = isEven.or(isGreaterThan5);
        List<Integer> evenOrGreaterNumbers = numbers.stream()
                                                     .filter(isEvenOrGreaterThan5)
                                                     .collect(Collectors.toList());
        System.out.println("짝수이거나 5보다 큰 수: " + evenOrGreaterNumbers); // [2, 4, 6, 7, 8, 9, 10]

        // negate(): 조건의 결과를 반전 (isEven의 반대 -> 홀수)
        Predicate<Integer> isOdd = isEven.negate();
        List<Integer> oddNumbers = numbers.stream()
                                          .filter(isOdd)
                                          .collect(Collectors.toList());
        System.out.println("홀수만 필터링: " + oddNumbers); // [1, 3, 5, 7, 9]
        System.out.println("---");

        // --- 4. 객체 리스트에 적용하기 ---
        List<Person> people = Arrays.asList(
            new Person("Alice", 25),
            new Person("Bob", 17),
            new Person("Charlie", 30),
            new Person("David", 19)
        );

        // 성인인지 판별하는 Predicate (나이가 20세 이상)
        Predicate<Person> isAdult = person -> person.getAge() >= 20;

        List<Person> adults = people.stream()
                                    .filter(isAdult)
                                    .collect(Collectors.toList());
        System.out.println("성인 리스트: " + adults);
    }
}

/**
 * Predicate 예제에 사용할 간단한 Person 클래스
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
