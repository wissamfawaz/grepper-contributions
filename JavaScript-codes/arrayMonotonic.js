/*
  This implementation demonstrates how to 
  efficiently check whether a given array
  is monotonic. Note that an array is said
  to be monotonic if its elements from 
  left to right are either entirely 
  non-increasing or entirely non-decreasing. 

  Let n be the size of the array.

  Time complexity: O(n)
  Space complexity: O(1)
*/

function isMonotonic(array) {
  if (!Array.isArray(array) || array.length <= 2) {
    return true;
  }
  let isIncreasing = true,
    isDecreasing = true;
  for (let idx = 0; idx < array.length - 1; idx++) {
    if (array[idx] < array[idx + 1]) {
      isDecreasing = false;
    }
    if (array[idx] > array[idx + 1]) {
      isIncreasing = false;
    }
  }

  return isIncreasing || isDecreasing;
}

console.log(isMonotonic([1, 2, 4, 6])); // true
console.log(isMonotonic([6, 5, 4, 3])); // true
console.log(isMonotonic([1, 4, 2, 6])); // false
