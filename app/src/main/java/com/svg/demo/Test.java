package com.svg.demo;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int[] ins = {2, 3, 5, 0, 1, 23, 6, 78, 34};
//        selectsort(ins);
//        quickSort(ins, 0, ins.length - 1);
        quickSort1(ins);
//        bubbleSort(ins);
        for (int i = 0; i < ins.length; i++) {
            System.out.println(ins[i]);
        }
        int index = commonBinarySearch(ins, 34);
        System.out.println("key的下标是：" + index);
    }


    // 选择排序
    public static int[] selectsort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            if (i != index) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    // 快速排序
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    public static void quickSort1(int array[]) {
        if (array == null || array.length <= 1) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(array.length - 1);
        while (!stack.empty()) {
            int right = stack.pop();
            int left = stack.pop();
            int index = partition(array, left, right);
            if (index - 1 > left) {
                stack.push(left);
                stack.push(index - 1);
            }
            if (index + 1 < right) {
                stack.push(index + 1);
                stack.push(right);
            }
        }
    }


    //找到轴心，进行交换
    public static int partition(int[] data, int first, int end) {
        int temp;
        int i = first, j = end;
        if (i < j) {
            temp = data[i];
            while (i < j) {
                while (i < j && data[j] > temp) {
                    j--;
                }
                if (i < j) {
                    data[i] = data[j];
                    i++;
                }
                while (i < j && data[i] < temp) {
                    i++;
                }
                if (i < j) {
                    data[j] = data[i];
                    j--;
                }
            }
            data[i] = temp;
        }
        return i;
    }

    // 冒泡排序
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];

                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static int commonBinarySearch(int[] arr, int key) {
        int middle = 0;
        int left = 0;
        int right = arr.length - 1;
        if (key < arr[0] || key > arr[right]) {
            return -1;
        }
        while (left <= right) {
            middle = (left + right) / 2;
            if (key > arr[middle]) {
                left = middle + 1;
            } else if (key < arr[middle]) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


}
