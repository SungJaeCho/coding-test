package binarySearch;

public class SearchA2DMatrix {

    static int[][] matrix;
    static int target;
    public static void main(String[] args) {
            matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
            target = 13;
            boolean result = false;

            int resultInt = -1;
            for(int[] arr : matrix) {
                int low = 0;
                int high = arr.length-1;
                resultInt = search(target, low, high, arr);
                if(resultInt > -1) {
                    result = true;
                    break;
                }
            }
        System.out.println(result);
    }

    public static int search(int target, int low, int high, int[] arr) {
        int mid;

        if(low <= high) {
            mid = (low+high)/2;
            if(target == arr[mid]) {
                return mid;
            } else if(target < arr[mid]) {
                return search(target, low, mid-1, arr);
            } else {
                return search(target, mid+1, high, arr);
            }
        }
        return -1;
    }
}
