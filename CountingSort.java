public class CountingSort {

	/**
	 * Counting Sort Algorithm
	 * Running time: O(n + k)
	 * Runs in O(n) - linear time when k = O(n)
	 * Stable: YES - Numbers with the same value appear in the output
	 *				 array in the same order as they do in the input array.
	 *
	 * @param A input array
	 * @param k range of the input elements in A
	 */
	public static void countingSort(int[] A, int k) {
		int[] C = new int[k + 1];
		int[] B = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			C[A[i]] = C[A[i]] + 1;
		}

		for (int j = 1; j < k + 1; j++) {
			C[j] = C[j] + C[j - 1];
		}

		for (int i = A.length - 1; i >= 0; i--) {
			B[ C[A[i]] - 1 ] = A[i];
			C[A[i]] = C[A[i]] - 1;
		}

		// Copy the output array B in the original array A
		for (int j = 0; j < A.length; j++) {
			A[j] = B[j];
		}
	}

	// =================================================================================

	public static void main(String[] args) {
		int[] A = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		countingSort(A, 9);
		printArray(A);
	}

	public static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}