package com.algorithm.code.leetcode;

/**
 * leetcode 38
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(32));
    }

    public static String countAndSay(int n) {
        if(n==1){ return "1";}
        else return rle(countAndSay(n-1));
    }

    public static String rle(String str){
        char[] data = str.toCharArray();
        StringBuilder sb = new StringBuilder("");
        int count = 1;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[i-1]){
                sb.append(count).append(data[i-1]);
                count = 1;
            }else{
                count++;
            }
        }
        sb.append(count).append(data[data.length-1]);
        return sb.toString();
    }
}
