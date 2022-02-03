package insertSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] arr = scan.nextLine().split(" ");

        System.out.println(Arrays.toString(arr));
        for(int i=1; i<arr.length; i++) {
            String temp;
            for(int j=i; j>0; j--) {
                if(Integer.parseInt(arr[j]) < Integer.parseInt(arr[j-1])) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                } else {
                    continue;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
