package _10_numRec1;

// 숫자 사각형 1
// input 4일시
// 1 2 3 4
// 5 6 7 8
// 9 10 11 12
// 13 14 15 16
public class Main {
    public static void main(String[] args) {
        int n = 2000;
        one(n);
        two(n);
    }

    public static void one(int n) {
        long start = System.currentTimeMillis();
        for(int i=1; i <= n*n ; i++) {
            System.out.printf("%5d", i);
            if(i%n == 0) {
                System.out.println();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("걸린시간 :"+(end-start));
    }
    public static void two(int n) {
        long start = System.currentTimeMillis();
        for(int j=0; j<n; j++){
            for(int i=0; i<n; i++) {
                System.out.printf("%5d", j*(n)+i+1);
            }
            System.out.println();
        }
        long end = System.currentTimeMillis();
        System.out.println("걸린시간 :"+(end-start));
    }
}
