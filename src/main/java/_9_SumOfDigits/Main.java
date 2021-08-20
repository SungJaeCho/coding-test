package _9_SumOfDigits;

//각 자리의 합을 구하는 알고리즘
public class Main {
    public static void main(String[] args) {
        int inputNum = 4280;
        int accSum = 0; //각 자리수의 합

        // 1232 => 123 => 12 => 1
        // 2         3     2    1

        while(inputNum > 0){
            accSum += inputNum%10;
            inputNum /= 10;
        }

        System.out.println(accSum);
    }
}
