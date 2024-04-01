package com.algorithm.code.sort;

import static com.algorithm.code.utils.util.generateRandomArray;
import static com.algorithm.code.utils.util.swap;

/**
 * 选择排序，时间复杂度n^2，空间复杂度1
 */
public class SelectSort {
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
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) min = j;
            }
            swap(arr, i, min);
        }
    }
}
