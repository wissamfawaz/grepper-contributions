
/*
	This implementation demonstrates how 
	to efficiently construct a min height 
	binary search tree based on a sorted 
	array of ints.

	In a binary search tree, for ever node v:
	- Elements in left subtree rooted at v 
	are less than element stored at v.
	- Elements in right subtree rooted at v
	are greater than or equal to one at v. 
	Let n be the number of nodes in the 
	binary search tree.

	Time complexity: O(n) 
	Space complexity: O(log2(n))
*/

public class SortedArrayToBST {
	BTNode BSTRoot;

	public static void main(String[] args) {
		SortedArrayToBST application = new SortedArrayToBST();
		int[] nums = { -10, -3, 0, 5, 9 };
		application.BSTRoot = application.convertArrayToBST(nums);
		/*
		 * The below bst is created:
		 * .. 0
		 * ./.. \
		 * -10.. 5
		 * ..\.. \
		 * .-3 .. 9
		 */
		System.out.println(application.BSTRoot.val); // 0
		System.out.println(application.BSTRoot.left.val); // -10
		System.out.println(application.BSTRoot.left.right.val); // -3
		System.out.println(application.BSTRoot.right.val); // 5
		System.out.println(application.BSTRoot.right.right.val); // 9
	}

	public BTNode convertArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return constructBST(nums, 0, nums.length - 1);
	}

	private BTNode constructBST(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int middle = left + (right - left) / 2;
		// Middle node is root for values between left and right
		BTNode currentNode = new BTNode(nums[middle], null, null);
		// Set left of current root
		currentNode.left = constructBST(nums, left, middle - 1);
		// Set right of current root
		currentNode.right = constructBST(nums, middle + 1, right);

		return currentNode;
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
