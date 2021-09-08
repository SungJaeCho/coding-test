package _27_snail;

//입력 n에 따른 달팽이모양의 숫자를 출력하시오
// 5
//  1  2  3  4 5
// 16 17 18 19 6
// 15 24 25 20 7
// 14 23 22 21 8
// 13 12 11 10 9

import java.util.Scanner;

public class Main {
    static int n = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("n의 값 입력");

        n = in.nextInt();
        solution(n);
    }
    public static void solution(int n) {
        int[][] arr = new int[n][n]; // 왜 10으로 생성했을까...

        int x = 0;
        int y = 0;
        int inputNum = 1;
        int f = n; //몇번을 이동할것인가 관리하는 변수

        for(int i=0; i<n*2-1; i++) { // 도는 횟수 12345 다음에 6789 다음에 10 11 12 13 꺽는순
            switch (i%4) {
                case 0: // 오른쪽 방향
                    for(int k=0; k < f; k++) {
                        arr[y][x] = inputNum;
                        x++;
                        inputNum++;
                    }
                    x--;
                    y++;
                    f--;
                    break;
                case 1: // 아래로
                    for(int k=0; k < f; k++) {
                        arr[y][x] = inputNum;
                        y++;
                        inputNum++;
                    }
                    x--;
                    y--;
                    break;
                case 2: // 왼쪽
                    for(int k=0; k < f; k++) {
                        arr[y][x] = inputNum;
                        x--;
                        inputNum++;
                    }
                    x++;
                    y--;
                    f--;
                    break;
                case 3: // 위
                    for(int k=0; k < f; k++) {
                        arr[y][x] = inputNum;
                        y--;
                        inputNum++;
                    }
                    x++;
                    y++;
                    break;
           }

        }
        print(arr);


    }
    public static void print(int[][] arr) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.printf("%4d",arr[i][j]);
            }
            System.out.println();
        }

    }
}
