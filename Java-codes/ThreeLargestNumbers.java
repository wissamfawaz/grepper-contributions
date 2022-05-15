import java.util.Arrays;
import java.util.PriorityQueue;

public class ThreeLargestNumbers {
	/*
	 * This code finds the three largest numbers
	 * in an array in an efficient manner.
	 * 
	 * Let n be size of the array
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 */
	public static void main(String[] args) {
		int[] arr = { 2, 4, 3, 1 };
		int[] threeLargestNbs = findThreeLargestNumbers(arr);
		// The below prints: [2, 3, 4]
		System.out.println(Arrays.toString(threeLargestNbs));
	}

	// Below function finds 3 larges numbers in arr
	private static int[] findThreeLargestNumbers(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] result = new int[3];
		for (int val : arr) {
			pq.add(val);
			// Do not allow size of pq exceed 3
			if (pq.size() > 3) {
				pq.remove();
			}
		}
		// Get the three largest values and store them in result
		for (int idx = 0; idx < result.length; idx++) {
			result[idx] = pq.remove();
		}
		return result;
	}
}
