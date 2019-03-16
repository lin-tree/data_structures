package net.lintree.chapter2.ds2_15;

public class Main {

	public static void main(String[] args) {
		System.out.println(contains(new int[]{1,3,5,7,9}, 1));
		System.out.println(contains(new int[]{2,4,6,8,10}, 2));
		System.out.println(contains(new int[]{1,3,5,7,9}, 3));
		System.out.println(contains(new int[]{2,4,6,8,10}, 7));
		System.out.println(contains(new int[]{1,2,3,4,5}, 11));
		System.out.println(contains(new int[]{2}, 2));
		System.out.println(contains(new int[]{0}, 2));
	}
	
	private static boolean contains(int[] arr, int value) {
		int start = 0, end = arr.length;
		while (start < end) {
			int mid = (start + end) / 2;
			int v = arr[mid];
			if (v == value) {
				return true;
			} else if (v > value) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

}
