package com.algorithm.code.sort;

import static com.algorithm.code.utils.util.generateRandomArray;
import static com.algorithm.code.utils.util.swap;

/**
 * 堆排序
 * 时间复杂度：在最坏、平均和最好情况下，堆排序的时间复杂度都是 O(n log n)。
 * 这是因为堆排序的主要操作是建堆和调整堆，建堆的时间复杂度为 O(n)，调整堆的时间复杂度为 O(log n)，而这两个操作都要执行 n 次（n 是数组的长度）。
 * 空间复杂度：堆排序是原地排序算法，因此它的空间复杂度是 O(1)，即常数空间。这是因为堆排序只需要一个固定大小的额外空间来存储堆的结构，而不随输入规模的增加而增加。
 */
public class HeapSort {

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
//        建大顶堆
        buildHeap(arr);
//        循环取堆首，并对堆进行维护
        for (int i = arr.length - 1; i > 0;) {
            swap(arr, 0, i--);
            heapify(arr, i, 0);
        }
    }

    /**
     * 建堆
     * @param arr 待建数组
     */
    private static void buildHeap(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }
    }

    /**
     * 堆维护
     * @param arr 存储堆的数组
     * @param len 当前数组长度
     * @param index 当前维护节点的下标
     */
    private static void heapify(int[] arr, int len, int index){
        int largest = index;
        int lson = 2 * largest + 1;
        int rson = 2 * largest + 2;
        if (lson <= len && arr[lson] > arr[largest]) largest = lson;
        if (rson <= len && arr[rson] > arr[largest]) largest = rson;
        if (largest != index){
            swap(arr, largest, index);
            heapify(arr, len, largest);
        }
    }
}
