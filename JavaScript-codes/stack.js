/* Errors to be thrown when 
   trying to get elements from
   an empty stack. */
class StackError extends Error {
  constructor(message) {
    super(message);
    this.name = "Stack Error";
  }
}
// Last In First Out stack data structure
class Stack {
  constructor() {
    this.items = []; // container holding elements
  }
  // Getter methods
  get size() {
    return this.items.length;
  }
  get isEmpty() {
    return this.size === 0;
  }
  // push: push an element onto
  // top of the stack
  push(item) {
    this.items.push(item);
  }
  // pop: pop top element from stack
  pop() {
    if (this.isEmpty) {
      throw new StackError("Stack is empty!");
    }
    return this.items.pop();
  }
  // peek: return top element of stack
  peek() {
    if (this.isEmpty) {
      throw new StackError("Stack is empty!");
    }
    return this.items[this.items.length - 1];
  }
}
const stack = new Stack();
try {
  stack.peek(); // Stack is empty => error
} catch (err) {
  console.log(err.message); // Stack is empty!
}
// Add elements 1, 2, and 3 to stack
for (let idx = 1; idx <= 3; idx++) {
  stack.push(idx);
}
console.log("Size:", stack.size); // Size: 3
const stackContent = [];
while (!stack.isEmpty) {
  stackContent.push(stack.pop() + " ");
}
console.log("Stack:", stackContent.join("")); // Stack: 3 2 1
