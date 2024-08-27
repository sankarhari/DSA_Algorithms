package org.example.sorting.impl;

import org.example.sorting.Sort;
import org.example.sorting.SortOrder;
import org.example.sorting.Util;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements Sort {

    public static <T extends Number & Comparable<T>> List<T> sort(List<T> inputList, SortOrder sortOrder){
        List<T> outputData = new ArrayList<>(inputList);
        for(int i = 0; i < inputList.size(); i++) {
            for (int j = 0; j < (inputList.size() - i) - 1; j++) {
                if ( sortOrder.equals(SortOrder.ASC) && outputData.get(j).compareTo(outputData.get(j + 1)) > 0) {
                    Util.swap(outputData, j, j + 1);
                }
                else if ( sortOrder.equals(SortOrder.DESC) && outputData.get(j).compareTo(outputData.get(j + 1)) < 0) {
                    Util.swap(outputData, j, j + 1);
                }
            }
        }
        return outputData;
    }
}
