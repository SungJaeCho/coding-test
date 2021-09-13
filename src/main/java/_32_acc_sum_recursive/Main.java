package _32_acc_sum_recursive;

import java.util.Scanner;

// 누적 합 재귀
// 1 4 => 10
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int end = scan.nextInt();

        int ans = 0;
        ans = calAccSum01(start, end);

        System.out.println("acc sum= " +ans);
    }
    public static int calAccSum(int start, int end) {
        if(end < 1) return 0;
        return end + calAccSum(start, end-1);
    }
    public static int calAccSum01(int start, int end) {
        if(start == end) return start;
        return start + calAccSum01(start+1, end);
    }
}
