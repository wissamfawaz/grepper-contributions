import java.util.List;
import java.util.ArrayList;

public class GeneratingSubsets {
	/*
	 * This code generates all subsets of a given
	 * set having n elements.
	 * 
	 * Time complexity: O(n2^n)
	 * Space complexity: O(2^n)
	 * 
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 8, 7 };
		List<List<Integer>> subsets = generateSubsets(arr);
		/*
		 * Below prints:
		 * [[], [1], [7], [1, 7], [8], [1, 8], [7, 8], [1, 7, 8],
		 * [9], [1, 9], [7, 9], [1, 7, 9], [8, 9], [1, 8, 9], [7,8, 9],
		 * [1, 7, 8, 9]]
		 */
		System.out.println(subsets);

	}

	// Below function generates subsets of array
	private static List<List<Integer>> generateSubsets(int[] arr) {
		// Idea is to count on binary representation of array
		// size. Then, consider all binary representations
		// having 1 valued bits using positions of these bits
		// as indexes into array.
		List<List<Integer>> subsets = new ArrayList<>();
		int[] set = { 1, 7, 8, 9 };
		int n = set.length;

		for (int b = 0; b < (1 << n); b++) {
			List<Integer> subset = new ArrayList<Integer>();

			for (int i = 0; i < n; i++) {
				if ((b & (1 << i)) != 0) {
					subset.add(set[i]);
				}
			}
			subsets.add(subset);
		}
		return subsets;
	}
}
