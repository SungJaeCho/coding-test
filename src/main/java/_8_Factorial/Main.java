package _8_Factorial;

public class Main {

    static int rst = 1;

    public static void main(String[] args) {
        int inputNum = 7;
        // 5! = 5*4*3*2*1
        // 7! = 7*6*5*4*3*2*1   !를 팩토리얼

        System.out.println(fatorial(inputNum));
//        System.out.println(fatorial1(inputNum));
//        System.out.println(fatorial2(inputNum));

    }

    public static int fatorial(int n) {
        if(n < 1){
            return rst;
        } else {
            rst *= n;
            return fatorial(n-1);
        }
    }
    public static int fatorial1(int n) {
        int result = 1;
        for(int i=1; i<= n; i++) {
            result *= i;
        }
        return result;
    }
    public static int fatorial2(int n) {
        int result = 1;
        for(int i=n; i>= 1; i--) {
            result *= i;
        }
        return result;
    }
}
