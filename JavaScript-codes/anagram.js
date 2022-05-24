/*
  An anagram can be obtained by rearranging
  the letters of another word. For instance, 
  "anagram" is an anagram of "nagaram".
  This implementation determines if one string
  is anagram of another. The two strings are
  assumed to be composed of lowercase alphabetic
  letters only.

  Time complexity: O(n)
  Space complexity: O(1)
*/
// Return true if str1 is anagram of str2
// Or false otherwise
function isAnagram(str1, str2) {
  // Two anagrams must have same length
  if (str1.length !== str2.length) {
    return false;
  }
  // Count nb of occurrences of characters
  // in str1. Only 26 countes are needed
  // since str1 has only lowercase letters
  const counter = new Array(26).fill(0);
  let currentChar1, currentChar2, currentIdx;
  const charCodeA = "a".charCodeAt(0);

  for (let idx = 0; idx < str1.length; idx++) {
    currentChar1 = str1.charAt(idx);
    currentIdx = currentChar1.charCodeAt(0) - charCodeA;
    counter[currentIdx]++;
  }
  // Decrement the previously calculated counters
  // by scanning through letters of str2.
  for (let idx = 0; idx < str2.length; idx++) {
    currentChar2 = str2.charAt(idx);
    currentIdx = currentChar2.charCodeAt(0) - charCodeA;
    console.log(currentIdx);
    counter[currentIdx]--;
    if (counter[currentIdx] < 0) {
      return false;
    }
  }
  return true;
}

console.log(isAnagram("rat", "car")); // true
