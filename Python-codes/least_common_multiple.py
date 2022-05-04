"""
GCD: Greatest Common Divisor
LCM: Least Common Multiple
Aim is to find LCM of two integers, a and b.
The absolute value of product of two numbers
is equal to the product of their GCD and LCM.
So, gcd(a, b) * lcm(a, b) = |a x b|
=> lcm(a, b) = |a x b| / gcd(a, b)

Time complexity: O(log2(min(a, b)))
Space complexity: O(1)
"""
import math


def lcm(a, b):
    # If one of them is 0, lcm is 0
    if a == 0 or b == 0:
        return 0
    # Otherwise, lcm = gcd / product
    gcd = math.gcd(a, b)
    return abs(a * b) // gcd


print(lcm(12, 18))  # 36
