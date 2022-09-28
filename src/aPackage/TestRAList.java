package aPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Some basic unit tests to check if we've implemented left-justified 
 * insertion and deletion correctly for arrays
 * @author gosnat/albing
 * @version 1.2a
 */

class TestRAList
{
    private RAList<Integer> list;

    @BeforeEach
    void setUp() {
	list = new RAList<Integer>(5);
    }

    @Test
    void testInsertEmpty() {
	assertEquals("", list.toString());
	list.insert(42, 0);
	assertEquals("42 ", list.toString());
    }
	
    @Test
    void testSmall() {
	list = new RAList<Integer>(1);
	assertEquals("", list.toString());
	list.insert(42, 0);
	assertEquals("42 ", list.toString());
	list.delete(42);
	assertEquals("", list.toString());
    }
	
    @Test
    void testInsertIndexOrder() {
	assertEquals("", list.toString());
	list.insert(42, 0);
	assertEquals("42 ", list.toString());
	list.insert(1, 1);
	assertEquals("42 1 ", list.toString());
	list.insert(2, 2);
	assertEquals("42 1 2 ", list.toString());
	list.insert(3, 3);
	assertEquals("42 1 2 3 ", list.toString());
	list.insert(4, 4);
	assertEquals("42 1 2 3 4 ", list.toString());
	assertThrows(IllegalArgumentException.class, () ->{list.insert(5, 5);});
	assertEquals("42 1 2 3 4 ", list.toString());
    } // testInsertIndexOrder
	
    @Test
    void testInsertToMiddle() {
	assertEquals("", list.toString());
	list.insert(42, 0);
	assertEquals("42 ", list.toString());
	list.insert(1, 1);
	assertEquals("42 1 ", list.toString());
	list.insert(2, 2);
	assertEquals("42 1 2 ", list.toString());
	list.insert(3, 1);
	assertEquals("42 3 1 2 ", list.toString());
	list.insert(4, 0);
	assertEquals("4 42 3 1 2 ", list.toString());
	assertThrows(IllegalArgumentException.class, () ->{list.insert(5, 1);});
	assertEquals("4 42 3 1 2 ", list.toString());
    } // testInsertToMiddle
	
    @Test
    void testDeleteFirst() {
	assertEquals("", list.toString());
	list.insert(42, 0);
	list.insert(1, 1);
	list.insert(2, 2);
	list.insert(3, 3);
	list.insert(4, 4);
	assertEquals("42 1 2 3 4 ", list.toString());
	list.delete(42);
	assertEquals("1 2 3 4 ", list.toString());
    } // testDeleteFirst
	
    @Test
    void testDeleteLast() {
	assertEquals("", list.toString());
	list.insert(42, 0);
	list.insert(1, 1);
	list.insert(2, 2);
	list.insert(3, 3);
	list.insert(4, 4);
	assertEquals("42 1 2 3 4 ", list.toString());
	list.delete(4);
	assertEquals("42 1 2 3 ", list.toString());
    } // testDeleteLast
	
    @Test
    void testDeleteMiddle() {
	assertEquals("", list.toString());
	list.insert(42, 0);
	list.insert(1, 1);
	list.insert(2, 2);
	list.insert(3, 3);
	list.insert(4, 4);
	assertEquals("42 1 2 3 4 ", list.toString());
	list.delete(2);
	assertEquals("42 1 3 4 ", list.toString());
    } // testDeleteMiddle
	
    @Test
    void testDeleteEmpty() {
	assertEquals("", list.toString());
	assertThrows(IllegalArgumentException.class, () ->{list.delete(1);});
    } // testDeleteEmpty
	
    @Test
    void testDeleteMissing() {
	assertEquals("", list.toString());
	list.insert(42, 0);
	assertThrows(IllegalArgumentException.class, () ->{list.delete(1);});
    } // testDeleteMissing

} // class TestRAList