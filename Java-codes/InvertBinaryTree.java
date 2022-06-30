
/*
	This is an implementation that demonstrates
	how to efficiently invert a binary tree. 
	When inverting a binary tree, every left node 
	is swapped with its corresponding right node.

	Let n be the number of nodes of the tree and 
	h be its height.

	Time complexity: O(n) 
	Space complexity: O(h)
*/

public class InvertBinaryTree {
	private BTNode BTRoot;

	public InvertBinaryTree() {
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
		InvertBinaryTree application = new InvertBinaryTree();
		application.invertBT();
		System.out.println(application.BTRoot.val); // 1
		System.out.println(application.BTRoot.left.val); // 3
		System.out.println(application.BTRoot.right.val); // 2
		System.out.println(application.BTRoot.left.left.val); // 5
		System.out.println(application.BTRoot.left.right.val); // 4
	}

	private void invertBT() {
		invertBTUtil(BTRoot);
	}

	private void invertBTUtil(BTNode tree) {
		if (tree == null)
			return;
		// Swap current left and right
		swapLeftAndRight(tree);
		// Recursively invert left subtree
		invertBTUtil(tree.left);
		// Recursively invert right subtree
		invertBTUtil(tree.right);
	}

	private void swapLeftAndRight(BTNode tree) {
		BTNode temp = tree.left;
		tree.left = tree.right;
		tree.right = temp;
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
