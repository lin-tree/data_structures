package net.lintree.ds1_5;

public class Main {

	public static void main(String[] args) {
		int value = 0b10010101001110101001;
		System.out.println("value = " + value + " contains " + count1InBinary(value) + " of 1 in binary");
	}
	
	private static int count1InBinary(int x) {
		if (x == 1) return 1;
		else if (x %2 == 1) return count1InBinary(x / 2) + 1;
		else return count1InBinary(x / 2);
	}

}
