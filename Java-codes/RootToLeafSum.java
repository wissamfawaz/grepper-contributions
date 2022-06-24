
/*
	This is an implementation that demonstrates
	how to check whether a root-to-leaf sum 
	in a binary tree matches some target sum value.

	Let n be the number of binary tree nodes

	Time complexity: O(n) 
	Space complexity: O(n)
*/

public class RootToLeafSum {
	private BTNode BTRoot;

	public RootToLeafSum() {
		/*
		 * Create tree below:
		 * * 1
		 * / \
		 * 2 3
		 * * / \
		 * * 4 5
		 */
		BTRoot = new BTNode(1, null, null);
		BTNode rootLeft = new BTNode(2, null, null);
		BTRoot.left = rootLeft;
		BTNode rootRight = new BTNode(3, null, null);
		BTRoot.right = rootRight;
		BTNode rootRightLeft = new BTNode(4, null, null);
		BTNode rootRightRight = new BTNode(5, null, null);
		rootRight.left = rootRightLeft;
		rootRight.right = rootRightRight;
	}

	public static void main(String[] args) {
		RootToLeafSum application = new RootToLeafSum();
		System.out.println(
				application.hasRootToLeafSum(9)); // true
		System.out.println(
				application.hasRootToLeafSum(7)); // false
	}

	private boolean hasRootToLeafSum(int sum) {
		return hasPathSum(BTRoot, sum);
	}

	private boolean hasPathSum(BTNode root, int sum) {
		// Traverse the tree while constantly update sum
		if (root == null) {
			return false;
		}
		// Deduct current node's value from sum
		sum -= root.val;
		// Sum should only reach zero if a leaf node is reached
		if (root.left == null && root.right == null) {
			return sum == 0;
		}
		// Otherwise continue traversing the tree
		return hasPathSum(root.left, sum) ||
				hasPathSum(root.right, sum);
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
