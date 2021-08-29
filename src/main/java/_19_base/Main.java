package _19_base;

// 거듭 제곱
// n의 m승의 결과 5 3 = 125
public class Main {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int rst = 1;

        for(int i=0; i<m; i++) {
            rst *= n;
        }
        System.out.println(rst);
    }
}
