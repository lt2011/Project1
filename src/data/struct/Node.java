package data.struct;

public class Node {
	private Object object;	//结点中存放的数据；
	private Node nextNode;	//指向的下一个结点；

	public Node(Object object, Node nextNode) {
		super();
		this.object = object;
		this.nextNode = nextNode;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

}
