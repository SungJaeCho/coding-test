package _38_chickenCoupon;

import java.util.Scanner;

// 백준 https://www.acmicpc.net/problem/1673
public class Main {
    static int orderCount = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        solution01(n, k);

    }

    public static void solution01(int n, int k) {
        int stamp = 0;
        while(n > 0) {
            orderCount += n;
            stamp += n;
            n = stamp/k;
            if(n > 0){
                stamp = stamp - n*k;
            }
        }
        System.out.println(orderCount);
    }
}
