"""
This implementation demonstrates how 
to generate all the permutations of 
a given set of integers.

Example: 
For following array: [1, 2, 3]
The output would be: 
[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], 
[3, 1, 2], [3, 2, 1]]

Let n be the size of the array.

Time complexity: O(n*n!)
Space complexity: O(n*n!)
"""


def find_permutations(array):
    permutations = []
    generate_permutations(0, array, permutations)
    return permutations


def generate_permutations(idx, array, permutations):
    if idx == len(array) - 1:
        permutations.append(array[:])  # add a copy of array to output
    else:
        for j in range(idx, len(array)):
            swap(array, idx, j)  # swap idxth elem with every other elem
            generate_permutations(idx+1, array, permutations)
            swap(array, j, idx)  # backtrack


def swap(array, i, j):
    array[i], array[j] = array[j], array[i]


# Below outputs:
# [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
print(find_permutations([1, 2, 3]))

"""
# Another solution:
import itertools
# Below output:
# [(1, 2, 3), (1, 3, 2), (2, 1, 3), (2, 3, 1), (3, 1, 2), (3, 2, 1)]
print(list(itertools.permutations([1, 2, 3])))
"""
