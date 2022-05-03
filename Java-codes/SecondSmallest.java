public class SecondSmallest {
	/*
	 * Aim is to find second smallest
	 * element in an array efficiently.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public static void main(String[] args) {
		int[] arr1 = { 1 };
		int secondSmallest = get2ndSmallest(arr1);
		// Below prints: Size should be greater than 2
		if (secondSmallest == Integer.MAX_VALUE) {
			System.out.println("Size should be greater than 2");
		} else {
			System.out.println(secondSmallest);
		}

		int[] arr2 = { 1, 2, 4, 2 };
		secondSmallest = get2ndSmallest(arr2);
		// Below prints: 2
		if (secondSmallest == Integer.MAX_VALUE) {
			System.out.println("Size should be greater than 2");
		} else {
			System.out.println(secondSmallest);
		}

	}

	// Supporting method for finding 2nd smallest value in array
	private static int get2ndSmallest(int[] arr) {
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for (int num : arr) {
			// Update second smallest if a new
			// running min is found
			if (num < smallest) {
				secondSmallest = smallest;
				smallest = num;
			} else if (num < secondSmallest && num != smallest) {
				secondSmallest = num;
			}
		}
		return secondSmallest;
	}
}
