package com.algorithm.code.sort;

import static com.algorithm.code.utils.util.generateRandomArray;
import static com.algorithm.code.utils.util.swap;

/**
 * 希尔排序：将数组序列不断拆分，并对每组进行插排，最终让整个数组不断趋于有序
 * 时间复杂度n^2~n^1.3
 * 空间复杂度1
 */
public class HillSort {
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
        int len = arr.length >> 1;
        while (len != 0){
            insertSortByNum(arr, len);
            len >>= 1;
        }
    }

    public static void insertSortByNum(int[] arr, int num){
        for (int i = num; i < arr.length; i+=num) {
            for (int j = i;j > 0 && arr[j] < arr[j-num];j-=num) swap(arr, j, j-num);
        }
    }
}
