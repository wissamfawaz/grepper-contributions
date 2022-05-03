public class EfficientPower {
	/*
	 * Aim is to find the power of a number
	 * in an efficient manner. Let us denote
	 * the exponent by n.
	 * 
	 * Time complexity: O(log2(n))
	 * Space complexity: O(1)
	 */
	public static void main(String[] args) {
		double base = 10;
		int exponent = 3;
		System.out.println(fastPower(base, exponent)); // 1000.0
	}

	// Method for efficiently calculating power
	private static double fastPower(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}

		// If exponent is negative, take reciporcal of base
		// and then change sign of exponent
		if (exponent < 0) {
			base = 1 / base;
			exponent = -exponent;
		}

		double answer = 1;
		// Update answer based on binary
		// representation of exponent
		while (exponent != 0) {
			// If bit is 1, update answer
			if (exponent % 2 == 1) {
				answer = answer * base;
			}
			// Move to next bit
			base = base * base;
			exponent = exponent / 2;
		}

		return answer;
	}
}
  
  
