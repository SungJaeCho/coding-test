package leetcode;

import java.util.Arrays;

public class Easy_2160 {
    public static void main(String[] args) {
        int num = 2932;
        System.out.println(minimumSum(num));
    }

    public static int minimumSum(int num) {
        int[] sortedArr = new int[4];
        for (int i = 0; i < 4; i++) {
            sortedArr[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(sortedArr);
        return sortedArr[0] * 10 + sortedArr[1] * 10 + sortedArr[2] + sortedArr[3];
    }
}
