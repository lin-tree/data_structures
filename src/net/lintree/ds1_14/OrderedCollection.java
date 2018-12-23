package net.lintree.ds1_14;

import net.lintree.ds1_13.Collection;

public class OrderedCollection<T extends Comparable<T>> extends Collection<T> {
	
	@SuppressWarnings("unchecked")
	public T findMin() {
		if (isEmpty()) return null;
		T min = (T) data[0];
		for (Object d : data) {
			T t = (T) d;
			if (min.compareTo(t) < 0) {
				min = t;
			}
		}
		return min;
	}
	
	@SuppressWarnings("unchecked")
	public T findMax() {
		if (isEmpty()) return null;
		T max = (T) data[0];
		for (Object d : data) {
			T t = (T) d;
			if (max.compareTo(t) > 0) {
				max = t;
			}
		}
		return max;
	}
}
