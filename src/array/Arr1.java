package array;


import java.util.Arrays;

/**
 * [문제]
 * 정수 배열을 정렬해서 반환하는 solution()함수를 완성하시오
 * [제약 조건]
 * 정수 배열의 길이는 2 이상 10^5이하
 * 정수 배열의 각 데이터 값은 -100000 이상 100000 이하
 */
public class Arr1 {
    public static void main(String[] args) {
        int [] arr = new int[100000];

        long start = System.currentTimeMillis();

        int [] bubble = bubbleSort(arr);

        long end = System.currentTimeMillis();
        System.out.println((end - start)/ 1000.0); // 3.574

        long startSort = System.currentTimeMillis();

        int[] sort = sortApi(arr);

        long endSort = System.currentTimeMillis();
        System.out.println((endSort - startSort) / 1000.0); //0.002

    }

    private static int [] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len -1; j++){
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    private static int [] sortApi(int[] arr) {
        // sort메서드는 정렬된 배열을 반환하지는 않는다. 따라서 arr을 따로 리턴해줘야 함.
        // return Arrays.sort(arr) 불가능
        Arrays.sort(arr);
       return arr;
    }
}


