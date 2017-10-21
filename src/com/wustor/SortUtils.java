package com.wustor;

import java.lang.reflect.Method;

public class SortUtils {
    // 生成有n个范围在[rangeL, rangeR]的数组
  public   static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        return arr;
    }

    // 生成一个有序数组, 之后随机交换swapTimes对
    public static Integer[] generateOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
        return arr;
    }
    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    // 将算法的运行时间以long类型返回, 单位为毫秒(ms)
    public static long testFast(String sortClassName, Comparable[] arr){

        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try{
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();
            return endTime - startTime;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return 0;
    }
    // 打印arr数组的所有内容
   public static void printArray(Comparable[] arr) {
        for (Comparable anArr : arr) {
            System.out.print(anArr);
            System.out.print(' ');
        }
        System.out.println();
    }
    // 通过反射获取调用相应的方法
    public static void testSlow(String sortClassName, Comparable[] arr) {
        // 通过Java的反射机制，通过排序的类名，运行排序函数
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();
            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}