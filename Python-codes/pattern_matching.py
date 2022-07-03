"""
This implementation demonstrates how 
to efficiently determine if a pattern 
string is a substring of some bigger,
target string.

Example: 
For following input values:
substring = "aefcd"
string = "dcaefcdcdaed"
Output would be: True

Let m be the size of the pattern and 
n be the size of the target string.

Time complexity: O(n+m)
Space complexity: O(m)
"""


def kmp_algorithm(string, substring):
    i, j = 0, 0
    """
    preprocess the pattern string by computing
    a failure function mapping indexes to shifts
    with the aim of reusing previously performed
    comparisons.
    """
    failure = compute_failure_function(substring)
    str_len, substr_len = len(string), len(substring)
    while i < str_len:
        if string[i] == substring[j]:
            # Pattern is found when its last char reached
            if j == substr_len - 1:
                return True
            i += 1
            j += 1
        elif j > 0:
            # Determine next continuation index in pattern
            # by consulting the failure function.
            j = failure[j-1]
        else:
            i += 1
    return False


def compute_failure_function(substring):
    # The failure function maps each index j
    # in pattern P to length of longest prefix
    # of P that is a suffix of P[1:j]
    j, i = 0, 1
    substr_len = len(substring)
    failure = [0] * substr_len
    while i < substr_len:
        if substring[j] == substring[i]:
            # We have matched j + 1 characters
            failure[i] = j + 1
            i += 1
            j += 1
        elif j > 0:
            # Place j just after a prefix that matches
            j = failure[j-1]
        else:
            i += 1
    return failure


print(kmp_algorithm("dcaefcdcdaed", "aefcd"))  # True
print(kmp_algorithm("dcaefccdaed", "aefcd"))  # False
