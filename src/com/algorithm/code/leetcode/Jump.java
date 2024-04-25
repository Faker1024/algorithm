package com.algorithm.code.leetcode;

import java.util.Arrays;

/**
 * leetcode 45
 */
public class Jump {
    public static void main(String[] args) {
        int[] arr = { 2,3,1};
        System.out.println(jump(arr));
    }

    public static int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int index = 0;
        int count = 0;
        for(int i = 0;i < nums.length-1;){
            int maxLen = Integer.MIN_VALUE;
            if(i + nums[i] >= nums.length-1) return ++count;
            for(int j = i+1; j <= i+nums[i];j++){
                if(maxLen < nums[j]+j){
                    maxLen = nums[j]+j;
                    index=j;
                }
            }
            i = index;
            count++;
        }
        return count;
    }
}
