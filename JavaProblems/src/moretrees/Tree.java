package moretrees;




public class Tree {

	private TreeNode root;
	
	public Tree() {
		this.root = null;
	}
	
	public TreeNode minNode(TreeNode t) {
		int value = minNodeHelper(t);
		return getNode(t, value);
	}
	
	private TreeNode getNode(TreeNode t, int value) {
		if(t == null) {
			return null;
		}
		if(t.value() == value) {
			return t;
		}
		TreeNode foundNode = getNode(t.getLeftChild(), value);
		if(foundNode == null) {
			foundNode = getNode(t.getRightChild(), value);
		}
		return foundNode;
	}

	public TreeNode maxNode(TreeNode t) {
		int value = maxNodeHelper(t);
		return getNode(t, value);
	}
	
	public boolean verifyParentLinks() {
		return verifyParentLinksHelper(root, null);
	}
	
	private boolean verifyParentLinksHelper(TreeNode node, TreeNode parent) {
		return (node == null || (node.getParent() == parent &&
				verifyParentLinksHelper(node.getLeftChild(), node) &&
				verifyParentLinksHelper(node.getRightChild(), node)));
	}

	public TreeNode successor(TreeNode t) {
		if(t == null) {
			return null;
		}
		
		TreeNode rightChild = t.getRightChild();
		if(rightChild != null) {
			return minNode(rightChild);
		}
		
		TreeNode parent = t.getParent();
		while(parent != null && parent.getRightChild() == t) {
			t = parent;
			parent = t.getParent();
		}
		return parent;
	}
	
	public int minNodeHelper(TreeNode t) {
		if(t == null) {
			return Integer.MAX_VALUE;
		}
		int left = minNodeHelper(t.getLeftChild());
		int right = minNodeHelper(t.getRightChild());
		return Math.min(left, Math.min(right, t.value()));
	}
	
	public int maxNodeHelper(TreeNode t) {
		if(t == null) {
			return Integer.MIN_VALUE;
		}
		int left = maxNodeHelper(t.getLeftChild());
		int right = maxNodeHelper(t.getRightChild());
		return Math.max(left, Math.max(right, t.value()));
	}
	
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new TreeNode(10);
		tree.root.setleftChild(15);
		tree.root.setRightChild(5);
		tree.root.getLeftChild().setleftChild(2);
		TreeNode minNode = tree.minNode(tree.root);
		TreeNode maxNode = tree.maxNode(tree.root);
		int minValue = minNode.value();
		int maxValue = maxNode.value();
		System.out.println("Max: " + maxValue + ", Min: " + minValue);	
	}
	
	
}
