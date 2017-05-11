// CHAPTER 10

public class SinglyLinkedList {

	private Node head;	// head of list
	
	private class Node {
		int key;
		Node next;

		// Constructor of Node with a given key
		public Node(int k) {
			key = k;
			next = null;
		}
	}

	/**
	 * Function to search a node with a given
	 * key in a linked list.
	 *
	 * Worst case Running time: O(n)
	 */
	private Node listSearch(int k) {
		Node x = head;
		while (x != null && x.key != k) {
			x = x.next;
		}

		return x;
	}

	/**
	 * Function to insert a node onto
	 * the front of the linked list.
	 *
	 * Running Time: O(1)
	 */
	public void listInsert(int k) {
		Node node = new Node(k);	// Create new node

		node.next = head;
		head = node;
	}

	/**
	 * Function to delete a given Node reference.
	 *
	 * Worst-case Running time: O(n)
	 */
	public void listDelete(Node x) {
		Node prev = null, runner = head;

		if ( runner == x ) {
			head = runner.next;
		} else {

			while ( runner != x ) {
				prev = runner;
				runner = runner.next;
			}

			if ( runner == null )
				return;

			prev.next = runner.next;
			runner.next = null;
		}
	}

	/**
	 * Function to delete a given key.
	 * We first call listSearch() in order to
	 * find the Node the given key, then we call
	 * listDelete() to delete that Node.
	 *
	 * Worst-case Running time: O(n)
	 */
	public void listDeleteKey(int k) {
		Node x = listSearch(k);
		listDelete(x);
	}

	/**
	 * Reverse a singly linked list
	 *
	 * Running Time: O(n)
	 */
	public void reverse() {
		if (head == null) {
			System.out.println("ERROR The list is empty.");
			System.exit(1);
		}

		Node prev = null;
		Node current = head;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
		prev = null;

	}

	/**
	 * Function to print the content of a Linked
	 * List
	 *
	 * Running Time:O(n)
	 */
	public void printList() {
		Node runner = head;
		while (runner != null) {
			System.out.print(runner.key + " ");
			runner = runner.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		SinglyLinkedList L = new SinglyLinkedList();
		L.listInsert(0);
		L.listInsert(1);
		L.listInsert(2);
		L.listInsert(3);
		L.listInsert(4);
		L.listInsert(5);
		L.listInsert(6);
		L.printList();
		L.reverse();

		L.printList();
	}
}