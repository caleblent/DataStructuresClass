package aPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Some basic unit tests to check if we've implemented left-justified insertion
 * and deletion correctly for arrays
 * 
 * @author gosnat
 * @version Fall 2020
 */

class TestLinkedList {
	private LinkedList<Integer> list;

	@BeforeEach
	void setUp() {
		list = new LinkedList<Integer>(null);
	}

	@Test
	void testInsertEmpty() {
		assertEquals("", list.toString());
		list.insert(42, 0);
		assertEquals("42 ", list.toString());
	}

	@Test
	void testSmall() {
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

	}
	
	@Test
	void testInsertIllegalIndex() {
		list.insert(42, 0);
		list.insert(1, 1);
		assertThrows(IllegalArgumentException.class, () -> {
			list.insert(50, -1);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			list.insert(50, 3);
		});
		list.insert(2, 2);
		list.insert(3, 3);
		list.insert(4, 4);
		assertThrows(IllegalArgumentException.class, () -> {
			list.insert(50, -1);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			list.insert(50, 6);
		});
	}

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
	}

	@Test
	void testGet() {

		list.insert(42, 0);
		list.insert(1, 1);
		list.insert(2, 2);
		list.insert(3, 1);
		list.insert(4, 0);
		assertEquals("4 42 3 1 2 ", list.toString());
		assertEquals(4, list.get(0));
		assertEquals(42, list.get(1));
		assertEquals(3, list.get(2));
		assertEquals(1, list.get(3));
		assertEquals(2, list.get(4));
		assertThrows(IllegalArgumentException.class, () -> {
			list.get(-1);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			list.get(5);
		});
	}
	
	@Test
	void testContains() {
		assertFalse(list.contains(42));
		list.insert(42, 0);
		list.insert(1, 1);
		list.insert(2, 2);
		list.insert(3, 1);
		list.insert(4, 0);
		assertTrue(list.contains(42));
		assertTrue(list.contains(1));
		assertTrue(list.contains(2));
		assertTrue(list.contains(3));
		assertTrue(list.contains(4));
		assertFalse(list.contains(0));
		assertFalse(list.contains(5));
	}

//	@Test
//	void testDeleteFirst() {
//		assertEquals("", list.toString());
//		list.insert(42, 0);
//		list.insert(1, 1);
//		list.insert(2, 2);
//		list.insert(3, 3);
//		list.insert(4, 4);
//		assertEquals("42 1 2 3 4 ", list.toString());
//		list.delete(42);
//		assertEquals("1 2 3 4 ", list.toString());
//	}
//
//	@Test
//	void testDeleteLast() {
//		assertEquals("", list.toString());
//		list.insert(42, 0);
//		list.insert(1, 1);
//		list.insert(2, 2);
//		list.insert(3, 3);
//		list.insert(4, 4);
//		assertEquals("42 1 2 3 4 ", list.toString());
//		list.delete(4);
//		assertEquals("42 1 2 3 ", list.toString());
//	}
//
//	@Test
//	void testDeleteMiddle() {
//		assertEquals("", list.toString());
//		list.insert(42, 0);
//		list.insert(1, 1);
//		list.insert(2, 2);
//		list.insert(3, 3);
//		list.insert(4, 4);
//		assertEquals("42 1 2 3 4 ", list.toString());
//		list.delete(2);
//		assertEquals("42 1 3 4 ", list.toString());
//	}
//
//	@Test
//	void testDeleteEmpty() {
//		assertEquals("", list.toString());
//		assertThrows(IllegalArgumentException.class, () -> {
//			list.delete(1);
//		});
//	}
//
//	@Test
//	void testDeleteMissing() {
//		assertEquals("", list.toString());
//		list.insert(42, 0);
//		assertThrows(IllegalArgumentException.class, () -> {
//			list.delete(1);
//		});
//	}
//	
//	@Test
//	void testDeleteFirstByIndex() {
//		assertEquals("", list.toString());
//		list.insert(42, 0);
//		list.insert(1, 1);
//		list.insert(2, 2);
//		list.insert(3, 3);
//		list.insert(4, 4);
//		assertEquals("42 1 2 3 4 ", list.toString());
//		list.deleteIndex(0);
//		assertEquals("1 2 3 4 ", list.toString());
//	}
//
//	@Test
//	void testDeleteLastByIndex() {
//		assertEquals("", list.toString());
//		list.insert(42, 0);
//		list.insert(1, 1);
//		list.insert(2, 2);
//		list.insert(3, 3);
//		list.insert(4, 4);
//		assertEquals("42 1 2 3 4 ", list.toString());
//		list.deleteIndex(4);
//		assertEquals("42 1 2 3 ", list.toString());
//	}
//
//	@Test
//	void testDeleteMiddleByIndex() {
//		assertEquals("", list.toString());
//		list.insert(42, 0);
//		list.insert(1, 1);
//		list.insert(2, 2);
//		list.insert(3, 3);
//		list.insert(4, 4);
//		assertEquals("42 1 2 3 4 ", list.toString());
//		list.deleteIndex(2);
//		assertEquals("42 1 3 4 ", list.toString());
//	}
//
//	@Test
//	void testDeleteEmptyByIndex() {
//		assertEquals("", list.toString());
//		assertThrows(IllegalArgumentException.class, () -> {
//			list.deleteIndex(0);
//		});
//	}
//	
//	@Test
//	void testDeleteIllegalIndex() {
//		assertEquals("", list.toString());
//		list.insert(42, 0);
//		list.insert(1, 1);
//		list.insert(2, 2);
//		list.insert(3, 3);
//		list.insert(4, 4);
//		assertEquals("42 1 2 3 4 ", list.toString());
//		assertThrows(IllegalArgumentException.class, () -> {
//			list.deleteIndex(-1);
//		});
//		assertThrows(IllegalArgumentException.class, () -> {
//			list.deleteIndex(5);
//		});
//		assertEquals("42 1 2 3 4 ", list.toString());
//	}

}