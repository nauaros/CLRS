public class QuickSort {

	/**
	 * Partitioning the array. Choose the best possible pivot.
	 * Running time: O(n)
	 *
	 * @param A array
	 * @param p first index of array A
	 * @param r end index of array A
	 * @return pivot with which we partition the array
	 */
	public static int partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;

		for (int j = p; j < r; j++) {
			if ( A[j] <= x ) {
				i = i + 1;
				exchange(A, i, j);
			}
		}

		exchange(A, i + 1, r);
		return i + 1;
	}

	/**
	 * Quicksort algorithm for sorting an array
	 * in increasing order.
	 *
	 * Worst-case running time: O(n^2)
	 * Expected running time: O(n * lg n)
	 * Quicksort sorts in place.
	 *
	 * To sort in decreasing order, we need to change the condition <= by >=
	 * in the partition procedure.
	 */
	public static void quickSort(int[] A, int p, int r) {
		if ( p < r ) {
			int q = partition(A, p, r);
			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
		}
	}

	/**
	 * Generates a random index i of the array.
	 * Exchange last element with random i-th element.
	 * Call partition method.
	 *
	 * Running time: O(n)
	 *
	 * @param A array
	 * @param p first index of array A
	 * @param r end index of array A
	 * @return pivot with which we partition the array
	 */
	public static int randomizedPartition(int[] A, int p, int r) {
		int i = random(p, r);
		exchange(A, i, r);
		return partition(A, p, r);
	}

	/**
	 * Randomized Quicksort algorithm for sorting an array
	 * in increasing order.
	 *
	 * Worst-case running time: O(n^2)
	 * Expected running time: O(n * lg n)
	 * Randomized Quicksort sorts in place.
	 *
	 * To sort in decreasing order, we need to change the condition <= by >=
	 * in the partition procedure.
	 */
	public static void randomizedQuickSort(int[] A, int p, int r) {
		if ( p < r ) {
			int q = randomizedPartition(A, p, r);
			randomizedQuickSort(A, p, q - 1);
			randomizedQuickSort(A, q + 1, r);
		}
	}


	// ====================================================================================================================================

	// TEST-CASE
	public static void main(String[] args) {
		System.out.println("Test - QuickSort");
		int A[] = {9, 8, 7 , 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -6};
		quickSort(A, 0, A.length - 1);
		printArray(A);

		System.out.println();

		System.out.println("Test - Randomized QuickSort");
		int B[] = {9, 8, 7 , 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -6};
		randomizedQuickSort(B, 0, B.length - 1);
		printArray(B);

		System.out.println("\nBoth algorithms have the same running time: O(n^2) - worst-case / O(n * lg n) - expected running time.\n");

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

	// Helper method
	static int random(int i, int j) {
		return i + (int)(Math.random() * ((j - i) + 1));
	}
}