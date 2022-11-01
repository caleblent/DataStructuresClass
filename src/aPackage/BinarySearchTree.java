package aPackage;

/**
 * (NON)Abstract binary search tree implementation. Its basically fully implemented
 * binary search tree, just template method is provided for creating Node (other
 * trees can have slightly different nodes with more info). This way some code
 * from standart binary search tree can be reused for other kinds of binary
 * trees.
 * 
 * @author Ignas Lelys
 * @author Caleb Lent (modified it to BTNode<T> and etc specification)
 * @created Jun 29, 2011
 * 
 * Original Github repo: https://github.com/ignl/BinarySearchTrees/blob/master/Trees/src/main/java/org/intelligentjava/algos/trees/AbstractBinarySearchTree.java
 * New Github repo: https://github.com/caleblent/DataStructuresClass/blob/master/src/aPackage/BinarySearchTree.java
 */
public class BinarySearchTree<T extends Comparable<T>> {

    /** Root node where whole tree starts. */
    public BTNode<T> root;

    /** Tree size. */
    private int size;
    
    private class BTNode<T> {
		/** The actual stored data item */
		public T data;
		/** Reference to parent node */
		public BTNode<T> parent;
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
		
		public BTNode(T data, BTNode<T> parent, BTNode<T> left, BTNode<T> right) {
			this.parent = parent;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((data == null) ? 0 : data.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            BTNode<T> other = (BTNode<T>) obj;
            if (this.data == null) {
                if (other.data != null)
                    return false;
            } else if (!data.equals(other.data))
                return false;
            return true;
        }

		@Override
		public String toString() {
			return this.data.toString();
		}

	}

    /**
     * Because this is abstract class and various trees have different additional information on 
     * different nodes subclasses uses this abstract method to create nodes (maybe of class {@link Node}
     * or maybe some different node sub class).
     * 
     * @param value Value that node will have.
     * @param parent Node's parent.
     * @param left Node's left child.
     * @param right Node's right child.
     * @return Created node instance.
     */
//    protected BTNode<T> createNode(T data, BTNode<T> parent, BTNode<T> left, BTNode<T> right);

    /**
     * Finds a node with concrete value. If it is not found then null is
     * returned.
     * 
     * @param element
     *            Element value.
     * @return BTNode<T> with value provided, or null if not found.
     */
    public BTNode<T> search(T target) {
    	BTNode<T> node = root;
        while (node != null && node.data != null && !node.data.equals(target)) {
            if (target.compareTo(node.data) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    /**
     * Insert new element to tree.
     * 
     * @param data to insert
     * 
     * @throws IllegalArgumentException if data is a duplicate
     */
    public BTNode<T> insert(T data) throws IllegalArgumentException {
        if (root == null) {
            root = new BTNode<T>(data, null, null, null);
            size++;
            return root;
        }

        BTNode<T> insertParentNode = null;
        BTNode<T> searchTempNode = root;
        while (searchTempNode != null && searchTempNode.data != null) {
            insertParentNode = searchTempNode;
            if (data.compareTo(searchTempNode.data) < 0) {
                searchTempNode = searchTempNode.left;
            } else if (data.compareTo(searchTempNode.data) > 0){
                searchTempNode = searchTempNode.right;
            } else {//(data.compareTo(searchTempNode.data) == 0)
            	throw new IllegalArgumentException("Data to insert cannot be a duplicate.");
            }
        }

        BTNode<T> newNode = new BTNode<T>(data, insertParentNode, null, null);
        if (insertParentNode.data.compareTo(newNode.data) > 0) {
            insertParentNode.left = newNode;
        } else {
            insertParentNode.right = newNode;
        }

        size++;
        return newNode;
    }

    /**
     * Removes element if node with such value exists.
     * 
     * @param element
     *            Element value to remove.
     * 
     * @return New node that is in place of deleted node. Or null if element for
     *         delete was not found.
     *         
     * @throws IllegalArgumentException if data null or was not found
     */
    public BTNode<T> delete(T element) throws IllegalArgumentException {
    	BTNode<T> deleteNode = search(element);
        if (deleteNode != null) {
            return delete(deleteNode);
        } else {
            throw new IllegalArgumentException("Data was not found.");
        }
    }

    /**
     * Delete logic when node is already found.
     * 
     * @param deleteNode
     *            Node that needs to be deleted.
     * 
     * @return New node that is in place of deleted node. Or null if element for
     *         delete was not found.
     * 
     */
    protected BTNode<T> delete(BTNode<T> deleteNode) {
        if (deleteNode != null) {
        	BTNode<T> nodeToReturn = null;
            if (deleteNode != null) {
                if (deleteNode.left == null) {
                    nodeToReturn = transplant(deleteNode, deleteNode.right);
                } else if (deleteNode.right == null) {
                    nodeToReturn = transplant(deleteNode, deleteNode.left);
                } else {
                	BTNode<T> successorNode = getMinimum(deleteNode.right);
                    if (successorNode.parent != deleteNode) {
                        transplant(successorNode, successorNode.right);
                        successorNode.right = deleteNode.right;
                        successorNode.right.parent = successorNode;
                    }
                    transplant(deleteNode, successorNode);
                    successorNode.left = deleteNode.left;
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
     * @param target
     * @return true if tree contains target.
     */
    public boolean contains(T target) {
        return search(target) != null;
    }

    /**
     * @return Minimum element in tree.
     */
    public T getMinimum() {
        return getMinimum(root).data;
    }

    /**
     * @return Maximum element in tree.
     */
    public T getMaximum() {
        return getMaximum(root).data;
    }

    /**
     * Get next element who is bigger than provided target.
     * 
     * @param element
     *            Element for whom descendand element is searched
     * @return Successor value.
     */
    // TODO Predecessor
    public T getSuccessor(T target) {
        return getSuccessor(search(target)).data;
    }

    /**
     * @return Number of elements in the tree.
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Tree traversal with printing element values. In order method.
     */
    public void printTreeInOrder() {
        printTreeInOrder(root);
    }

    /**
     * Tree traversal with printing element values. Pre order method.
     */
    public void printTreePreOrder() {
        printTreePreOrder(root);
    }

    /**
     * Tree traversal with printing element values. Post order method.
     */
    public void printTreePostOrder() {
        printTreePostOrder(root);
    }

    /*-------------------PRIVATE HELPER METHODS-------------------*/

    private void printTreeInOrder(BTNode<T> entry) {
        if (entry != null) {
            printTreeInOrder(entry.left);
            if (entry.data != null) {
                System.out.print(entry.data + " ");
            }
            printTreeInOrder(entry.right);
        }
    }

    private void printTreePreOrder(BTNode<T> entry) {
        if (entry != null) {
            if (entry.data != null) {
                System.out.print(entry.data + " ");
            }
            printTreeInOrder(entry.left);
            printTreeInOrder(entry.right);
        }
    }

    private void printTreePostOrder(BTNode<T> entry) {
        if (entry != null) {
            printTreeInOrder(entry.left);
            printTreeInOrder(entry.right);
            if (entry.data != null) {
                System.out.print(entry.data + " ");
            }
        }
    }

    protected BTNode<T> getMinimum(BTNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    protected BTNode<T> getMaximum(BTNode<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    protected BTNode<T> getSuccessor(BTNode<T> node) {
        // if there is right branch, then successor is leftmost node of that
        // subtree
        if (node.right != null) {
            return getMinimum(node.right);
        } else { // otherwise it is a lowest ancestor whose left child is also
            // ancestor of node
        	BTNode<T> currentNode = node;
        	BTNode<T> parentNode = node.parent;
            while (parentNode != null && currentNode == parentNode.right) {
                // go up until we find parent that currentNode is not in right
                // subtree.
                currentNode = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode;
        }
    }
    
    //-------------------------------- TREE PRINTING ------------------------------------

    public void printTree() {
        printSubtree(root);
    }
    
    public void printSubtree(BTNode<T> node) {
        if (node.right != null) {
            printTree(node.right, true, "");
        }
        printNodeValue(node);
        if (node.left != null) {
            printTree(node.left, false, "");
        }
    }
    
    private void printNodeValue(BTNode<T> node) {
        if (node.data == null) {
            System.out.print("<null>");
        } else {
            System.out.print(node.data.toString());
        }
        System.out.println();
    }
    
    private void printTree(BTNode<T> node, boolean isRight, String indent) {
        if (node.right != null) {
            printTree(node.right, true, indent + (isRight ? "        " : " |      "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" /");
        } else {
            System.out.print(" \\");
        }
        System.out.print("----- ");
        printNodeValue(node);
        if (node.left != null) {
            printTree(node.left, false, indent + (isRight ? " |      " : "        "));
        }
    }

    
    /*---------------TREE PRINTING METHODS FROM ORIGINAL SPECIFICATION-------------------*/
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
}