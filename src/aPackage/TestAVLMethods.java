package aPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAVLMethods {

	@Test
	void testInsertInOrder() {
		AVL<String> tree = new AVL<String>();
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
		assertEquals("A B ", tree.printLevelOrder());
		
		tree.insert("C"); //should rotate CCW
		assertEquals("A B C ", tree.printInOrder());
		assertEquals("B A C ", tree.printPreOrder());
		assertEquals("A C B ", tree.printPostOrder());
		assertEquals("B A C ", tree.printLevelOrder());
		
		tree.insert("D");
		assertEquals("A B C D ", tree.printInOrder());
		assertEquals("B A C D ", tree.printPreOrder());
		assertEquals("A D C B ", tree.printPostOrder());
		assertEquals("B A C D ", tree.printLevelOrder());
	}
	
	@Test
	void testInsertReverseOrder() {
		AVL<String> tree = new AVL<String>();
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
		assertEquals("D C ", tree.printLevelOrder());
		
		tree.insert("B");
		assertEquals("B C D ", tree.printInOrder());
		assertEquals("C B D ", tree.printPreOrder());
		assertEquals("B D C ", tree.printPostOrder());
		assertEquals("C B D ", tree.printLevelOrder());
		
		tree.insert("A");
		assertEquals("A B C D ", tree.printInOrder());
		assertEquals("C B A D ", tree.printPreOrder());
		assertEquals("A B D C ", tree.printPostOrder());
		assertEquals("C B D A ", tree.printLevelOrder());
	}
	
	@Test
	void testInsertRandomOrder() {
		AVL<String> tree = new AVL<String>();
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
		assertEquals("C B ", tree.printLevelOrder());
		
		tree.insert("D");
		assertEquals("B C D ", tree.printInOrder());
		assertEquals("C B D ", tree.printPreOrder());
		assertEquals("B D C ", tree.printPostOrder());
		assertEquals("C B D ", tree.printLevelOrder());
		
		tree.insert("F");
		assertEquals("B C D F ", tree.printInOrder());
		assertEquals("C B D F ", tree.printPreOrder());
		assertEquals("B F D C ", tree.printPostOrder());
		assertEquals("C B D F ", tree.printLevelOrder());
		
		tree.insert("E");
		assertEquals("B C D E F ", tree.printInOrder());
		assertEquals("C B E D F ", tree.printPreOrder());
		assertEquals("B D F E C ", tree.printPostOrder());
		assertEquals("C B E D F ", tree.printLevelOrder());
		
	}
	
	
	@Test
	void testContains() {
		AVL<String> tree = new AVL<String>();
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
