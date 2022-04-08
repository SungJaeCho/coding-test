package twoPoint;

import java.util.Arrays;

public class MoveZeroes283 {
    static int[] nums = {0,1,0,3,12}; // 1,3,12,0,0

    public static void main(String[] args) {
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int index = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        while(index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    // 0을 보내면서 숫자 정렬도할시
    public static void moveZeroes2(int[] nums) {
        int point = nums.length-1;
        if(nums.length > 0) {
            for(int i=0,j=i+1; i<point; i++,j++) {
                if(nums[i] == 0) {
                    int temp = nums[point];
                    nums[point] = 0;
                    nums[i] = temp;
                    point--;
                    i--;
                    j--;
                } else if(nums[j] == 0) {
                    int temp = nums[point];
                    nums[point] = 0;
                    nums[j] = temp;
                    point--;
                    i--;
                    j--;
                } else if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}
