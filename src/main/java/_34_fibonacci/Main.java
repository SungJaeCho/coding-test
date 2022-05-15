package _34_fibonacci;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int ans = fibo(n);
        System.out.println(ans);

    }
    public static int fibo(int n) {
        if(n <= 1) {
            return n;
        } else {
            return fibo(n-1) + fibo(n-2);
        }
    }

}
