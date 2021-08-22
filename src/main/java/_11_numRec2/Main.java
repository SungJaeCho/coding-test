package _11_numRec2;

// 숫자 사각형 2
// input 4일시
// 1 2 3 4
// 8 7 6 5
// 9 10 11 12
// 16 15 14 13
public class Main {
    public static void main(String[] args) {
        int n = 5;
        one(n);
    }

    public static void one(int n) {
        int arr[][] = new int[n][n];

        for(int i=0; i<n; i++) { //행
            if(i%2 == 0) { //짝수 행
                for(int j=0; j<n; j++) {
                    arr[i][j] = i * n + j + 1;
                }
            }
            else {//홀수
                for(int j=n-1; j >=0; j--) {
                    arr[i][j] = i * n + n - j;
                }

            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }



    }
}
