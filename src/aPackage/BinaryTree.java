package aPackage;

import java.util.Iterator;

public class BinaryTree<T> implements Iterable<T> {
	
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
					new BinaryTree<String>("G", null, null),
					new BinaryTree<String>("H", null, null)),
				new BinaryTree<String>("E",
						new BinaryTree<String>("I", null, null),
						new BinaryTree<String>("J", null, null))
				),
			new BinaryTree<String>("C", 
				new BinaryTree<String>("F", 
							null,
							new BinaryTree<String>("K", null, null)),
				null)
			);
		
		
		for(String s : bt) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		System.out.println(bt.printInOrder());
	}
	
	private String printInOrder() {
		// TODO Auto-generated method stub
		return "";
	}

	private class BTNode<T> {
		public BTNode left;
		public T data;
		public BTNode right;
		
		public BTNode(T data, BTNode<T> left, BTNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	private BTNode<T> root;
	
	public BinaryTree() {
		root = new BTNode<T>(null, null, null);
	}
	
	public BinaryTree(T rootData, 
			BinaryTree<T> leftTree, 
			BinaryTree<T> rightTree) {
		this();
		root = new BTNode<T>(rootData, null, null);
		if (leftTree != null) {
			root.left = leftTree.root;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		}
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(BTNode<T> root) {
		if (root == null) {
			return 0;
		}
		return 1 + size(root.left) + size(root.right);
	}
	
	public int height() {
		return height(root);
	}
	
	private int height(BTNode<T> root) {
		if (root == null) {
			return -1;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
