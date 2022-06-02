
/*
	This is an implementation that collects the 
	values of the nodes of a binary tree by performing 
	a breadth first search through the tree.
	Let n be the number of binary tree nodes
	Time complexity: O(n) 
	Space complexity: O(n)
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class BreadthFirstSearch {
	private BTNode BTRoot;

	public BreadthFirstSearch() {
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
		BreadthFirstSearch application = new BreadthFirstSearch();
		List<Integer> values = application.bfsTraversal();
		System.out.println(values); // [1, 2, 3, 4, 5]
	}

	// Perform breadth first traversal through the tree.
	public List<Integer> bfsTraversal() {
		List<Integer> list = new ArrayList<>();
		populateList(BTRoot, list);
		return list;
	}

	// Helper method to populate list by performing
	// breadth first search through the tree.
	private void populateList(BTNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		Deque<BTNode> queue = new ArrayDeque<>();
		BTNode current;
		queue.add(root);

		while (!queue.isEmpty()) {
			current = queue.removeFirst();
			list.add(current.val);

			if (current.left != null) {
				queue.add(current.left);
			}

			if (current.right != null) {
				queue.add(current.right);
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
