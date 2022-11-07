package aPackage;

import java.util.LinkedList;
import java.util.Queue;


/**
 * An AVL Search Tree Implementation
 * Null Sentinels used to avoid null code case
 * 
 * This implementation doesn't allow duplicate values, but removing that restriction doesn't
 * fundamentally alter the implementation strategies shown here
 * 
 * This implementation is insert and find only.  
 * 
 * Alternate implementation can be found in Gray book 
 * 
 * Some inspiration drawn from implementations by Mark Allen Weiss and Simon Gray.
 * 
 * @author Nathan Gossett
 * @author Carl Albing
 * @author Caleb Lent
 * @version Fall 2020
 *
 * @param T must implement Comparable Interface to be a BST
 */ 

public class AVL<T extends Comparable<? super T>> {
	
	/**
	 * A private class to gether information about an AVL tree node
	 */
	private class AVLNode{
		/** The height of this node, aka number of links to follow to get to deepest leaf*/
		public int height;
		
		/** Actual data stored in this node */
		public T data;
		
		/** left child */
		public AVLNode left;
		
		/** right child */
		public AVLNode right;
		
		public AVLNode(T data, AVLNode left, AVLNode right){
			this.data = data;
			this.left = left;
			this.right = right;
			height = 0; //probably inserting as a leaf, change this after construction if not
		}
		
	}
	
	/** the root of the tree */
	private AVLNode root;
	
	/** A null sentinel with a height of -1 */
	//TODO: HEY! LOOK! A SENTINEL NODE!
	private AVLNode nullSentinel;
	
	
	/** construct empty tree */
	public AVL(){
		//TODO
	}
	
	/**
	 * Recursively add new node to BST
	 * @param data new data to add
	 * @throws IllegalArgumentException if data is a duplicate
	 */
	public void insert(T data) throws IllegalArgumentException{	
		if(data == null){
			throw new IllegalArgumentException("Null data in addNode()");
		}
		//deal with an empty tree
		if( root == nullSentinel){
			root = new AVLNode(data, nullSentinel, nullSentinel);
			return;
		}
		//otherwise we have at least one real node, call recursive method
		root = insert(data, root);
	}
	
	/**
	 * Recursively insert a node into the tree, update heights and balance on 
	 * the way back up
	 * @param data The data to insert into the tree
	 * @param root the root of this sub-tree
	 * @return The node that should be the (new) root of this sub-tree
	 */
	private AVLNode insert(T data, AVLNode root) {
		if(root.data.compareTo(data) == 0) {
			throw new IllegalArgumentException("Duplicate data item!");
		}
		if(root.data.compareTo(data) > 0) { //new data is less than
			if(root.left == nullSentinel) {
				root.left = new AVLNode(data, nullSentinel, nullSentinel);
			}
			//TODO potential rotations during insert requires a different case here than BST
		}else { //new data is greater than
			if(root.right == nullSentinel) { 
				root.right = new AVLNode(data, nullSentinel, nullSentinel);
			}
			//TODO potential rotations during insert requires a different case here than BST
		}
		//is this an imbalance? 
		//TODO before we return, check to see if we violate AVL property and correct
		
		//TODO correct the root's height attribute as needed
		
		//TODO return the root of this subtree
		return null;
		
	}
	
	/**
	 * Helper method to calculate appropriate height for a node
	 * Assumes both children have already corrected their heights
	 * @param parent the node we are calculating a height for
	 */
	private void updateHeight(AVLNode parent) {
		//TODO implement this
	}
	
	/**
	 * Single rotate the left child clockwise over the specified node
	 * @param oldP the old Parent node
	 * @return the former child node that is now the parent of this sub-tree
	 */
	private AVLNode rotateCW(AVLNode oldP) {
		//TODO
		return null;
	}
	
	/**
	 * Single rotate the right child counter-clockwise over the specified node
	 * @param oldP the old Parent node
	 * @return the former child node that is now the parent of this sub-tree
	 */
	private AVLNode rotateCCW(AVLNode oldP){
		//TODO
		return null;
	}
	
	/**
	 * Double rotate a left-right grandchild up
	 * @param oldP the former parent node
	 * @return the former grandchild node that is now the parent of this subtree
	 */
	private AVLNode doubleRotateFromLeft(AVLNode oldP){
		//TODO
		return null;
		
	}
	
	/**
	 * Double rotate a right-left grandchild up
	 * @param oldP the former parent node
	 * @return the former grandchild node that is now the parent of this subtree
	 */
	private AVLNode doubleRotateFromRight(AVLNode oldP){
		//TODO
		return null;
	}

	
	//////////////////////////////////////////////////
	// Everything else is the same as a regular old BST
	// (other than the fact that we aren't implementing deletion today)
	//////////////////////////////////////////////////
	
	/**
	 * 
	 * @param data data we're looking for
	 * @return true if that data is in the tree, false if it is not
	 */
	public boolean contains(T data){
		return !(findData(data)==nullSentinel);
	}
	

	/**
	 * Locate the node containing target data
	 * @param target data we're looking for
	 * @return node containing target data, or nullSentinel if not found
	 */
	private AVLNode findData(T target) {
		return findData(target, root);
	}

	/**
	 * Locate the node containing target data
	 * @param target data we're looking for
	 * @param current the root of the sub-tree we're current searching through
	 * @return node containing target data, or nullSentinel if not found
	 */
	private AVLNode findData(T target, AVLNode current) {
		if(current == nullSentinel || current.data.compareTo(target) == 0){
			return current;
		}
		if(current.data.compareTo(target) > 0){
			return findData(target, current.left);
		}
		return findData(target, current.right);
	}

	

	
	
	/**
	 * Public facing interface for recursive pre-order traversal printing
	 * @return a String consisting of all elements concatenated together in order
	 */
	public String printInOrder() {
		return printInOrder(root); //call the private recursive method
	}
	
	/**
	 * Recursively print tree in In-Order traversal order
	 * @param root root of this sub-tree
	 * @return a String consisting of all elements concatenated together in order
	 */
	private String printInOrder(AVLNode root){
		if(root == nullSentinel){
			return "";
		}
		return printInOrder(root.left) + root.data + " " + printInOrder(root.right);
	}
	
	/**
	 * Public facing interface for recursive post-order traversal printing
	 * @return a String consisting of all elements concatenated together in post order
	 */
	public String printPostOrder() {
		return printPostOrder(root); //call the private recursive method
	}
	
	/**
	 * Recursively print tree in Post-Order traversal order
	 * @param root root of this sub-tree
	 * @return a String consisting of all elements concatenated together in post order
	 */
	private String printPostOrder(AVLNode root){
		if(root == nullSentinel){
			return "";
		}
		return printPostOrder(root.left) + printPostOrder(root.right) + root.data + " ";
	}
	
	/**
	 * Public facing interface for recursive pre-order traversal printing
	 * @return a String consisting of all elements concatenated together in pre order
	 */
	public String printPreOrder() {
		return printPreOrder(root); //call the private recursive method
	}
	
	/**
	 * Recursively print tree in Pre-Order traversal order
	 * @param root root of this sub-tree
	 * @return a String consisting of all elements concatenated together in pre order
	 */
	private String printPreOrder(AVLNode root){
		if(root == nullSentinel){
			return "";
		}
		return root.data + " " + printPreOrder(root.left) + printPreOrder(root.right);
	}
	
	/**
	 * A level order traversal of this BST using a Queue
	 * @return a String consisting of all elements concatenated together in level order
	 */
	public String printLevelOrder() {
		Queue<AVLNode> q = new LinkedList<AVLNode>();
		q.add(root);
		String result = "";
		while(!q.isEmpty()) {
			AVLNode cur = q.poll();
			if(cur.left != nullSentinel) q.add(cur.left);
			if(cur.right != nullSentinel) q.add(cur.right);
			result += cur.data + " ";
		}
		return result;
	}
}
