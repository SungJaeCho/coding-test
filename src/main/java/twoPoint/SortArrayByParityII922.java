package twoPoint;

import javax.swing.*;
import java.util.Arrays;

public class SortArrayByParityII922 {
    public static void main(String[] args) {
        int[] nums = {4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityBest(nums)));
        System.out.println(Arrays.toString(sortArrayByParity2(nums))); //성능은 이게더 좋음.
    }
    public static int[] sortArrayByParityBest(int[] nums) {
        int length = nums.length;

        for(int i=0, j=1; i < length; i += 2, j+= 2) {
            while(i<length && nums[i]%2 == 0){
                i += 2;
            }
            while (j<length && nums[j]%2 == 1) {
                j += 2;
            }
            if(i<length) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }

    public static int[] sortArrayByParity2(int[] nums) {
        boolean even = true;
        for(int i=0; i<nums.length; i++) {
            if(even && nums[i]%2 == 0) {
                even = false;
                continue;
            } else if(!even && nums[i]%2 != 0) {
                even = true;
                continue;
            } else {
                for(int j= nums.length-1; j< nums.length; j--) {
                    if(even) {
                        if(nums[j]%2 == 0){
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            even = false;
                            break;
                        }
                    } else {
                        if(nums[j]%2 != 0){
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            even = true;
                            break;
                        }
                    }
                }
            }
        }
        return nums;
    }

}
