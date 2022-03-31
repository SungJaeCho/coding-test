package binarySearch;

import java.util.*;

public class IntersectionOfTwoArrays2 {
    public static void main(String[] args) {
        int[] num1 = {2,2};
        int[] num2 = {2,2};
//        int[] num1 = {1,2,2,1};
//        int[] num2 = {2};
//        int[] num1 = {61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81};
//        int[] num2 = {5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48};
        System.out.println(Arrays.toString(intersect01(num1, num2)));
    }

    public static int[] intersect01(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // <number, count>
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            map.merge(num, 2, Integer::sum);
        }

        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);

            if (count > 0) {
                list.add(num);
                map.put(num, count - 1);
            }
        }
        return list.stream().mapToInt(k -> k).toArray();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        int low = 0, high;
        List<Integer> list = new ArrayList<>();

        for(int target : nums1) {
            Arrays.sort(nums2);
            high = nums2.length -1;
            int result = search(nums2, target, low, high);
            System.out.println(result);
            if(result >= 0) {
                list.add(target);
                nums2[result] = -1;
            }
        }
        return list.stream().mapToInt(k -> k).toArray();
    }

    public static int search(int[] arr, int target, int low, int high) {
        while(low <= high) {
            int mid = (low+high)/2;
            if(target == arr[mid]) {
                return mid;
            } else if(target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
