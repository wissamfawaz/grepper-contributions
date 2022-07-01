"""
This implementation demonstrates how 
to efficiently find the first index 
in an array of distinct numbers that
is equal to the value at that index.

Example: 
array = [-5, -3, 0, 3, 4, 5, 9]
First idx matching value is 3 as 
array[3] = 3
Let n the size of the input sorted array
of distinct values.

Time complexity: O(nlog2(n))
Space complexity: O(1)
"""
from turtle import left


def index_equal_value(array):
    left_idx = 0
    right_idx = len(array) - 1

    while left_idx <= right_idx:
        middle_idx = left_idx + (right_idx-left_idx)//2
        middle_value = array[middle_idx]

        if middle_value < middle_idx:
            # Focus on later half of the array
            left_idx = middle_idx + 1
        elif middle_value == middle_idx and middle_idx == 0:
            return middle_idx
        elif middle_idx == middle_idx and array[middle_idx-1] < middle_idx-1:
            return middle_idx
        else:
            # Focus on left hand side of the array
            right_idx = middle_idx-1
    return -1


print(index_equal_value([-5, -3, 0, 3, 4, 5, 9]))  # 3
