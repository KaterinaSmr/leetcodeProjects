import java.util.Arrays;

public class Main {
    /*>
Напишите функцию на входе которой массив целых чисел, на выходе подмассив наибольшей суммы.
: для массива [-2,1,-3,4,-1,2,1,-5,4] результатом будет: [4,-1,2,1]с суммой 6.
     */

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        getLargestSumSubseqWithRecursion(arr);


    }




    static int max;
    static int largestSubArr[];

    public static void getLargestSumSubseqWithRecursion(int[]arr){
        getMaxSubArr(arr);
        System.out.println("max = " + max);
        System.out.println("array:" + Arrays.toString(largestSubArr));

    }
    public static int[] getMaxSubArr(int[]arr){
        if (arr.length == 1){
            max = arr[0];
            largestSubArr = arr;
            return arr;
        }
        int[] maxSubArr = getMaxSubArr(Arrays.copyOfRange(arr, 1, arr.length));

        int sum = arr[0] + Arrays.stream(maxSubArr).sum();
        int[] newArr = new int[maxSubArr.length+1];
        System.arraycopy(maxSubArr, 0, newArr, 1, maxSubArr.length);
        newArr[0] = arr[0];
        System.out.println(Arrays.toString(newArr));

        if (sum > max){
            max = sum;
            largestSubArr = newArr;
        }

        if (sum < arr[0]) {
            return new int[]{arr[0]};
        }
        return newArr;
    }

}
