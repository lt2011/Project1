package data.struct;

public class LinkTest {

	public static void main(String[] args) {
		// 构建一个 1-2-3-4 顺序的单链表；
		LinkList linkList = new LinkList(null);
		for (int i = 4; i >= 1; i--) {
			Node node = new Node(i, null);
			linkList.addHead(node);
		}
		
		
		System.out.println("链表的长度为 : " + linkList.count());
		linkList.displayAll(null);
		
		Node node = linkList.reverse(null);
		linkList.displayAll(node);

	}

}
