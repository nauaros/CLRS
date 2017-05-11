// CHAPTER 10

public class CircularDoublyLinkedList {

	private Node header;	// Head of CircularList

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

	public CircularDoublyLinkedList() {
		header = new Node(Integer.MIN_VALUE);
	}

	/**
	 * Function to insert a node onto
	 * the front of the linked list.
	 *
	 * Running Time: O(1)
	 */
	public void listInsert(int k) {
		Node node = new Node(k);

		if (header.prev == null && header.next == null) {
			header.prev = node;
			node.next = header;
		} else {
			node.next = header.next;
			header.next.prev = node;
		}

		header.next = node;
		node.prev = node;
	}

	/**
	 * Function to delete a given Node reference.
	 *
	 * Running time: O(1)
	 */
	public void listDelete(Node x) {
		x.prev.next = x.next;
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
		listDelete( listSearch(k) );
	}

	/**
	 * Function to search a node with a given
	 * key in a linked list.
	 *
	 * Worst case Running time: O(n)
	 */
	public Node listSearch(int k) {
		Node x = header.next;
		while (x != header && x.key != k) {
			x = x.next;
		}

		return x;
	}

	/**
	 * Function to print the content of a Linked
	 * List
	 *
	 * Running Time:O(n)
	 */
	public void printList() {
		Node x = header.next;
		while (x != header) {
			System.out.print(x.key + " ");
			x = x.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		CircularDoublyLinkedList L = new CircularDoublyLinkedList();
		L.listInsert(1);
		L.listInsert(2);
		L.listInsert(3);
		L.listInsert(3);
		L.listInsert(4);
		L.listInsert(5);
		L.printList();
		L.listDeleteKey(1);
		L.listDeleteKey(2);
		L.listDeleteKey(3);
		L.printList();
	}

}