package org.example.sorting;

import org.example.sorting.impl.BubbleSort;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;
import org.example.sorting.impl.BubbleSort;
import org.example.sorting.impl.InsertionSort;
import org.example.sorting.impl.MergeSort;
import org.example.sorting.impl.SelectionSort;

import java.util.ArrayList;
import java.util.List;

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
}
