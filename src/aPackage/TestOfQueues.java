package aPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Make sure to add the following line to your module-info.java file:
 * requires org.junit.jupiter.params;
 * 
 * Note that the same unit tests should pass for both Array-based and LinkedList-base
 * queues.  They both implement the same interface, so we write our tests to the DSQueue interface
 * @author Nathan Gossett
 *
 */
public class TestOfQueues{
	
	private static Object[] queues;
	
	//you don't need to be an expert in this JUnit code, but the unit tests are important
	@BeforeAll
	static void setUp() {
		queues = new Object[2];
		queues[0] = new ArrayQueue<String>(10);
		queues[1] = new LinkedListQueue<String>();
	}
	
	//you don't need to be an expert in this JUnit code, but the unit tests are important
	//This will run the test method once for our ArrayQueue, and a second time for our LinkedListQueue
	@ParameterizedTest
	@ValueSource(ints = {0, 1})
	public void methodTests(int index){
		DSQueue<String> myQueue = (DSQueue<String>)queues[index];
		myQueue.enqueue("one");
		myQueue.enqueue("two");
		myQueue.enqueue("three");
		myQueue.enqueue("four");
		assertEquals("one", myQueue.getFront());
		assertEquals("one", myQueue.dequeue());
		assertEquals("two", myQueue.dequeue());
		myQueue.enqueue("five");
		assertEquals("three", myQueue.dequeue());
		assertEquals("four", myQueue.dequeue());
		assertEquals("five", myQueue.dequeue());
		assertThrows(RuntimeException.class, ()->{myQueue.getFront();});
		assertThrows(RuntimeException.class, ()->{myQueue.dequeue();});
		myQueue.enqueue("six");
		myQueue.enqueue("seven");
		assertEquals("six", myQueue.getFront());
		assertEquals("six", myQueue.dequeue());
		assertEquals("seven", myQueue.dequeue());
		
	}
	


}