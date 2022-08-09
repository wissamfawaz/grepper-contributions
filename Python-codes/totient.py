"""
This implementation demonstrates how 
to efficiently implement the so-called 
Euler's totient function.

This function takes an integer n as 
input and returns the number of integers
between 1 and n that are coprime with n. 
Two numbers are said to be coprime if their
greatest common divisor is equal to 1.


Time complexity: O(sqrt(n))
Space complexity: O(1)
"""
# The count of coprimes for n can be determined
# through the prime factors of n as follows.


def totient_function(n):
    answer = n
    div = 2
    while div * div <= n:
        if n % div == 0:
            # This factor along with its multiples
            # are not coprimes with n.
            answer -= answer // div
            # Before turning to next prime factor,
            # remove all occurrences of current factor
            # from n.
            while n % div == 0:
                n = n // div
        div += 1
    # Process the last prime factor, if need be
    if n > 1:
        answer -= answer // n
    return answer


# Number of ints that are coprime with 5 = 4
print(totient_function(5))  # 4
# Number of ints that are coprime with 5 = 8
print(totient_function(20))  # 8
