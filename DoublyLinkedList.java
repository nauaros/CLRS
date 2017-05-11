// CHAPTER 10

public class DoublyLinkedList {

	private Node head;	// Head of list

	private class Node {
		int key;
		Node prev;
		Node next;

		Node(int k) {
			key = k;
			prev = null;
			next = null;
		}
	}

	/**
	 * Function to search a node with a given
	 * key in a linked list.
	 *
	 * Worst case Running time: O(n)
	 */
	public Node listSearch(int k) {
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
		if ( head != null ) {
			head.prev = node;
		}

		head = node;
		node.prev = null;
	}

	/**
	 * Function to delete a given Node reference.
	 *
	 * Running time: O(1)
	 */
	public void listDelete(Node x) {
		
		if (x.prev != null)
			x.prev.next = x.next;
		else
			head = x.next;

		if (x.next != null)
			x.next.prev = x.prev;
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
		DoublyLinkedList L = new DoublyLinkedList();
		L.listInsert(0);
		L.listInsert(1);
		L.listInsert(2);
		L.listInsert(3);
		L.listInsert(4);
		L.listInsert(5);
		L.listDeleteKey(3);
		L.listDeleteKey(0);
		L.listInsert(99);

		L.printList();
	}
}