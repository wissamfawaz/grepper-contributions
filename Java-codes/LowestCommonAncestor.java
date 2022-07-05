
/*
	This is an implementation that demonstrates
	how to efficiently find the lowest common 
	ancestor of two given nodes	(denoted by 
	targetNode1 and targetNode2) in a binary tree. 
	
	Let n be the number of nodes in the tree.

	Time complexity: O(n) 
	Space complexity: O(n)
*/

public class LowestCommonAncestor {
	private BTNode BTRoot;
	private BTNode targetNode1, targetNode2;

	public LowestCommonAncestor() {
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
		targetNode1 = rootRightLeft;
		targetNode2 = rootLeft;
	}

	public static void main(String[] args) {
		LowestCommonAncestor application = new LowestCommonAncestor();
		// The below prints 1 as the root is lowest
		// common ancestor for the considered target nodes
		System.out.println(application.findLCA().val); // 1
	}

	private BTNode findLCA() {
		return findLCAUtil(BTRoot, targetNode1, targetNode2);
	}

	private BTNode findLCAUtil(BTNode root, BTNode p, BTNode q) {
		if (root == null) {
			return null;
		}
		// If root is one of target nodes then lca is root
		if (root == p || root == q) {
			return root;
		}

		BTNode left = findLCAUtil(root.left, p, q);
		BTNode right = findLCAUtil(root.right, p, q);
		// If target nodes belong to two different subtrees
		// then root is lca
		if (left != null && right != null) {
			return root;
		}

		if (left == null && right == null) {
			return null;
		}
		// If part of same subtree then non-null
		// output is the lca
		return left == null ? right : left;
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
