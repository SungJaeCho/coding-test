package _30_plus_and_minus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int util;
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        util = scan.nextInt();

        for(int i=1; i<=util; i++) {
            if(i == util) {
                System.out.print(i);
                break;
            }

            if(flag) {
                System.out.print(i+"+");
            } else {
                System.out.print(i+"-");
            }
        }
    }
}
