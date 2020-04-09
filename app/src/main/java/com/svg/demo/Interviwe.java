package com.svg.demo;

import java.util.Random;

public class Interviwe {
    static int n = 15;

    public static void main(String[] args) {
        int[] mark = new int[n];


        for (int i = 0; i < n; i++) {
            Random random = new Random();
            mark[i] = random.nextInt(100) + 1;
            System.out.println(mark[i]);
        }

        int second = getSecond(mark);
        sort(mark, n);

        if (mark[0] >= 60) {
            System.out.println("及格线是：60分！");
        } else {
            int index = (int) (n * 0.4);
            System.out.println("及格线是：" + mark[index] / 10 * 10 + "分");
        }

        String strOne = "abcdefg";
        String strTwo = "cdexf";
        String result  =maxSubstring(strOne, strTwo);
        System.out.println(result);

    }

    private static int[] sort(int[] mark, int len) {
        int temp = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (mark[i] > mark[j]) {
                    temp = mark[i];
                    mark[i] = mark[j];
                    mark[j] = temp;
                }
            }
        }

        return mark;
    }

    public static Integer getSecond(int[] array) {
        int max = array[0];
        int second = Integer.MIN_VALUE;
        // 遍历数组
        for (int i = 1; i < array.length; i++) {
            // 判断是否为最大数
            if (max < array[i]) {
                // 更新前两大数
                second = max;
                max = array[i];
                continue;
            }
            // 判断是否为第二大数
            if (second < array[i]) {
                // 更新第二大数
                second = array[i];
            }
        }
        return second;
    }

    // 求解两个字符号的最长公共子串
    public static String maxSubstring(String strOne, String strTwo){
        // 参数检查
        if(strOne==null || strTwo == null){
            return null;
        }
        if(strOne.equals("") || strTwo.equals("")){
            return null;
        }
        // 二者中较长的字符串
        String max = "";
        // 二者中较短的字符串
        String min = "";
        if(strOne.length() < strTwo.length()){
            max = strTwo;
            min = strOne;
        } else{
            max = strOne;
            min = strTwo;
        }
        String current = "";
        // 遍历较短的字符串，并依次减少短字符串的字符数量，判断长字符是否包含该子串
        for(int i=0; i<min.length(); i++){
            for(int begin=0, end=min.length()-i; end<=min.length(); begin++, end++){
                current = min.substring(begin, end);
                if(max.contains(current)){
                    return current;
                }
            }
        }
        return null;
    }
}
