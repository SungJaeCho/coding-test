package _7;

// 소수 구하기 1을제외하고 1과 나자신만 나눌수 있는 수
// 약수가 1과 자기자신이여야만함
// 에라토스테네스 체
public class Main {
    public static void main(String[] args) {

        System.out.println(getPrime(100000));

    }

    // 1차적 코딩
    public static int getPrime(int n) {
        int cnt = 0; //소수의 갯수

        // n=4
        for (int num=2; num <= n; num++) {
            boolean isPrime = true;
            // i = 2,3,4
            for(int i=2; i < num; i++) {
                if(num%i == 0){
                    isPrime = false;
                }
            }
            if(isPrime) {
                cnt++;
            }
        }
        return cnt;
    }

}
