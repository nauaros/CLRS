public class MergeSort {


	/**
	 * Merge two sorted sublists into a single list
	 * @param A a list containing two sorted sublists
	 * @param p start index of first list
	 * @param q end index of first list
	 * @param r end index of second list
	 */
	public static void mergeWithSentinels(int A[], int p, int q, int r) {
		int i, j, k;

		int n1 = q - p + 1;
		int n2 = r - q;

		int L[] = new int[n1 + 1];
		int R[] = new int[n2 + 1];

		for (i = 0; i < n1; i++)
			L[i] = A[p + i];

		for (j = 0; j < n2; j++)
			R[j] = A[q + j + 1];

		// Setting sentinels in last position of L and R
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;

		for (i = 0, j = 0, k = p; k <= r; k++) {
			if (L[i] <= R[j])
				A[k] = L[i++];
			else
				A[k] = R[j++];
		}
	}

	// Exercise 2.3-2

	/**
	 * Merge two sorted sublists into a single list
	 * @param A a list containing two sorted sublists
	 * @param p start index of first list
	 * @param q end index of first list
	 * @param r end index of second list
	 */
	public static void merge(int A[], int p, int q, int r) {
		int i, j, k;

		int n1 = q - p + 1;
		int n2 = r - q;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = A[p + i];

		for (j = 0; j < n2; j++)
			R[j] = A[q + j + 1];

		for (i = 0, j = 0, k = p; k <= r; k++) {
			if (i == n1)
				A[k] = R[j++];
			else if (j == n2)
				A[k] = L[i++];
			else if (L[i] <= R[j])
				A[k] = L[i++];
			else
				A[k] = R[j++];
		}
	} 

	public static void merge_sort(int A[], int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(A, p, q);
			merge_sort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}

	public static void merger_sort(int A[]) {
		merge_sort(A, 0, A.length - 1);
	}

}