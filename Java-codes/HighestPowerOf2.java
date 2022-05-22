/*
	This implementation shows how to easily
	find the highest power of 2 that divides
	a given number n.

	For example, if n=48 => answer = 16

	Time complexity: O(1)
	Space complexity: O(1)
*/

public class HighestPowerOf2 {
	private static int highestPowerOfTwo(int n) {
		return (n & (~(n - 1)));
	}

	public static void main(String[] args) {
		System.out.println(highestPowerOfTwo(48)); // 16
		System.out.println(highestPowerOfTwo(5)); // 1
	}
}
