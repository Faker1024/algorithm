package com.algorithm.code.sort;

import static com.algorithm.code.utils.util.generateRandomArray;
import static com.algorithm.code.utils.util.swap;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = generateRandomArray(10);
//        int[] arr = {18, 64, 39, 18, 88, 98, 76, 31, 74, 4};


        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        sort(arr, 0, arr.length-1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }


    public static void sort(int[] arr, int left, int right){
        if (right <= left)return;
        int pivot = left;
        int l = left, r = right;
        l++;
        boolean flag = true;
        while (l <= r){
            if (flag){
//                r
                if (arr[pivot] > arr[r]){
                    swap(arr, pivot, r);
                    pivot = r;
                    flag = false;
                }
                r--;
            }else{
//                l
                if (arr[pivot] < arr[l]){
                    swap(arr, pivot, l);
                    pivot = l;
                    flag = true;
                }
                l++;
            }
        }
        sort(arr, left, r);
        sort(arr, l, right);
    }
}
