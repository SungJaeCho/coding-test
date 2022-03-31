package binarySearch;

import java.util.*;

public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        int[] num1 = {2,1};
        int[] num2 = {1,2};
        System.out.println(Arrays.toString(intersect(num1, num2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int low = 0, high;
        List<Integer> list = new ArrayList<>();
        if(nums1.length >= nums2.length) {
            high = nums1.length -1;
            Arrays.sort(nums1);
            for(int target : nums2) {
                int result = search(nums1, target, low, high);
                if(result >= 0) {
                    list.add(result);
                }
            }
        } else {
            high = nums2.length -1;
            Arrays.sort(nums2);
            for(int target : nums1) {
                int result = search(nums2, target, low, high);
                if(result >= 0) {
                    list.add(result);
                }
            }
        }
        return list.stream().mapToInt(k -> k).toArray();
    }

    public static int search(int[] arr, int target, int low, int high) {
        while(low <= high) {
            int mid = (low+high)/2;
            if(target == arr[mid]) {
                return target;
            } else if(target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
