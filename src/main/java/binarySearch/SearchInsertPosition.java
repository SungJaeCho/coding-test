package binarySearch;

public class SearchInsertPosition {
    static int[] arr;
    static int mid = 0;

    public static void main(String[] args) {
        arr = new int[] {1,3};
        int low = 0;
        int high = arr.length-1;
        int result = search02(4, low, high);
        System.out.println("결과:"+result);
    }
    public static int search02(int target, int low, int high) {

        while (low < high) {
            mid = (low+high)/2;
            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(low >= high) {
            mid = (low+high)/2;
            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                mid--;
            }
        }
        return mid + 1;
    }

    public static int search(int target, int low, int high) {
        int mid;
        if(target < 1) return 0;
        if(low <= high) {
            mid = (low+high)/2;
            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                return search(target, low, mid-1);
            } else {
                return search(target, mid+1, high);
            }
        }
        return  + 1;
    }

}
