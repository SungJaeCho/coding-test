package dp;

import java.util.Arrays;

public class CountingBits338 {
    public static void main(String[] args) {
        int n = 5;
//        System.out.println(Arrays.toString(countingBits(n)));
        System.out.println(Arrays.toString(countBits(n)));
    }
    public static int[] countingBits(int n) {
        int[] result = new int[n+1];
        for(int i=0; i <= n; i++) {
            int dividend = i; // 피제수
            int sum =0;
            while(dividend > 0) {
                sum += dividend%2;
                dividend = dividend/2;
            }
            result[i] = sum;
        }

        return result;
    }

    public static int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++){
            System.out.println("f[i >> 1] : " + f[i >> 1]);
            System.out.println("i & 1 : " + (i & 1));
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }
}
