package _26_sangsu;

/*
상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 예를 들어, 734과 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다. 따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.

예제 입력: 734 893
예제 출력: 437

출처: 백준 (2908번)
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("두개의 값 입력");
        int n1 = in.nextInt();
        int n2 = in.nextInt();

        System.out.printf("출력: %d", solution01(n1, n2));
    }
    public static int solution01(int n1, int n2) {
        int rev_n1 = 0;
        int rev_n2 = 0;

        while (n1 > 0) {
            rev_n1 = n1 % 10 + rev_n1 * 10;
            n1 /= 10;
        }
        while (n2 > 0) {
            rev_n2 = n2 % 10 + rev_n2 * 10;
            n2 /= 10;
        }

        return Math.max(rev_n1, rev_n2);
    }
}
