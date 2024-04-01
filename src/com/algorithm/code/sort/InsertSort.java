package com.algorithm.code.sort;

import static com.algorithm.code.utils.util.generateRandomArray;
import static com.algorithm.code.utils.util.swap;

/**
 * 插入排序，时间复杂度n^2，空间复杂度1
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(10);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) swap(arr, j, j-1);
    }
}
