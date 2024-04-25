package com.algorithm.code.sort;


import static com.algorithm.code.utils.util.generateRandomArray;
import static com.algorithm.code.utils.util.swap;

/**
 * 冒泡排序，时间复杂度为n^2,空间复杂度为1
 */
public class BubblingSort {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(10);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();;
        sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j -1]) swap(arr, j, j-1);
            }
        }
    }
}
