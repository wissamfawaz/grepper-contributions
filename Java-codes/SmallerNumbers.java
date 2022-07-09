
/*
	This is an implementation that demonstrates
	how to efficiently find the number of smaller
	elements to the right of every individual array
	element.
	Example: 
	Input: nums = [5,2,6,1]
	Output: [2,1,1,0]
	Explanation:
	To the right of 5 there are 2 smaller elements (2 and 1).
	To the right of 2 there is only 1 smaller element (1).
	To the right of 6 there is 1 smaller element (1).
	To the right of 1 there is 0 smaller element. 
	

	Time complexity: O(nlog2(n)) 
	Space complexity: O(n)
*/

import java.util.List;
import java.util.ArrayList;

public class SmallerNumbers {
	class Item {
		int val;
		int index;

		public Item(int v, int i) {
			val = v;
			index = i;
		}

	}

	public static void main(String[] args) {
		SmallerNumbers application = new SmallerNumbers();
		int[] nums = { 5, 2, 6, 1 };
		List<Integer> output = application.countSmaller(nums);
		System.out.println(output); // [2, 1, 1, 0]
	}

	public List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		Item[] items = new Item[n];

		for (int i = 0; i < n; i++) {
			items[i] = new Item(nums[i], i);
		}

		int[] count = new int[n];
		mergeSort(items, 0, n - 1, count);

		List<Integer> result = new ArrayList<>();

		for (int c : count) {
			result.add(c);
		}

		return result;

	}

	private void mergeSort(Item[] items, int lo, int hi, int[] count) {
		if (lo >= hi)
			return;
		int mid = lo + (hi - lo) / 2;
		mergeSort(items, lo, mid, count);
		mergeSort(items, mid + 1, hi, count);
		merge(items, lo, mid, mid + 1, hi, count);
	}

	private void merge(Item[] items, int lo, int loEnd, int hi, int hiEnd, int[] count) {
		int m = hiEnd - lo + 1;
		Item[] sorted = new Item[m];
		int index = 0;
		int loPtr = lo, hiPtr = hi;

		int rightCounter = 0;

		while (loPtr <= loEnd && hiPtr <= hiEnd) {
			if (items[hiPtr].val < items[loPtr].val) {
				rightCounter++;
				sorted[index++] = items[hiPtr++];
			} else {
				count[items[loPtr].index] += rightCounter;
				sorted[index++] = items[loPtr++];
			}
		}

		while (loPtr <= loEnd) {
			count[items[loPtr].index] += rightCounter;
			sorted[index++] = items[loPtr++];
		}

		while (hiPtr <= hiEnd) {
			sorted[index++] = items[hiPtr++];
		}

		System.arraycopy(sorted, 0, items, lo, m);

	}
}
