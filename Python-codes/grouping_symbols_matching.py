"""
This implementation demonstrates how 
to efficiently determine if the opening
and closing brackets of an arithmetic
expression match up correctly.

Example: 
For following expression: (1 + 2)
The output would be: true
However, for the following one: (1 + 2]
The output would be: false

Let n be the number of tokens that make up
the arithmetic expression.

Time complexity: O(n)
Space complexity: O(n)
"""


def validate_expression(expression):
    opening_symbols = "([{"
    closing_symbols = ")]}"
    # A map associating opening with closing
    matching_symbols = {")": "(", "]": "[", "}": "{"}
    stack = []
    for token in expression:
        # Add an opening symbol to stack
        if token in opening_symbols:
            stack.append(token)
        elif token in closing_symbols:
            # For a closing symbol stack cannot be empty
            if is_empty(stack):
                return False
            if stack[-1] == matching_symbols[token]:
                # If closing symbol match opening at top of stack
                # pop the top element
                stack.pop()
            else:
                # Closing and opening don't match up
                return False
    # Stack should be empty after processing all tokens
    return is_empty(stack)


def is_empty(stack):
    return len(stack) == 0


print(validate_expression("([1 + 2])"))  # True
print(validate_expression("([1 + 2)"))  # False
