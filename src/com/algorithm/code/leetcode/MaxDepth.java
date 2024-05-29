package com.algorithm.code.leetcode;

/**
 * leetcode 104
 * 简单就是简单  (,,・ω・,,)
 */
public class MaxDepth {
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
