package pro.sky;

import pro.sky.exceptions.InvalidIndexInputException;
import pro.sky.exceptions.ItemNotFoundException;
import pro.sky.exceptions.NullPointerItemException;

import java.util.Arrays;

public class ListInterfaceIntegerImpl implements ListInterface<Integer> {

    private Integer[] integerList;
    private int currentSize;

    public ListInterfaceIntegerImpl() {
        this.integerList = new Integer[10];
    }

    public ListInterfaceIntegerImpl(int initCapacity) {
        this.integerList = new Integer[initCapacity];
    }

    public Integer[] getIntegerList() {
        return integerList;
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullPointerItemException();
        }
    }

    private void validateIndex(int index) {
        if (index > currentSize || index < 0) {
            throw new InvalidIndexInputException();
        }
    }

    public void extendList() {
        Integer[] extendedIntegerList = new Integer[currentSize * 3 / 2];
        System.arraycopy(integerList, 0, extendedIntegerList, 0, currentSize);
        integerList = extendedIntegerList;
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        if (currentSize == integerList.length) {
            extendList();
        }
        integerList[currentSize] = item;
        currentSize++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateIndex(index);
        if (index == currentSize) {
            return add(item);
        }
        validateItem(item);
        if (currentSize == integerList.length) {
            extendList();
        }
        System.arraycopy(integerList, index, integerList, index + 1, currentSize - index);
        integerList[index] = item;
        currentSize++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateItem(item);
        validateIndex(index);
        if (index == currentSize) {
            throw new InvalidIndexInputException();
        }
        integerList[index] = item;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        validateItem(item);
        Integer[] integerListCopy = Arrays.copyOf(integerList, currentSize);
        quickSort(integerListCopy, 0, integerListCopy.length - 1);
        return binarySearch(integerListCopy, item);
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemNotFoundException();
        }
        remove(index);
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        if (index == currentSize) {
            throw new ItemNotFoundException();
        }
        Integer item = integerList[index];
        System.arraycopy(integerList, index + 1, integerList, index, currentSize - index - 1);
        currentSize--;
        return item;
    }

    @Override
    public int indexOf(Integer item) {
        validateItem(item);
        for (int i = 0; i < currentSize; i++) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateItem(item);
        for (int i = currentSize - 1; i >= 0; i--) {
            if (integerList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        if (index == currentSize) {
            throw new ItemNotFoundException();
        }
        return integerList[index];
    }

    @Override
    public boolean equals(ListInterface<Integer> otherList) {
        if (otherList == null) {
            throw new NullPointerItemException();
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void clear() {
        integerList = new Integer[10];
        currentSize = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integerList, currentSize);
    }

    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    public static void swapElements(Integer[] arr, int idx1, int idx2) {
        Integer temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static boolean binarySearch(Integer[] arr, Integer item) {

        int idxMin = 0;
        int idxMax = arr.length - 1;

        while (idxMin <= idxMax) {
            int idxMiddle = (idxMin + idxMax) / 2;
            if (arr[idxMiddle].equals(item)) {
                return true;
            }
            if (arr[idxMiddle] > item) {
                idxMax = idxMiddle - 1;
            }
            else {
                idxMin = idxMiddle + 1;
            }
        }
        return false;
    }
}
