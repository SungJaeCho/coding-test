package twoPoint;

import java.util.Arrays;

public class SortArrayByParity905 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
        System.out.println(Arrays.toString(sortArrayByParity01(nums)));
        System.out.println(Arrays.toString(sortArrayByParity_best(nums)));
    }

    public static int[] sortArrayByParity(int[] nums) {

        if(nums.length == 1) {
            return nums;
        }

        int i = 0;
        int j = i+1;
        while (i <= nums.length && j < nums.length) {
            Integer temp;
            if(nums[i] % 2 == 1 && nums[j] % 2 == 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j = i+1;
            } else {
                j++;
            }
            if(j == nums.length) {
                i++;
                j = i+1;
            }

        }
        return nums;
    }

    public static int[] sortArrayByParity01(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        for (int k : nums) {
            if (k % 2 == 0) {
                result[start] = k;
                start++;
            } else {
                result[end] = k;
                end--;
            }
        }
        return result;
    }

    public static int[] sortArrayByParity_best(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            if(nums[start] % 2 == 0) {
                start++;
            } else {
                if(nums[end] % 2 == 0) {
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                }
                end--;
            }
        }
        return nums;
    }
}
