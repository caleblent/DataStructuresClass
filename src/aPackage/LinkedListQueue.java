package aPackage;

public class LinkedListQueue<T> extends LinkedListSimple<T> implements DSQueue<T> {
	
	private ListNode penultimate; // the "real tail", which points to the last element (which points to the tail node)
	
	public LinkedListQueue() {
		super(null);
		head = new ListNode(null, null);
		head = new ListNode(null, tail);
		penultimate = head;
	}
	
	public boolean isEmpty() {
		return tail == head.next;
	}
	
	public void enqueue(T element) {
		if (isEmpty()) {
			ListNode temp = new ListNode(element, tail);
			penultimate.next = temp;
			penultimate = temp;
			nodeCount++;
		}
	}

	public T dequeue() throws RuntimeException {
		if (isEmpty()) {
			throw new RuntimeException("Queue underflow");
		}
		T temp = head.next.data;
		
		if(head.next == penultimate) {
			penultimate = head;
		}
		head.next = head.next.next;
		return temp;
	}

	public T getFront() throws RuntimeException {
		if (isEmpty()) {
			throw new RuntimeException("Queue underflow");
		}
		return head.next.data;
	}

}
