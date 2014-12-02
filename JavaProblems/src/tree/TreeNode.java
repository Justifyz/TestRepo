package tree;

public class TreeNode {

	private TreeNode leftChild;
	private TreeNode rightChild;
	private int value;
	public TreeNode(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public void addLeft(TreeNode t) {
		this.leftChild = t;
	}
	
	public void addRight(TreeNode t) {
		this.rightChild = t;
	}
	
	public TreeNode getLeftChild() {
		return leftChild;
	}
	
	public TreeNode getRightChild() {
		return rightChild;
	}
	
	public int value() {
		return value;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value());
	}
	
	public TreeNode[] getChildren() {
		TreeNode[] children = new TreeNode[2];
		children[0] = getLeftChild();
		children[1] = getRightChild();
		return children;
	}
}
