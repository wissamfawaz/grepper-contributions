/* Class representing unusual
   situations occurring when
   manipulating the queue */
class QueueError extends Error {
  constructor(message) {
    super(message);
    this.name = "Queue Error";
  }
}
// FIFO queue data structure
class Queue {
  constructor() {
    this.items = {}; // object used to hold elements
    this.front = 0; // index of front element
    this.rear = 0; // idx of next available spot in queue
  }
  // Getter methods
  get size() {
    return this.rear - this.front; // nb of items in queue
  }
  get isEmpty() {
    return this.size === 0;
  }
  // enqueue: insert an element
  // at rear end of queue
  enqueue(item) {
    this.items[this.rear] = item;
    this.rear++;
  }
  // Access front element
  accessFront() {
    if(this.isEmpty) {
      throw new QueueError("Queue is empty!");
    }
    return this.items[front];
  }
  // dequeue: remove front element
  dequeue() {
    if(this.isEmpty) {
      throw new QueueError("Queue is empty!");
    }
    const toReturn = this.items[this.front];
    delete this.items[this.front];
    this.front++;
    return toReturn;
  }
}

const queue = new Queue();
try {
  queue.accessFront(); // Generates an error
} catch(err) {
  console.log(err.message); // Queue is empty!
}
// Add elements 1, 2, and 3 to queue
for(let idx=1; idx<=3; idx++) {
  queue.enqueue(idx);
}
console.log("Size:", queue.size); // Size: 3
const queueContent = [];
while(!queue.isEmpty) {
  queueContent.push(queue.dequeue() + " ");
}
console.log("Queue:", queueContent.join("")); // Queue: 1 2 3
