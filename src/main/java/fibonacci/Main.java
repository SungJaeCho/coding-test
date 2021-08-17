package fibonacci;

public class Main {

    static long[] fibo;//이미 계산한걸 기억하는 변수
    final static int n = 50;

    //피보나치 수열 알고리즘
    public static void main(String[] args) {
        // F1 = F2 = 1
        // Fn = F(n-1) + F(n-2)

        // 1.재귀적 호출
//        System.out.println(fibonacci(50));
        // 2.동적계산
        fibo = new long[n+1];
        System.out.println(fibonacci1(50));

        // 3.반복문
        System.out.println(fibonacci2(50));


    }

    public static long fibonacci(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return fibonacci(n-1) +  fibonacci(n-2);  //중복연산
    }

    public static long fibonacci1(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        //이미 계산한 경우
        if(fibo[n] != 0) {
            return fibo[n];
        }
        fibo[n] = fibonacci1(n-1) + fibonacci1(n-2);
        return fibo[n];
    }

    public static long fibonacci2(int n) {
        fibo[0] = 1;
        fibo[1] = 1;
        for(int i=2; i<=n; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        return fibo[n];
    }

}
