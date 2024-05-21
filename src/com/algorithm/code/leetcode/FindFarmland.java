package com.algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * leetcode 1992
 */
public class FindFarmland {
    public static void main(String[] args) {
        int[][] array = {
                {1, 0, 0},
                {0, 1, 1},
                {0, 1, 1}
        };
        findFarmland(array);
    }

    public static int[][] findFarmland(int[][] land) {
        ArrayList<int[]> result = new ArrayList<>();
        int[][][] data = new int[land.length][land[0].length][4];
        //初始化数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                Arrays.fill(data[i][j], -1);
            }
        }
        if (land[0][0] == 1) {
            data[0][0][0] = 0;
            data[0][0][1] = 0;
            data[0][0][2] = 0;
            data[0][0][3] = 0;
        }
        // 初始化边界
        for (int i = 1; i < data.length; i++) {
            if (land[i][0] == 1) {
                if (land[i-1][0] == 1) {
                    data[i][0][0] = data[i-1][0][0];
                    data[i][0][1] = data[i-1][0][1];
                    data[i][0][2] = i;
                    data[i][0][3] = 0;
                } else {
                    data[i][0][0] = i;
                    data[i][0][1] = 0;
                    data[i][0][2] = i;
                    data[i][0][3] = 0;
                }
            }
        }
        for (int i = 1; i < data[0].length; i++) {
            if (land[0][i] == 1) {
                if (land[0][i-1] == 1) {
                    data[0][i][0] = data[0][i-1][0];
                    data[0][i][1] = data[0][i-1][1];
                    data[0][i][2] = 0;
                    data[0][i][3] = i;
                }else {
                    data[0][i][0] = 0;
                    data[0][i][1] = i;
                    data[0][i][2] = 0;
                    data[0][i][3] = i;
                }
            }
        }
        HashMap<String, int[]> map = new HashMap<>();
        for (int i = 1; i < land.length; i++) {
            for (int j = 1; j < land[i].length; j++) {
                //开始逐行遍历
                if (land[i][j] == 1){
                    if (land[i-1][j] == 1){
                        data[i][j][0] = data[i-1][j][0];
                        data[i][j][1] = data[i-1][j][1];
                    } else if (land[i][j - 1] == 1){
                        data[i][j][0] = data[i][j-1][0];
                        data[i][j][1] = data[i][j-1][1];
                    }else {
                        data[i][j][0] = i;
                        data[i][j][1] = j;
                    }
                    data[i][j][2] = i;
                    data[i][j][3] = j;
                }
            }
        }
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1)map.put(String.valueOf(data[i][j][0]) +","+ String.valueOf(data[i][j][1]), data[i][j]);
            }
        }
        return map.values().toArray(new int[0][0]);
    }
}
