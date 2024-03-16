package pro.sky.sorting;

import java.util.Arrays;
import java.util.Random;

public class ComparingSorting {

    public static void main(String[] args) {

        Random random = new Random();
        Integer[] unsorted = new Integer[100_000];
        for (int i = 0; i < unsorted.length; i++) {
            unsorted[i] = random.nextInt();
        }

        Integer[] unsortedCopy1 = Arrays.copyOf(unsorted, unsorted.length);
        Integer[] unsortedCopy2 = Arrays.copyOf(unsorted, unsorted.length);
        Integer[] unsortedCopy3 = Arrays.copyOf(unsorted, unsorted.length);

        Long start1 = System.currentTimeMillis();
        bubbleSort(unsortedCopy1);
        Long finish1 = System.currentTimeMillis();
        System.out.println("Время сортировки массива 'пузырьком': " + (finish1 - start1));

        Long start2 = System.currentTimeMillis();
        selectionSort(unsortedCopy2);
        Long finish2 = System.currentTimeMillis();
        System.out.println("Время сортировки массива выбором: " + (finish2 - start2));

        Long start3 = System.currentTimeMillis();
        insertSort(unsortedCopy3);
        Long finish3 = System.currentTimeMillis();
        System.out.println("Время сортировки массива вставкой: " + (finish3 - start3));

    }

    public static void swapElements(Integer[] arr, int idx1, int idx2) {
        Integer temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void bubbleSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void insertSort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Integer temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
