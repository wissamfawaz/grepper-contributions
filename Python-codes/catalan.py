"""
This implementation demonstrates how
to efficiently calculate the nth
Catalan number. For instance, 
the nth catalan number gives the 
number of unique binary search trees 
which has exactly n nodes of unique values
between 1 and n!

Let us denote it by Cn:
C0 = 1 and Cn = 2(2n+1)Cn/(n+2)

More info at:
https://en.wikipedia.org/wiki/Catalan_number

Time complexity: O(n)
Space complexity: O(1)
"""


def C_n(n):
    C = 1
    for i in range(0, n):
        C = C * 2*(2*i+1)/(i+2)
    return int(C)


print("C1 =", C_n(1))  # C1 = 1
print("C3 =", C_n(3))  # C3 = 5
