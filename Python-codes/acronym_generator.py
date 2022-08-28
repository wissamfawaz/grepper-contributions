from string import punctuation


def str_to_acronym(str):
    """
    This method generates the acronym associated
    with str. The acronym is formed by combining
    the initials of the different words that make 
    str together. 
    """
    if not str:
        return ""  # return empty string if input string is empty
    str = remove_punctuation(str)  # remove punctuation characters
    words = str.split()
    result = ""
    for word in words:
        result += word[0]

    return result.upper()


def remove_punctuation(str):
    for punct in punctuation:
        str = str.replace(punct, "")
    return str


print(str_to_acronym("Transmission Control Protocol"))  # TCP
print(str_to_acronym("User, Datagram, Protocol !"))  # UDP
# or alternatively, 
# phrase = str(input("Enter a phrase: "))
# print(str_to_acronym(phrase))
