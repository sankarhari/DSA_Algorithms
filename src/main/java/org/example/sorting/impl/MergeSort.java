package org.example.sorting.impl;

import org.example.sorting.Sort;
import org.example.sorting.SortOrder;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sort {

    private static <T extends Number & Comparable<T>> List<T> subProcess(List<T> inputList, SortOrder sortOrder){
        int lengthInputList = inputList.size();
        if(lengthInputList <= 1){
            return inputList;
        }
        int mid = lengthInputList / 2;
        List<T> leftList = new ArrayList<>(inputList.subList(0, mid));
        List<T> rightList = new ArrayList<>(inputList.subList(mid, lengthInputList));
        leftList = subProcess(leftList, sortOrder);
        rightList = subProcess(rightList, sortOrder);
        return merge(leftList,rightList, sortOrder);
    }


    public static <T extends Number & Comparable<T>> List<T> merge(List<T> leftList, List<T> rightList, SortOrder sortOrder){
        List<T> sortedList = new ArrayList<>();
        int lengthLeftList = leftList.size();
        int lengthRightList = rightList.size();
        int l = 0;
        int r = 0;

        if(sortOrder.equals(SortOrder.ASC)){
            while( l < lengthLeftList && r < lengthRightList ){
                if(leftList.get(l).compareTo(rightList.get(r)) < 0){
                    sortedList.add(leftList.get(l));
                    l++;
                }
                else{
                    sortedList.add(rightList.get(r));
                    r++;
                }
            }
            while(l < lengthLeftList){
                sortedList.add(leftList.get(l));
                l++;
            }
            while(r < lengthRightList){
                sortedList.add(rightList.get(r));
                r++;
            }
        }
        if(sortOrder.equals(SortOrder.DESC)){
            while( l < lengthLeftList && r < lengthRightList ){
                if(leftList.get(l).compareTo(rightList.get(r)) > 0){
                    sortedList.add(leftList.get(l));
                    l++;
                }
                else{
                    sortedList.add(rightList.get(r));
                    r++;
                }
            }
            while(r < lengthRightList){
                sortedList.add(rightList.get(r));
                r++;
            }
            while(l < lengthLeftList){
                sortedList.add(leftList.get(l));
                l++;
            }
        }

        return sortedList;
    }

    public static <T extends Number & Comparable<T>> List<T> sort(List<T> inputList, SortOrder sortOrder){
        List<T> outputData = new ArrayList<>(inputList);

        outputData = subProcess(outputData, sortOrder);

        return outputData;
    }
}
