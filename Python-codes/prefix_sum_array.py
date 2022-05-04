"""
How to construct a prefix sum array?
Prefix sum array helps respond to sum queries
on an array efficiently.
[1, 3, 4, 8]: original array --> [1, 4, 8, 16]: prefix sum
Sum query sumq(idx1, idx2) = sumq(0, b) - sumq(0, a-1)
Let n denote the size of the original array.

Time complexity: O(n)
Space complexity: O(n)
"""


def prefix_sum(array):
    pref_sum_arr = [0]
    n = len(array)
    for idx in range(1, n+1):
        pref_sum_arr.append(pref_sum_arr[idx-1] + array[idx-1])
    return pref_sum_arr


arr = [1, 3, 4, 8]
print(prefix_sum(arr)[1:])  # [1, 4, 8, 16]
