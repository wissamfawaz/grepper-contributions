/*
	This is an implementation that shows how
	to efficiently find the node from which 
	a loop originates in a singly linked list 
	that contains one.
	
	Let n be the number of nodes in the list.
	Time complexity: O(n) 
	Space complexity: O(1)
*/
public class FindLoop {
	private ListNode head;

	public FindLoop() {
		/*
		 * Create below linked list
		 * 0 -> 1 -> 2 -> 3 -> 4 -> 2
		 */
		head = new ListNode(0, null);
		ListNode loopNode = null, prev = head, temp;
		for (int i = 1; i <= 4; i++) {
			temp = new ListNode(i, null);
			if (i == 2) {
				loopNode = temp;
			}
			prev.next = temp;
			prev = temp;
		}
		prev.next = loopNode;
	}

	public static void main(String[] args) {
		FindLoop application = new FindLoop();
		ListNode middleNode = application.findLoopNode();
		System.out.println(middleNode.val); // 2
	}

	// Two pointers are maintained, namely fastPtr and slowPtr.
	// fastPtr advances by 2 steps every time
	// while the slow one by 1 step only.
	public ListNode findLoopNode() {
		ListNode slowPtr = head, fastPtr = head;
		// Loop until the fastPtr reaches the slowPtr
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if (slowPtr == fastPtr) {
				break;
			}
		}
		// Reset the slowPtr to head
		slowPtr = head;
		// Loop until they cross again.
		while (slowPtr != fastPtr) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}

		return fastPtr;
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
