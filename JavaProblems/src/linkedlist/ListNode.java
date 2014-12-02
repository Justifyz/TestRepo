package linkedlist;

public class ListNode {
	private Object value;
	private ListNode next;
	
	public ListNode(Object v) {
		this.value = v;
	}
	
	public Object value() {
		return value;
	}
	
	public ListNode next() {
		return next;
	}
	
	public void setNext(ListNode node) {
		this.next = node;
	}
}
