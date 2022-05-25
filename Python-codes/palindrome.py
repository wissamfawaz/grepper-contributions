"""
This implementation checks whether a given
string is a palindrome. A string is 
considered to be a palindrome if it reads the
same forward and backward. For example, "kayak"
is a palindrome, while, "door" is not. 

Let n be the length of the string

Time complexity: O(n), 
Space complexity: O(1)
"""


def isPalindrome(string):
    # Maintain left and right pointers
    leftIdx = 0
    rightIdx = len(string)-1
    while leftIdx < rightIdx:
        # If chars on either end don't match
        # string cannot be a palindrome
        if string[leftIdx] != string[rightIdx]:
            return False
        # Otherwise, proceed to next chars
        leftIdx += 1
        rightIdx -= 1
    return True


print(isPalindrome("kayak"))  # True
print(isPalindrome("door"))  # False
