
/*
	This is an implementation that collects the 
	values of the nodes of a binary tree by performing 
	an iterative depth first search through the tree.

	Let n be the number of binary tree nodes
	Time complexity: O(n) 
	Space complexity: O(n)
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearchIter {
	private BTNode BTRoot;

	public DepthFirstSearchIter() {
		/*
		 * Create tree below:
		 * 1
		 * \
		 * 2
		 * / \
		 * 3 4
		 */
		BTRoot = new BTNode(1, null, null);
		BTNode rootRight = new BTNode(2, null, null);
		BTRoot.right = rootRight;
		BTNode rootRightLeft = new BTNode(3, null, null);
		BTNode rootRightRight = new BTNode(4, null, null);
		rootRight.left = rootRightLeft;
		rootRight.right = rootRightRight;
	}

	public static void main(String[] args) {
		DepthFirstSearchIter application = new DepthFirstSearchIter();
		List<Integer> values = application.dfsTraversalIter();
		System.out.println(values); // [1, 2, 3, 4]
	}

	// Perform depth first traversal through the tree.
	public List<Integer> dfsTraversalIter() {
		List<Integer> list = new ArrayList<>();
		populateList(BTRoot, list);
		return list;
	}

	// Helper method to populate list by performing
	// iterative depth first search through the tree.
	private void populateList(BTNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		Stack<BTNode> stack = new Stack<>();
		BTNode current;
		stack.push(root);

		while (!stack.isEmpty()) {
			current = stack.pop();
			list.add(current.val);

			if (current.right != null) {
				stack.push(current.right);
			}

			if (current.left != null) {
				stack.push(current.left);
			}
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
