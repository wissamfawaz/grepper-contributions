
// Implementation of the merge sort algorithm.
// Let n be size of list to sort.
// Time complexity: O(n log2(n))
// Space complexity: O(n)

function mergeSort(array) {
  if (array.length <= 1) return array;
  mergeSortHelper(array, 0, array.length - 1);
  return array;
}

// Sort the array recursively
function mergeSortHelper(array, leftIdx, rightIdx) {
  // Base case: no more recursive calls needed
  if (rightIdx <= leftIdx) return;
  const middleIdx = Math.floor(leftIdx + (rightIdx - leftIdx) / 2);
  // Recursive step for sorting half of current array
  mergeSortHelper(array, leftIdx, middleIdx);
  mergeSortHelper(array, middleIdx + 1, rightIdx);
  // Merge recursively sorted subarrays
  merge(array, leftIdx, middleIdx, middleIdx + 1, rightIdx);
}

// Merge sorted subarrays
function merge(array, left, leftEnd, right, rightEnd) {
  const sizeSortedArray = rightEnd - left + 1;
  const sortedArray = [];
  let leftIdx = left,
    rightIdx = right;
  let sortedArrayIdx = 0;
  // Always get smaller value from sorted subarrays
  while (leftIdx <= leftEnd && rightIdx <= rightEnd) {
    if (array[leftIdx] < array[rightIdx]) {
      sortedArray[sortedArrayIdx++] = array[leftIdx++];
    } else {
      sortedArray[sortedArrayIdx++] = array[rightIdx++];
    }
  }
  // Get remaining elements if any
  while (leftIdx <= leftEnd) {
    sortedArray[sortedArrayIdx++] = array[leftIdx++];
  }
  // Get remaining elements if any
  while (rightIdx <= rightEnd) {
    sortedArray[sortedArrayIdx++] = array[rightIdx++];
  }
  // Copy sorted version of array back to original array
  arrayCopy(sortedArray, 0, array, left, sizeSortedArray);
}

function arrayCopy(srcArray, srcIndex, destArray, destIndex, length) {
  destArray.splice(
    destIndex,
    length,
    ...srcArray.slice(srcIndex, srcIndex + length)
  );
}
