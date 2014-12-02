package treeball;

public class TreeNode {

	private TreeNode left, right;
	private int value;
	
	public TreeNode(int val) {
		this.value = val;
	}
	
	public int value() {
		return value;
	}
	
	public TreeNode left() {
		return left;
	}
	
	public TreeNode right() {
		return right;
	}
	
	public void addLeft(TreeNode t) {
		this.left = t;
	}
	
	public void addRight(TreeNode t) {
		this.right = t;
	}
}
