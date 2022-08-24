def is_armstrong(num):
    """
    This function checks if num is an Armstrong number.
    Note that an armstrong number is equal to the sum
    of the cubes of its digits.
    Let n be the number of digits that make up num.

    Time complexity: O(n)
    Space complexity: O(1)
    """
    if num < 0:
        return False
    sum = 0
    temp = num
    while temp > 0:
        last_digit = temp % 10
        sum += last_digit ** 3
        temp //= 10
    return num == sum


print(is_armstrong(0))  # True
print(is_armstrong(1))  # True
print(is_armstrong(3))  # False
print(is_armstrong(153))  # True
