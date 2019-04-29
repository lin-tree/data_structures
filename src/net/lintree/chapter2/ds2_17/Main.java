package net.lintree.chapter2.ds2_17;

import static net.lintree.chapter2.util.TestUtil.getRandomDoubles;
import static net.lintree.chapter2.util.TestUtil.getRandomInts;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println("最小子序列和：");
		for (int i=0; i<10; i++) {
			int[] seq = getRandomInts(10);
			int result = minSubSeqSum(seq);
			System.out.println(toString(seq) + " => " + result);
		}
		
		System.out.println("最小正子序列和：");
		for (int i=0; i<10; i++) {
			int[] seq = getRandomInts(10);
			int result = minPositiveSubSeqSum(seq);
			System.out.println(toString(seq) + " => " + result);
		}

		System.out.println("最大子序列积：");
		for (int i=0; i<10; i++) {
			double[] seq = getRandomDoubles(10);
			double result = maxSubSeqProd(seq);
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
	 * 最小正子序列和 O(NlogN)<br>
	 * 所有的子序列可以用所有包含首个元素的子序列想减得到<br>
	 * 先算出先序和，然后带上下标一起排序，然后求最小的相邻元素差（要求前下标比后下标小）
	 */
	private static int minPositiveSubSeqSum(int[] seq) {
		int len = seq.length, sum = 0;
		Data[] prefixSum = new Data [len + 1];
		for (int i = 0; i < len; i++) {
			sum += seq[i];
			prefixSum[i] = new Data(i, sum);
		}
		prefixSum[len] = new Data(-1, 0);
		Arrays.sort(prefixSum, (v1, v2) -> {
			int val = v1.value - v2.value;
			if (val == 0) {
				v1.index = v2.index = Math.min(v1.index, v2.index);
			}
			return val;
		});
		
		int minPositiveSubSeqSum = 0;
		for (int i = 0; i < len; i++) {
			Data last = prefixSum[i];
			Data that = prefixSum[i + 1];
			if (that.index > last.index) {
				int val = that.value - last.value;
				minPositiveSubSeqSum = minPositiveSubSeqSum == 0 
					? val 
					: Math.min(val, minPositiveSubSeqSum);
			}
		}
		
		return minPositiveSubSeqSum;
	}
	static class Data {
		public int index;
		public int value;
		Data(int index, int value) {
			this.index = index;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Data(index=" + index + ", value=" + value + ")";
		}
	}

	/**
	 * 最大子序列积 O(N)<br>
	 * 考虑存在负数的情况<br>
	 * <code>max[i]</code> 以 <code>i</code> 结尾的最大子序列积 <code>max[0] = seq[0]</code><br>
	 * <code>min[i]</code> 以 <code>i</code> 结尾的最小子序列积 <code>min[0] = seq[0]</code><br>
	 * <code>max[i] = max(seq[i], min[i-1] * seq[i], max[i-1] * seq[i])</code><br>
	 * <code>min[i] = min(seq[i], min[i-1] * seq[i], max[i-1] * seq[i])</code><br>
	 * 遍历一趟算完
	 */
	private static double maxSubSeqProd(double[] seq) {
		int len = seq.length;
		double max_i_1, min_i_1;
		double result = max_i_1 = min_i_1 = seq[0];
		
		for (int i = 1; i < len; i++) {
			double val = seq[i];
			double max_i = max(val, max_i_1 * val, min_i_1 * val);
			double min_i = min(val, max_i_1 * val, min_i_1 * val);
			result = Math.max(result, max_i);
			max_i_1 = max_i;
			min_i_1 = min_i;
		}

		return result;
	}
	private static double max(double a, double b, double c) {
		return a > b ? (c > a ? c : a) : (c > b ? c : b);
	}
	private static double min(double a, double b, double c) {
		return a < b ? (c < a ? c : a) : (c < b ? c : b);
	}
	
	private static String toString(int[] seq) {
		return Arrays.toString(seq);
	}
	
	private static String toString(double[] seq) {
		return Arrays.toString(seq);
	}
}
