package aPackage;

public class Trie {
	
	private TrieNode root;
	
	public Trie() {
        root = new TrieNode('\0');
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if (curr.children[c - 'a'] == null) {
        		curr.children[c - 'a'] = new TrieNode(c);
        	}
        	curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
    	TrieNode trieNode = getNode(word);
        return trieNode != null && trieNode.isWord;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }
    
    private TrieNode getNode(String word) {
    	TrieNode curr = root;
    	for (int i = 0; i < word.length(); i++) {
    		char c = word.charAt(i);
    		if (curr.children[c - 'a'] == null)
    			return null;
    		curr = curr.children[c - 'a'];
    	}
    	return curr;
    	
    }
    
    class TrieNode {
    	public char c;
    	public boolean isWord;
//    	TrieNode parent;
    	public TrieNode[] children;
    	
    	public TrieNode(char ch) {
    		this.c = ch;
    		this.isWord = false;
    		children = new TrieNode[26];
    	}
    }
}
