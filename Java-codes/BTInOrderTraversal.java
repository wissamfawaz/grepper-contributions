
/*
	This is an implementation that collects the 
	values of the nodes of a binary tree by performing 
	an in-order traversal of the tree.

	Let n be the number of binary tree nodes
	Time complexity: O(n) 
	Space complexity: O(n)
*/
import java.util.List;
import java.util.ArrayList;

public class BTInOrderTraversal {
	private BTNode BTRoot;

	public BTInOrderTraversal() {
		/*
		 * Create tree below:
		 * 1
		 * \
		 * 2
		 * /
		 * 3
		 */
		BTRoot = new BTNode(1, null, null);
		BTNode rootRight = new BTNode(2, null, null);
		BTRoot.right = rootRight;
		BTNode rootRightLeft = new BTNode(3, null, null);
		rootRight.left = rootRightLeft;
	}

	public static void main(String[] args) {
		BTInOrderTraversal application = new BTInOrderTraversal();
		List<Integer> values = application.inorderTraversal();
		System.out.println(values); // [1, 3, 2]
	}

	// Perform in-order traversal through the tree.
	public List<Integer> inorderTraversal() {
		List<Integer> list = new ArrayList<>();
		populateList(BTRoot, list);
		return list;
	}

	// Helper method to populate list by performing
	// in-order traversal through the tree.
	private void populateList(BTNode root, List<Integer> list) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			populateList(root.left, list);
		}
		list.add(root.val);
		if (root.right != null) {
			populateList(root.right, list);
		}
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
