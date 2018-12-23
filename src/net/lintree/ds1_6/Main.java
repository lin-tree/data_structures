package net.lintree.ds1_6;

public class Main {

	public static void main(String[] args) {	
		Main m = new Main();
		m.permute("abcde");
	}
	
	public void permute(String str) {
		char[] chars = str.toCharArray();
		permute(chars, 0, chars.length);
	}
	
	/**
	 * 数组全排列：将数组0号元素分别和0..length-1号元素交换，然后对去掉0号元素的子数组继续此流程
	 */
	private void permute(char[] str, int low, int high) {
		if (low + 1 == high) { //到头了
			println(str);
			return;
		}

		for (int i=low; i<high; i++) {
			swap(str, low, i); // 交换
			permute(str, low + 1, high);
			swap(str, low, i);// 注意要交换回来
		}
	}

	/**
	 * 交换数组中的元素
	 * @param str 数组
	 * @param idx1 下标1
	 * @param idx2 下标2
	 */
	private void swap(char[] str, int idx1, int idx2) {
		char tmp = str[idx1];
		str[idx1] = str[idx2];
		str[idx2] = tmp;
	}

	private void println(char[] chs) {
		System.out.println(new String(chs));
	}

}
