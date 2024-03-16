package pro.sky;

import org.junit.jupiter.api.Test;
import pro.sky.exceptions.InvalidIndexInputException;
import pro.sky.exceptions.ItemNotFoundException;
import pro.sky.exceptions.NullPointerItemException;

import static org.junit.jupiter.api.Assertions.*;

class ListInterfaceStringImplTests {

    ListInterfaceStringImpl testList = new ListInterfaceStringImpl(3);

    String str1 = "Test1";
    String str2 = "Test2";
    String str3 = "Test3";

    @Test
    void extendList() {
        assertEquals(3, testList.getStringList().length);
        testList.extendList();
        assertEquals(5, testList.getStringList().length);
    }

    @Test
    void add_StringArgument_positive(){
        testList.add(str1);
        assertEquals(1, testList.size());
        assertEquals("Test1", testList.get(0));
    }

    @Test
    void add_StringArgument_positive_with_extend(){
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        testList.add(str1);
        assertEquals(4, testList.size());
        assertEquals("Test1", testList.get(3));
    }

    @Test
    void add_StringArgument_negative_nullPointerException(){
        assertThrows(NullPointerItemException.class, () ->
        testList.add(null));
    }

    @Test
    void add_IndexStringArgument_positive(){
        testList.add(0, str1);
        assertEquals(1, testList.size());
        assertEquals("Test1", testList.get(0));
    }

    @Test
    void add_IndexStringArgument_positive_with_extend(){
        testList.add(0, str1);
        testList.add(1, str2);
        testList.add(2, str3);
        testList.add(3, str1);
        assertEquals(4, testList.size());
        assertEquals("Test1", testList.get(3));
    }

    @Test
    void add_IndexStringArgument_negative_nullPointerException(){
        assertThrows(NullPointerItemException.class, () ->
                testList.add(0,null));
    }

    @Test
    void add_IndexStringArgument_negative_InvalidIndexInputException(){
        testList.add(str1);
        assertThrows(InvalidIndexInputException.class, () ->
                testList.add(2, str2));
        assertThrows(InvalidIndexInputException.class, () ->
                testList.add(-1, str2));
    }

    @Test
    void set_positive(){
        testList.add(0, str1);
        testList.add(1, str2);
        testList.set(0, str3);
        assertEquals(2, testList.size());
        assertEquals("Test3", testList.get(0));
    }

    @Test
    void set_negative_InvalidIndexInput(){
        testList.add(str1);
        testList.add(str2);
        assertThrows(InvalidIndexInputException.class, () ->
                testList.set(2, str3));
        assertThrows(InvalidIndexInputException.class, () ->
                testList.set(-1, str3));
    }

    @Test
    void set_negative_NullPointerItem(){
        testList.add(str1);
        testList.add(str2);
        assertThrows(NullPointerItemException.class, () ->
                testList.set(0, null));
    }

    @Test
    void contains_positive(){
        testList.add(str1);
        assertTrue(testList.contains(str1));
        assertFalse(testList.contains(str2));
    }

    @Test
    void contains_negative_nullPointerException(){
        assertThrows(NullPointerItemException.class, () ->
                testList.contains(null));
    }

    @Test
    void remove_StringArgument_positive(){
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        testList.remove(str1);
        assertEquals(2, testList.size());
        assertEquals("Test2", testList.get(0));
        assertEquals("Test3", testList.get(1));
    }

    @Test
    void remove_StringArgument_negative_NullPointerException() {
        assertThrows(NullPointerItemException.class, () ->
                testList.remove(null));
    }

    @Test
    void remove_StringArgument_negative_ItemNotFoundException() {
        testList.add(str1);
        assertThrows(ItemNotFoundException.class, () ->
                testList.remove(str2));
    }

    @Test
    void remove_IndexArgument_positive(){
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        String temp = testList.remove(0);
        assertEquals(2, testList.size());
        assertEquals("Test2", testList.get(0));
        assertEquals("Test3", testList.get(1));
        assertEquals("Test1", temp);
    }

    @Test
    void remove_IndexArgument_negative_InvalidIndexInputException() {
        testList.add(str1);
        assertThrows(InvalidIndexInputException.class, () ->
                testList.remove(-1));
        assertThrows(InvalidIndexInputException.class, () ->
                testList.remove(2));
    }

    @Test
    void remove_IndexArgument_negative_ItemNotFoundException() {
        testList.add(str1);
        assertThrows(ItemNotFoundException.class, () ->
                testList.remove(1));
    }

    @Test
    void idexOf_positive() {
        testList.add(str1);
        testList.add(str2);
        assertEquals(0, testList.indexOf(str1));
        assertEquals(1, testList.indexOf(str2));
        assertEquals(-1, testList.indexOf(str3));
    }

    @Test
    void indexOf_negative_NullPointerException() {
        assertThrows(NullPointerItemException.class, () ->
                testList.indexOf(null));
    }

    @Test
    void lastIdexOf_positive() {
        testList.add(str1);
        testList.add(str2);
        assertEquals(0, testList.lastIndexOf(str1));
        assertEquals(1, testList.lastIndexOf(str2));
        assertEquals(-1, testList.lastIndexOf(str3));
    }

    @Test
    void lastIndexOf_negative_NullPointerException() {
        assertThrows(NullPointerItemException.class, () ->
                testList.lastIndexOf(null));
    }

    @Test
    void get_positive(){
        testList.add(str1);
        testList.add(str2);
        assertEquals("Test1", testList.get(0));
        assertEquals("Test2", testList.get(1));
    }

    @Test
    void get_negative_ItemNotFoundException() {
        testList.add(str1);
        assertThrows(ItemNotFoundException.class, () ->
                testList.get(1));
    }

    @Test
    void get_negative_InvalidIndexInputException() {
        testList.add(str1);
        assertThrows(InvalidIndexInputException.class, () ->
                testList.get(-1));
        assertThrows(InvalidIndexInputException.class, () ->
                testList.get(2));
    }

    @Test
    void equals_positive() {
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        ListInterfaceStringImpl testList2 = new ListInterfaceStringImpl(3);
        testList2.add(str1);
        testList2.add(str2);
        testList2.add(str3);
        assertTrue(testList.equals(testList2));
        testList2.remove(str1);
        assertFalse(testList.equals(testList2));
        testList2.add(0, str1);
        assertTrue(testList.equals(testList2));
        testList2.add(str2);
        assertFalse(testList.equals(testList2));
    }

    @Test
    void equals_negative_NullPointerItemException() {
        assertThrows(NullPointerItemException.class, () ->
                testList.equals(null));
    }

    @Test
    void clear() {
        testList.add(str1);
        testList.add(str2);
        testList.add(str3);
        assertEquals(3, testList.size());
        testList.clear();
        assertTrue(testList.isEmpty());
        assertThrows(ItemNotFoundException.class, () ->
                testList.get(0));
    }
}