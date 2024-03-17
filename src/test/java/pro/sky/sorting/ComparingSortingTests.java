package pro.sky.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ComparingSortingTests {

    Integer[] testingArray = {2, 9, 0, 6, 1, 7, 8, 4, 3, 5};

    private boolean isSorted(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    void bubbleSortTest() {
        Integer[] testingArrayCopy1;
        testingArrayCopy1 = Arrays.copyOf(testingArray, testingArray.length);
        ComparingSorting.bubbleSort(testingArrayCopy1);
        assertTrue(isSorted(testingArrayCopy1));
    }

    @Test
    void selectionSortTest() {
        Integer[] testingArrayCopy2;
        testingArrayCopy2 = Arrays.copyOf(testingArray, testingArray.length);
        ComparingSorting.selectionSort(testingArrayCopy2);
        assertTrue(isSorted(testingArrayCopy2));
    }

    @Test
    void insertSortTest() {
        Integer[] testingArrayCopy3;
        testingArrayCopy3 = Arrays.copyOf(testingArray, testingArray.length);
        ComparingSorting.insertSort(testingArrayCopy3);
        assertTrue(isSorted(testingArrayCopy3));
    }

    @Test
    void quickSortTest() {
        Integer[] testingArrayCopy4;
        testingArrayCopy4 = Arrays.copyOf(testingArray, testingArray.length);
        ComparingSorting.quickSort(testingArrayCopy4, 0, testingArrayCopy4.length - 1);
        assertTrue(isSorted(testingArrayCopy4));
    }
}
