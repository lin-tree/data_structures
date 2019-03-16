package net.lintree.chapter2.ds2_17;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.println("最小子序列和：");
		for (int i=0;i<10;i++) {
			int[] seq = getRandomInts(10);
			int result = minSubSeqSum(seq);
			System.out.println(toString(seq) + " => " + result);
		}
		
		System.out.println("最小正子序列和：");
		for (int i=0;i<10;i++) {
			int[] seq = getRandomInts(10);
			int result = minPositiveSubSeqSum(seq);
			System.out.println(toString(seq) + " => " + result);
		}

	}
	
	/**
	 * 最小子序列和
	 * O(n)
	 */
	private static int minSubSeqSum(int[] seq) {
		int min = 0, now = 0;
		for (int v : seq) {
			if (v < 0) now += v;
			else now = 0;
			if (now < min) min = now;
		}
		return min;
	}
	
	/**
	 * 最小正子序列和
	 */
	private static int minPositiveSubSeqSum(int[] seq) {
		int min = 0, now = 0;
		for (int v : seq) {
			
		}
		return min;
	}

	/**
	 * 最大子序列积
	 */
	private static double maxSubSeqProd(double[] seq) {
		
		return 0;
	}
	
	private static Random rnd = new Random();
	
	private static int[] getRandomInts(int n) {
		int[] result = new int[n];
		
		for (int i=0; i<n; i++)
			result[i] = rnd.nextInt(20) - 10;
		return result;
	}
	
	private static String toString(int[] seq) {
		return Arrays.toString(seq);
	}
}
