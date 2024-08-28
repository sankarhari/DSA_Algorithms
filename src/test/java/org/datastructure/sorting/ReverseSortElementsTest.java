package org.datastructure.sorting;

import org.datastructure.sorting.impl.*;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ReverseSortElementsTest extends TestCase {

    List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> expected = Arrays.asList(5, 4, 3, 2, 1);

    public void testBubbleSorted() {
        List<Integer> actual = BubbleSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }

    public void testMergeSorted() {
        List<Integer> actual = MergeSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }

    public void testInsertionSorted() {
        List<Integer> actual = InsertionSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }

    public void testSelectionSorted() {
        List<Integer> actual = SelectionSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }

    public void testQuickSorted() {
        List<Integer> actual = QuickSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }
}
