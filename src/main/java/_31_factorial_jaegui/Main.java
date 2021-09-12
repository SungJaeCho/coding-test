package _31_factorial_jaegui;

import java.util.Scanner;

// 팩토리얼 재귀
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        int ans = 0;
        ans = calFact(input);
        System.out.println(ans);
    }

    public static int calFact(int i){
        if(i == 1) return 1;
        return i*calFact(i-1);
    }
}
