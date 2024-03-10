package pro.sky;

import pro.sky.exceptions.InvalidIndexInputException;
import pro.sky.exceptions.ItemNotFoundException;
import pro.sky.exceptions.NullPointerItemException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] stringList;
    private int currentSize;

    public StringListImpl() {
        this.stringList = new String[10];
    }

    public StringListImpl(int initCapacity) {
        this.stringList = new String[initCapacity];
    }

    public String[] getStringList() {
        return stringList;
    }

    private void validateItem(String item) {
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
        String[] extendedStringList = new String[currentSize + 5];
        System.arraycopy(stringList, 0, extendedStringList, 0, currentSize);
        stringList = extendedStringList;
    }

    @Override
    public String add(String item) {
        validateItem(item);
        if (currentSize == stringList.length) {
            extendList();
        }
        stringList[currentSize] = item;
        currentSize++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateIndex(index);
        if (index == currentSize) {
            return add(item);
        }
        validateItem(item);
        if (currentSize == stringList.length) {
            extendList();
        }
        System.arraycopy(stringList, index, stringList, index + 1, currentSize - index);
        stringList[index] = item;
        currentSize++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateItem(item);
        validateIndex(index);
        if (index == currentSize) {
            throw new InvalidIndexInputException();
        }
        stringList[index] = item;
        return item;
    }

    @Override
    public boolean contains(String item) {
        validateItem(item);
        return indexOf(item) != -1;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemNotFoundException();
        }
        remove(index);
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        if (index == currentSize) {
            throw new ItemNotFoundException();
        }
        String item = stringList[index];
        System.arraycopy(stringList, index + 1, stringList, index, currentSize - index - 1);
        currentSize--;
        return item;
    }

    @Override
    public int indexOf(String item) {
        validateItem(item);
        for (int i = 0; i < currentSize; i++) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        validateItem(item);
        for (int i = currentSize - 1; i >= 0; i--) {
            if (stringList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        if (index == currentSize) {
            throw new ItemNotFoundException();
        }
        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
        stringList = new String[10];
        currentSize = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringList, currentSize);
    }
}
