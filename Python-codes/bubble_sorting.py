"""
Bubble sort sorts a list by repeatedly 
swapping adjacent out-of-order values.
The process continues until the list
becomes sorted.
Let n denote the size of the list.

Time complexity: O(n^2)
Space complexity: O(1)
"""


def bubble_sort(array):
    isSorted = False
    passes = 0
    length = len(array)
    while not isSorted:
        isSorted = True
        # Perform a pass through the array
        # excluding already sorted positions
        for i in range(length-1-passes):
            if(array[i] > array[i+1]):
                swap(i, i+1, array)
                # Array is not sorted yet
                isSorted = False
        passes += 1
    return array


def swap(i, j, array):
    # Swap values at indices i and j
    array[i], array[j] = array[j], array[i]


arr = [1, 9, 3, 2]
print(bubble_sort(arr))  # [1, 2, 3, 9]
