"""
This implementation deals with the problem
of run-length encoding. According to Wikepedia
"run-length encoding is a form of lossless data
compression in which runs of data are stored as 
a single data value and count, rather than the original
run". For instance, "AAA" would be run-length-encoded 
as "3A". 
However a sequence having more than 9 characters, would 
be split into multiple ones having less than 9 chars. 
For example, "AAAAAAAAAAAA" is run-length encoded as "9A3A".
Time complexity: O(n), where n is length of string to encode
Space complexity: O(n)
"""
def run_length_encode(input_str):
    run_length_encoded_string = []
    current_run_length = 1
    # Perform a run length encoding of input_string
    for i in range(1, len(input_str)):
        current_char = input_str[i]
        previous_char = input_str[i-1]
        if current_char != previous_char or current_run_length == 9:
            run_length_encoded_string.append(str(current_run_length))
            run_length_encoded_string.append(previous_char)
            current_run_length = 0
        current_run_length += 1
    # Handle any remaining character
    run_length_encoded_string.append(str(current_run_length))
    run_length_encoded_string.append(input_str[len(input_str)-1])
    return "".join(run_length_encoded_string)


print(run_length_encode("AAA"))  # 3A
print(run_length_encode("AAAAAAAAAAAA"))  # 9A3A
