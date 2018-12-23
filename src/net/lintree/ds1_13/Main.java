package net.lintree.ds1_13;

public class Main {

	public static void main(String[] args) {
		Collection<String> coll = new Collection<>();
		
		System.out.println("isEmpty = " + coll.isEmpty());
		System.out.println("coll = " + coll);
		coll.insert("test1");
		coll.insert("test2");
		coll.insert("test3");
		coll.insert("test4");
		
		System.out.println("coll = " + coll);
		
		System.out.println("isPresent test2 = " + coll.isPresent("test2"));
		coll.remove("test3");
		System.out.println("coll = " + coll);
		coll.insert("test3");
		coll.remove("test1");
		System.out.println("coll = " + coll);
		coll.makeEmpty();
		System.out.println("isEmpty = " + coll.isEmpty());
		System.out.println("coll = " + coll);
	}

}
