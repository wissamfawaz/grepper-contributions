import java.util.Arrays;

public class CountingSort {
	/*
	 * This code performs a Counting sort of
	 * a list of positive integer values.
	 * 
	 * Let n be size of the list to be sorted and
	 * m be the maximum value in the list
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(n+m)
	 * 
	 */
	public static void main(String[] args) {
		int[] arr = { 2, 4, 3, 1 };

		System.out.println("Before: " + Arrays.toString(arr));
		int[] sortedArr = countingSort(arr);
		System.out.println("After counting sort: " + Arrays.toString(sortedArr));
	}

	private static int[] countingSort(int[] arr) {
		/*
		 * The counting sort method counts the number
		 * of occurrences of every element in arr.
		 * Then uses that information to sort these elements.
		 */
		int max = findMax(arr); // linear
		if (max == Integer.MIN_VALUE) {
			return new int[] {};
		}
		int[] counts = new int[max + 1];
		for (int num : arr) {
			counts[num]++;
		}
		for (int idx = 1; idx < counts.length; idx++) {
			counts[idx] = counts[idx - 1] + counts[idx];
		}
		int[] sortedArray = new int[arr.length];
		int current, sortedIdx;
		for (int idx = arr.length - 1; idx >= 0; idx--) {
			current = arr[idx];
			counts[current]--;
			sortedIdx = counts[current];
			sortedArray[sortedIdx] = current;
		}
		return sortedArray;
	}

	private static int findMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int num : arr) {
			if (num > max) {
				max = num;
			}
		}
		return max;
		// or return Collections.max(Arrays.asList(arr));
	}
}
