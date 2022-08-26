from math import log10


def is_disarium(num):
    """
    This function checks if num is a Disarium number.
    Note that a Disarium number is a n-digit number 
    that is equal to the sum of its digits raised each
    to a power matching its position in the number.

    For example:  175 = 1^1 + 7^2 + 5^3, making 175 
    a Disarium number. 

    Time complexity: O(nlog2(n))
    Space complexity: O(1)
    """
    if num < 0:
        return False
    if num == 0:
        return True
    # Compute the number of digits in num
    n = int(log10(num)) + 1
    # Running sum to store the sum of
    # digits raised to corresponding position
    sum = 0
    temp = num
    while temp > 0:
        last_digit = temp % 10  # Get next digit
        sum += last_digit ** n  # Update sum
        temp //= 10  # Truncate current digit, to access next one
        n -= 1  # Next position is one less than current one

    return num == sum


print("All Disarium numbers below 1001: ")
for i in range(0, 1001):
    # Below prints: 0 1 2 3 4 5 6 7 8 9 89 135 175 518 598
    if is_disarium(i):
        print(i, end=" ")
