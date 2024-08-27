package org.example;

import org.example.sorting.Util;
import org.example.sorting.impl.BubbleSort;
import org.example.sorting.impl.InsertionSort;
import org.example.sorting.impl.MergeSort;
import org.example.sorting.impl.SelectionSort;
import org.example.sorting.SortOrder;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args){

        long startTime;
        long endTime;
        List<Integer> output;

        List<Integer> inputList = Util.getRandomList();
        System.out.println("Input Array:\n" + inputList + "\n");

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

        startTime = System.currentTimeMillis();
        output = MergeSort.sort(inputList, SortOrder.DESC);
        endTime = System.currentTimeMillis();

//        System.out.println("Merg Sort Output:\n" + output);
        System.out.println("Merg Sort Execution time: " + (endTime - startTime) + "ms\n");
    }
}
