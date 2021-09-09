package _28_jinsu;

import java.util.Scanner;

// 10진수 -> 2~16진수 변환
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("변환할 값을 입력하세요.");
        int n = in.nextInt();
        System.out.println("변경을 원하는 진수값을 입력하세요.");
        int jinsu = in.nextInt();

        solution01(n, jinsu);
    }

    public static void solution(int n, int jinsu) { //10진수까지만 가
        int[] arr = new int[100];
        int i = 0;

        while (n > 0) {
            arr[i] = n%jinsu;
            n /= jinsu;
            i++;
        }
        i--;
        for(; i>=0; i--){
            System.out.print(arr[i]);
        }
    }

    public static void solution01(int num, int jinsu) {
        char n[] = new char[100];
        // A, B, C

        int i= 0;
        while (num > 0) {
            int tmp = num % jinsu;
            if(tmp >= 10 && tmp <= jinsu-1) { // 16진수까지 있기때문에 15까지만 설정
                n[i] = (char) ('A'+(tmp-10));
            } else {
                n[i] = (char) ('0'+tmp);
            }
            num /= jinsu;
            i++;
        }

        for(; i>=0; i--){
            System.out.print(n[i]);
        }
    }

}
