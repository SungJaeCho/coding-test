package _21_removeNum;

public class Main {
    public static void main(String[] args) {
        int n = 101;
        boolean[] arr = new boolean[n];
        int[] inArr = new int[n];
        inArr[0] = 1;
        inArr[1] = 2;
        inArr[2] = 3;
        inArr[3] = 1;
        inArr[4] = 6;
        inArr[5] = 3;
        inArr[6] = 4;
        inArr[7] = 16;
        inArr[8] = 12;
        inArr[9] = 10;
        inArr[10] = 99;

        for(int i=0; i<=n-1; i++) {
            arr[inArr[i]] = true;
        }

        for(int i=1; i<=n-1; i++) {
            if(arr[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
