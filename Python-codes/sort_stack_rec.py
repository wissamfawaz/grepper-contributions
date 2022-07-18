"""
This implementation demonstrates how 
to recursively sort a stack in place.

Let n be the size of the stack.

Time complexity: O(n^2)
Space complexity: O(n)
"""


def sort_stack(stack):
    # base case
    if len(stack) == 0:
        return

    top_element = stack.pop()
    # Pop elements from stack
    sort_stack(stack)

    # Insert them in order into stack
    insert_in_order(stack, top_element)


def insert_in_order(stack, value):
    # Insert value at right position within stack
    if len(stack) == 0 or stack[len(stack)-1] <= value:
        stack.append(value)
        return

    top = stack.pop()
    # Same process all over again but one less element
    insert_in_order(stack, value)

    stack.append(top)


stack = [1, 4, 2, 3]
sort_stack(stack)
print("After sorting:", stack)  # After sorting: [1, 2, 3, 4]
