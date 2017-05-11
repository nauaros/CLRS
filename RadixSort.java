public class RadixSort {

	/**
	 * Counting Sort modified so that it can be used in Radix Sort.
	 * See CountingSort.java for more details.
	 */
	public static void countingSort(int[] A, int div) {
		int[] C = new int[10];
		int[] B = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			C[ (A[i]/div) % 10 ]++;
		}

		for (int j = 1; j < C.length; j++) {
			C[j] = C[j] + C[j - 1];
		}

		for (int i = A.length - 1; i >= 0; i--) {
			B[ --C[ (A[i]/div) % 10 ] ] = A[i];
		}

		// Copy the output array B in the original array A
		for (int j = 0; j < A.length; j++) {
			A[j] = B[j];
		}
	}

	/**
	 * Radix Sort Algorithm
	 * Running time: O(d * (n + k))
	 * 
	 * @param A array to sort
	 */
	public static void radixSort(int[] A) {
		int max = max(A);

		for (int div = 1; max/div > 0; div *= 10) {
			countingSort(A, div);
		}
	}

	// =================================================================================

	// TEST - CASE
	public static void main(String[] args) {
		int[] A = {95, 73, 128, 541, 634};
		radixSort(A);
		printArray(A);
	}

	/**
	 * Print Array
	 *
	 * @param A array
	 */
	public static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Maximum elemnt of an array
	 *
	 * @param A array
	 * @return maximum element of an array
	 */
	public static int max(int[] A) {
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			max = (A[i] > max) ? A[i] : max;
		}

		return max;
	}
}