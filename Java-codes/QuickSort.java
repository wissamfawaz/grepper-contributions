
/*
	This is an implementation of the quick sort algorithm.

	Let n be the size of the list to sort
	Best: O(nlog2(n)) time | O(log2(n)) space
	Average: O(nlog2(n)) time | O(log2(n)) space
	Worst: O(n^2) time | O(log2(n)) space
*/
import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 1, 10, 5, 3, 6 };
		quickSort(arr);
		// Below prints: [1, 3, 5, 6, 10]
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] array) {
		// Sort array recursively
		quickSortUtil(array, 0, array.length - 1);
	}

	private static void quickSortUtil(int[] array, int startIdx, int endIdx) {
		// Base case: at this point array is sorted
		if (startIdx >= endIdx) {
			return;
		}
		// Let first value be pivot
		// Sort every other number wrt to pivot
		int pivotIdx = startIdx;
		int leftIdx = startIdx + 1;
		int rightIdx = endIdx;
		// Make sure that element at leftIdx <= to one at pivotIdx
		// and element at rightIdx is >= to one at pivotIdx
		while (leftIdx <= rightIdx) {
			if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
				swap(leftIdx, rightIdx, array);
			}
			if (array[leftIdx] <= array[pivotIdx]) {
				leftIdx++;
			}
			if (array[rightIdx] >= array[pivotIdx]) {
				rightIdx--;
			}
		}

		swap(pivotIdx, rightIdx, array);
		// At the end of current iteration, element at
		// pivot is in its final sorted position
		quickSortUtil(array, startIdx, rightIdx - 1);
		quickSortUtil(array, rightIdx + 1, endIdx);
	}

	private static void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
