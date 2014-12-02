package waiting;

import linkedlist.ListNode;

public class WaitingList {

	private int numNodes;
	private ListNode front;
	
	public int size() {
		return numNodes;
	}
	
	public ListNode getKthNode(int k) {
		ListNode node = front;
		for(int i = 0; i < k; i++) {
			node = node.next();
		}
		return node;
	}
	
	public void setSize(int n) {
		numNodes = n;
	}
	
	public void transferNodesFromEnd(WaitingList other, int num) {
		ListNode start = getKthNode(size()-1);
		ListNode end = other.getKthNode(other.size() - num);
		other.setSize(other.size() - num);
		if(other.size() == 0) {
			other.front = null;
		}
		start.setNext(end);
		setSize(size() + num);
	}
	
}
