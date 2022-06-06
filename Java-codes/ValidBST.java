
/*
	This is an implementation that determines
	if a given binary tree is a binary search 
	tree.
	In a binary search tree, for ever node v:
	- Elements in left subtree rooted at v 
	are less than element stored at v.
	- Elements in right subtree rooted at v
	are greater than or equal to one at v. 

	Let n be the number of nodes in the 
	binary search tree.
	Time complexity: O(n) 
	Space complexity: O(n)
*/

public class ValidBST {
	private BTNode BTRoot;

	public ValidBST() {
		/*
		 * Create tree below:
		 * * 4
		 * / \
		 * 2 7
		 * * / \
		 * * 6 8
		 */
		BTRoot = new BTNode(4, null, null);
		BTNode rootLeft = new BTNode(2, null, null);
		BTRoot.left = rootLeft;
		BTNode rootRight = new BTNode(7, null, null);
		BTRoot.right = rootRight;
		BTNode rootRightLeft = new BTNode(6, null, null);
		BTNode rootRightRight = new BTNode(8, null, null);
		rootRight.left = rootRightLeft;
		rootRight.right = rootRightRight;
	}

	public void setRootVal(int val) {
		BTRoot.val = val;
	}

	public static void main(String[] args) {
		ValidBST application = new ValidBST();
		// The considered Binary Tree is a BST
		System.out.println(application.validateBST()); // true
		// Change root value such that result Binary Tree
		// is no longer a BST.
		application.setRootVal(1);
		System.out.println(application.validateBST()); // false
	}

	public boolean validateBST() {
		return isValidBST(BTRoot, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isValidBST(BTNode root, int min, int max) {
		// Empty trees are valid BSTs
		if (root == null) {
			return true;
		}

		// The current value must be between min and max
		if (root.val < min || root.val >= max) {
			return false;
		}

		// Current value is max for left subtree
		// and min for right subtree.
		return isValidBST(root.left, min, root.val) &&
				isValidBST(root.right, root.val, max);

	}

	// Class representing a binary tree node
	// with pointers to value, left, and right nodes
	private class BTNode {
		int val;
		BTNode left;
		BTNode right;

		public BTNode(int val, BTNode left, BTNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
