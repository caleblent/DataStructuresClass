package aPackage;

import java.util.Scanner;


/**
 * A basic Expressions tree class
 * @author Nathan Gossett
 * @author Carl Albing
 * @author Caleb Lent
 * @version Fall 2020
 *
 */

public class ExpressionTree{
	
	/**
	 * Basic Binary Tree Node class. 
	 * @author Nathan Gossett
	 *
	 * @param <T>
	 */
	private class BTNode<T>{
		public T data;
		public BTNode<T> left;
		public BTNode<T> right;
		
		public BTNode(T data, BTNode<T> left, BTNode<T> right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
	
	/** Root of tree.  If tree is not empty, will be equal to null */
	private BTNode<String> root;
	
	
	/**
	 * Construct a tree from the given expression
	 * @param expression: infix expression with parentheses around all sub expressions and spaces between all tokens
	 * @throws RuntimeException For malformed infix expressions
	 */
	public ExpressionTree(String expression) throws RuntimeException{
		Scanner in = new Scanner(expression);
		root = buildTree(in);
		if(in.hasNext()){
			throw new RuntimeException("Symbols encountered after end of expression: " + in.next());
		}
		
	}
	
	/**
	 * Build left and right sub-trees recursively, operator in parent node
	 * @param in A scanner that has been advanced to the appropriate point in the expression
	 * @return The root node of the current (sub) tree
	 * @throws RuntimeException for illegal expressions
	 */
	private BTNode<String> buildTree(Scanner in) throws RuntimeException{
		BTNode<String> root = new BTNode<String>(null, null, null);

		if (in.hasNextDouble()) {
			root.data = in.next();
		} else if (openParen(in)) {
			root.left = buildTree(in); // NOTE: recursive call
			if(!in.hasNext()) {
				throw new RuntimeException("Missing closing paren");
			}
			root.data = in.next();
			root.right = buildTree(in);
			if (!closeParen(in)) {
				throw new RuntimeException("Closing paren not found");
			}
		} else {
			throw new RuntimeException("Missing closing paren");
		}
		
		
		return root;
	}
	
	/**
	 * Detect and consume (if present) a closing parenthesis from the input expression
	 * @param in A scanner that has been parsed to the appropriate point in the exception
	 * @return true if the closing paren was detected and consumed, false otherwise
	 */
	private boolean closeParen(Scanner in) {
		boolean result = false;
		if (in.hasNext("\\)")) {
			in.next(); // swallow the close paren
			result = true;
		}
		return result;
	}
	
	/**
	 * Detect and consume (if present) an opening parenthesis from the input expression
	 * @param in A scanner that has been parsed to the appropriate point in the exception
	 * @return true if the opening paren was detected and consumed, false otherwise
	 */
	private boolean openParen(Scanner in) {
		boolean result = false;
		if (in.hasNext("\\(")) {
			in.next(); // swallow the close paren
			result = true;
		}
		return result;
	}
	
	/**
	 * Check to see if symbol contains +, -, *, or /
	 * @param symbol 
	 * @return true if symbol is one of the four allowed operators, false otherwise
	 */
	private boolean isValidOperator(String symbol){
		boolean result = false;
		
		if (symbol.equals("+") ||
			symbol.equals("-") ||
			symbol.equals("/") ||
			symbol.equals("*"))
			result = true;
		
		return result;
	}
	


	public static void main(String[] args){
		ExpressionTree et = new ExpressionTree("( ( 2 + ( 4 * 6 ) ) - ( 8 / 2 ) ) ");
//		System.out.println(et + "= " + et.evaluateTree());
		System.out.println(et.printInFix(et.root));
	}

	
	/** 
	 * HOMEWORK
	 * Infix = in-order traversal
	 * @return String representation of tree
	 */
	public String printInFix(BTNode<String> node) {
		if (node.left == null) {
			return node.data;
		}
		return printInFix(node.left) + " " + node.data + " " + printInFix(node.right);
	}
	
	/** 
	 * HOMEWORK
	 * @return PostFix representation of tree
	 */
	public String printPostFix(BTNode<String> node) {
		if (node.left == null) {
			return node.data + " ";
		}
		return printPostFix(node.left) + printPostFix(node.right)+ node.data + " ";
	}
	
	
	/**
	 * HOMEWORK
	 * @return value that this tree evaluates to
	 */
	public double evaluateTree(){
		//TODO
		return 0;
	}
	

	/**
	 * HOMEWORK
	 * @param operator 
	 * @param left left operand
	 * @param right right operand
	 * @return result of applying operator to left and right operands
	 * @throws RuntimeException for anything other than +, -, *, /
	 */
	private double applyOperator(String operator, double left, double right)
			throws RuntimeException {
		//TODO
		return 0;
	}
}