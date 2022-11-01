package aPackage;

/**
 * A Binary Search Tree Implementation No sentinel nodes used
 * 
 * This implementation doesn't allow duplicate values, but removing that
 * restriction doesn't fundamentally alter the implementation strategies shown
 * here
 * 
 * Alternate implementation can be found in Gray book using recursion and parent
 * links
 * 
 * Some inspiration drawn from implementations by Mark Allen Weiss and Simon
 * Gray.
 * 
 * @author Nathan Gossett
 * @version Spring 2021
 *
 * @param <T>
 */

public class BST<T extends Comparable<T>> { // TODO: we need T to be Comparable

	/** the root of the tree */
	private BTNode<T> root;

	/** construct empty tree */
	public BST() {
		root = null;
	}

//	public BST(T data) {
//		root = new BTNode<T>(data, null, null);
//	}
//
//	public BST(T data, BTNode<T> left, BTNode<T> right) {
//		root = new BTNode<T>(data, left, right);
//	}

	/**
	 * Recursive implementation of find method
	 * 
	 * @param target what data are you looking for?
	 * @return the node containing target data
	 */
	private BTNode<T> findData(T target) {
		BTNode<T> curr = root;
		while (curr != null) {
			int temp = curr.data.compareTo(target);
			if (temp < 0)
				curr = curr.left;
			else if (temp > 0)
				curr = curr.right;
			else if (temp == 0)
				return curr;
		}
		return null;
	}

	/**
	 * Iterative implementation of find method
	 * 
	 * @param data what data are you looking for?
	 * @return the node containing data
	 */
	/*
	 * private BTNode<T> findData(T data) { //TODO return null; }
	 */

	/**
	 * 
	 * @param target data we're looking for
	 * @return true if that target data is in the tree, false if it is not
	 */
	public boolean contains(T target) {
		if (findData(target) != null)
			return true;
		return false;
	}

	/**
	 * Recursively add new node to BST
	 * 
	 * @param node new data to add
	 * @throws IllegalArgumentException if data is a duplicate
	 */
	public BTNode<T> insert(BTNode<T> node) throws IllegalArgumentException {
		if (root == null) {
			root = node;
			return root;
		}
		
		int temp = root.data.compareTo(node.data);

		if (temp < 0) {
			return insert(root.right);
		}

		else if (temp > 0) {
			return insert(root.left);
		}

		else if (temp == 0)
			throw new IllegalArgumentException("Cannot insert duplicate data.");
		
		return null;
		
	}
	
	/**
	 * Iteratively add new node to BST
	 * 
	 * @param data new data to add
	 * @throws IllegalArgumentException if data is a duplicate
	 */
	public void insert(T data) throws IllegalArgumentException {
		if (root == null) {
			root = new BTNode<T>(data, null, null);
			return;
		}

		BTNode<T> curr = root;
		int index = 0;
		
		while (index < 50) {
			int temp = curr.data.compareTo(data);

			if (temp < 0) {
				if (curr.right == null) {
					curr.right = new BTNode<T>(data, null, null);
					return;
				}
				else 
					curr = curr.right;
			}

			else if (temp > 0) {
				if (curr.left == null) {
					curr.left = new BTNode<T>(data, null, null);
					return;
				}
				else 
					curr = curr.left;
			}

			else if (temp == 0)
				throw new IllegalArgumentException("Cannot insert duplicate data.");
			
			index++;
		}
	}

	/**
	 * Iteratively delete data from tree
	 * 
	 * @param target data to delete
	 * @throws IllegalArgumentException if data null or was not found
	 */
	public void delete(T target) throws IllegalArgumentException {
		if (target == null) {
			throw new IllegalArgumentException("Data to delete cannot be null.");
		}

		BTNode<T> curr = root;
		
		while (curr != null) {
			int temp = curr.data.compareTo(target);
//			System.out.println(curr.data + " - " + target + " = " + temp);

			if (temp < 0) {
				if (curr.right != null)
					curr = curr.right;
				else 
					throw new IllegalArgumentException("Data was not found.");
			}

			else if (temp > 0) {
				if (curr.left != null)
					curr = curr.left;
				else
					throw new IllegalArgumentException("Data was not found.");
			}

			else if (temp == 0) {
				// 1. curr is a leaf node (no children)
				if (curr.left == null && curr.right == null) {
					System.out.println("NULL NULL NULL");
					curr = null;
					return;
				}
				
				// 2. curr has a left node
				else if (curr.right == null) {
					curr.right = curr.left.right;
					curr.data = curr.left.data;
					curr.left = curr.left.left;
					System.out.println(curr.left + " " + curr.data + " " + curr.right);
					return;
				}
				
				// 3. curr has a right node
				else if (curr.left == null) {
					curr.left = curr.right.left;
					curr.data = curr.right.data;
					curr.right = curr.right.right;
					System.out.println(curr.left + " " + curr.data + " " + curr.right);
					return;
				}
				
				// 4. curr has both a left and right child node
				else {
					curr.data = findMin(curr).data;
					BTNode<T> min = findMin(curr);
					min = null; // WHY THE #$%@ DOES THIS NOT WORK????
					OBJ_DESTROY(min);
					return;
//					BTNode<T> min = findMin(curr);
//					curr.data = min.data;
//					min = null; // WHY THE #$%@ DOES THIS NOT WORK????
//					return;
				}
			}
		}
	}

	/**
	 * A helper method to aid in deletion
	 * 
	 * @param subTreeRoot We're looking for the smallest value in the subtree rooted
	 *                    at this node
	 * @return a reference to the node holding the smallest value in this subtree
	 */
	private BTNode<T> findMin(BTNode<T> subTreeRoot) {
		if (subTreeRoot.right != null) {
			BTNode<T> curr = subTreeRoot.right;
			
			while (curr.left != null) {;
				curr = curr.left;
			}
			return curr;
		} else if (subTreeRoot.left != null) {
			System.out.println("the left subtree is not null but the right probably is");
			BTNode<T> curr = subTreeRoot.left;
			
			while (curr.right != null) {
				System.out.println("curr:" + curr.toString());
				curr = curr.right;
			}
			return curr;
		}
		return null;
		
//		if (subTreeRoot.right != null) {
//			return findLeftMostNode(subTreeRoot.right);
//		} else if (subTreeRoot.left != null) {
//			return findRightMostNode(subTreeRoot.left);
//		} else {
//			return subTreeRoot;
//		}
	}
	
	public String getMin() {
		return findMin(root).toString();
	}
	
	public String getRoot() {
		return root.toString();
	}

	private BTNode<T> findLeftMostNode(BTNode<T> node) {
		// if there is no left subtree of the node, than it is the leftmost node
		if (node.left == null)
			return node;

		// cycle through the left child nodes until a null is reached,
		// in which case the leftmost node has been found
		BTNode<T> curr = node;
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}

	private BTNode<T> findRightMostNode(BTNode<T> node) {
		// if there is no right subtree of the node, than it is the rightmost node
		if (node.right == null)
			return node;

		// cycle through the right child nodes until a null is reached,
		// in which case the rightmost node has been found
		BTNode<T> curr = node;
		while (curr.right != null) {
			curr = curr.right;
		}
		return curr;
	}

	/**
	 * Binary Tree Node
	 * 
	 * @author gosnat
	 *
	 * @param <T>
	 */
	private class BTNode<T> {
		/** The actual stored data item */
		public T data;
		/** Reference to left child */
		public BTNode<T> left;
		/** Reference to right child */
		public BTNode<T> right;

		public BTNode(T data, BTNode<T> left, BTNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public String toString() {
//			return ":::data:" + this.data + ":::  ";
//			return this.left + "<-" + this.data.toString() + "->" + this.right + " ||| ";
			return this.data.toString();
		}
		
		public void nullify() {
//			this = null;
		}

	}

	/**
	 * Public facing interface for recursive pre-order traversal printing
	 */
	public String printInOrder() {
		return printInOrder(root); // call the private recursive method
	}

	/**
	 * Recursively print tree in In-Order traversal order
	 * 
	 * @param root root of this sub-tree
	 */
	private String printInOrder(BTNode<T> root) {
		if (root == null) {
			return "";
		}
		return printInOrder(root.left) + root.data.toString() + " " + printInOrder(root.right);
	}

	/**
	 * Public facing interface for recursive post-order traversal printing
	 */
	public String printPostOrder() {
		return printPostOrder(root); // call the private recursive method
	}

	/**
	 * Recursively print tree in Post-Order traversal order
	 * 
	 * @param root root of this sub-tree
	 */
	private String printPostOrder(BTNode<T> root) {
		if (root == null) {
			return "";
		}
		return printPostOrder(root.left) + printPostOrder(root.right) + root.data + " ";
	}

	/**
	 * Public facing interface for recursive pre-order traversal printing
	 */
	public String printPreOrder() {
		return printPreOrder(root); // call the private recursive method
	}

	/**
	 * Recursively print tree in Pre-Order traversal order
	 * 
	 * @param root root of this sub-tree
	 */
	private String printPreOrder(BTNode<T> root) {
		if (root == null) {
			return "";
		}
		return root.data + " " + printPreOrder(root.left) + printPreOrder(root.right);
	}
	
	public String printRoot() {
		return this.root.toString();
	}
}