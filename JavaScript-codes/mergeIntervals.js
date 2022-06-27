/*
  This implementation demonstrates how to 
  merge overlapping intervals in a non-empty
  array of arbitrary intervals. Each interval
  is an array of two ints, with first element
  being start and second the end of interval.

  Let n be the number of intervals to process.

  Time complexity: O(nlog2(n))
  Space complexity: O(n)
*/

function mergeOverlappingIntervals(intervals) {
  // Sort input intervals by their lower-bound
  const sortedIntervals = intervals.sort((a, b) => a[0] - b[0]);
  // Resulting array of merged intervals
  // It will serve as a stack when solving problem
  const mergedIntervals = [];
  let currentInterval = sortedIntervals[0];
  mergedIntervals.push(currentInterval);

  for (const nextInterval of sortedIntervals) {
    const [_, currentIntervalEnd] = currentInterval;
    const [nextIntervalStart, nextIntervalEnd] = nextInterval;

    if (currentIntervalEnd >= nextIntervalStart) {
      // If current and next intervals overlap, then merge them
      currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
    } else {
      currentInterval = nextInterval;
      mergedIntervals.push(currentInterval);
    }
  }

  return mergedIntervals;
}

const intervals = [
  [1, 2],
  [3, 5],
  [4, 7],
  [6, 8],
  [9, 10],
];
// Below prints: [ [ 1, 2 ], [ 3, 8 ], [ 9, 10 ] ]
console.log(mergeOverlappingIntervals(intervals));
