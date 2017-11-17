package com.file.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;

public class FileDemo {
	public static void main(String[] args) throws IOException {
		// write();
		// read();
		// bufferedRead();
		// bufferedWrite();
		 inputStreamReader();
		// bufferStreamCopy("E:\\main.jar", "E:\\backup\\mai.jar");
//		bufferedStreamCopy(new File("E:\\main.jar"), new File("E:\\backup\\main.jar"));
	}

	// 1. 字符流写
	public static void write() throws IOException {
		// 创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件。
		// 而且该文件会被创建到指定目录下。如果该目录有同名文件，那么该文件将被覆盖。
		FileWriter fw = new FileWriter("E:\\aaa.txt");

		fw.write("hello world!\r\n"); // 调用write的方法将字符串写到流中
		fw.flush(); // 刷新流对象缓冲中的数据，将数据刷到目的地中
		fw.write("first_test"); // 关闭流资源，但是关闭之前会刷新一次内部缓冲中的数据。当我们结束输入时候，必须close();
		fw.close(); // flush和close的区别：flush刷新后可以继续输入，close刷新后不能继续输入。
	}

	// 2. 字符流读
	public static void read() throws IOException {
		FileReader fr = new FileReader("E:\\1.txt");
		int ch = 0;
		while ((ch = fr.read()) != -1) {
			System.out.print((char) ch);
		}
		fr.close();
	}

	// 3. 字符缓冲区读，效率高
	public static void bufferedRead() throws IOException {
		FileReader fr = new FileReader("E:\\1.txt");
		BufferedReader br = new BufferedReader(fr);
		String string = null;
		while ((string = br.readLine()) != null) {
			System.out.println(string);
		}
		br.close();// 关闭输入流对象
		fr.close();
	}

	// 4. 字符缓冲区写，效率高
	public static void bufferedWrite() throws IOException {
		FileWriter fw = new FileWriter("E:\\bbb.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("abc\r\nde");
		bw.newLine(); // 这行代码等价于bfw.write("\r\n"),相当于一个跨平台的换行符

		for (int i = 1; i < 5; i++) {
			bw.write("abc" + i + "\r\n");
			bw.flush();
		}
		bw.flush(); // 刷新缓冲区
		bw.close(); // 关闭缓冲区，但是必须要先刷新
		fw.close(); // 关闭输入流对象
	}

	// 5. 字节流读
	public static void inputStreamReader() throws IOException {
		FileInputStream fis = new FileInputStream("E:\\main.jar");
		InputStreamReader isr = new InputStreamReader(fis);  //将字节流转换成字符流
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = isr.read()) != -1) {
			System.out.println((char) len);
		}
		fis.close();
	}

	// 字节缓冲流从具体路径中 读与写文件（实现复制）
	public static void bufferStreamCopy(String pathA, String pathB) throws IOException {
		FileInputStream fis = new FileInputStream(pathA);
		FileOutputStream fos = new FileOutputStream(pathB);

		BufferedInputStream bis = new BufferedInputStream(fis); // 读字节文件
		BufferedOutputStream bos = new BufferedOutputStream(fos);// 写字节文件

		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = bis.read(buf)) != -1) {
			bos.write(buf, 0, len);
		}
		bis.close();
		bos.close();
		fos.close();
		fis.close();
	}

	// 用字节缓冲流从File读与写（复制一份文件）
	public static void bufferedStreamCopy(File source, File target) throws IOException {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(source));
			bos = new BufferedOutputStream(new FileOutputStream(target));
			byte[] buf = new byte[4096];
			int i;
			while ((i = bis.read(buf)) != -1) {
				bos.write(buf, 0, i); // 字节流写完后不用flush
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bis.close();
			bos.close();
		}
	}

}
