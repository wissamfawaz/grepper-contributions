/*
  This implementation demonstrates how to
  find all triplets in an array that sum 
  up to some target value. 

  Let n be the size of the input array.

  Time complexity: O(n^2)
  Space complexity: O(n)
*/

function tripletsSum(arr, targetSum) {
  // Sort elements in ascending order
  arr.sort((a, b) => a - b);
  const triplets = [];
  // Find the triplets by scanning through array
  for (let idx = 0; idx < arr.length; idx++) {
    let left = idx + 1;
    let right = arr.length - 1;
    // Find two elements that equals
    // target minus the one at idx
    while (left < right) {
      const currentSum = arr[idx] + arr[left] + arr[right];
      if (currentSum === targetSum) {
        triplets.push([arr[idx], arr[left], arr[right]]);
        left++;
        right--;
      } else if (currentSum < targetSum) {
        // Look for a larger left value
        left++;
      } else {
        // Look for a smaller right value
        right--;
      }
    }
  }
  return triplets;
}

const arr = [12, 3, 1, 2, -6, 5, -8, 6];
const targetSum = 0;
// Below outputs:[ [ -8, 2, 6 ], [ -8, 3, 5 ], [ -6, 1, 5 ] ]
console.log(tripletsSum(arr, targetSum));
