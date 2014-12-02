package tree;



public class GrowingTree {

	private TreeNode root;
	
	public GrowingTree(TreeNode tn) {
		this.root = tn;
	}
	
	public void expandNode(TreeNode t) {
		TreeNode left = new TreeNode(t.value());
		TreeNode right = new TreeNode(t.value());
		TreeNode oldLeft = t.getLeftChild();
		TreeNode oldRight = t.getRightChild();
		t.addLeft(left);
		t.addRight(right);
		left.addLeft(oldLeft);
		right.addRight(oldRight);
	}
	
	public void growTree(int val) {
		growTreeHelper(root, val);
	}
	
	public void growTreeHelper(TreeNode current, int val) {
		boolean expanded = false;
		if(current == null) return;
		
		if(current.value() == val) {
			expandNode(current);
			expanded = true;
		}
		
		if(expanded) {
			growTreeHelper(current.getLeftChild().getLeftChild(), val);
			growTreeHelper(current.getRightChild().getRightChild(), val);
		}
		else {
			growTreeHelper(current.getLeftChild(), val);
			growTreeHelper(current.getRightChild(), val);
		}
		
	}
	
	public static void main(String[] args) {
		int x = 5;
		int y = 7;
		int w = 9;
		TreeNode t = new TreeNode(x);
		BTreePrinter btp = new BTreePrinter();
		t.addLeft(new TreeNode(x));
		t.addRight(new TreeNode(y));
		t.getLeftChild().addRight(new TreeNode(w));
		GrowingTree gt = new GrowingTree(t);
		btp.printNode(gt.root);
		gt.growTree(x);
		System.out.println();
		btp.printNode(gt.root);
	}
	
}
