package org.datastructure.sorting.impl;

import org.datastructure.sorting.Sort;
import org.datastructure.sorting.SortOrder;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort implements Sort {

    public static <T extends Number & Comparable<T>> List<T> sort(List<T> inputList, SortOrder sortOrder){
        List<T> outputData = new ArrayList<>(inputList);
        for(int i = 1; i < outputData.size(); i++){
            T valueTaken = outputData.get(i);
            int hole = i;
            while(sortOrder.equals(SortOrder.ASC) && hole > 0 && outputData.get(hole - 1).compareTo(valueTaken) > 0){
                outputData.set(hole, outputData.get(hole - 1));
                hole--;
            }

            while(sortOrder.equals(SortOrder.DESC) && hole > 0 && outputData.get(hole - 1).compareTo(valueTaken) < 0){
                outputData.set(hole, outputData.get(hole - 1));
                hole--;
            }
            outputData.set(hole, valueTaken);
        }

        return outputData;
    }
}
