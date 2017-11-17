package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsolePrintX {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("请输入行数：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		System.out.println("总元素个数为:" + genList(x) +" "+ "内容如下");

		int temp = 0;
		for (int i = 1; i <= x; i++) {
			System.out.println();
			int[] b = new int[i];
			for (int j = 0; j < i; j++) { // 给每行的数组赋值
				b[j] = temp + 1 + j;
				System.out.print(b[j] + "\t");
			}
			temp = b[b.length - 1];

		}
	}

	// 递归找到输入n时，要打印的总元素个数 f(n)=f(n-1)+n
	public static int genList(int n) {
		int len = 0;
		if (n > 1) {
			int[] a = new int[genList(n - 1)];
			len = a.length;
		}
		return len + n;
	}
}
