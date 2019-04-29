package net.lintree.chapter2.util;

import java.util.Random;

public class TestUtil {
	private static Random rnd = new Random();
	
	public static int[] getRandomInts(int n) {
		int[] result = new int[n];
		
		for (int i=0; i<n; i++)
			result[i] = rnd.nextInt(20) - 10;
		return result;
	}
	
	public static double[] getRandomDoubles(int n) {
		double[] result = new double[n];
		
		for (int i=0; i<n; i++)
			result[i] = (rnd.nextInt(50) - 20) / 10.0;
		return result;
	}
	
	public static double max(double ... seq) {
		double result = seq[0];
		for (double d : seq) {
			if (d > result) {
				result = d;
			}
		}
		return result;
	}
	
	public static double min(double ... seq) {
		double result = seq[0];
		for (double d : seq) {
			if (d < result) {
				result = d;
			}
		}
		return result;
	}
}
