package aPackage;

public class Trie {
	
	public Trie() {
        
    }
    
    public void insert(String word) {
        
    }
    
    public boolean search(String word) {
        return false;
    }
    
    public boolean startsWith(String prefix) {
        return false;
    }
    
    class TrieNode {
    	char ch;
    	boolean isWord;
    	TrieNode parent;
    	LinkedList<TrieNode> children;
    }
}