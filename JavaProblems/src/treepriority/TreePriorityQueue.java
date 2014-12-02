package treepriority;

import java.util.NoSuchElementException;

public class TreePriorityQueue implements PriorityQueue {

	private TreeNode root;
	
	public TreePriorityQueue() {
		root = null;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void add(Object obj) {
		root = addHelper( (Comparable<Object>) obj, root);
		
	}

	private TreeNode addHelper(Comparable<Object> obj, TreeNode t) {
		if(t == null) {
			return new TreeNode(new Item(obj));
		}
		Item item = (Item)t.getValue();
		int diff = obj.compareTo(item.getData());
		if(diff == 0) {
			item.incrementCount();
		}
		else if(diff < 0) {
			t.setLeft(addHelper(obj, t.getLeft()));
		}
		else {
			// diff > 0
			t.setRight(addHelper(obj, t.getRight()));
		}
		return t;
	}

	@Override
	public Object removeMin() {
		if(root == null) {
			throw new NoSuchElementException();
		}
		TreeNode t = root;
		while(t.getLeft() != null) {
			t = t.getLeft();
		}
		TreeNode min = t;
		t = null;
		return ((Item)min.getValue()).getData();
	}

	@Override
	public Object peekMin() {
		if(root == null) {
			throw new NoSuchElementException();
		}
		TreeNode t = root;
		while(t.getLeft() != null) {
			t = t.getLeft();
		}
		return ((Item)t.getValue()).getData();
	}

}
