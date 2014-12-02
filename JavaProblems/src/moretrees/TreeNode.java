package moretrees;

public class TreeNode {
	
	private TreeNode left, right, parent;
	private int value;
	
	public TreeNode(int value) {
		this.value = value;
	}
	
	public TreeNode getParent() {
		return parent;
	}
	
	public void setParent(TreeNode p) {
		parent = p;
	}
	
	public TreeNode getLeftChild() {
		return left;
	}
	
	public TreeNode getRightChild() {
		return right;
	}
	
	public int value() {
		return value;
	}
	
	public void setleftChild(int n) {
		left = new TreeNode(n);
	}
	
	public void setRightChild(int n) {
		right = new TreeNode(n);
	}
	
	@Override
	public String toString() {
		return Integer.toString(value);
	}
	
	
	
}
