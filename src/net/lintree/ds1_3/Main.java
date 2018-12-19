package net.lintree.ds1_3;

/**
 * 1.3 只使用处理io的<code>printDigit</code>方法，
 * 编写一种方法以输出任意<code>double</code>型量（可以是负的）。
 * @author Tree
 *
 */
public class Main {
	// 负数
	private static final char MINUS = '-';
	// 小数点
	private static final char DOT = '.';
	// 指数字符
	private static final char EXP = 'E';
	// 精度
	private static final double ACC = Double.MIN_NORMAL;

	public static void main(String[] args) {
		print(1.1);
		System.out.println();
		print(10000);
		System.out.println();
		print(1E22);
		System.out.println();
		print(1.323E10);
		System.out.println();
		print(-4.2341E-310);
		System.out.println();
		print(-431.2341);
	}
	
	private static void print(double b) {
		// 首先处理负数的情况： 化为正数的情况处理
		if (b < 0) {
			System.out.print(MINUS);
			print(-b);
		} else {
			print(b, 0);
		}
	}
	
	/**
	 * 打印double数
	 * @param b 小数区
	 * @param i 指数区
	 */
	private static void print(double b, int i) {
		if (b >= 10) {
			print(b / 10, i + 1);
		} else if (b < 1) {
			print(b * 10, i - 1);
		} else {
			// 小数区（有效数字）收敛到 1-10之后
			
			// 打印有效数字
			int c = (int) b;
			// 打印整数部分
			printDigit(c);
			double frt = b - c;
			if (frt >= ACC) {
				System.out.print(DOT);
				// 打印小数部分
				printfrt(frt);
			}

			// 打印指数
			if (i != 0) {
				System.out.print(EXP);
				printInt(i);
			}
		}
	}

	/**
	 * 打印小数部分
	 * @param b 保证 b 属于(0, 1)
	 */
	private static void printfrt(double b) {
		
		if (b >= ACC) {
			double c = b * 10;
			int d = (int) c;
			printDigit(d);
			printfrt(c - d);
		}
	}

	/**
	 * 打印整数（兼容负数）
	 */
	private static void printInt(int i) {
		if (i < 0) {
			System.out.print(MINUS);
			printOut(-i);
		} else {
			printOut(i);
		}
	}
	
	/**
	 * 打印正整数
	 * 教科书第7页照抄
	 */
	private static void printOut(int i) {
		if (i >= 10)
			printOut(i / 10);
		printDigit(i % 10);
	}

	private static void printDigit(int i) {
		System.out.print(i);
	}
}
