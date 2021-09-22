package _36_decToBin;

import java.util.Scanner;

/*
입력된 수를 이진수로 변환하세요
17
정답: 1 0001
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        decToBin(input);
    }
    public static void decToBin(int N) {
        if(N/2 == 0) {
            System.out.print(N);
            return;
        }
        decToBin(N/2);
        System.out.print(N%2);
    }
}
