package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashSet;

public class AlgorithmProblem3 {

    // --- JUnit 테스트 영역 ---

    @Test
    void 테스트_케이스_종합() {
        Solution sol1 = new Solution();   // 배열 풀이
        Solution2 sol2 = new Solution2(); // HashSet 풀이

        int[] numbers1 = {2, 1, 3, 4, 1};
        int[] expected1 = {2, 3, 4, 5, 6, 7};

        int[] numbers2 = {5, 0, 2, 7};
        int[] expected2 = {2, 5, 7, 9, 12};

        // 두 가지 풀이 모두 검증
        Assertions.assertArrayEquals(expected1, sol1.solution(numbers1));
        Assertions.assertArrayEquals(expected1, sol2.solution(numbers1));

        Assertions.assertArrayEquals(expected2, sol1.solution(numbers2));
        Assertions.assertArrayEquals(expected2, sol2.solution(numbers2));
    }


    // 배열로 풀이
    class Solution {
        public int[] solution(int[] numbers) {
            // 1. 모든 합을 담을 임시 배열 (n * n 크기)
            int[] temp = new int[numbers.length * numbers.length];
            int count = 0;

            // 2. 서로 다른 인덱스의 두 수를 더함
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    temp[count++] = numbers[i] + numbers[j];
                }
            }

            // 3. 실제 저장된 개수만큼 자르고 오름차순 정렬
            int[] validSums = Arrays.copyOf(temp, count);
            Arrays.sort(validSums);

            // 4. 중복 제거
            int[] resultTemp = new int[validSums.length];
            int uniqueCount = 0;
            if (validSums.length > 0) {
                resultTemp[uniqueCount++] = validSums[0];
                for (int i = 1; i < validSums.length; i++) {
                    if (validSums[i] != validSums[i - 1]) {
                        resultTemp[uniqueCount++] = validSums[i];
                    }
                }
            }

            // 5. 최종 결과 반환
            return Arrays.copyOf(resultTemp, uniqueCount);
        }
    }

    // 2. HashSet 방식: 컬렉션 프레임워크 활용 (중복 제거 자동)
    class Solution2 {
        public int[] solution(int[] numbers) {
            // 중복을 허용하지 않는 자료구조 선언
            HashSet<Integer> set = new HashSet<>();

            // 두 수의 합을 set에 저장 (중복은 알아서 걸러짐)
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    set.add(numbers[i] + numbers[j]);
                }
            }

            // set을 배열로 변환 후 정렬
            // Stream API를 쓰면 더 짧아지지만, 가독성을 위해 기본 변환 사용
            int[] result = new int[set.size()];
            int index = 0;
            for (int num : set) {
                result[index++] = num;
            }
            Arrays.sort(result);

            return result;
        }
    }



}