package com.test;

public class LinkList {
	// 头结点，即代表了整个链表的逻辑关系
	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public LinkList(Node head) {
		super();
		this.head = head;
	}

	/* * 上述即构造好了链表，下面开始写本单链表自带的一些基本方法 */

	// 在头节点前插入一个节点
	public void addHead(Node node) {
		node.setNextNode(head);
		head = node;
	}

	// 删除头节点，并返回此删除的头节点
	public Node deleteHead() {
		Node p = head; // 先把头节点取下来
		head = p.getNextNode(); // 上述头节点的下一个节点成为新的头节点
		return p;
	}

	// 单链表反转，头插式倒置法，返回新的头节点
	public Node reverse(Node node) {
		Node p = null; // 作为遍历指针，从头开始；
		if (node == null) { // 当不传头节点的时候，即本类中的head即为此链表的头节点，满足健壮性；
			p = head;
		} else {
			p = node;
		}

		Node q = null; // 作为p的缓存；
		Node head = null; // 作为整个链表的头
		while (p != null) {
			q = p; // 先缓存
			p = p.getNextNode(); // 指针后移；
			q.setNextNode(head); // 每次在head前插入一个q，此q来自于上次缓存的p
			head = q; // q将成为新链表的新头；
		}
		return head; // 返回新head，即返回了整个链表的逻辑关系；
	}

	// 统计整个链表的节点数
	public int count() {
		int count = 0;
		Node temp = head; // 将头节点缓存起来，以便下面遍历完后，要继续恢复原样，head节点不能变。
		while (head.getNextNode() != null) {
			count++;
			head = head.getNextNode();
		}
		head = temp; // 遍历完成后，把原先缓存起来头节点恢复，保证链表的不变；
		return count + 1;
	}

	// 打印链表的所有信息
	public void displayAll(Node node) {
		Node p = null; // 将头节点缓存起来，以便下面遍历完后，要继续恢复原样，head节点不能变。
		Node temp = null;
		if (node == null) { // 增加健壮性，若不传具体头节点参数，则默认用此类的head作为头
			p = head;
			temp = head;
		} else {
			p = node;
			temp = node;
		}

		while (p.getNextNode() != null) {
			System.out.print(p.getObject() + "\t");
			p = p.getNextNode();
		}
		System.out.print(p.getObject() + "\t"); // 因循环到最后一个节点时，上述while条件中会不成立，所以最后一个节点会漏打。
		head = temp;
	}

	// 查找倒数第K个节点的内容:倒数第K个，即顺数第N-K+1个，N为链表总长度
	public Object findTailK(int k) {
		int n = count(); // 获取链表总长度n
		Node p = head;
		for (int i = 1; i < n - k + 1; i++) {
			p = p.getNextNode();// 一直遍历到最后一个节点
		}
		return p.getObject();

	}

}
