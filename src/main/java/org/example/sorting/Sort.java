package org.example.sorting;

import java.util.ArrayList;
import java.util.List;

public interface Sort {
   static <T extends Number & Comparable<T>> List<T> sort(List<T> inputData, SortOrder sortOrder){
       return new ArrayList<>();
   }
}
