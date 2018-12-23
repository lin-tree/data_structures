package net.lintree.chapter1.ds1_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 1.4 C允许拥有形如<br><code>#include <i>filename</i></code><br>的语句，它将
 * <code><i>filename</i></code>读入并将其插入到<code>include</code>语句处。
 * <code>include</code>语句可以嵌套；换句话说，文件<code>filename</code>本身还可以
 * 包含<code>include</code>语句，但是显然一个文件在任何链接中都不能包含它自己。
 * 编写一个程序，使它读入被一些<code>include</code>语句修饰的文件并输出这个文件。<br>
 * <br> 
 * 
 * 扩展了下，可以判断环形引入（a文件<code>include b</code>;b文件又<code>include a</code>）了，
 * 显然包含自己是环形引入的一种情况。
 * @author Tree
 */
public class Main {
	private static final String WORKING_DIR = "D:\\CodeFiles\\java\\data_structures\\test_data\\1_4\\";
	private static final String INPUT_FINENAME = "test.txt";
	private static final String OUTPUT_FINENAME = "out.txt";

	public static void main(String[] args) {
		Main main = new Main();
		
		System.out.println("Start in folder: " + WORKING_DIR);
		System.out.println("Input file: " + INPUT_FINENAME);
		
		// 读取并处理文件
		List<String> lines = main.readAndProcess(INPUT_FINENAME);
		
		System.out.println("Process Complete.");
		System.out.println("Output file: " + OUTPUT_FINENAME);
		
		// 输出结果到文件
		main.writeLines(lines, OUTPUT_FINENAME);
		
		System.out.println("Output Complete.");
	}

	/**
	 * 文件的处理栈 用来判断环形引入和在出现环形引入时给予更好的提示
	 */
	private Stack<String> includeBases = new Stack<>();

	/**
	 * 读取并处理文件
	 * @param fileName 文件名
	 * @return 处理后的结果
	 */
	private List<String> readAndProcess(String fileName) {
		System.out.println("Processing: " + fileName);
		// 将待处理文件名入栈
		includeBases.push(fileName);

		// 读入待文件
		List<String> lines = readLines(fileName);
		List<String> processedLines = new LinkedList<>();

		// 逐行处理
		for (String line : lines) {

			if (isInclude(line)) {
				// 处理include语句
				
				String includedFileName = getFileNameFromInclude(line);
				System.out.println("Including: " + includedFileName);
				if (includeBases.contains(includedFileName)) {
					// 出现环形引入了
					onCircularInclude(includedFileName);
					continue;
				}
				
				List<String> includedLines = readAndProcess(includedFileName);
				for (String includedLine : includedLines) {
					processedLines.add(includedLine);
				}
				
			} else {
				processedLines.add(line);
			}
		}

		// 将待处理文件名出栈
		includeBases.pop();
		return processedLines;
	}

	/**
	 * 出现环形引入时的动作
	 */
	private void onCircularInclude(String includedFileName) {
		System.err.println("Circular include! [" + toString(includeBases) + includedFileName + "]");
		// 可以直接System.exit(1);
	}

	/**
	 * 判定一行输入是否是<code>include</code>语句
	 */
	private boolean isInclude(String line) {
		// 这里用最简单粗暴的做法
		return line.startsWith("#include ");
	}
	
	/**
	 * 从<code>include</code>语句中提取文件名
	 */
	private String getFileNameFromInclude(String line) {
		// 这里用最简单粗暴的做法
		return line.substring("#include ".length()).trim();
	}

	/**
	 * 更好的展示 依赖栈
	 */
	private String toString(Stack<String> includeBases) {
		StringBuilder sb = new StringBuilder();
		for (String item : includeBases)
			sb.append(item).append("->");
		return sb.toString();
	}

	/**
	 * 按行读取文件
	 * @param fileName 文件名
	 * @return 读取文件中的行
	 */
	private List<String> readLines(String fileName) {
		List<String> result = new LinkedList<>();
		try (FileInputStream is = new FileInputStream(WORKING_DIR + fileName);
		        InputStreamReader ir = new InputStreamReader(is, UTF_8);
		        BufferedReader br = new BufferedReader(ir)) {
			String line;
			while ((line = br.readLine()) != null) {
				result.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 按行写入文件
	 * @param lines 需要写入文件的内容
	 * @param fileName 文件名
	 */
	private void writeLines(Iterable<String> lines, String fileName) {
		try (FileOutputStream os = new FileOutputStream(WORKING_DIR + fileName);
		        OutputStreamWriter ow = new OutputStreamWriter(os, UTF_8);
		        BufferedWriter bw = new BufferedWriter(ow);) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读文件的编码
	 */
	private static final Charset UTF_8 = Charset.forName("utf-8");
}
