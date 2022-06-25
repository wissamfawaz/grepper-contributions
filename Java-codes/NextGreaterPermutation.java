
/*
	This is an implementation that demonstrates
	how to efficiently find the next greater
	permutation for a list of values.
	For example, next greater permutation for:
	- [1, 2, 3] -> [1, 3, 2]
	- [2, 3, 1] -> [3, 1, 2]

	Let n be the number of values in the list.

	Time complexity: O(n) 
	Space complexity: O(1)
*/
import java.util.Arrays;

public class NextGreaterPermutation {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums)); // [1, 3, 2]
		nums = new int[] { 2, 3, 1 };
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums)); // [3, 1, 2]
	}

	public static void nextPermutation(int[] nums) {
		int i = -1;

		// Find position of rightmost value
		// that is smaller than its successor
		for (int j = nums.length - 2; j >= 0; j--) {
			if (nums[j] < nums[j + 1]) {
				i = j;
				break;
			}
		}
		if (i == -1) {
			// This is the max combination
			// We need to sort it in ascending order
			reverse(nums, 0);
			return;
		}
		// Find rightmost value greater than the one
		// at index i and swap it with the one at i
		for (int j = nums.length - 1; j > i; j--) {
			if (nums[j] > nums[i]) {
				swap(nums, i, j);
				break;
			}
		}
		// Reverse the elements to the right of i
		reverse(nums, i + 1);
	}

	private static void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
