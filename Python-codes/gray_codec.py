def encode(number):
    """
    Find the gray code corresponding to number.
    Gray code is an ordering of the binary system
    where any two consecutive values differ by
    exactly one bit.
    For 3-bit numbers, the gray codes are as follows:
    000, 001, 011, 010, 110, 111, 101, 100
    Denote by G the function mapping binary numbers to
    gray codes. In light of the above, G(5) = 7

    Time complexity: O(1)
    Space complexity: O(1)
    """
    return number ^ (number >> 1)


def decode(gray_code):
    """
    Decode a gray code back into a number.
    Let n be the number of bits of the gray code.

    Time complexity: O(n)
    Space complexity: O(1)
    """
    number = 0
    while gray_code:
        number = number ^ gray_code
        gray_code >>= 1
    return number


"""
Below code outputs:
000:000 001:001 010:011 011:010 100:110 101:111 110:101 111:100 
"""
for number in range(0, 8):
    gray_code = encode(number)
    decoded_number = decode(gray_code)
    print(f"{decoded_number:03b}:{gray_code:03b}", end=" ")
