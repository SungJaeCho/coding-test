package binarySearch;

public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));
    }

    public static boolean isPerfectSquare(int num) {
        int low = 0, high = num, mid;

        while (low <= high) {
            mid = (low+high)/2;
            if(mid*mid == num) return true;
            else if(mid*mid > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
