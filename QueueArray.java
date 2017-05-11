// CHAPTER 10


/**
 * Implementation of a Queue using an
 * Array instead of Linked List.
 */
public class QueueArray {

	private int[] Q;
	private int tail;
	private int head;

	public QueueArray(int n) {
		Q = new int[n];
		tail = 0;
		head = -1;
	}

	/**
	 * Function to add an item to the Queue's tail.
	 * Running time: O(1)
	 */
	public void enQueue(int x) {

		// Check for overflow condition
		if ( tail == head ) {
			System.out.println("Error Overflow");
			System.exit(1);
		}

		Q[tail] = x;

		if ( head == -1 )
			head = tail;

		if ( tail == Q.length - 1 )
			tail = 0;
		else
			tail = tail + 1;
	}

	/**
	 * Function to remove an item from the Queue's head.
	 * Running time: O(1)
	 */
	public int deQueue() {

		// Check for underflow condition
		if ( head == -1 ) {
			System.out.println("Error Underflow");
			System.exit(1);
		}

		int x = Q[head];

		if ( head == Q.length - 1 )
			head = 0;
		else if ( head == tail ) 	// the queue is empty again
			head = -1;
		else
			head = head + 1;

		return x;
	}

	/** 
	 * Function to return the Queue's head.
	 * Running time: O(1);
	 */
	public int headQueue() {
		// Check if queue is empty
		if ( head == -1 )
			return Integer.MIN_VALUE;
		else
			return Q[head];
	}

	/** 
	 * Function to return the Queue's tail.
	 * Running tail: O(1);
	 */
	public int tailQueue() {
		// Check if queue is empty
		if ( head == -1 )
			return Integer.MIN_VALUE;
		else
			return Q[tail - 1];
	}

	/** 
	 * Function to print the contents of the stack.
	 *
	 * HEAD-x-x-x-x-x-x-x-x-x-x-TAIL
	 *
	 * Running Time:O(num of elements in queue) --> O(n)
	 */
	public void printQueue() {
		int localHead = head;
		int localTail = tail;

		while (localHead != localTail) {
			System.out.print(Q[localHead] + " ");
			localHead = (localHead + 1) % Q.length;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QueueArray queue = new QueueArray(10);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.deQueue();
		queue.deQueue();
		queue.printQueue();
	}
}