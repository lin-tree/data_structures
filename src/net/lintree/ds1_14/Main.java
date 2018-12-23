package net.lintree.ds1_14;

public class Main {

	public static void main(String[] args) {
		OrderedCollection<String> coll = new OrderedCollection<>();
		System.out.println("max=" + coll.findMax());
		System.out.println("min=" + coll.findMin());
		
		coll.insert("test2");
		coll.insert("test4");
		coll.insert("test1");
		coll.insert("test3");
		
		System.out.println("max=" + coll.findMax());
		System.out.println("min=" + coll.findMin());
	}

}
