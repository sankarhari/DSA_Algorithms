package org.datastructure.sorting;

import org.datastructure.sorting.impl.*;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Example
{
    public static void main(String[] args){

        long startTime;
        long endTime;
        List<Integer> output;

        List<Integer> inputList = Util.getRandomList(1000, 1, 10000000);
        System.out.println("Input Array:\n" + inputList + "\n");

        startTime = System.currentTimeMillis();
        output = QuickSort.sort(inputList, SortOrder.DESC);
        endTime = System.currentTimeMillis();

//        System.out.println("Quick Sort Output:\n" + output);
        System.out.println("Quick Sort Execution time: " + (endTime - startTime) + "ms\n");



        startTime = System.currentTimeMillis();
        output = MergeSort.sort(inputList, SortOrder.DESC);
        endTime = System.currentTimeMillis();

//        System.out.println("Merg Sort Output:\n" + output);
        System.out.println("Merg Sort Execution time: " + (endTime - startTime) + "ms\n");

        startTime = System.currentTimeMillis();
        output = BubbleSort.sort(inputList, SortOrder.DESC);
        endTime = System.currentTimeMillis();

//        System.out.println("Bubble Sort Output:\n" + output);
        System.out.println("Bubble Sort Execution time: " + (endTime - startTime) + "ms\n");

        startTime = System.currentTimeMillis();
        output = SelectionSort.sort(inputList, SortOrder.DESC);
        endTime = System.currentTimeMillis();

//        System.out.println("Selection Sort Output:\n" + output);
        System.out.println("Selection Sort Execution time: " + (endTime - startTime) + "ms\n");

        startTime = System.currentTimeMillis();
        output = InsertionSort.sort(inputList, SortOrder.DESC);
        endTime = System.currentTimeMillis();

//        System.out.println("Insertion Sort Output:\n" + output);
        System.out.println("Insertion Sort Execution time: " + (endTime - startTime) + "ms\n");
    }
}
