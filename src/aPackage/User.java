package aPackage;

public class User {
	
	public static void main(String[] args) {
		
		Integer[] nums = {};
		LinkedList<Integer> list = new LinkedList<Integer>(nums);
		
		System.out.println(list.toString() + "::: " + list.getNodeCount());
		System.out.println(list.contains(42));
		list.insert(42, 0);
		System.out.println(list.toString() + "::: " + list.getNodeCount());
		System.out.println(list.contains(42));
//		list.insert(1, 1);
//		list.insert(2, 2);
//		list.insert(3, 1);
//		list.insert(4, 0);
		System.out.println(list.get(0));
		System.out.println(list.contains(42));
		
//		LL.insert(50, -1);
//		LL.insert(2, 0);
//		System.out.println(LL.toString());
//		
//		LL.insert(6, 4);
//		System.out.println(LL.toString());
//		
//		LL.delete(5);
//		System.out.println(LL.toString());
//		
//		LL.deleteIndex(5);
//		System.out.println(LL.toString());
	}
	
	
	
	
}
