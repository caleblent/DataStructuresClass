package aPackage;


/**
 * Example implementation of a queue using a circular array
 * @author Nathan Gossett
 * @version AY22F21
 * @param <T>
 */
public class ArrayQueue <T> implements DSQueue<T>{

	/** Backing array for the queue */
	private T[] queue;
	
	/** How many elements are currently in the queue? */
	private int size;
	
	/** Index of head of queue */
	private int head;
	
	/** Index after tail of queue (where next element should go) */
	private int tail;
	
	/**
	 * 
	 * @param capacity how large should the array be?
	 * @throws IllegalArgumentException capacity must be positive
	 */
	public ArrayQueue(int capacity) throws IllegalArgumentException{
		size = 0;
		head = tail = 0; //this will allow for a single case in enqueue
		if(capacity < 1){
			throw new IllegalArgumentException("Capacity must be positive");
		}
		queue = (T[])(new Object[capacity]);
	}
	
	/**
	 * 
	 * @return true if queue is empty, false otherwise
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * Not officially part of the interface, but could be handy
	 * @return true if queue is out of free space, false otherwise
	 */
	public boolean isFull(){
		return size == queue.length;
	}
	
	/**
	 * comparisons: 1 (isFull)
	 * assignments: 3 (including size++)
	 * allocations: 0
	 * returns: 1
	 * @param element element to be added to tail of queue
	 * @throws RuntimeException if queue is already full
	 */
	public void enqueue(T element) throws RuntimeException{
		if(isFull()){
			throw new RuntimeException("Queue Overflow");
		}
		queue[tail]=element;
		tail = (tail + 1) % queue.length;
		size++;
	}
	
	/**
	 * comparisons: 1 (isEmpty)
	 * assignments: 3
	 * allocations: 0
	 * returns: 2
	 * @return front element of queue, which is then removed from queue
	 * @throws RuntimeException if queue is empty
	 */
	public T dequeue() throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("Queue Underflow");
		}
		T temp = queue[head];
		head = (head + 1) % queue.length;
		size--;
		return temp;
	}
	
	/**
	 * comparisons: 1 (isEmpty)
	 * assignments: 0
	 * allocations: 0
	 * returns: 2
	 * @return front element of queue, which is not removed from queue
	 * @throws RuntimeException if queue is empty
	 */
	public T getFront()throws RuntimeException{
		if(isEmpty()){
			throw new RuntimeException("Queue Underflow");
		}
		return queue[head];
	}
}