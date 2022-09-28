package aPackage;

/** 
 * A simple LinkedList implementation
 * We will move on to a better version of this soon
 * @author gosnat
 * @version Fall 2020
 *
 * @param <T> the type of data we are storing in this LinkedList
 */
public class LinkedListSimple<T> {
	
	/** The first node in the list */
	private ListNode headPointer;

	/** The number of items in the list */
	private int nodeCount;

	/** 
	 * Don't pay too much attention to this constructor since we're going to
	 * move on to a better version soon.  Just know that it's putting all of the
	 * data items from the items array into a LinkedList in the same order
	 * @param items
	 */
	public LinkedListSimple(T[] items) {
		int size = items.length;
		ListNode temp = null;
		for(int i = size-1; i > 0; i--) {
			temp = new ListNode(items[i], temp);
		}
		headPointer = new ListNode(items[0], temp);
		nodeCount = size;
	}
	
	/**
	 * Helper method to locate the node at a particular index
	 * Can be used to avoid duplicated code in other methods
	 * Note this is private since it is used to support the public methods
	 * @param index the index you want to locate
	 * @return A pointer to the node at requested index
	 * @throws IllegalArgumentException If requested index is out of bounds
	 */
	private ListNode findNodeAtPosition(int index) throws IllegalArgumentException{
		ListNode ptr = headPointer;
		if(index >= nodeCount) {
			throw new IllegalArgumentException("Not valid; largest index is " + (nodeCount-1));
		}
		for(int i = 0; i < index; i++) {
			ptr = ptr.next;
		}
		return ptr;
	}
	
	/**
	 * Note that this is returning pointer the data item (type T), not the ListNode object
	 * @param index index that you want to fetch data from
	 * @return data item located at that index
	 * @throws IllegalArgumentException if requested index is out of bounds
	 */
	public T get(int index) throws IllegalArgumentException{
		return findNodeAtPosition(index).data;
	}
	
	/**
	 * Does this item exist in the list?
	 * @param data The data item you're looking for
	 * @return true if data item is already in the list, false if not
	 */
	public boolean contains(T target) {
		ListNode ptr = headPointer;
		while(ptr != null) {
			if( ptr.data.equals(target)) {
				return true;
			}
			ptr = ptr.next;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String retVal = "";
		ListNode ptr = headPointer;
		
		if (ptr == null) {
			return "Empty";
		}
		
		while( ptr != null) {
			retVal += ptr.data;
			if (ptr.next != null) {
				retVal += " -> ";
			}
			ptr = ptr.next;
		}
		
		return retVal;
	}

	/**
	 * A private class for our ListNodes
	 * Since this class is private, only code in the LinkedList class can reference it
	 * We can safely make the attributes here public because no one else can get to the private class
	 * This allows for simpler code in our LinkedList class as long as we can trust ourselves
	 * not to supply illegal values
	 * Note that since this is a private class, we're still using the same type T as the LinkedList
	 * class that we are inside of, so no need to re-declare that type parameter here.
	 * @author gosnat
	 *
	 */
	private class ListNode {
		/** The data to store in this node */
		T data;
		/** A pointer to the next node in the list */
		ListNode next;

		/**
		 * Constructor
		 * @param data The actual data item to store
		 * @param next A pointer to the node that should go next in the list
		 */
		public ListNode(T input, ListNode nextNode) {
			data = input;
			next = nextNode;
		}

	}
	
}