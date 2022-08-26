from math import isqrt


def is_perfect(num):
    """
    This function checks if num is a perfect number.
    Note that a number is said to be perfect if it 
    matches the sum of all of its divisors, excluding
    itself.

    For example:  6 = 1 + 2 + 3, 28 = 1 + 2 + 4 + 7 + 14, 
    and 496 = 1 + 2 + 4 + 8 + 16 + 31 + 62 + 124 + 248, 
    are all perfect numbers.

    Time complexity: O(sqrt(n)), with sqrt being square root
    Space complexity: O(1)
    """
    if num <= 5:
        return False
    sum = 1
    for div in range(2, isqrt(num) + 1):
        if num % div == 0:
            sum += div + num // div
        if sum > num:
            return False

    return (num == sum)


print("All perfect numbers below 100: ")
for n in range(100):
    """
    The below prints:
    6
    28
    """
    if is_perfect(n):
        print(n)
