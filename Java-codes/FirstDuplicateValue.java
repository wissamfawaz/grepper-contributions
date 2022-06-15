/*
	This is an implementation that demonstrates
	how to efficiently find the first duplicate 
	value in an array of ints between 1 and n, 
	where n is the length of the array.
	
	Time complexity: O(n) 
	Space complexity: O(1)
*/
public class FirstDuplicateValue {
	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 3, 3, 2, 4 };
		// Below outputs: 3
		// as 3 is the first int appearing more
		// than once
		System.out.println(firstDuplicateValue(arr));
	}

	public static int firstDuplicateValue(int[] array) {
		// The main idea behind solution lies
		// in treating array elements as indices
		int index;
		for (int val : array) {
			index = Math.abs(val) - 1;
			if (array[index] < 0) {
				return index + 1;
			} else {
				array[index] *= -1;
			}
		}

		return -1;
	}
}
