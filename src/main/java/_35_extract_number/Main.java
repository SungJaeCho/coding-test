package _35_extract_number;

import java.util.Scanner;

/*
입력된 수를 높은 자릿수 부터 출력하시오
2312
정답:
2
3
1
2
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        extract(input);
    }
    public static void extract(int N) {
        if(N/10 == 0) {
            System.out.println(N);
            return;
        }
        extract(N/10);
        System.out.println(N%10);
    }
}
