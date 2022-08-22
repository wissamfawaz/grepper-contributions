def gcd(a, b):
    """
    The below code demonstrates how to implement 
    Euclid's algorithm to find the greatest
    common divisor of two integer values a and b.

    Time complexity: O(log2(min(a, b)))
    Space complexity: O(1)
    """
    while(b != 0):
        a, b = b, a % b
    return abs(a)


print(gcd(10, 5))  # 5
print(gcd(48, 36))  # 12
