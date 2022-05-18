/*
This is an implementation of the selection sort
algorithm.
Idea is to sort a list by successively putting
each value in its final sorted position.

Let n be the size of the list to sort

Time complexity: O(n^2),
Space complexity: O(1)
*/
function selectionSort(arr) {
  let min;
  // idx is position to fill up with next smallest value
  for (let idx = 0; idx < arr.length - 1; idx++) {
    min = idx;
    // Look for next smallest value in rest of array
    for (let scan = idx + 1; scan < arr.length; scan++) {
      if (arr[scan] < arr[min]) {
        min = scan;
      }
    }
    // Exchange current value with the next smallest value
    swap(arr, idx, min);
  }
}
function swap(arr, i, j) {
  const temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}
const arr = [1, 10, 3, 2];
selectionSort(arr);
console.log(arr); // [ 1, 2, 3, 10 ]
