package _12_numRec3;

// n = 4
// 1 5 9 13
// 2 6 10 14
// 3 7 11 15
// 4 8 12 16

public class Main {
    public static void main(String[] args) {
        int n = 4;
        one(n);
        two(n);
    }

    public static void one(int n) {
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                arr[i][j] = i + j * n + 1 ;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                System.out.printf("%4d",arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void two(int n) {
        int num = 1;
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                arr[j][i] = num;
                num++;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                System.out.printf("%4d",arr[i][j]);
            }
            System.out.println();
        }
    }
}
