package aPackage;

import java.util.Iterator;
import java.util.Stack;

/**
 * Simple Binary Tree implementation
 * Missing lots of functionality (which we will add when we get to Binary Search Trees)
 * No sentinel nodes in this version
 * @author N Gossett, modified
 * @version Fall 2022
 * @param <T> Data being stored in nodes
 */
public class BinaryTree<T> {

	private class BTNode<T>
	{
		// attributes of a BTNode:
		public BTNode<T> left;
		public T data;
		public BTNode<T> right;

		// constructor
		public BTNode(T data, BTNode<T>left, BTNode<T> right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		} // BTNode constructor
		
	} // class BTNode

	// the only attribute we need for the Binary Tree class:
	private BTNode<T> root;
	
	// constructor
	public BinaryTree() {
		root = new BTNode<T>(null, null, null);
	}
	
	public BinaryTree(T rootData, BTNode<T> leftTree,
			                       BTNode<T> rightTree)
	{
		this();
		root.left = leftTree;
		root.right = rightTree;
	} // constructor
	
	/*
	 * construct a tree from BTNode parts;
	 * private, since the world doesn't know/see BTNodes
	 */
	private BinaryTree(T rootData, BinaryTree<T> leftTree,
									BinaryTree<T> rightTree)
	{
		this();
		root = new BTNode<T>(rootData, null, null);
		if (leftTree != null) { root.left = leftTree.root; }
		if (rightTree != null) { root.right = rightTree.root;}
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(BTNode<T> root) {
		if (root == null) { return 0; }
		return 1 + size(root.left) + size(root.right);  
	}

	public int height() {
		return height(root);
	}
	
	private int height(BTNode<T> root) {
		if (root == null) { return -1; }
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	public static void main(String[] args) {
		/*
		 *                  A
		 *             B         C
		 *          D     E    F
		 *        G  H   I J     K
		 */


		BinaryTree<String> bt = new 
			BinaryTree<String>("A", 
				new BinaryTree<String>("B",
					new BinaryTree<String>("D", 
						new BinaryTree<String>("G", (BinaryTree)null, null),
						new BinaryTree<String>("H", (BinaryTree)null, null)),
					new BinaryTree<String>("E",
						new BinaryTree<String>("I", (BinaryTree)null, null),
						new BinaryTree<String>("J", (BinaryTree)null, null))
					),
				new BinaryTree<String>("C", 
					new BinaryTree<String>("F", 
						null,
					new BinaryTree<String>("K", (BinaryTree)null, null)),
						null)
				);

		System.out.println("size of tree:" + bt.size());
		System.out.println("height of tree:" + bt.height());
	} // main

} // class BinaryTree