package org.datastructure.sorting.impl;

import org.datastructure.sorting.Sort;
import org.datastructure.sorting.SortOrder;
import org.datastructure.sorting.Util;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort implements Sort {

    public static <T extends Number & Comparable<T>> List<T> sort(List<T> inputData, SortOrder sortOrder){
        List<T> outputData = new ArrayList<>(inputData);

        for(int i = 0; i < outputData.size(); i++){
            int selectedIndex = i;
            for(int j = i; j < outputData.size(); j++){
                if(sortOrder.equals(SortOrder.ASC) && outputData.get(selectedIndex).compareTo(outputData.get(j)) > 0){
                    selectedIndex = j;
                }
                else if(sortOrder.equals(SortOrder.DESC) && outputData.get(selectedIndex).compareTo(outputData.get(j)) < 0){
                    selectedIndex = j;
                }
            }
            Util.swap(outputData, i, selectedIndex);
        }
        return outputData;
    }
}
