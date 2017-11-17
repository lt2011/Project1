package com.tt;

public class RunMain {

	public static void main(String[] args) {
		System.out.println("请输入参数");
		// Scanner scanner = new Scanner(System.in);
		// String string = scanner.next();
		// System.out.println(string);

		String[] a = new String[10];//a[0]~a[9] = null
		int[] b = new int[10];//a[0]~a[9] = 0
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}

		int[] arr = { 2, 4, 6, 8, 9, 14 };
		System.out.println(halfSearch(arr, 5));

	}

	// 二分查找，查找出key所在的下标，二分查找的前提是数据已排序好。
	public static int halfSearch(int[] arr, int key) {
		int min = 0;
		int max = arr.length - 1;
		int mid = (max + min) / 2;

		while (arr[mid] != key) {
			if (key > arr[mid])
				min = mid + 1;
			else if (key < arr[mid])
				max = mid - 1;
			if (min > max)
				return -1;// 找不到key值，返回-1
			mid = (max + min) / 2;
		}
		return mid;

	}

}
