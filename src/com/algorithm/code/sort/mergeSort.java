package com.algorithm.code.sort;

import static com.algorithm.code.utils.util.generateRandomArray;

/**
 * 归并排序：利用递归将数组拆分，然后合并时进行排序
 * 时间复杂度：nlogn，递归深度为logn，每一层合并分解为n
 * 空间复杂度：n
 */
public class mergeSort {
    public static void main(String[] args) {
        int[] arr = generateRandomArray(10);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] tempArr = new int[arr.length];
        sort(arr, tempArr, 0, arr.length-1);
        for (int num : tempArr) {
            System.out.print(num + " ");
        }
    }

    public static void sort(int[] arr, int[] tempArr, int start, int end){
        if (start >= end) return;
        int mid = (end + start) >> 1;
        sort(arr, tempArr, start, mid);
        sort(arr, tempArr, mid + 1, end);
        for (int i = start, j = mid + 1, index = start;index <= end;index++) {
//            默认走i，当j小于i，或i>mid时走j
            if (i > mid) {
                tempArr[index] = arr[j++];
                continue;
            } else if (j > end) {
                tempArr[index] = arr[i++];
                continue;
            }
            if (arr[i] < arr[j]) tempArr[index] = arr[i++];
            else tempArr[index] = arr[j++];
        }
        for (int i = start; i <= end; i++) arr[i] = tempArr[i];
    }
}
