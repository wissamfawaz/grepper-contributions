public class PrimeFactorization {
	/*
	 * Aim is to find all the prime
	 * factors of a given number n
	 */
	public static void main(String[] args) {
		int n = 315;
		printPrimeFactors(n); // 3^2 5^1 7^1
	}

	private static void printPrimeFactors(int n) {
		int powerOfDivisor;
		// Identify the prime factors of n
		for (int div = 2; div * div <= n; div++) {
			if (n % div == 0) {
				powerOfDivisor = 0;
				// How many times prime factor divides n
				while (n % div == 0) {
					n = n / div;
					powerOfDivisor++;
				}
				// Print prime factor raised to a certain power
				System.out.print(div + "^" + powerOfDivisor + " ");
			}
		}
		// Last prime factor of n has a power = 1
		if (n > 1)
			System.out.println(n + "^" + 1);
		else
			System.out.println();
	}
}
