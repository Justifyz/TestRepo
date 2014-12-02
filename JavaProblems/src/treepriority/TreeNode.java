package treepriority;

public class TreeNode {

	private Item item;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(Item item) {
		this.item = item;
	}
	
	public void setLeft(TreeNode t) {
		left = t;
	}
	
	public void setRight(TreeNode t) {
		right = t;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public TreeNode getRight() {
		return right;
	}

	public Item getValue() {
		return item;
	}
	
}
