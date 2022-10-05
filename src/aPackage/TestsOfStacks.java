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
public class TestsOfStacks{
	
	private static Object[] stacks;
	
	
	@BeforeAll
	static void setUp() {
		stacks = new Object[2];
		stacks[0] = new LinkedListStack<String>();
		stacks[1] = new LinkedListStack<String>();
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0, 1})
	public void methodTests(int index){
		DSStack<String> myStack = (DSStack<String>)stacks[index];
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		myStack.push("four");
		assertEquals("four", myStack.top());
		assertEquals("four", myStack.pop());
		assertEquals("three", myStack.pop());
		myStack.push("five");
		assertEquals("five", myStack.pop());
		assertEquals("two", myStack.pop());
		assertEquals("one", myStack.pop());
		assertThrows(RuntimeException.class, ()->{myStack.top();});
		assertThrows(RuntimeException.class, ()->{myStack.pop();});
		myStack.push("six");
		myStack.push("seven");
		assertEquals("seven", myStack.top());
		assertEquals("seven", myStack.pop());
		assertEquals("six", myStack.pop());
		
	}
	


}