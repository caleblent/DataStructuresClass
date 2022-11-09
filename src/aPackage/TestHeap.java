package aPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestHeap {
	@Test
	void testMaxHeap() {
		BinaryMaxHeap<String> myHeap = new BinaryMaxHeap<String>(10);
		assertTrue(myHeap.isEmpty());
		assertThrows(IllegalStateException.class, ()->{myHeap.findMax();});

		assertThrows(IllegalStateException.class, ()->{myHeap.deleteMax();});
		
		myHeap.insert("January");
		assertEquals("January", myHeap.findMax());
		myHeap.insert("February");
		assertEquals("January", myHeap.findMax());
		myHeap.insert("March");
		assertEquals("March", myHeap.findMax());
		myHeap.insert("April");
		assertEquals("March", myHeap.findMax());
		myHeap.insert("May");
		assertEquals("May", myHeap.findMax());
		myHeap.insert("June");
		assertEquals("May", myHeap.findMax());
		assertEquals("May", myHeap.deleteMax());
		assertEquals("March", myHeap.findMax());
		myHeap.insert("July");
		assertEquals("March", myHeap.findMax());
		myHeap.insert("August");
		assertEquals("March", myHeap.findMax());
		myHeap.insert("September");
		assertEquals("September", myHeap.findMax());

		assertEquals("September", myHeap.deleteMax());
		assertEquals("March", myHeap.deleteMax());
		assertEquals("June", myHeap.deleteMax());
		assertEquals("July", myHeap.deleteMax());
		assertEquals("January", myHeap.deleteMax());
		assertEquals("February", myHeap.deleteMax());
		assertEquals("August", myHeap.deleteMax());
		assertEquals("April", myHeap.deleteMax());
		assertTrue(myHeap.isEmpty());
	}


	
	@Test
	void testBuildHeap() {
		String[] months = {"January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December"};
		BinaryMaxHeap<String> myHeap = new BinaryMaxHeap<String>(months);

		assertEquals("September", myHeap.deleteMax());
		assertEquals("October", myHeap.deleteMax());
		assertEquals("November", myHeap.deleteMax());
		assertEquals("May", myHeap.deleteMax());
		assertEquals("March", myHeap.deleteMax());
		assertEquals("June", myHeap.deleteMax());
		assertEquals("July", myHeap.deleteMax());
		assertEquals("January", myHeap.deleteMax());
		assertEquals("February", myHeap.deleteMax());
		assertEquals("December", myHeap.deleteMax());
		assertEquals("August", myHeap.deleteMax());
		assertEquals("April", myHeap.deleteMax());
		assertTrue(myHeap.isEmpty());	
	}
	
	@Test
	void testHeapSort() {
		String[] months = {"January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December"};
		String[] sorted = {"April","August", "December", "February", "January",  "July", "June",
				"March",  "May", "November", "October","September"};
		BinaryMaxHeap.heapSort(months);
		assertEquals(sorted.length, months.length);
		for(int i = 0; i < sorted.length; i++) {
			assertEquals(sorted[i], months[i]);
		}

	}
	
	/*@Test
	void testMinHeap() {
		BinaryMinHeap<String> myHeap = new BinaryMinHeap<String>(10);
		assertTrue(myHeap.isEmpty());
		assertThrows(IllegalStateException.class, ()->{myHeap.findMin();});

		assertThrows(IllegalStateException.class, ()->{myHeap.deleteMin();});
		
		myHeap.insert("January");
		assertEquals("January", myHeap.findMin());
		myHeap.insert("February");
		assertEquals("February", myHeap.findMin());
		myHeap.insert("March");
		assertEquals("February", myHeap.findMin());
		myHeap.insert("April");
		assertEquals("April", myHeap.findMin());
		myHeap.insert("May");
		assertEquals("April", myHeap.findMin());
		myHeap.insert("June");
		assertEquals("April", myHeap.findMin());
		assertEquals("April", myHeap.deleteMin());
		assertEquals("February", myHeap.findMin());
		myHeap.insert("July");
		assertEquals("February", myHeap.findMin());
		myHeap.insert("August");
		assertEquals("August", myHeap.findMin());
		myHeap.insert("September");
		assertEquals("August", myHeap.findMin());

		assertEquals("August", myHeap.deleteMin());
		assertEquals("February", myHeap.deleteMin());
		assertEquals("January", myHeap.deleteMin());
		assertEquals("July", myHeap.deleteMin());
		assertEquals("June", myHeap.deleteMin());
		assertEquals("March", myHeap.deleteMin());
		assertEquals("May", myHeap.deleteMin());
		assertEquals("September", myHeap.deleteMin());
		assertTrue(myHeap.isEmpty());
	}*/
}