package _38_chickenCoupon;

import java.util.Scanner;

// 백준 https://www.acmicpc.net/problem/1673
public class Main2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        solution01(n, 0, k, 0);

    }

    public static void solution01(int coupon, int stamp, int k, int ans) {
        if(coupon ==0 && stamp/k == 0) {
            System.out.println(ans);
        }

        if(coupon > 0) {
            coupon--;
            stamp++;
            ans++;
            solution01(coupon, stamp, k, ans);
        } else if(stamp > 0) {
            if(stamp/k > 0) {
                stamp -= k;
                coupon++;
                solution01(coupon, stamp, k, ans);
            }
        }
    }
}
