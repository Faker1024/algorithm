package com.algorithm.code.leetcode;

/**
 * leetcode 72
 * 插入A一个字符
 * 替换A一个字符
 * 插入B一个字符
 */
public class MinDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }

    public static int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        if (chars2.length == 0)return chars1.length;
        if (chars1.length == 0)return chars2.length;
        int[][] dp = new int[chars1.length][chars2.length];
        dp[0][0] = chars1[0] == chars2[0] ? 0 : 1;
        for (int i = 1; i < chars2.length; i++) {
//            只能允许一次相等
            if (chars2[i] == chars1[0] && dp[0][i-1] > i-1) dp[0][i] = dp[0][i - 1];
            else dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i < chars1.length; i++) {
            if (chars1[i] == chars2[0] && dp[i-1][0] > i-1) dp[i][0] = dp[i - 1][0];
            else dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]-1) + 1;
                else dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
            }
        }
        return dp[chars1.length-1][chars2.length-1];
    }
}
