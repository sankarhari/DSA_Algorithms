package org.datastructure.sorting;

import junit.framework.TestCase;
import org.datastructure.sorting.impl.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortElementsTest  extends TestCase{

    List<Integer> input = Arrays.asList(5, 2, 8, 1, 9);
    List<Integer> expected = Arrays.asList(9, 8, 5, 2, 1);

    public void testBubbleSort() {
        List<Integer> actual = BubbleSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }

    public void testSelectionSort() {
        List<Integer> actual = SelectionSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }

    public void testInsertionSort() {
        List<Integer> actual = InsertionSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }

    public void testMergeSort() {
        List<Integer> actual = MergeSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }

    public void testQuickSort() {
        List<Integer> actual = QuickSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }
}
