"""
Implementation of the "Boyer-Moore" majority
vote algorithm (https://en.wikipedia.org/wiki/Boyer-Moore_majority_vote_algorithm).
It aims at finding the element with the majority
count (called majority element) in a sequence 
of values.

Time complexity: O(n)
Space complexity: O(1)
"""


def find_majority_elt(arr):
    # Find majority candidate using algorithm
    majority_candidate = -1
    votes = 0
    for elt in arr:
        if votes == 0:
            majority_candidate = elt
            votes = 1
        else:
            if elt == majority_candidate:
                votes += 1
            else:
                votes -= 1
    return majority_candidate


def is_majority(candidate, array):
    # Confirm that candidate is majority element
    n = len(array)
    if n == 0:
        return False
    count = 0
    for elt in array:
        if elt == candidate:
            count += 1
    return count > n // 2


values = [1, 1, 1, 2, 1, 3]
majority_elt = find_majority_elt(values)
# The below prints: Majority element is: 1
if is_majority(majority_elt, values):
    print("Majority element is:", majority_elt)
else:
    print("No majority element found.")
