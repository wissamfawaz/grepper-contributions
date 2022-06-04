
/*
	This is an implementation that searches for
	a target value within a binary search tree.
	In a binary search tree, for ever node v:
	- Elements in left subtree rooted at v 
	are less than element stored at v.
	- Elements in right subtree rooted at v
	are greater than or equal to one at v. 

	Let h be the height of the binary search
	tree.
	Time complexity: O(h) 
	Space complexity: O(1)
*/

public class BSTSearch {
	private BTNode BTRoot;

	public BSTSearch() {
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

	public static void main(String[] args) {
		BSTSearch application = new BSTSearch();
		System.out.println(application.findTarget(8)); // true
		System.out.println(application.findTarget(3)); // false
	}

	// Find target in binary search tree
	public boolean findTarget(int target) {
		return searchBST(BTRoot, target);
	}

	private boolean searchBST(BTNode root, int target) {
		BTNode currentNode = root;

		while (currentNode != null) {
			if (currentNode.val == target) {
				break;
			} else if (currentNode.val > target) {
				// Continue the search in left subtree
				currentNode = currentNode.left;
			} else {
				// Continue the search in right subtree
				currentNode = currentNode.right;
			}
		}

		return (currentNode != null);
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
