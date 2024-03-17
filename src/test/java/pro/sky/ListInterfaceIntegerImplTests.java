package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.exceptions.NullPointerItemException;

import static org.junit.jupiter.api.Assertions.*;

class ListInterfaceIntegerImplTests {

    ListInterface<Integer> test = new ListInterfaceIntegerImpl(5);

    @BeforeEach
    void setUp() {
        test.add(3);
        test.add(1);
        test.add(0);
        test.add(5);
        test.add(4);
    }

    @Test
    void binarySearchTest() {
      Integer[] testListCopy = test.toArray();
      ListInterfaceIntegerImpl.quickSort(testListCopy, 0, testListCopy.length - 1);
      assertTrue(ListInterfaceIntegerImpl.binarySearch(testListCopy, 0));
      assertTrue(ListInterfaceIntegerImpl.binarySearch(testListCopy, 4));
      assertTrue(ListInterfaceIntegerImpl.binarySearch(testListCopy, 3));
      assertFalse(ListInterfaceIntegerImpl.binarySearch(testListCopy, 10));
      assertFalse(ListInterfaceIntegerImpl.binarySearch(testListCopy, -1));
      assertFalse(ListInterfaceIntegerImpl.binarySearch(testListCopy, 15));
    }

    @Test
    void contains_positive() {
        assertTrue(test.contains(0));
        assertTrue(test.contains(4));
        assertTrue(test.contains(3));
        assertFalse(test.contains(10));
        assertFalse(test.contains(-1));
        assertFalse(test.contains(15));
    }

    @Test
    void contains_negative_NullPointer() {
        assertThrows(NullPointerItemException.class, () ->
                test.contains(null));
    }
}
