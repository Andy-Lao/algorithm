package com.algorithm;

import sort.QuickSort;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] test = {3,5,2,4,1,4,3,2,6,7,8};
        System.out.println(Arrays.toString(test));
        QuickSort.quickSortSwap(test, 0, 10);
        System.out.println(Arrays.toString(test));

    }
}
