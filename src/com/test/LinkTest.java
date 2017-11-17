package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkTest {

	public static void main(String[] args) throws Exception {

		LinkList linkList1 = new LinkList(null);
		LinkList linkList2 = new LinkList(null);
		// 构建一个 1-2-3-4 顺序的单链表；
		for (int i = 4; i >= 1; i--) {
			Node node = new Node(i, null);
			linkList1.addHead(node);
		}
		// 构建一个 5-6-7-8 顺序的单链表；
		for (int i = 8; i >= 5; i--) {
			Node node = new Node(i, null);
			linkList2.addHead(node);
		}
		System.out.println("问题一：构造的两个单链表如下");
		System.out.println("链表1内容为：");
		linkList1.displayAll(null);
		System.out.println();
		System.out.println("链表2内容为：");
		linkList2.displayAll(null);
		System.out.println();
		System.out.println("--------------------------------------------");

		// 第二问
		System.out.println("问题二：查找链表1倒数第K个节点的内容:");
		System.out.println("请输入K值：K的范围是 1~4 ");
		int k = getInput();
		while (k > 4 || k < 1) {
			System.out.println("输入超出范围，请重新输入:");
			k = getInput();
		}
		Object object = linkList1.findTailK(k);
		System.out.println("链表1的倒数第" + k + "个节点是" + object);
		System.out.println("--------------------------------------------");

		// 第三问
		System.out.println("问题三：合并两个链表后的内容为:");
		merge(linkList1, linkList2).displayAll(null);
		System.out.println();
		System.out.println("--------------------------------------------");
		
		
		
		//第四问
		System.out.println("问题四：合并后的链表进行反转后为:");
		linkList1.displayAll(linkList1.reverse(null));

	}

	// 从键盘输入
	public static int getInput() throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		return k;
	}

	public static LinkList merge(LinkList list1, LinkList list2) {
		Node p = list1.getHead();
		while (p.getNextNode() != null) {
			p = p.getNextNode();
		}
		p.setNextNode(list2.getHead());// 第一个链表的尾指向第二个链表的头
		return list1;
	}
}
