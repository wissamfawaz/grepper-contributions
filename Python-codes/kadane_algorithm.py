"""
Implementation of "kadane's algorithm".
It returns the maximum subarray sum for
a given bigger array.
Time complexity: O(n)
Space complexity: O(1)
"""


def kadane_algorithm(array):
    running_sum = array[0]
    max_sum = array[0]
    for idx in range(1, len(array)):
        current_val = array[idx]
        running_sum = max(current_val, running_sum+current_val)
        max_sum = max(max_sum, running_sum)
    return max_sum


print(kadane_algorithm([1, 2, 3, 5, -1]))  # 11 = 1 + 2 + 3 + 5
