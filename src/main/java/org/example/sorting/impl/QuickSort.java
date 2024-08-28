package org.example.sorting.impl;

import org.example.sorting.Sort;
import org.example.sorting.SortOrder;
import org.example.sorting.Util;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements Sort {

    private static <T extends Number & Comparable<T>> int partition(List<T> inputList, SortOrder sortOrder, int startIndex, int endIndex){

        T pivotElement = inputList.get(endIndex);
        int partIndex = startIndex;

        for(int i = startIndex; i < endIndex; i++)
        {
            if(sortOrder.equals(SortOrder.ASC) && inputList.get(i).compareTo(pivotElement) < 0){
                Util.swap(inputList, i, partIndex);
                partIndex++;
            }

            if(sortOrder.equals(SortOrder.DESC) && inputList.get(i).compareTo(pivotElement) > 0){
                Util.swap(inputList, i, partIndex);
                partIndex++;
            }
        }
        Util.swap(inputList, endIndex, partIndex);
        return partIndex;
    }

    private static <T extends Number & Comparable<T>> void quickSort(List<T> inputList, SortOrder sortOrder, int startIndex, int endIndex){

        if(startIndex < endIndex){
            int partIndex = partition(inputList, sortOrder, startIndex,endIndex);
            quickSort(inputList, sortOrder, startIndex, partIndex - 1);
            quickSort(inputList, sortOrder, partIndex + 1, endIndex);
        }
    }

    public static <T extends Number & Comparable<T>> List<T> sort(List<T> inputList, SortOrder sortOrder){
        List<T> outputData = new ArrayList<>(inputList);
        quickSort(outputData, sortOrder,0, outputData.size() - 1);
        return outputData;
    }
}
