package twoPoint;

import java.util.Arrays;

public class SquaresOfASortedArray977 {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(solution(nums)));
    }
    public static int[] solution(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length-1;

        for(int i=nums.length-1; i>=0; i--) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i]  = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
