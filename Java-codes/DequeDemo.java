/*
	This implementation shows how to use a Deque
	object as a stack and then how to use it
	as a queue.

	Time complexity of methods used: O(1)
*/
import java.util.Deque;
import java.util.ArrayDeque;

public class DequeDemo {
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();
		// Deque as stack
		deque.push(4); // Insert a new top element
		deque.push(3);
		// Pop top element from stack
		System.out.println(deque.getFirst()); // 3
		deque.pop();
		System.out.println(deque.pop()); // 4

		// Deque as Queue
		deque.add(5); // Enqueue an element
		deque.add(2);
		System.out.println(deque.getFirst()); // 5
		// Dequeue the front element of queue
		deque.removeFirst();
		System.out.println(deque.removeFirst()); // 2
	}
}
