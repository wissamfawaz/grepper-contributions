public class Fibonacci {
	/*
	 * Fibonacci sequence starts with 0 and 1, then
	 * any subsequent value is the sum of 2 previous ones.
	 * 0, 1, 1, 2, 3, 5, 8, etc...
	 * fib(0) = 0; fib(1) = 1; fib(n)=fib(n-1)+fib(n-2)
	 * Code below finds Fibonacci of n iteratively.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public static void main(String[] args) {
		System.out.println(fib(3)); // 2
		System.out.println(fib(6)); // 8
	}

	// Supporting method for finding Fibonacci of n
	private static int fib(int n) {
		int prevprev = 0, prev = 1;
		int current = n;
		// Loop until reaching n each time
		// deriving current based on 2 previous values
		for (int i = 2; i <= n; i++) {
			current = prevprev + prev;
			prevprev = prev;
			prev = current;
		}
		return current;
	}
}
