package aPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test cases for the Trie implementation
 * 
 * @author Caleb Lent
 * @version October 2022
 */
class TestTrie {
	
	Trie trie = new Trie();
	
	@BeforeEach
	void init() {
		trie.insert("cat");
		trie.insert("cats");
		trie.insert("catnip");
		trie.insert("catnap");
		trie.insert("caterpillar");
	}

	@Test
	void testBasicFunctionality() {
		assertFalse(trie.search("c"));
		assertFalse(trie.search("ca"));
		assertTrue(trie.search("cat"));
		assertTrue(trie.search("cats"));
		
		assertFalse(trie.search("catn"));
		assertTrue(trie.startsWith("catn"));
		
		assertTrue(trie.startsWith("cater"));
		assertFalse(trie.search("cater"));
	}
	
	@Test
	void testUppercaseLetters() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			trie.insert("Casper");
		});
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			trie.insert("canTALoupe");
		});
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			trie.insert("DOGGY");
		});
	}
	
	

}
