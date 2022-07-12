"""
This implementation demonstrates how 
to generate the power set of an array 
of unique integers.

Example: 
For following array: [1, 2]
The power set is the set of all subsets of 
the array. 
So, output would be: [[], [1], [2], [1, 2]]

Let n be the size of the array.

Time complexity: O(n*2^n)
Space complexity: O(n*2^n)
"""


def powerset(array):
    # Empty set is part of power set
    subsets = [[]]
    for element in array:
        # Add every element to existing subsets
        for idx in range(len(subsets)):
            subset = subsets[idx]
            subsets.append(subset + [element])
    return subsets


print(powerset([1, 2]))  # [[], [1], [2], [1, 2]]
