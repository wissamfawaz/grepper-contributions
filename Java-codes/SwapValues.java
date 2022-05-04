public class SwapValues {
	/*
	 * To effect the swapping, arrays of size 1
	 * are used since array variables store the
	 * address of a value.
	 * 
	 * Time complexity: O(1)
	 * Space complexity: O(1)
	 */
	public static void main(String[] args) {
		int[] val1 = new int[] { 12 }, val2 = new int[] { 13 };
		System.out.println(val1[0] + ", " + val2[0]); // 12, 13
		swapValues(val1, val2);
		System.out.println(val1[0] + ", " + val2[0]); // 13, 12
	}

	private static void swapValues(int[] val1, int[] val2) {
		int temp = val1[0];
		val1[0] = val2[0];
		val2[0] = temp;
	}
}
