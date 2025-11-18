package array;


import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * [문제]
 * 배열의 중복을 제거하고 , 내림차순으로 정렬하는 함수를 완성하시오
 * [제약 조건]
 * 배열 길이는 2이상 1000이하이다.
 * 각 배열의 데이터 값은 -100000 이상 100000 이하 이다.
 */
public class Arr2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,3};

        useStream(arr);

    }

    private static void useStream(int[] arr) {
        Integer[] stream = Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(stream));
    }
}
