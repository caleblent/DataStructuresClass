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
	private int size;


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
				} else
					curr = curr.right;
			}

			else if (temp > 0) {
				if (curr.left == null) {
					curr.left = new BTNode<T>(data, null, null);
					return;
				} else
					curr = curr.left;
			}

			else if (temp == 0)
				throw new IllegalArgumentException("Cannot insert duplicate data.");

			index++;
		}
	}

	public BTNode<T> deleteNode(BTNode<T> nodeToDelete) throws IllegalArgumentException {
		if (nodeToDelete != null) {
			BTNode<T> nodeToReturn = null;
			if (nodeToDelete != null) {
				if (nodeToDelete.left == null) {
					nodeToReturn = transplant(nodeToDelete, nodeToDelete.right);
				} else if (nodeToDelete.right == null) {
					nodeToReturn = transplant(nodeToDelete, nodeToDelete.left);
				} else {
					BTNode<T> successorNode = getMinimum(nodeToDelete.right);
					if (successorNode.parent != nodeToDelete) {
						transplant(successorNode, successorNode.right);
						successorNode.right = nodeToDelete.right;
						successorNode.right.parent = successorNode;
					}
					transplant(nodeToDelete, successorNode);
					successorNode.left = nodeToDelete.left;
					successorNode.left.parent = successorNode;
					nodeToReturn = successorNode;
				}
				size--;
			}

			return nodeToReturn;
		}
		return null;
	}

	/**
     * Put one node from tree (newNode) to the place of another (nodeToReplace).
     * 
     * @param nodeToReplace
     *            Node which is replaced by newNode and removed from tree.
     * @param newNode
     *            New node.
     * 
     * @return New replaced node.
     */
	private BTNode<T> transplant(BTNode<T> nodeToReplace, BTNode<T> newNode) {
		if (nodeToReplace.parent == null) {
            this.root = newNode;
        } else if (nodeToReplace == nodeToReplace.parent.left) {
            nodeToReplace.parent.left = newNode;
        } else {
            nodeToReplace.parent.right = newNode;
        }
        if (newNode != null) {
            newNode.parent = nodeToReplace.parent;
        }
        return newNode;
	}

	/**
	 * Recursively delete data from tree
	 * 
	 * @param take a node and target data to delete
	 * @throws IllegalArgumentException if data null or was not found
	 */
	public BTNode<T> deleteRecDoesntWork(BTNode<T> node, T target) throws IllegalArgumentException {
		if (node == null)
			return null;

		if (target == null)
			throw new IllegalArgumentException("Data in deleteRec() cannot be null.");

		if (node.data.compareTo(target) > 0) {

			node.left = deleteRecDoesntWork(node.left, target);

		} else if (node.data.compareTo(target) < 0) {

			node.right = deleteRecDoesntWork(node.right, target);

		} else if (node.left == null || node.right == null) {

			System.out.println(" Deleting : " + target);
			BTNode<T> temp = null;
			temp = node.left == null ? node.right : node.left;

			if (temp == null)
				return null;
			else
				return node;

		} else {
			BTNode<T> successor = getSuccessor(node);
			node.data = successor.data;
			node.right = deleteRecDoesntWork(node.right, successor.data);
			return node;
		}

		return node;
	}

	/**
     * Removes element if node with such value exists.
     * 
     * @param element
     *            Element value to remove.
     * 
     * @return New node that is in place of deleted node. Or null if element for
     *         delete was not found.
     */
	public BTNode<T> delete(T target) throws IllegalArgumentException {
		
		BTNode<T> deleteNode = search(target);
	        if (deleteNode != null) {
	            return deleteNode(deleteNode);
	        } else {
	            return null;
	        }
	    
	}

	/**
	 * Iteratively delete data from tree
	 * 
	 * @param target data to delete
	 * @throws IllegalArgumentException if data null or was not found
	 */
	public void deleteDoesntWork(T target) throws IllegalArgumentException {
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
//					BTNode<T> successor = getSuccessor(curr);
//					curr.data = successor.data;
//					successor.data = null;
//					deleteRec(successor, null); // WHY THE #$%@ DOES THIS NOT WORK????
//					return;
					BTNode<T> min = getSuccessor(curr);
					curr.data = min.data;
					min = null; // WHY THE #$%@ DOES THIS NOT WORK????
					return;
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
	private BTNode<T> getSuccessor(BTNode<T> subTreeRoot) {
		// if there is a right branch, than it is the leftmost value of that subtree
		if (subTreeRoot.right != null) {
			return getMinimum(subTreeRoot.right);
		}

		// otherwise it is a lowest ancestor whose left child is also ancestor of node
		else {
			BTNode<T> currentNode = subTreeRoot;
			BTNode<T> parentNode = subTreeRoot.parent;
			while (parentNode != null && currentNode == parentNode.right) {
				// go up until we find parent that currentNode is not in right subtree
				currentNode = parentNode;
				parentNode = parentNode.parent;
			}
			return parentNode;
		}
	}

	public String getRoot() {
		return root.toString();
	}
	
	/**
     * Finds a node with concrete value. If it is not found then null is
     * returned.
     * 
     * @param element
     *            Element value.
     * @return Node with value provided, or null if not found.
     */
    public BTNode<T> search(T element) {
    	BTNode<T> node = root;
        while (node != null && node.data != null && !node.data.equals(element)) {
            if (element.compareTo(node.data) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

	private BTNode<T> getMinimum(BTNode<T> node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	private BTNode<T> getMaximum(BTNode<T> node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	/**
	 * Binary Tree Node
	 * 
	 * @author gosnat
	 *
	 * @param <T>
	 */
	private class BTNode<T> {
		public BTNode<T> parent;
		/** The actual stored data item */
		public T data;
		/** Reference to left child */
		public BTNode<T> left;
		/** Reference to right child */
		public BTNode<T> right;

		public BTNode(T data, BTNode<T> left, BTNode<T> right) {
			this.parent = null;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public BTNode(BTNode<T> parent, T data, BTNode<T> left, BTNode<T> right) {
			this.parent = parent;
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