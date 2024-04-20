package com.algorithm.code.leetcode;

/**
 * leetcode 64
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(newMinPathSum(array));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) dp[i][0] = dp[i-1][0] + grid[i][0];
        for (int i = 1; i < n; i++) dp[0][i] = dp[0][i-1] + grid[0][i];
        for (int i = 1; i < m; i++) for (int j = 1; j < n; j++) dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
        return dp[m-1][n-1];
    }

    public static int newMinPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++) grid[i][0] = grid[i-1][0] + grid[i][0];
        for (int i = 1; i < n; i++) grid[0][i] = grid[0][i-1] + grid[0][i];
        for (int i = 1; i < m; i++) for (int j = 1; j < n; j++) grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
        return grid[m-1][n-1];
    }
    
}
