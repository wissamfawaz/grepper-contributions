/*
  This code demonstrates how to efficiently implement 
  a priority queue in JavaScript.  
  Let n be the size of the priority queue.
*/
const parentIdx = (idx) => Math.floor((idx - 1) / 2);
const leftChildIdx = (idx) => idx * 2 + 1;
const rightChildIdx = (idx) => idx * 2 + 2;

/* Class representing unusual
   situations occurring when
   manipulating the priority queue */
class PQueueError extends Error {
  constructor(message) {
    super(message);
    this.name = "Priority Queue Error";
  }
}

class PriorityQueue {
  // Construct an empty priority queue
  constructor() {
    this.pq = []; // Array used to hold pq elements
  }
  // Size of priority queue
  // Time complexity: O(1)
  size() {
    return this.pq.length;
  }
  // Check if pq is empty
  // Time complexity: O(1)
  isEmpty() {
    return this.size() === 0;
  }
  // Get smallest element in pq
  // Time complexity: O(1)
  peek() {
    if (this.isEmpty()) {
      throw new PQueueError("Priority Queue is empty!");
    }
    // Element at idx 0 is smallest element in pq
    return this.pq[0];
  }
  // Insert an element into pq
  // Time complexity: O(log2(n))
  insert(value) {
    this.pq.push(value);
    this.siftUp();
  }
  // Sift an element after insertion up
  // Time complexity: O(log2(n))
  siftUp() {
    let currentIdx = this.size() - 1;
    let currentParentIdx = parentIdx(currentIdx);
    // Insert inserted element at appropriate location in the pq
    while (currentIdx > 0 && this.pq[currentIdx] > this.pq[parentIdx]) {
      this.swap(currentIdx, currentParentIdx);
      // Proceed to the next level up
      currentIdx = currentParentIdx;
      currentParentIdx = parent(currentIdx);
    }
  }
  // Remove smallest element from pq
  // Time complexity: O(log2(n))
  remove() {
    if (this.isEmpty()) {
      throw new PQueueError("Priority queue is empty!");
    }
    const valueToRemove = this.peek();
    const lastElementIdx = this.size() - 1;
    this.swap(0, lastElementIdx); // Swap top and last element
    // Then remove top element and sift last element down
    this.pq.pop();
    this.siftDown();
    return valueToRemove;
  }
  // Sift out of order element down the heap-based pq
  // Time complexity: O(log2(n))
  siftDown() {
    let currentIdx = 0;
    let childOneIdx = leftChildIdx(currentIdx);
    const endIdx = this.size() - 1;
    // When sifting an element down, it should be
    // Swapped with the smallest of its descendent elements
    while (childOneIdx <= endIdx) {
      let childTwoIdx = rightChildIdx(currentIdx);
      // The idx of child two must be valid
      childTwoIdx = childTwoIdx <= endIdx ? childTwoIdx : -1;
      let idxToSwap;
      if (childTwoIdx !== -1 && this.pq[childTwoIdx] < this.pq[childOneIdx]) {
        idxToSwap = childTwoIdx;
      } else {
        idxToSwap = childOneIdx;
      }
      if (this.pq[idxToSwap] < this.pq[currentIdx]) {
        // Move one level down
        this.swap(currentIdx, idxToSwap);
        currentIdx = idxToSwap;
        childOneIdx = leftChildIdx(currentIdx);
      } else {
        return;
      }
    }
  }

  // Swap elements at indexes i and j
  // Time complexity: O(1)
  swap(i, j) {
    [this.pq[i], this.pq[j]] = [this.pq[j], this.pq[i]];
  }
}

const pq = new PriorityQueue();
try {
  pq.peek(); // Priority Queue is empty!
} catch (err) {
  console.log(err.message);
}

const array = [1, 10, 9, 8, 2];
array.forEach((value) => {
  pq.insert(value);
});
console.log(pq.size()); // 5

const pqContent = [];
while (!pq.isEmpty()) {
  pqContent.push(pq.remove() + " ");
}
// Below prints: PQ content:  1 2 8 9 10
console.log("PQ content: ", pqContent.join(""));
