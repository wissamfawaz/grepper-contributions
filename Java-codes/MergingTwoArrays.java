import java.util.Arrays;

public class MergingTwoArrays {
	/*
	 * This code merges two arrays, sorted in ascending
	 * order, into a single aggregate array sorted in
	 * ascending order.
	 * 
	 * Let n be size of first array and
	 * m the size of the second array.
	 * 
	 * Time complexity: O(n+m)
	 * Space complexity: O(n+m)
	 */
	public static void main(String[] args) {
		int[] nums1 = { 1, 5, 7 };
		int[] nums2 = { 3, 6 };
		// Below prints: [1, 3, 5, 6, 7]
		System.out.println(Arrays.toString(merge(nums1, nums2)));
	}

	// Method merging the two sorted arrays
	private static int[] merge(int[] nums1, int[] nums2) {
		int n = nums1.length, m = nums2.length;
		int[] sortedArray = new int[n + m];
		// Indexes into nums1, nums2, and sortedArray
		int nums1Ptr = 0, nums2Ptr = 0, sortedArrayIdx = 0;
		// Collect the elements of nums1 and nums2 in order
		while (nums1Ptr < n && nums2Ptr < m) {
			// Transfer smaller element to sortedArray
			if (nums1[nums1Ptr] < nums2[nums2Ptr]) {
				sortedArray[sortedArrayIdx++] = nums1[nums1Ptr++];
			} else {
				sortedArray[sortedArrayIdx++] = nums2[nums2Ptr++];
			}
		}
		// Transfer elements remaining in either nums1 or nums2
		// to the resulting sortedArray
		while (nums1Ptr < n) {
			sortedArray[sortedArrayIdx++] = nums1[nums1Ptr++];
		}
		while (nums2Ptr < m) {
			sortedArray[sortedArrayIdx++] = nums2[nums2Ptr++];
		}

		return sortedArray;
	}
}
