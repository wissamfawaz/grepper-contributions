"""
Implementation of the "Sieve of Eratosthenes"
algorithm.
It aims at finding all primes that are less
than or equal to a certain upperbound, denoted
by n.

Time complexity: O(n log log n)
Space complexity: O(n)
"""
from math import sqrt


def find_primes(n):
    # Only 1 prime <= 2
    if n <= 2:
        return [2]
    """
    Initialize numbers[0] and numbers[1] as False
    because 0 and 1 are not prime.
    Set numbers[2] through numbers[n-1] to True.
    When we find a divisor for one of them, set 
    it to False
    """
    numbers = [False, False] + [True] * (n-1)
    sqrtN = int(sqrt(n))
    for p in range(2, sqrtN + 1):
        if numbers[p]:
            # Set all multiples of p to False
            # because they are not prime
            for multiple in range(p*p, n+1, p):
                numbers[multiple] = False

    # Return all identified prime numbers
    return [p for p in range(n + 1) if numbers[p]]


print(find_primes(13))  # [2, 3, 5, 7, 11, 13]
print(find_primes(19))  # [2, 3, 5, 7, 11, 13, 17, 19]
