package net.lintree.chapter2.ds2_23;

public class Main {

	public static void main(String[] args) {
		System.out.println(pow(2.0, 34));
	}

	/**
	 * @param b 底数
	 * @param n 幂
	 */
	public static double pow(double b, int n) {
		if (n == 0) return 1;
		int x = n;
		double b0 = b;
		double r = 1;

		while (x > 1) {
			if (x % 2 == 1) {
				r *= b0;
			}
			b0 *= b0;
			x /= 2;
			
			System.out.println("x = " + x + "; b0 = " + b0 + "; r = " + r);
		}
		return b0 * r;
	}
}
