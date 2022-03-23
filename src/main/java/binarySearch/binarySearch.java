package binarySearch;

public class binarySearch {
    static int[] arr;

    public static void main(String[] args) {
        arr = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        int low = 0;
        int high = arr.length - 1;
        long start = System.currentTimeMillis();
        System.out.println(search01(target, low, high));
        long end = System.currentTimeMillis();
        System.out.println("시간차이:" + (start-end)/1000);

        start = System.currentTimeMillis();
        System.out.println(search02(target, low, high));
        end = System.currentTimeMillis();
        System.out.println("시간차이:" + (start-end)/1000);
    }

    public static int search01(int target, int low, int high) {
        int mid;

        if (low <= high) {
            mid = (low+high)/2;
            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                return search01(target, low, mid-1);
            } else {
                return search01(target, mid+1, high);
            }
        }
        return -1;
    }

    public static int search02(int target, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low+high)/2;
            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
