package _7;

// 소수 구하기 1을제외하고 1과 나자신만 나눌수 있는 수
// 약수가 1과 자기자신이여야만함
// 에라토스테네스 체
public class Main {
    public static void main(String[] args) {

        System.out.println(getPrime(100000));
        System.out.println(getPrimeE(100000));

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

    //에라토스테네스 체
    // 2,3,4,5,6,7,8,9...n : 지우게 되는 첫번째 = 소수

    public static int getPrimeE(int n) {
        int cnt = 0;

        boolean[] check = new boolean[n+1];

        for(int i=2; i<=n; i++) {
            if(!check[i]) { //해당 수가 첫번째면 소수임
                cnt++;
                for(int j=i*2; j<=n; j += i) { //j=i*2 배수를 찾기위함 j += i 2,4,6,8,10
                    check[j] = true;
                }
            }
        }

        return cnt;
    }
}
