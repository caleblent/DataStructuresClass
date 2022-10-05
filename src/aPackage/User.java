package aPackage;

public class User {
	
	public static void main(String[] args) {
		
		LinkedListStack<String> stack = new LinkedListStack<String>();
//		System.out.println(stack.top());
		System.out.println(stack.toString());
		System.out.println(stack.isEmpty());
		System.out.println();
		
		stack.push("one");
		System.out.println(stack.top());
		System.out.println(stack.toString());
		System.out.println(stack.isEmpty());
		System.out.println();
		
		stack.push("two");
		System.out.println(stack.top());
		System.out.println(stack.toString());
		System.out.println(stack.isEmpty());
		System.out.println();
		
		stack.push("three");
		System.out.println(stack.top());
		System.out.println(stack.toString());
		System.out.println(stack.isEmpty());
		System.out.println();
		
		stack.push("four");
		System.out.println(stack.top());
		System.out.println(stack.toString());
		System.out.println(stack.isEmpty());
		System.out.println();
		
		
		
		
		
		
	}
	
	
	
	
}
