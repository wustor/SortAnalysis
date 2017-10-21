package com.wustor.fast;

import com.wustor.SortUtils;

import java.util.Arrays;

public class Main {

    // 比较 Shell Sort 和 Merge Sort 和 三种 Quick Sort 的性能效率
    // 使用更科学的比较方式, 每次比较都运行多次测试用例, 取平均值
    // 可以看出, Shell Sort虽然慢于高级的排序方式, 但仍然是非常有竞争力的一种排序算法
    // 其所花费的时间完全在可以容忍的范围内, 远不像O(n^2)的排序算法, 在数据量较大的时候无法忍受
    // 同时, Shell Sort实现简单, 只使用循环的方式解决排序问题, 不需要实现递归, 不占用系统占空间, 也不依赖随机数
    // 所以, 如果算法实现所使用的环境不利于实现复杂的排序算法, 或者在项目工程的测试阶段, 完全可以暂时使用Shell Sort来进行排序任务:)
    public static void main(String[] args) {
        int T = 1000000;
        int N = 20000;
        // 比较 HeapSort、Shell Sort 和 Merge Sort 和 三种 Quick Sort 的性能效率
        Integer[] arr1 = SortUtils.generateRandomArray(T, 0, N);
//        Integer[] arr1 = SortUtils.generateOrderedArray(T, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        long time1 = SortUtils.testFast("com.wustor.ShellSort", arr1);
        long time2 = SortUtils.testFast("com.wustor.fast.HeapSort", arr2);
        long time3 = SortUtils.testFast("com.wustor.fast.MergeSort", arr3);
        long time4 = SortUtils.testFast("com.wustor.fast.QuickSort", arr4);
        System.out.println("Sorting " + N + " elements " + T + " times. Calculate the average run time.");
        System.out.println("Shell Sort        Average Run Time: " + time1 + " ms");
        System.out.println("Heap  Sort        Average Run Time: " + time2 + " ms");
        System.out.println("Merge Sort        Average Run Time: " + time3 + " ms");
        System.out.println("Quick Sort        Average Run Time: " + time4 + " ms");

    }
}