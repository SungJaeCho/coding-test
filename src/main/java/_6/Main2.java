package _6;
//최대공약수 유클리드 호제법
public class Main2 {

    public static void main(String[] args) {
        int num1, num2;
        num1 = 24;
        num2 = 4;

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

        while (small > 0) {
            int temp = big;
            big = small;
            small = temp%small;
        }
        System.out.println(big);
    }

}
