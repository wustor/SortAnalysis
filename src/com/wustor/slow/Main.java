package com.wustor.slow;

import com.wustor.SortUtils;

import java.util.Arrays;

public class Main {

    // 比较SelectionSort, InsertionSort和BubbleSort和ShellSort四种排序算法的性能效率
    // ShellSort是这四种排序算法中性能最优的排序算法
    public static void main(String[] args) {
        int N = 5000;
        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
        Integer[] arr1 = SortUtils.generateRandomArray(N, 0, 20000);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        SortUtils.testSlow("com.wustor.slow.SelectionSort", arr1);
        SortUtils.testSlow("com.wustor.slow.InsertionSort", arr2);
        SortUtils.testSlow("com.wustor.slow.BubbleSort", arr3);
        SortUtils.testSlow("com.wustor.ShellSort", arr4);
        System.out.println();
        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);
        arr1 = SortUtils.generateOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        SortUtils.testSlow("com.wustor.slow.SelectionSort", arr1);
        SortUtils.testSlow("com.wustor.slow.InsertionSort", arr2);
        SortUtils.testSlow("com.wustor.slow.BubbleSort", arr3);
        SortUtils.testSlow("com.wustor.ShellSort", arr4);
    }
}