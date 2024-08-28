package org.example.sorting;

import junit.framework.TestCase;
import org.example.sorting.SortOrder;
import org.example.sorting.impl.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SingleElementTest extends TestCase {

    List<Integer> input = List.of(5);
    List<Integer> expected = List.of(5);

    public void testBubbleSort() {
        List<Integer> actual = BubbleSort.sort(input, SortOrder.DESC);
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

    public void testSelectionSort() {
        List<Integer> actual = SelectionSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }

    public void testQuickSort() {
        List<Integer> actual = QuickSort.sort(input, SortOrder.DESC);
        assertIterableEquals(expected, actual);
    }
}
