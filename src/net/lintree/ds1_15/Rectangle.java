package net.lintree.ds1_15;

public class Rectangle {
	private int length;
	private int width;
	
	public Rectangle(int l, int w) {
		length = l;
		width = w;
	}
	
	public int getLength() {
		return length;
	}
	public int getWidth() {
		return width;
	}

	@Override
	public String toString() {
		return "Rectangle(" + length + ", " + width + ")";
	}
}
