package binarySearch;

public class ArrangingCoins441 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins2(8));
    }
    public static int arrangeCoins(int n) {
        int row = 0;
        while (row < n) {
            row++;
            n = n - row;
        }
        return row;
    }
    // 등차수열 k(k*1)/2 <= N
    public static int arrangeCoins2(int n) {
        int low=0, high=n;
        int row =0;
        while(low <= high) {
            int mid = (low + high) / 2;
            long sum = (long) mid * (mid + 1) / 2;
            if(sum <= n) {
                row = mid;
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return row;
    }
}
