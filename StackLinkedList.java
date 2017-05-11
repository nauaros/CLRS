// CHAPTER 10

public class StackLinkedList {

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

	/**
	 * Adds an element at the beginning of
	 * the list.
	 *
	 * Running Time: O(1)
	 */
	public void push(int k) {
		Node node = new Node(k);

		node.next = head;
		if ( head != null ) {
			head.prev = node;
		}

		head = node;
		head.prev = null;
	}

	/**
	 * Removes the first element of the
	 * list
	 *
	 * Running Time: O(1)
	 */
	public int pop() {

		if (head == null) {
			System.out.println("The Stack is empty.");
			System.exit(1);
		}

		int x = head.key;
		head = head.next;
		head.prev = null;
		return x;
	}

	/**
	 * Function to print the content of a Linked
	 * List
	 *
	 * Running Time:O(n)
	 */
	public void printStack() {
		Node runner = head;
		while (runner != null) {
			System.out.print(runner.key + " ");
			runner = runner.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		StackLinkedList S = new StackLinkedList();
		S.push(1);
		S.push(2);
		S.push(3);
		S.printStack();
		S.pop();
		S.printStack();
	}
}