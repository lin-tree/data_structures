package net.lintree.chapter2.ds2_19;

import static net.lintree.chapter2.util.TestUtil.getRandomInts;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			int[] seq = getRandomInts(10);
			System.out.println(Arrays.toString(seq) + " => " + maxSubSum(seq));
		}
	}
	
	static class Data {
		int result;
		int from;
		int to;
		public Data(int result, int from, int to) {
			super();
			this.result = result;
			this.from = from;
			this.to = to;
		}
		@Override
		public String toString() {
			return "Data [result=" + result + ", from=" + from + ", to=" + to + "]";
		}
	}
	
	private static Data maxSubSum(int[] seq) {
		int max = 0, from = 0, nowFrom = 0, to = 0, value = 0;
		for (int i = 0, l = seq.length; i < l; i++) {
			value += seq[i];
			if (value > max) {
				max = value;
				to = i;
				from = nowFrom;
			} else if (value < 0) {
				value = 0;
				nowFrom = i + 1;
			}
		}
		return new Data(max, from, to);
	} 

}
