// CHAPTER 9

public class RandomizedSelect {

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
	 * Randomized recursive algorithm that return the
	 * i-th smallest element in a given array A.
	 *
	 * Expected Running Time: O(n)
	 *
	 * @param A array
	 * @param p first index of A
	 * @param r last index of A
	 * @param i i-th smallest element
	 */
	public static int randomizedSelection(int[] A, int p, int r, int i) {
		if (p == r)		// Base case of the recursion
			return A[p];

		int q = randomizedPartition(A, p, r);
		int k = q - p + 1;		// number of elements in the low side of the partition + the pivot

		if ( i == k )
			return A[q];
		else if ( i < k )
			return randomizedSelection(A, p, q - 1, i);
		else
			return randomizedSelection(A, q + 1, r, r);
	}

	// =====================================================================================

	public static void main(String[] args) {
		int[] A = {0, 1, -9, -5, 8, 9};
		System.out.println(randomizedSelection(A, 0, A.length - 1, 1));
	}

	// Helper method
	static void exchange(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	// Helper method
	static int random(int i, int j) {
		return i + (int)(Math.random() * ((j - i) + 1));
	}
}