// CHAPTER 10

/**
 * Java implementation of a Stack
 * in which is possible to specify the
 * size
 * 
 * Operations: Stack-Empty, push, pop, peek, printStack
 */
public class StackArray {

	private int[] S;
	int capacity;
	int top;

	public StackArray(int n) {
		S = new int[n];
		top = -1;
	}

	/** 
	 * Function to determine if the stack is empty.
	 * Running time: O(1)
	 */
	public  boolean stackEmpty(StackArray S) {
		if (S.top == -1)
			return true;
		else
			return false;
	}

	/** 
	 * Function to add an item to the stack.
	 * Running time: O(1);
	 */
	public void push(int x) {
		if (top >= S.length - 1) {
			System.out.println("Error Overflow.");
			System.exit(1);
		}
		else {
			S[++top] = x;
		}
	}

	/** 
	 * Function to remove an item from stack.
	 * Running time: O(1);
	 */
	public int pop() {s
		int x = 0;
		if (top == -1) {
			System.out.println("Error Underflow.");
			System.exit(1);
		} else {
			x = S[top--];
		}

		return x;
	}

	/**
	 * Function to get top item from stack
	 * Running time: O(1)
	 */
	public int peek() {
		if (top == -1) {
			System.out.println("The stack is empty.");
			System.exit(1);
		} else {
			return S[top - 1];
		}
	}

	/**
	 * Function to print the Stack
	 * Worst-case Running Time: O(n)
	 */
	public void printStack() {
		for (int i = 0; i <= top; i++) {
			System.out.print(S[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StackArray stack = new StackArray(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println(stack.stackEmpty());
		
		int x = stack.pop();
		System.out.println(x);
		stack.printStack();
	}
}