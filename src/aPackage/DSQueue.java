package aPackage;

/**
 * A common interface for all Queue classes regardless of how they are stored
 * @author gosnat
 * @version Fall 2020
 *
 * @param <T>
 */
public interface DSQueue<T> {
	/**
	 * 
	 * @return true if queue is empty, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * 
	 * @param element element to be added to front of queue
	 * @throws RuntimeException if queue is full
	 */
	public void enqueue(T element) throws RuntimeException;
	
	/**
	 * 
	 * @return front element of queue, which is then removed from queue
	 * @throws RuntimeException if queue is empty
	 */	
	public T dequeue() throws RuntimeException;
	
	/**
	 * 
	 * @return front element of queue, which is not removed from queue
	 * @throws RuntimeException if queue is empty
	 */	
	public T getFront()throws RuntimeException;
}