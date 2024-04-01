package com.algorithm.code.utils;

import java.util.Random;

public class util {

    public static void swap(int[] arr, int i, int j){
        if (i == j)return;
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public static int[] generateRandomArray(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(100); // 在 0 到 99 之间生成随机数
        }
        return arr;
    }
}
