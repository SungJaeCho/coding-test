package _14_countNum;

// 숫자의 갯수 출력
public class Main {
    public static void main(String[] args) {
        int n = 421314218;
        int[] arr = new int[10];
        /*
        int arr[0] = 0;
        int arr[1] = 3;
        int arr[2] = 2;
        */
        while (n>0) {
            arr [n % 10]++;
            n /= 10;
        }

        for(int i=0; i<10; i++) {
            System.out.println(i+": "+arr[i]);
        }
    }
}
