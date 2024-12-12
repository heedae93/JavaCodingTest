package solution;

import java.util.Arrays;

public class sortArray {

    /**
     * 정수 배열을 입력 받아 정렬하는 알고리즘
     * 제약 조건 : 정수 배열의 길이는 2이상 10^5 이하, 정부 배열의 데이터 값은 -1000000이상 1000000이하
     * 입출력 예시 : [1,-5,2,4,3] => [-5,1,2,3,4] , [2,1,1,3,2,5,4] => [1,1,2,2,3,4,5]
     */


    public static void main(String[] args) {
        solution(new int[]{1, -5, 2,99, -8,4, 3});
        solution2(new int[100000]);
        solution3(new int[100000]);

    }

    // 풀이 1 : Arrays.sort() 메소드를 이용한 풀이
    public static int[] solution(int[] nums) {
        long start = System.currentTimeMillis();
        Arrays.sort(nums);
        long end = System.currentTimeMillis();
        System.out.println("수행 시간 : " + (end - start) + "ms"); // 1ms
        return nums;
    }

    // 풀이 2 : Arrays.sort() 메소드를 이용한 풀이, clone() 메소드를 이용하여 원본 배열을 보존
    public static int[] solution2(int[] nums) {
        long start = System.currentTimeMillis();
        int[] clone = nums.clone();
        Arrays.sort(clone);
        long end = System.currentTimeMillis();
        System.out.println("수행 시간 : " + (end - start) + "ms"); // 1ms
        return clone;
    }

    // 풀이 3 : 버블 정렬 알고리즘을 이용한 풀이
    public static int[] solution3(int[] nums) {

        int[] clone = nums.clone();
        long start = System.currentTimeMillis();
        for ( int i = 0; i <clone.length; i++) {
            for( int j= 0; j < clone.length- 1 -i ; j++){
                    if(clone[j] > clone[j+1]) {
                        int temp = clone[j];
                        clone[j] = clone[j+1];
                        clone[j+1] = temp;
                    }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("수행 시간 : " + (end - start) + "ms");
        return clone;
    }

}
