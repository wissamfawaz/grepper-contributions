/*
	This is an implementation that finds the idx of 
	smallest value that is larger than some target value.
	The method returns length of array if no such value 
	exist in the array.

	Let n be the number of binary tree nodes
	Time complexity: O(log2n) 
	Space complexity: O(1)
*/
public class SmallestLargerThanTarget {
	private static int getIdxSmallestLargerVal(int[] arr, int target) {
		// If target is larger than largest value in arr
		// Return length of arr.
		if (target > arr[arr.length - 1]) {
			return arr.length;
		}
		int middle, left = 0, right = arr.length - 1;
		// Find through binary search the smallest idx
		// where arr[idx] > target
		while (left < right) {
			middle = left + (right - left) / 2;
			if (arr[left] <= target) {
				left = middle;
			} else {
				right = middle - 1;
			}
		}

		return left;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 9, 12, 13, 16 };
		int target = 8;
		int result = getIdxSmallestLargerVal(arr, target);
		System.out.println(result); // 2
		target = 17;
		result = getIdxSmallestLargerVal(arr, target);
		System.out.println(result); // 6
	}
}
