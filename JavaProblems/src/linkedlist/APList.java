package linkedlist;

public class APList {

	private ListNode front;
	
	private int listSize;
	
	private int remIndex;
	
	private ListNode remNode;
	
	public APList() {
		this.front = null;
		this.remIndex = -1;
		this.remNode = null;
		this.listSize = 0;
	}
	
	public Object get(int n) {
		if(n < remIndex) {
			remIndex = 0;
			remNode = front;
		}
		else {
			while(remIndex < n) {
				remIndex++;
				remNode = remNode.next();
			}
		}
		return remNode.value();
	}
	
	public void addFirst(Object obj) {
		ListNode temp = front;
		front = new ListNode(obj);
		front.setNext(temp);
		listSize++;
		remIndex++;
	}
	
	public int size() {
		return listSize;
	}
	
	
	
}
