package twoPoint;

import java.util.Arrays;

public class SortColors75 {
    static int[] nums = {1,1,2,0,2,1};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortColors2(nums)));
    }
    public static int[] sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length-1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if(nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
        return nums;
    }
    public static int[] sortColors2(int[] nums) {
        int left = 0, right = nums.length-1;

        for(int i=0; i<=right; i++) {
            System.out.println("L:"+left+" R:"+right+" i:"+i);
            if(nums[i] == 0) {
                swap(nums, i, left++);
            }
            if(nums[i] == 2) {
                swap(nums, i--, right--);
            }
        }
        return nums;
    }
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
