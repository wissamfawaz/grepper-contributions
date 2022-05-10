// Aim is to build a min-heap from an
// array of integers with support for following methods:
// buildHeap(array): to build the heap from array
// bubbleDown(currentIdx, endIdx, heap): to bubble an element down
// bubbleUp(currentIdx, heap): to bubble an element up
// peek(): returns min value without removing it
// remove(): removes min value
// insert(): inserts a new element into heap
class MinHeap {
  // Build heap using array of ints
  constructor(array) {
    this.heap = this.buildHeap(array);
  }
  // O(n) time | O(1) space
  buildHeap(array) {
    const firstParentIdx = Math.floor((array.length - 2) / 2);
    for (let currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
      this.bubbleDown(currentIdx, array.length - 1, array);
    }
    return array;
  }
  // O(log(n)) time | O(1) space
  bubbleDown(currentIdx, endIdx, heap) {
    let childOneIdx = currentIdx * 2 + 1;
    while (childOneIdx <= endIdx) {
      const childTwoIdx =
        currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
      let idxToSwap;
      if (childTwoIdx !== -1 && heap[childTwoIdx] < heap[childOneIdx]) {
        idxToSwap = childTwoIdx;
      } else {
        idxToSwap = childOneIdx;
      }
      if (heap[idxToSwap] < heap[currentIdx]) {
        this.swap(currentIdx, idxToSwap, heap);
        currentIdx = idxToSwap;
        childOneIdx = currentIdx * 2 + 1;
      } else {
        return;
      }
    }
  }
  // O(log(n)) time | O(1) space
  bubbleUp(currentIdx, heap) {
    let parentIdx = Math.floor((currentIdx - 1) / 2);
    while (currentIdx > 0 && heap[currentIdx] < heap[parentIdx]) {
      this.swap(currentIdx, parentIdx, heap);
      currentIdx = parentIdx;
      parentIdx = Math.floor((currentIdx - 1) / 2);
    }
  }
  // O(1) time | O(1) space
  peek() {
    return this.heap[0];
  }
  // O(log(n)) time | O(1) space
  remove() {
    this.swap(0, this.heap.length - 1, this.heap);
    const valueToRemove = this.heap.pop();
    this.bubbleDown(0, this.heap.length - 1, this.heap);
    return valueToRemove;
  }
  // O(log(n)) time | O(1) space
  insert(value) {
    this.heap.push(value);
    this.bubbleUp(this.heap.length - 1, this.heap);
  }
  swap(i, j, heap) {
    const temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }
}
