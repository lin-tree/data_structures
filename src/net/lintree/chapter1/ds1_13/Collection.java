package net.lintree.chapter1.ds1_13;

import java.util.Arrays;
import java.util.Objects;

public class Collection<T> {

	protected Object[] data;
	protected int size;

	public Collection() {
		data = new Object[0];
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public void makeEmpty() {
		size = 0;
		data = new Object[0];
	}
	
	public void insert(T val) {
		int newSize = size + 1;
		data = Arrays.copyOf(data, newSize);
		data[size] = val;
		size = newSize;
	}
	
	public void remove(T val) {
		int idx = indexOf(val);
		if (idx < 0) return;
		
		int newSize = size - 1;
		Object[] newData = new Object[newSize];
		for (int i=0; i<idx; i++)
			newData[i] = data[i];

		for (int i=idx + 1; i<size; i++) 
			newData[i - 1] = data[i];
		
		data = newData;
		size = newSize;
	}

	public boolean isPresent(T val) {
		return indexOf(val) >= 0;
	}
	
	protected int indexOf(T val) {
		for (int i=0; i<size; i++) 
			if (Objects.equals(data[i], val)) 
				return i;
		return -1;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(data);
	}
}
