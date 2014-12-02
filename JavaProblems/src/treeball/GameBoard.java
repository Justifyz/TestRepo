package treeball;

import java.util.ArrayList;

public class GameBoard {

	private TreeNode root;
	
	public GameBoard(int numLevels) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		root = new TreeNode(randomInt());
		for(int i = 0; i < numLevels; i++) {
			if(list.isEmpty()) {
				TreeNode left = new TreeNode(randomInt());
				TreeNode right = new TreeNode(randomInt());
				root.addLeft(left);
				root.addRight(right);
				list.add(left);
				list.add(right);
			}
			else {
				for(TreeNode node : list) {
					TreeNode left = new TreeNode(randomInt());
					TreeNode right = new TreeNode(randomInt());
					node.addLeft(left);
					node.addRight(right);
					list.clear();
					list.add(left);
					list.add(right);
				}
			}
		}

	}
	
	public int maxScore() {
		return getMaxHelper(root);
	}
	
	private int getMaxHelper(TreeNode current) {
		if(current == null) {
			return 0;
		}
		return current.value() + Math.max(getMaxHelper(current.left()), getMaxHelper(current.right()));		
	}
	
	public int randomInt() {
		return (int)(Math.random()*10);
	}
	
}
