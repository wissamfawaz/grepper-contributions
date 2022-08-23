/*
  This code demonstrates how to efficiently find the most 
  frequent element of an array.  
  Let n be the size of the array.

  Time complexity: O(n)
  Space complexity: O(n)
*/
function computeElementsFrequencies(arr, map) {
  // Computer the number of occurrences of each
  // array element.
  for (const element of arr) {
    if (map.has(element)) {
      map.set(element, map.get(element) + 1);
    } else {
      map.set(element, 1);
    }
  }
}

function findMostFrequentElements(map) {
  const maxFrequency = Math.max.apply(null, Array.from(map.values()));
  // Return an array containing the most frequent elements
  return Array.from(map.keys()).filter((key) => {
    return map.get(key) === maxFrequency;
  });
}

const map = new Map();
computeElementsFrequencies(
  ["Wissam", "Wissam", "Chadi", "Chadi", "Fawzi"],
  map
);
const mostFrequentElements = findMostFrequentElements(map);
console.log(mostFrequentElements); // [ 'Wissam', 'Chadi' ]
