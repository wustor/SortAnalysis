package com.wustor.fast;

import com.wustor.SortUtils;

// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序
public class HeapSort {

    // 我们的算法类不允许产生任何实例
    private HeapSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for (int i = (n - 1 - 1) / 2; i >= 0; i--)
            shiftDown(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 原始的shiftDown过程
    private static void shiftDown(Comparable[] arr, int n, int k) {

        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0)
                j += 1;
            if (arr[k].compareTo(arr[j]) >= 0) break;

            swap(arr, k, j);
            k = j;
        }
    }

    // 测试 HeapSort
    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortUtils.generateRandomArray(N, 0, 100000);
        SortUtils.testSlow("com.wustor.fast.HeapSort", arr);
    }
}