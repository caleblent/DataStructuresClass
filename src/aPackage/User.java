package aPackage;

public class User {

	public static void main(String[] args) {

		BST<String> tree = new BST<String>();
		tree.insert("A");
		tree.insert("B");
		tree.insert("C");
		tree.insert("D");
		tree.insert("E");

		BST<String> tree2 = new BST<String>();
		tree2.insert("P");
		tree2.insert("I");
		tree2.insert("R");
		tree2.insert("Q");
		tree2.insert("S");
		tree2.insert("E");
		tree2.insert("Y");

//		System.out.println(tree.getRoot());
		System.out.println(tree2.printInOrder());
		System.out.println(tree2.printPreOrder());
		System.out.println(tree2.printPostOrder());
//		System.out.println(tree.getMin());
		System.out.println();
		System.out.println();
		System.out.println();
		tree2.delete("P");

//		System.out.println(tree.getRoot());
		System.out.println(tree2.printInOrder());
		System.out.println(tree2.printPreOrder());
		System.out.println(tree2.printPostOrder());
//		System.out.println(tree.getMin());

//		System.out.println(tree2.getRoot());
//		System.out.println(tree2.printInOrder());
//		System.out.println(tree2.printPreOrder());
//		System.out.println(tree2.printPostOrder());
//		System.out.println(tree2.getMin());
//		Trie trie = new Trie();
//		trie.insert("cat");
//		trie.insert("cats");
//		trie.insert("catnip");
//		trie.insert("catnap");
//		trie.insert("caterpillar");
//		trie.insert("45");

//		System.out.println(trie.search("c"));
//		System.out.println(trie.search("ca"));
//		System.out.println(trie.startsWith("ca"));
//		System.out.println(Math.pow(10, 2));
//		System.out.println(trie.search("cat"));
//		System.out.println(trie.search("cats"));
//		System.out.println(trie.search("catn"));
//		System.out.println();
//		System.out.println(trie.startsWith("catn"));
//		System.out.println(trie.startsWith("catm"));
//		System.out.println();
//		System.out.println(trie.startsWith("cater"));
//		System.out.println(trie.search("cater"));

	}

	public static void testArrayLengtheners() {
		int[] nums = { 1, 2, 3, 4, 5 };

		int[] nums2 = doubleArray(nums);
		int[] nums3 = tripleArray(nums);
		int[] nums4 = quadrupleArray(nums);

		printInt(nums);
		printInt(nums2);
		printInt(nums3);
		printInt(nums4);
	}

	public static void printInt(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}

	public static int[] doubleArray(int[] arr) {
		int[] ret = new int[2 * arr.length];

		for (int i = 0; i < ret.length; i++) {
			ret[i] = arr[i % arr.length];
		}

		return ret;
	}

	public static int[] tripleArray(int[] arr) {
		int[] ret = new int[3 * arr.length];

		for (int i = 0; i < ret.length; i++) {
			ret[i] = arr[i % arr.length];
		}

		return ret;
	}

	public static int[] quadrupleArray(int[] arr) {
		int[] ret = new int[4 * arr.length];

		for (int i = 0; i < ret.length; i++) {
			ret[i] = arr[i % arr.length];
		}

		return ret;
	}

	public static void stackOperations() {
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

	//

}
