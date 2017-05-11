/**
* CLRS: Chapter 6
* 01-31-2016
* @author Naufal Aros
*/

public class HeapSort {

	private static int n;

	/** 
	 * Returns parent of node i in the heap.
	 * @param i heap's node
	 */
	static int parent(int i) {
		return (i / 2);
	}

	/** 
	 * Returns left child of node i in the heap.
	 * @param i heap's node
	 */
	static int left(int i) {
		return (2 * i);
	}

	/** 
	 * Returns right child of node i in the heap.
	 * @param i heap's node
	 */
	static int right(int i) {
		return (2 * i + 1);
	}

	/**
	 * Maintaining the heap property.
	 * In order to mantain the max-heap property, we call maxHeapify.
	 * @param A array representation of the Max-heap.
	 * @param i heap's node where we start to mantain the max-heap property.
	 *
	 * Running time: O( lg n )
	 */
	static void maxHeapify(int[] A, int i) {
		int l = left(i);
		int r = right(i);
		int largest;

		if ( l < n && A[l] > A[i] )
			largest = l;
		else
			largest = i;

		if ( r < n && A[r] > A[largest] )
			largest = r;

		if ( largest != i ) {
			exchange(A, i, largest);
			maxHeapify(A, largest); 
		}
	}

	/**
	 * Maintaining the heap property.
	 * In order to mantain the min-heap property, we call minHeapify.
	 * @param A array representation of the Min-heap.
	 * @param i heap's node where we start to mantain the min-heap property.
	 *
	 * Running time: O( lg n )
	 */
	static void minHeapify(int[] A, int i) {
		int l = left(i);
		int r = right(i);
		int smallest;

		if ( l < n && A[l] < A[i])
			smallest = l;
		else 
			smallest = i;

		if ( r < n && A[r] < A[smallest] )
			smallest = r;

		if ( smallest != i) {
			exchange(A, i, smallest);
			minHeapify(A, smallest);
		}
	}

	/**
	 * Converts an array A[0 ... n] into a Max-heap.
	 * Elementes in the subarray A[(n/2 + 1) ... n] are all leaves of the tree.
	 * @param A array
	 */
	static void buildMaxHeap(int[] A) {
		n = A.length - 1;
		for (int i = (n / 2) - 1; i >= 0; i--)
			maxHeapify(A, i);
	}

	/**
	 * Converts an array A[0 ... n] into a Min-heap.
	 * Elementes in the subarray A[(n/2 + 1) ... n] are all leaves of the tree.
	 * @param A array
	 */
	static void buildMinHeap(int[] A) {
		n = A.length - 1;
		for (int i = (n / 2) - 1; i >= 0; i--)
			minHeapify(A, i);
	}

	/**
	 * Sort an array in increasing order using the HeapSort algorithm.
	 * Running Time: O(n * lg n)
	 *
	 * @param A array to sort
	 */
	static void heapSortIncreasing(int[] A) {
		buildMaxHeap(A);	// we build a max-heap so that the root is the greatest element of the array.
		for (int i = n; i > 1; i--) {
			// Exchange the first element with the last element in the array.
			exchange(A, 0, i);
			// Heapify the array so that the max-property holds.
			n = n - 1;
			maxHeapify(A, 0);
		}
	}

	/**
	 * Sort an array in decreasing order using the HeapSort algorithm.
	 * Running Time: O(n * lg n)
	 *
	 * @param A array to sort
	 */
	static void heapSortDecreasing(int[] A) {
		buildMinHeap(A);	// we build a min-heap so that the root is the smallest element of the array.
		for (int i = n; i > 1; i--) {
			// Exchange the first element with the last element in the array.
			exchange(A, 0, i);
			// Heapify the array so that the min-property holds.
			n = n - 1;
			minHeapify(A, 0);
		}
	}

	// A priority queue is a data structure for maintaining a set S of elements,
	// each with an associated value called a key. A max-priority queue support the
	// operations of Insert(S, x), Maximum(S), Extract-Max(S) and Increase-Key(S, x, k)

	/**
	 * Return the maximum of the heap.
	 * Running time: O(1)
	 */
	static int heapMaxium(int[] A) {
		buildMaxHeap(A);
		return A[0];
	}

	/**
	 * Removes and returns the maximum of the array
	 * Running time: O(lg n)
	 */
	static int heapExtractMax(int[] A) {
		buildMaxHeap(A);
		if (A.length < 0) {
			System.out.println("Head underflow");
			return;
		}

		buildMaxHeap(A);
		int max = A[0];
		A[0] = A[A.length - 1];
		maxHeapify(A, 0);
		return max;
	}

	/**
	 * Increase the key of a given node in the head.
	 * Running time: O(lg n)
	 *
	 * @param A array
	 * @param i node
	 * @param key new key
	 */
	static void heapIncreaseKey(int[] A,int i,int key) {
		buildMaxHeap(A);
		if ( key < A[i]) {
			System.out.println("New key is smaller than current key");
			return;
		}

		A[i] = key;
		while (i > 0 && A[parent(i)] < A[i]) {
			exchange(A, parent(i), i);
			i = parent(i);
		}
	}

	/**
	 * Return the minimum of the heap.
	 * Running time: O(1)
	 */
	static int heapMininum(int[] A) {
		buildMinHeap(A);
		return A[i];
	}

	/**
	 * Removes and returns the minimum of the array
	 * Running time: O(lg n)
	 */
	static int heapExtractMin(int[] A) {
		buildMaxHeap(A);
		if (A.length < 0) {
			System.out.println("Head underflow");
			return;
		}

		buildMinHeap(A);
		int min = A[0];
		A[0] = A[A.length - 1];
		minHeapify(A, 0);
		return min;
	}

	/**
	 * Decrease the key of a given node in the head.
	 * Running time: O(lg n)
	 *
	 * @param A array
	 * @param i node
	 * @param key new key
	 */
	static void heapDecreaseKey(int[] A,int i,int key) {
		buildMaxHeap(A);
		if ( key < A[i]) {
			System.out.println("New key is larger than current key");
			return;
		}

		A[i] = key;
		while (i > 0 && A[parent(i)] > A[i]) {
			exchange(A, parent(i), i);
			i = parent(i);
		}
	}

	// *********************************************************************************************************************

	// TEST-CASE
	public static void main(String[] args) {
		int A[] = {9, 8, 7 , 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -6};
		heapSortIncreasing(A);
		printArray(A);
		heapSortDecreasing(A);
		printArray(A);
	}

		// Helper method
	static void exchange(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	// Helper method
	static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}


}