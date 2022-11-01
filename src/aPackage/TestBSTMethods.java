package aPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBSTMethods {

	@Test
	void testInsertInOrder() {
		BST<String> tree = new BST<String>();
		assertEquals("", tree.printInOrder());
		assertEquals("", tree.printPreOrder());
		assertEquals("", tree.printPostOrder());
		
		tree.insert("A");
		assertEquals("A ", tree.printInOrder());
		assertEquals("A ", tree.printPreOrder());
		assertEquals("A ", tree.printPostOrder());
		
		tree.insert("B");
		assertEquals("A B ", tree.printInOrder());
		assertEquals("A B ", tree.printPreOrder());
		assertEquals("B A ", tree.printPostOrder());
		
		tree.insert("C");
		assertEquals("A B C ", tree.printInOrder());
		assertEquals("A B C ", tree.printPreOrder());
		assertEquals("C B A ", tree.printPostOrder());
		
		tree.insert("D");
		assertEquals("A B C D ", tree.printInOrder());
		assertEquals("A B C D ", tree.printPreOrder());
		assertEquals("D C B A ", tree.printPostOrder());
	}
	
	@Test
	void testInsertReverseOrder() {
		BST<String> tree = new BST<String>();
		assertEquals("", tree.printInOrder());
		assertEquals("", tree.printPreOrder());
		assertEquals("", tree.printPostOrder());
		
		tree.insert("D");
		assertEquals("D ", tree.printInOrder());
		assertEquals("D ", tree.printPreOrder());
		assertEquals("D ", tree.printPostOrder());
		
		tree.insert("C");
		assertEquals("C D ", tree.printInOrder());
		assertEquals("D C ", tree.printPreOrder());
		assertEquals("C D ", tree.printPostOrder());
		
		tree.insert("B");
		assertEquals("B C D ", tree.printInOrder());
		assertEquals("D C B ", tree.printPreOrder());
		assertEquals("B C D ", tree.printPostOrder());
		
		tree.insert("A");
		assertEquals("A B C D ", tree.printInOrder());
		assertEquals("D C B A ", tree.printPreOrder());
		assertEquals("A B C D ", tree.printPostOrder());
	}
	
	@Test
	void testInsertRandomOrder() {
		BST<String> tree = new BST<String>();
		assertEquals("", tree.printInOrder());
		assertEquals("", tree.printPreOrder());
		assertEquals("", tree.printPostOrder());
		
		tree.insert("C");
		assertEquals("C ", tree.printInOrder());
		assertEquals("C ", tree.printPreOrder());
		assertEquals("C ", tree.printPostOrder());
		
		tree.insert("B");
		assertEquals("B C ", tree.printInOrder());
		assertEquals("C B ", tree.printPreOrder());
		assertEquals("B C ", tree.printPostOrder());
		
		tree.insert("D");
		assertEquals("B C D ", tree.printInOrder());
		assertEquals("C B D ", tree.printPreOrder());
		assertEquals("B D C ", tree.printPostOrder());
		
		tree.insert("F");
		assertEquals("B C D F ", tree.printInOrder());
		assertEquals("C B D F ", tree.printPreOrder());
		assertEquals("B F D C ", tree.printPostOrder());
		
		tree.insert("A");
		assertEquals("A B C D F ", tree.printInOrder());
		assertEquals("C B A D F ", tree.printPreOrder());
		assertEquals("A B F D C ", tree.printPostOrder());
		
		tree.insert("E");
		assertEquals("A B C D E F ", tree.printInOrder());
		assertEquals("C B A D F E ", tree.printPreOrder());
		assertEquals("A B E F D C ", tree.printPostOrder());
	}
	
	@Test
	void testInsertDuplicateData() {
		BST<String> tree = new BST<String>();
		tree.insert("C");
		tree.insert("B");
		tree.insert("D");
		tree.insert("F");
		tree.insert("A");
		tree.insert("E");
		assertEquals("A B C D E F ", tree.printInOrder());
		assertEquals("C B A D F E ", tree.printPreOrder());
		assertEquals("A B E F D C ", tree.printPostOrder());
		assertThrows(IllegalArgumentException.class, ()->{tree.insert("D");});
		assertEquals("A B C D E F ", tree.printInOrder());
		assertEquals("C B A D F E ", tree.printPreOrder());
		assertEquals("A B E F D C ", tree.printPostOrder());
	}
	
	@Test
	void testDeleteNoChild() {
		BST<String> tree = new BST<String>();
		tree.insert("C");
		tree.insert("B");
		tree.insert("D");
		tree.insert("F");
		tree.insert("A");
		tree.insert("E");
		assertEquals("A B C D E F ", tree.printInOrder());
		assertEquals("C B A D F E ", tree.printPreOrder());
		assertEquals("A B E F D C ", tree.printPostOrder());
		
		tree.delete("A");
		assertEquals("B C D E F ", tree.printInOrder());
		assertEquals("C B D F E ", tree.printPreOrder());
		assertEquals("B E F D C ", tree.printPostOrder());
	}
	
	@Test
	void testDeleteOneChildLeft() {
		BST<String> tree = new BST<String>();
		tree.insert("C");
		tree.insert("B");
		tree.insert("D");
		tree.insert("F");
		tree.insert("A");
		tree.insert("E");
		assertEquals("A B C D E F ", tree.printInOrder());
		assertEquals("C B A D F E ", tree.printPreOrder());
		assertEquals("A B E F D C ", tree.printPostOrder());
		
		tree.delete("B");
		assertEquals("A C D E F ", tree.printInOrder());
		assertEquals("C A D F E ", tree.printPreOrder());
		assertEquals("A E F D C ", tree.printPostOrder());
	}
	
	@Test
	void testDeleteOneChildRight() {
		BST<String> tree = new BST<String>();
		tree.insert("C");
		tree.insert("B");
		tree.insert("D");
		tree.insert("F");
		tree.insert("A");
		tree.insert("E");
		assertEquals("A B C D E F ", tree.printInOrder());
		assertEquals("C B A D F E ", tree.printPreOrder());
		assertEquals("A B E F D C ", tree.printPostOrder());
		
		tree.delete("D");
		assertEquals("A B C E F ", tree.printInOrder());
		assertEquals("C B A F E ", tree.printPreOrder());
		assertEquals("A B E F C ", tree.printPostOrder());
	}
	
	@Test
	void testDeleteTwoChildrenOneChildDonor() {
		BST<String> tree = new BST<String>();
		tree.insert("C");
		tree.insert("B");
		tree.insert("D");
		tree.insert("F");
		tree.insert("A");
		tree.insert("E");
		assertEquals("A B C D E F ", tree.printInOrder());
		assertEquals("C B A D F E ", tree.printPreOrder());
		assertEquals("A B E F D C ", tree.printPostOrder());
		
		tree.delete("C");
		assertEquals("A B D E F ", tree.printInOrder());
		assertEquals("D B A F E ", tree.printPreOrder());
		assertEquals("A B E F D ", tree.printPostOrder());
	}
	
	@Test
	void testDeleteTwoChildrenNoChildDonor() {
		BST<String> tree = new BST<String>();
		tree.insert("C");
		tree.insert("B");
		tree.insert("E");
		tree.insert("F");
		tree.insert("A");
		tree.insert("D");
		assertEquals("A B C D E F ", tree.printInOrder());
		assertEquals("C B A E D F ", tree.printPreOrder());
		assertEquals("A B D F E C ", tree.printPostOrder());
		
		tree.delete("C");
		assertEquals("A B D E F ", tree.printInOrder());
		assertEquals("D B A E F ", tree.printPreOrder());
		assertEquals("A B F E D ", tree.printPostOrder());
	}
	
	@Test
	void testDeleteMissing() {
		BST<String> tree = new BST<String>();
		tree.insert("C");
		tree.insert("B");
		tree.insert("E");
		tree.insert("F");
		tree.insert("A");
		tree.insert("D");
		assertEquals("A B C D E F ", tree.printInOrder());
		assertEquals("C B A E D F ", tree.printPreOrder());
		assertEquals("A B D F E C ", tree.printPostOrder());
		
		assertThrows(IllegalArgumentException.class, ()->{tree.delete("G");});
		assertEquals("A B C D E F ", tree.printInOrder());
		assertEquals("C B A E D F ", tree.printPreOrder());
		assertEquals("A B D F E C ", tree.printPostOrder());
	}

	
	@Test
	void testContains() {
		BST<String> tree = new BST<String>();
		tree.insert("C");
		tree.insert("B");
		tree.insert("E");
		tree.insert("F");
		tree.insert("A");
		tree.insert("G");
		assertTrue(tree.contains("G"));
		assertTrue(tree.contains("A"));
		assertTrue(tree.contains("F"));
		assertFalse(tree.contains("1"));
		assertFalse(tree.contains("D"));
		assertFalse(tree.contains("H"));
		
	}

}