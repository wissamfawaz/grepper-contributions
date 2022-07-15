/*
	This implementation demonstrates how to 
	efficiently shift a singly linked list
	in place by k positions.

	Example: 
	shifting 0-> 1 -> 2 -> 3 -> 4-> null 
	by 2 positions yields: 
	3 -> 4 -> 0 -> 1 -> 2 -> null

	
	Let n be the number of nodes in the list.
	Time complexity: O(n) 
	Space complexity: O(1)
*/
public class LinkedListShifting {
	private ListNode head;

	public LinkedListShifting() {
		/*
		 * Create below linked list
		 * 0 -> 1 -> 2 -> 3 -> 4 -> null
		 */
		head = new ListNode(0, null);
		ListNode prev = head, temp;
		for (int i = 1; i <= 4; i++) {
			temp = new ListNode(i, null);
			prev.next = temp;
			prev = temp;
		}
	}

	public static void main(String[] args) {
		LinkedListShifting application = new LinkedListShifting();
		application.head = application.shiftLinkedList(2);
		System.out.println(application.head.val); // 3
	}

	public ListNode shiftLinkedList(int k) {
		if (head == null) {
			return null;
		}
		int length = 1;
		ListNode listTail = head;
		// Count the number of list nodes
		while (listTail.next != null) {
			listTail = listTail.next;
			length++;
		}
		// The offset should less than length
		int offset = Math.abs(k) % length;
		if (offset == 0)
			return head; // no shifting is needed
		int newTailPosition = k > 0 ? length - offset : offset;
		ListNode newTail = head;
		for (int i = 1; i < newTailPosition; i++) {
			newTail = newTail.next;
		}
		ListNode newHead = newTail.next;
		newTail.next = null;
		listTail.next = head;
		return newHead;
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
