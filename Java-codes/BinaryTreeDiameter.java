
/*
	This implementation demonstrates how 
	to efficiently find the diameter of a
	binary tree. Note that the diameter
	of a binary tree is defined as the 
	length of its longest path.

	Let n be the number of nodes and h be 
	the height of the binary tree.

	Time complexity: O(n) 
	Space complexity: O(h)
*/

public class BinaryTreeDiameter {
	BTNode BTRoot;

	public BinaryTreeDiameter() {
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
		BinaryTreeDiameter application = new BinaryTreeDiameter();
		System.out.println(application.binaryTreeDiameter(application.BTRoot)); // 3
	}

	public int binaryTreeDiameter(BTNode root) {
		int[] diameter = new int[1];

		findDiameter(root, diameter);

		return diameter[0];
	}

	private int findDiameter(BTNode node, int[] diameter) {
		if (node == null) {
			return 0;
		}

		int leftHeight = findDiameter(node.left, diameter);
		int rightHeight = findDiameter(node.right, diameter);

		diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

		return 1 + Math.max(leftHeight, rightHeight);
	}

	// Class representing a binary tree node
	// with pointers to value, left, right, and parent nodes
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
