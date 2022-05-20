"""
This implementation finds the three largest
numbers in an array in an efficient manner.

The idea is to maintain a subarray holding
the three largest values encountered so 
far. When the algorithm concludes that 
subarray would end up holding the desired
output value (i.e., 3 largest values of 
main array).

Let n be the size of the array
Time complexity: O(n)
Space complexity: O(1)
"""


def find_three_largest_values(arr):
    # Container for 3 largest values
    result = [None]*3
    # Make sure result holds always
    # 3 largest values encountered so far
    for val in arr:
        update_result(result, val)
    return result


def update_result(result, val):
    # Insert val into appropriate position
    # Only vals of interest are those bigger
    # than values already in result array.
    if result[2] is None or val > result[2]:
        update_and_shift(result, val, 2)
    elif result[1] is None or val > result[1]:
        update_and_shift(result, val, 1)
    elif result[0] is None or val > result[0]:
        update_and_shift(result, val, 0)


def update_and_shift(result, val, idx):
    for i in range(idx+1):
        if i == idx:
            result[i] = val
        else:
            result[i] = result[i+1]


arr = [1, 2, 3, 7, 8, 9]
print(find_three_largest_values(arr))  # [7, 8, 9]
