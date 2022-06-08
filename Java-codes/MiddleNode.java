/*
	This is an implementation that shows how
	to efficiently get to the middle node 
	of a singly linked list whose size is not 
	known in advance.
	Each linked list node has an integer value
	as well as a next pointer that points to 
	the next node or null in case of tail of list.
	
	Let n be the number of nodes in the list.
	Time complexity: O(n) 
	Space complexity: O(1)
*/
public class MiddleNode {
	private ListNode head;
	public MiddleNode() {
		/*
		 * Create below linked list
		 * 0 -> 1 -> 2 -> 3 -> 4
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
		MiddleNode application = new MiddleNode();
		ListNode middleNode = application.findMiddleNode();
		System.out.println(middleNode.val); // 2
	}
	// Two pointers are maintained, namely fastPtr and slowPtr.
	// fastPtr advances by 2 steps every time
	// while the slow one by 1 step only.
	public ListNode findMiddleNode() {
		ListNode slowPtr = head, fastPtr = head;
		// By the time the fastPtr reaches the end of list
		// the slowPtr would reach the middle node
		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
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
