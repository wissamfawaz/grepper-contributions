public class BinarySearch {
	/*
	 * Searching is the process of finding a target
	 * element within a search pool. Binary search
	 * is used when the search pool is sorted.
	 * Let n denote the size of the search pool.
	 * 
	 * Time complexity: O(log2(n))
	 * Space complexity: O(1)
	 */
	public static void main(String[] args) {
		int[] searchPool = { 1, 3, 5, 10, 12, 14 };
		int target = 12;
		System.out.println(binarySearch(searchPool, target)); // true
		target = 13;
		System.out.println(binarySearch(searchPool, target)); // false
	}

	private static boolean binarySearch(int[] pool, int target) {
		// Pool is assumed to be sorted in ascending order
		int left = 0, right = pool.length - 1;
		int middle;
		boolean found = false;
		// Keep searching until either you find element or don't
		while (!found && left <= right) {
			middle = left + (right - left) / 2;
			// Repeatedly check middle element
			if (pool[middle] == target) {
				found = true;
			} else if (pool[middle] < target) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return found;
	}
}
