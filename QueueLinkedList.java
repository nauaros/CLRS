// CHAPTER 10

public class QueueLinkedList {

	private Node tail;
	private Node head;

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

	public QueueLinkedList() {
		// We keep a sentinel at the head of the queue
		Node sentinel = new Node(Integer.MIN_VALUE);
		head = sentinel;
	}

	/**
	 * Adds an element at the beginning of the linked list.
	 *
	 * Running Time: O(1);
	 */
	public void enQueue(int k) {
		Node node = new Node(k);

		node.next = tail;

		if ( tail != null ) {
			tail.prev = node;
		} else {
			node.next = head;
			head.prev = node;
		}

		tail = node;
		node.prev = null;
	}

	/**
	 * Removes an element from the end of the linked list.
	 *
	 * Running Time: O(1);
	 */
	public int deQueue() {
		if ( tail == null ) {
			System.out.println("ERROR There're no elements in the queue.");
			System.exit(0);
		}

		Node x = head.prev;
		int n = x.key;

		x.prev.next = head;
		head.prev = x.prev;

		return n;
	}

	/**
	 * Function to print the content of the Queue.
	 *
	 * Running Time:O(n)
	 */
	public void printQueue() {
		Node runner = tail;
		while (runner != head) {
			System.out.print(runner.key + " ");
			runner = runner.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QueueLinkedList queue = new QueueLinkedList();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.printQueue();
		
		queue.deQueue();
		queue.deQueue();
		queue.printQueue();
	}

}