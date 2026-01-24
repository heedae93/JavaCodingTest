package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 문제: 정수 배열 정렬하기
 * * [문제 설명]
 * 정수 배열을 입력받아 오름차순으로 정렬하여 반환하는 solution 함수를 작성하십시오.
 * * [제약 사항]
 * 1. 정수 배열의 길이는 2 이상 100,000 이하입니다.
 * 2. 배열의 각 데이터 값은 -100,000 이상 100,000 이하인 정수입니다.
 */
public class AlgorithmProblem1 {


    @Test
    void main() {
        Solution sol1 = new Solution();   // Arrays.sort 풀이
        Solution2 sol2 = new Solution2(); // PriorityQueue(Heap) 풀이
        Solution3 sol3 = new Solution3(); // 버블 정렬 풀이

        int[] numbers1 = {4, 2, 1, 3, 5};
        int[] expected1 = {1, 2, 3, 4, 5};

        int[] numbers2 = {10, -5, 0, 3, -10};
        int[] expected2 = {-10, -5, 0, 3, 10};

        // 두 가지 풀이 모두 검증
        Assertions.assertArrayEquals(expected1, sol1.solution(numbers1.clone()));
        Assertions.assertArrayEquals(expected1, sol2.solution(numbers1.clone()));
        Assertions.assertArrayEquals(expected1, sol3.solution(numbers1.clone()));

        Assertions.assertArrayEquals(expected2, sol1.solution(numbers2.clone()));
        Assertions.assertArrayEquals(expected2, sol2.solution(numbers2.clone()));
        Assertions.assertArrayEquals(expected2, sol3.solution(numbers2.clone()));
    }

    // 1. Arrays.sort() 방식: Dual-Pivot Quicksort 활용
    class Solution {
        public int[] solution(int[] arr) {
            // 원본 배열을 직접 정렬하거나 복사본을 정렬합니다.
            // 시간 복잡도: O(N log N)
            // 원본 배열을 유지하고 싶다면 clone() 사용
            // int[] arrCopy = arr.clone();
            // Arrays.sort(arrCopy);
            // return arrCopy;

            Arrays.sort(arr);
            return arr;
        }
    }

    // 2. PriorityQueue 방식: Heap Sort 원리 활용
    class Solution2 {
        public int[] solution(int[] arr) {
            // 우선순위 큐는 내부적으로 최소 힙(Min-Heap)으로 동작합니다.
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            // 모든 요소를 힙에 삽입: O(N log N)
            for (int num : arr) {
                pq.add(num);
            }

            // 힙에서 하나씩 꺼내어 배열에 담음 (오름차순 보장): O(N log N)
            int[] result = new int[arr.length];
            int index = 0;
            while (!pq.isEmpty()) {
                result[index++] = pq.poll();
            }

            return result;
        }
    }

    // 3. 버블 정렬 방식: 인접한 두 원소를 비교하며 정렬
    class Solution3 {
        public int[] solution(int[] arr) {
            int len = arr.length;

            for(int i = 0; i < len -1; i ++){
                for(int j = 0; j < len -1-i; j ++) {
                    if(arr[j] > arr[j+1]) {
                        int temp = arr[j + 1];
                        arr[j+1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

            return arr;
        }
    }
}
