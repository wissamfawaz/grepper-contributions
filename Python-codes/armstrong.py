from math import log10


def is_armstrong(num):
    """
    This function checks if num is an Armstrong number.
    Note that an Armstrong number is a n-digit number 
    that is equal to the sum of each of its digits 
    raised to the nth power.

    For example:  1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 
    371, 407, and 1634 are all Armstrong numbers

    Time complexity: O(n^2)
    Space complexity: O(1)
    """
    if num < 0:
        return False
    if num == 0:
        return True
    n = int(log10(num)) + 1
    sum = 0
    temp = num
    while temp > 0:
        last_digit = temp % 10
        sum += last_digit ** n
        temp //= 10
    return num == sum


print(is_armstrong(3))  # True
print(is_armstrong(120))  # False
print(is_armstrong(153))  # True
print(is_armstrong(1600))  # False
print(is_armstrong(1634))  # True
