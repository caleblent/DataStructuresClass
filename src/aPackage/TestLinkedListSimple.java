package aPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Some basic unit tests to check if we've implemented get, contains,
 * and toString for simple LinkedLists
 * 
 * @author gosnat
 * @version Fall 2020
 */

class TestLinkedListSimple {
	private LinkedListSimple<String> list;

	@BeforeEach
	void setUp() {
		list = new LinkedListSimple<String>(new String[] {"First", "Second", "Third", "Fourth"});
	}

	@Test
	void testToString() {
		assertEquals("First Second Third Fourth ", list.toString());
	}

	@Test
	void testGet() {
		assertEquals("First", list.get(0));
		assertEquals("Second", list.get(1));
		assertEquals("Third", list.get(2));
		assertEquals("Fourth", list.get(3));
		assertThrows(IllegalArgumentException.class, () -> {
			list.get(-1);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			list.get(4);
		});
	}
	
	@Test
	void testContains() {
		assertTrue(list.contains("First"));
		assertTrue(list.contains("Second"));
		assertTrue(list.contains("Third"));
		assertTrue(list.contains("Fourth"));
		assertFalse(list.contains("Not there"));
	}


}