package leetcodeHard;

import java.util.Arrays;

public class MedianOfTwoSortedArrays4 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(solution(nums1,nums2));
    }

    public static double solution(int[] nums1, int[] nums2) {
        int[] sumArr = new int[nums1.length+nums2.length];
        System.arraycopy(nums1, 0, sumArr, 0, nums1.length);
        System.arraycopy(nums2, 0, sumArr, nums1.length, nums2.length);
        Arrays.sort(sumArr);
//        System.out.println(Arrays.toString(sumArr));
        double result = 0;
        double divisor = 2;
        if(sumArr.length%2 == 1) {//나머지가 홀수면 몫을 그냥 세팅
            result = sumArr[sumArr.length/2];
        } else {
            result = (sumArr[sumArr.length/2] + sumArr[sumArr.length/2 - 1]) / divisor;
        }
//        int[] resultArr = Arrays.stream(sumArr).distinct().toArray(); //중복제거
//        System.out.println(Arrays.toString(resultArr));

        return result;
    }
}
