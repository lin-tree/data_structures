package net.lintree.chapter2.ds2_16;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rnd = new Random();
		long ns = System.nanoTime();
		test(17057886, 1355893914);
		test(714896567, 1039849552);
		test(47934420418362L, 72890371185498954L);
		test(7096029842150368392L, 4222752507156645553L);
		test(2989382748324438781L, 6948568748723777777L);
		
		for (int i = 0; i < 1_000; i++) {
			long v1 = Math.abs(rnd.nextLong());
			long v2 = Math.abs(rnd.nextLong());
			test(v1, v2);
		}
		
		long stopns = System.nanoTime();
		
		System.out.println("All " + count + " tests cost: " + (stopns - ns) / 1_000_000 + "ms");
	}
	
	static int count = 0;
	
	public static void test(long i, long j) {
		System.out.println("gcd(" + i + ", " + j + ") = " + gcd(i, j));
		count += 1;
	}
	

	private static long gcd(long i, long j) {
		if (i == j) return i;
		long a = i, b = j;
		if (i < j) {
			a = j;
			b = i;
		}

		int value = 1;
		while (a != b && b != 1) {
			long x = a % 2, y = b % 2;
			if (x == 0 && y == 0) {
				value *= 2;
				a /= 2;
				b /= 2;
			} else if (x == 1 && y == 0) {
				b /= 2;
			} else if (x == 0 && y == 1) {
				if (b < a / 2) {
					a /= 2;
				} else {
					long t = b;
					b = a / 2;
					a = t;
				}
			} else {
				long t = a;
				a = (a + b) / 2;
				b = (t - b) / 2;
			}
		}
		return value * b;
	}
}
