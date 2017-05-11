// CHAPTER 9

public class MinimumMaximum {

	/**
	 * This is the optimal algorithm to find the minimum or
	 * maximum of a set of elements.
	 *
	 * Worst case Running Time = O(n)
	 */
	public static int minimum(int[] A) {
		int min = A[0];
		for (int i = 1; i < A.length; i++) {
			if (min > A[i])
				min = A[i];
		}

		return min;
	} 

	/**
	 * Algorithm to find the minimum and maximum simultaneously of
	 * a given array.
	 * 
	 * It takes 3 * (n - 2)/2 comparisons if A.length is even
	 * It takes 3 * (n - 1)/2 comparisons if A.length is odd
	 *
	 * If we used the same pattern as in "minimum" algorithm to find both the
	 * minimum and the maximum, it'd required 2n - 2 comparisons.
	 */
	public static int[] MinMax(int[] A) {
		int min, max, j;
		if (A.length % 2 != 0) {
			min = A[0];
			max = A[0];
			j = 2;
		} else {
			if (A[0] < A[1]) {
				min = A[0];
				max = A[1];
			} else {
				min = A[1];
				max = A[0];
			}
			j = 2;
		}

		for (int i = j; i < A.length; i+=2) {
			if (A[i] < A[i + 1]) {
				if (min > A[i])
					min = A[i];
				if (max < A[i + 1])
					max = A[i + 1];
			} else {
				if (min > A[i + 1])
					min = A[i + 1];
				if (max < A[i])
					max = A[i];
			}
		}

		int[] minMax = new int[2];
		minMax[0] = min;
		minMax[1] = max;

		return minMax;
	}

	public static void main(String[] args) {
		int[] A = {3, 1, 39, 7, 5, 4, 0, -8};
		int[] B = MinMax(A);
		System.out.printf("%d, %d\n\n", B[0], B[1]);
	}
}