package net.lintree.chapter2.ds2_20;

public class Main {

	public static void main(String[] args) {
		System.out.println(isPrime(12325367L));
		System.out.println(isPrime(97L));
	}

	private static boolean isPrime(long num) {
		for (long i = 2, end = (long) Math.sqrt(num); i < end;  i++) {
			if (num % i == 0) {
				System.out.print(i + " ");
				return false;
			}
		}
		return true;
	}
}
