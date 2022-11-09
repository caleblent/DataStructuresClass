package aPackage;

/**
 * Example implementation of a binary MaxHeap
 * 
 * @author gosnat
 *
 * @param <T>
 */
public class BinaryMaxHeap<T extends Comparable<? super T>> {
	/** The actual heap storage */
	private T[] heap;

	/** Number of items in the heap, doubles as index of next open spot in array */
	private int size;

	/**
	 * Constructor
	 * 
	 * @param capacity max number of items this heap can hold
	 */
	public BinaryMaxHeap(int capacity) {
		heap = (T[]) (new Comparable[capacity]);
		size = 0;
	}

	/**
	 * Constructor Note this uses the supplied array as our heap storage, not a copy
	 * 
	 * @param array Turn this array into a minHeap
	 */
	public BinaryMaxHeap(T[] array) {
		buildHeap(array);
	}

	/**
	 * 
	 * @return true if there are no items in the heap, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 
	 * @return the maximum item in this heap
	 * @throws IllegalStateException if the heap is empty
	 */
	public T findMax() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException("Empty heap has no max");
		}
		return heap[0];
	}

	/**
	 * Insert the specified item into the heap and percolate as needed
	 * 
	 * @param item the new element to place in the heap
	 */
	public void insert(T item) {
		int parent;
		int index = size;
		size++;
		parent = (index - 1) / 2; // integer division
		
		heap[index] = item;
		
		// now percolate upwards if needed
		// while not at root AND heap[index] item > heap[parent] item
		while (index != 0 && heap[index].compareTo(heap[parent]) > 0) {
			T temp = heap[index];
			heap[index] = heap[parent];
			heap[parent] = temp; // could also use 'item' instead
			index = parent;
			parent = (index - 1) / 2;
		}
	}

	/**
	 * remove the maximum item in the heap
	 * 
	 * @return the former maximum item in the heap
	 * @throws IllegalStateException if the heap is empty
	 */
	public T deleteMax() throws IllegalStateException {
		if (isEmpty()) {
			throw new IllegalStateException("Empty heap has no max");
		}
		
		T max = heap[0];
		size--;
		heap[0] = heap[size];
		percDown(0);
		
		return max;
	}

	/**
	 * Percolate the item at the specified index as far as appropriate
	 * 
	 * @param curIndex index of item that needs to be percolated down
	 */
	private void percDown(int curIndex) {
		int swapIndex;
		int leftChild; // index of i's left child
		int rightChild; // index of i's right 

		while (true) {
			leftChild = curIndex*2 + 1;
			rightChild = leftChild + 1;
			if (leftChild >= size) { // out of range (a.k.a. no children)
				break;
			}
			swapIndex = curIndex;
			// there is a left child or we would have stopped already
			if(heap[leftChild].compareTo(heap[curIndex]) > 0) {
				swapIndex = leftChild;
			}
			
			if (rightChild < size) { // is there a right child?
				if (heap[rightChild].compareTo(heap[swapIndex]) > 0) {
					swapIndex = rightChild;
				}
			}
			
			if (swapIndex == curIndex) break;
			
			T temp = heap[curIndex];
			heap[curIndex] = heap[swapIndex];
			heap[swapIndex] = temp;
		}
	}


	/**
	 * Turn an unsorted array into a maxHeap. Note that incoming array becomes this
	 * heap, so no copy/clone is produced. We alter the original.
	 * 
	 * @param array the array of values we want to turn into a heap
	 */
	public void buildHeap(T[] array) {
		//TODO implement
	}

	/**
	 * Perform in-place heapsort algorithm
	 * 
	 * @param array the array you wish to sort
	 */
	public static <Type extends Comparable<? super Type>> void heapSort(Type[] array) {
		//TODO implement
	}

}