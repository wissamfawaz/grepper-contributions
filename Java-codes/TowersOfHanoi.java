public class TowersOfHanoi {
	/*
	 * This code solves the towers of Hanoi problem
	 * The considered puzzle consists of three pegs
	 * and a set of rings. Each ring has a different
	 * size. Initially all rings are stacked on leftmost
	 * peg in ascending order of size.
	 * Aim: move all rings from leftmost peg to destination
	 * peg while obeying following rules: 1) Only one ring
	 * can be moved at a time; 2) A larger ring cannot
	 * be placed on top of a smaller one.
	 * Let n be the number of rings.
	 * 
	 * Time complexity: O(2^n)
	 * Space complexity: O(n)
	 */
	public static void main(String[] args) {
		int nbDisks = 3;
		moveTower(nbDisks, 1, 3, 2);
		/*
		 * The above prints:
		 * 1->3
		 * 1->2
		 * 3->2
		 * 1->3
		 * 2->1
		 * 2->3
		 * 1->3
		 */
	}

	// Method for moving n disks from start to end via extra
	private static void moveTower(int n, int start, int end, int extra) {
		// Base case of 0 disks
		if (n == 0)
			return;
		// Move n-1 disks out of the way
		moveTower(n - 1, start, extra, end);
		moveOneDisk(start, end);
		// Move remaining n-1 disks to destination
		moveTower(n - 1, extra, end, start);
	}

	private static void moveOneDisk(int start, int end) {
		System.out.println(start + "->" + end);
	}
}
