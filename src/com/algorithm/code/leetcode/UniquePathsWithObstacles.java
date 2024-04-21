package com.algorithm.code.leetcode;

/**
 * leetcode 63
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println(uniquePathsWithObstacles(matrix));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        处理极端情况
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)  return 0;
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (j == 0 && obstacleGrid[i][j] == 1) dp[j] = 0;
                else if (j != 0) {
                    if (obstacleGrid[i][j] == 1) dp[j] = 0;
                    else dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[dp.length-1];
    }
}


