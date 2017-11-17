package com.tt;

public class Unchecked {
	public static void main(String[] args) {
		try {
			method();
		} catch (Exception e) {
			System.out.println("A");
		} finally {
			System.out.println("B");
		}
	}

	static void method() {
		try {
			wrench();
			System.out.println("C");
		} catch (ArithmeticException e) {
			System.out.println("D");
		} finally {
			System.out.println("E");
		}
		System.out.println("F");
	}

	static void wrench() {
		throw new NullPointerException();
	}

	static byte addOneAndOne() {
		byte a = 1;
		byte b = 1;
		byte c = (byte) (a + b);
		return c;
	}

}
