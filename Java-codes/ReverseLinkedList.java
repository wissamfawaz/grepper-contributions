
/*
	This is an implementation that shows how
	to reverse a singly linked list in place.
	Each linked list node has an integer value
	as well as a next pointer that points to 
	the next node or null in case of tail of list.
	
	Let n be the number of nodes in the list.
	Time complexity: O(n) 
	Space complexity: O(1)
*/

public class ReverseLinkedList {
	private ListNode head;

	public ReverseLinkedList() {
		/*
		 * Create below linked list
		 * 0 -> 1 -> 2 -> 3 -> 4 -> 5
		 */
		head = new ListNode(0, null);
		ListNode prev = head, temp;
		for (int i = 1; i <= 5; i++) {
			temp = new ListNode(i, null);
			prev.next = temp;
			prev = temp;
		}
	}

	// Print elements of linked list starting from head
	private void printLinkedList() {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ReverseLinkedList application = new ReverseLinkedList();
		application.printLinkedList(); // 0 1 2 3 4 5
		application.reverseList();
		application.printLinkedList(); // 5 4 3 2 1 0
	}

	public void reverseList() {
		if (head == null || head.next == null) {
			return;
		}

		// Three pointers are used to allow for
		// efficient reversal of the list
		ListNode previousNode = null;
		ListNode currentNode = head;
		ListNode nextNode;

		while (currentNode != null) {
			// Keep updating next, current, and
			// previous pointers properly until
			// end of list is reached.
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}
		// List has a new head
		head = previousNode;
	}

	// Class representing a linked list node
	// with pointers to value and next node

	private class ListNode {
		int val;
		ListNode next;

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
