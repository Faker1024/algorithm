package com.algorithm.code.sort;

import static com.algorithm.code.utils.util.generateRandomArray;

/**
 * 计数排序
 * 计数排序的时间复杂度是 O(n + k)，其中 n 是待排序数组的长度，k 是待排序数组中最大元素与最小元素的差值加 1。
 * 由于计数排序是基于数组下标来统计元素出现次数的，因此需要额外的空间来存储计数数组，空间复杂度为 O(k)。如果 k 的范围相对于待排序数组长度 n 来说很小，那么计数排序的性能会非常高效。
 * 但是当 k 远大于 n 时，计数排序的空间复杂度可能会很高，不适合大规模数据的排序。
 */
public class CountingSort {
    public static void main(String[] args) {
        //        int[] arr = {94, 32, 61, 64, 95, 45, 96, 27, 73, 20};
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

    private static void sort(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (min > num) min = num;
            if (max < num) max = num;
        }
        int[] countArr = new int[max - min + 2];
        for (int i : arr) countArr[i - min]++;
        for (int i = 0, index = 0; i < countArr.length-1; i++) {
            while (countArr[i] != 0){
                arr[index++] = min + i;
                countArr[i]--;
            }
        }
    }
}
