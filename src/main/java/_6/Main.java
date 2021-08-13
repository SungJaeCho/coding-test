package _6;
//최대공약수 구하기 노멀 버전
public class Main {
    public static void main(String[] args) {

        int num1, num2;
        num1 = 1071;
        num2 = 1029;

        int small;
        int big;
        if(num1 > num2) {
            big = num1;
            small = num2;
        }
        else {
            big = num2;
            small = num1;
        }

        int gcd = 1; //최대공약수

        for(int i=2; i<=small; i++) {
            if(big%i==0 && small%i==0){
                gcd = i;
            }
        }

        System.out.println(gcd);

    }
}
