package net.lintree.chapter1.ds1_15;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Rectangle[] data = new Rectangle[] {
				new Rectangle(3, 3), // 9, 6
				new Rectangle(1, 5), // 5, 6
				new Rectangle(1, 6), // 6, 7
				new Rectangle(2, 2)  // 4, 4
		};
		
		System.out.println(
			findMax(data, (r1, r2) -> r1.getWidth() * r1.getLength() - r2.getWidth() * r2.getLength())
		);
		
		System.out.println(
			findMax(data, (r1, r2) -> r1.getWidth() + r1.getLength() - r2.getWidth() - r2.getLength())
		);

	}
	
	public static Rectangle findMax(Rectangle[] rs, Comparator<Rectangle> cp) {
		if (rs.length == 0) return null;
		Rectangle max = rs[0];
		for (Rectangle r : rs) 
			if (cp.compare(r, max) > 0)
				max = r;
		return max;
	}

}
