/*
  This implementation demonstrates how to 
  merge two sorted lists into an aggregate
  sorted one. 

  Let n be the number of elements of first
  singly linked list and m the number of 
  elements of the second one.

  Time complexity: O(n + m)
  Space complexity: O(1)
*/
function mergeLinkedLists(headOne, headTwo) {
  let ptr1 = headOne;
  let ptr1Prev = null;
  let ptr2 = headTwo;

  while (ptr1 !== null && ptr2 !== null) {
    // If smaller value belongs to first list
    // advance to next node in first list
    if (ptr1.value < ptr2.value) {
      ptr1Prev = ptr1;
      ptr1 = ptr1.next;
    } else {
      // Otherwise, advance to next node in second
      if (ptr1Prev !== null) ptr1Prev.next = ptr2;
      ptr1Prev = ptr2;
      ptr2 = ptr2.next;
      ptr1Prev.next = ptr1;
    }
  }
  if (ptr1 === null) ptr1Prev.next = ptr2;
  return headOne.value < headTwo.value ? headOne : headTwo;
}

class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class LinkedList {
  constructor() {
    this.head = null;
  }

  // Add a value at end of list
  addEnd(value) {
    const node = new Node(value);
    let curr = this.head;
    if (curr == null) {
      this.head = node;
      return;
    }

    while (curr !== null && curr.next !== null) {
      curr = curr.next;
    }

    curr.next = node;
  }
}

const list1 = new LinkedList();
const list2 = new LinkedList();
const aggregateList = new LinkedList();

list1.addEnd(1);
list1.addEnd(4);
list1.addEnd(6);
list2.addEnd(2);
list2.addEnd(5);

aggregateList.head = mergeLinkedLists(list1.head, list2.head);
let temp = aggregateList.head;
const aggregateListContent = [];
while (temp !== null) {
  aggregateListContent.push(temp.value + " ");
  temp = temp.next;
}
// Below prints: 1 2 4 5 6
console.log("Aggregate list:", aggregateListContent.join(""));
