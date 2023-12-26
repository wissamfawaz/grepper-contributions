def levenshtein_distance(str1, str2):
    # Swap strings if str1 is longer than str2
    if len(str1) > len(str2):
        str1, str2 = str2, str1

    # Initialize the previous row of distances
    previous_row = range(len(str1) + 1)
    for i, c1 in enumerate(str2):
        # Start a new row with the delete operation count
        current_row = [i + 1]
        for j, c2 in enumerate(str1):
            # Calculate costs for various operations
            insertions = previous_row[j + 1] + 1
            deletions = current_row[j] + 1
            substitutions = previous_row[j] + (c1 != c2)
            # Append the minimum cost of operations to current row
            current_row.append(min(insertions, deletions, substitutions))
        # Move to the next row
        previous_row = current_row

    # The last element of the previous row is the answer
    return previous_row[-1]
