/*
This implementation aims at finding the 
index of the first non-repeating character
in a String consisting only of lowercase
alphabetic characters.

Let n be the size of the String

Time complexity: O(n),
Space complexity: O(1)
Constant space results from the fact that
input string only has lowercase characters.
*/
function firstNonRepeatingChar(inputString) {
  // Object mapping char to its frequency
  const charFrequencies = {};
  for (const char of inputString) {
    // New char ==> set its frequency to 0
    if (!(char in charFrequencies)) {
      charFrequencies[char] = 0;
    }
    charFrequencies[char]++;
  }
  for (let idx = 0; idx < inputString.length; idx++) {
    const currentChar = inputString[idx];
    if (charFrequencies[currentChar] == 1) return idx;
  }
  return -1;
}

console.log(firstNonRepeatingChar("aaccbdd")); // 4
