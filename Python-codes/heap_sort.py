"""
The below code provides an implementation 
for the heap sort algorithm 
(https://en.wikipedia.org/wiki/Heapsort). 
Sorting a list via heap sort is a two-step 
process:
1. In first step, insert elements of list 
into an initially empty heap by means of
n push operations. Time complexity: O(nlog2(n)) 
2. In second step, extract the elements from 
the heap in non-decreasing order through 
n pop operations, packaging them back into 
sorted list. Time complexity: O(nlog2(n))

Let n be the number of elements in list to sort.

Time complexity: O(nlog2(n))
Space complexity: O(n), to hold the values in heap.
"""
from heapq import heappop, heappush


def heap_sort(list):
    min_heap = []
    # first step: insert elements into heap
    for val in list:
        heappush(min_heap, val)
    # second step: extract elements to form a sorted list
    return [heappop(min_heap) for _ in range(len(list))]


unsorted_list = [1, 10, 4, 3, 2]
print(heap_sort(unsorted_list))  # [1, 2, 3, 4, 10]
