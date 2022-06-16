
/*
	This performs iterative in-order traversal 
	through a binary search tree.
	In a binary search tree, for ever node v:
	- Elements in left subtree rooted at v 
	are less than element stored at v.
	- Elements in right subtree rooted at v
	are greater than or equal to one at v. 

	Let n be the number of nodes in the 
	binary search tree.
	Time complexity: O(n) 
	Space complexity: O(1)
*/
import java.util.function.Consumer;

public class IterativeInOrderTraversal {
	private BTNode BTRoot;

	public IterativeInOrderTraversal() {
		/*
		 * Create tree below:
		 * * 4
		 * / \
		 * 2 7
		 * * / \
		 * * 6 8
		 */
		BTRoot = new BTNode(4, null, null, null);
		BTNode rootLeft = new BTNode(2, null, null, BTRoot);
		BTRoot.left = rootLeft;
		BTNode rootRight = new BTNode(7, null, null, BTRoot);
		BTRoot.right = rootRight;
		BTNode rootRightLeft = new BTNode(6, null, null, rootRight);
		BTNode rootRightRight = new BTNode(8, null, null, rootRight);
		rootRight.left = rootRightLeft;
		rootRight.right = rootRightRight;
	}

	public static void main(String[] args) {
		IterativeInOrderTraversal application = new IterativeInOrderTraversal();
		// The in-order traversal yields a sorted list
		application.iterativeInOrderTraversal((node) -> {
			System.out.print(node.val + " ");
		}); // 2 4 6 7 8

	}

	// Use three pointers to traverse the tree iteratively
	public void iterativeInOrderTraversal(
			Consumer<BTNode> callback) {
		if (BTRoot == null) {
			return;
		}

		BTNode currentNode = BTRoot, previousNode = null;
		BTNode nextNode;

		while (currentNode != null) {
			if (previousNode == null || previousNode == currentNode.parent) {
				if (currentNode.left != null) {
					nextNode = currentNode.left;
				} else {
					callback.accept(currentNode);
					nextNode = (currentNode.right != null) ? currentNode.right : currentNode.parent;
				}

			} else if (previousNode == currentNode.left) {
				callback.accept(currentNode);
				nextNode = (currentNode.right != null) ? currentNode.right : currentNode.parent;
			} else {
				nextNode = currentNode.parent;
			}

			previousNode = currentNode;
			currentNode = nextNode;
		}
	}

	// Class representing a binary tree node
	// with pointers to value, left, right, and parent nodes
	private class BTNode {
		int val;
		BTNode left;
		BTNode right;
		BTNode parent;

		public BTNode(int val, BTNode left, BTNode right, BTNode parent) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}
}
