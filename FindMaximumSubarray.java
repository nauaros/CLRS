// A Divide and Conquer program to find the Maximum Subarray Sum
//
// Time Complexity: T(n) = 2T(n/2) + O(n) = O(n * lg(n))

public class FindMaximumSubarray {

	/**
	 * Find the maximum subarray sum that crosses the mid point.
	 * @param A array
	 * @param low start index of left subarray
	 * @param mid end index of right subarray
	 * @param high end index of right subarray
	 * @return Maximum subarray sum crossing the mid point
	 */
	public static int findMaxCrossingSubarraySum(int[] A, int low, int mid, int high) {
		int left_sum = Integer.MIN_VALUE;
		int sum = 0, max_left, max_right;

		for (int i = mid; i >= low; i--) {
			sum += A[i];
			if (sum > left_sum) {
				left_sum = sum;
				max_left = i;
			}
		}

		int right_sum = Integer.MIN_VALUE;
		sum = 0;

		for (int j = mid + 1; j <= high; j++) {
			sum += A[j];
			if (sum > right_sum) {
				right_sum = sum;
				max_right = j;
			}
		}

		return left_sum + right_sum;
	}

	/**
	 * Find the maximum subarray sum of A
	 * @param A array
	 * @param low start index of array
	 * @param hight end index of array
	 * @return maximum subarray sum
	 */
	public static int findMaximumSubarraySum(int[] A, int low, int high) {

		// Base case: Only one element
		if (low == high)
			return A[low];
		else {

			// Find mid point
			int mid = (low + high) / 2;

			// Divide and Conquer
			int leftHalf = findMaximumSubarraySum(A, low, mid);
			int rightHalf = findMaximumSubarraySum(A, mid + 1, high);

			// Combine Part
			int crossSubarray = findMaxCrossingSubarraySum(A, low, mid, high);

			// Return maximum of the three possible cases
			if (leftHalf > rightHalf && leftHalf > crossSubarray)
				return leftHalf;
			else if (rightHalf > leftHalf && rightHalf > crossSubarray)
				return rightHalf;
			else
				return crossSubarray;
		}
	}

	/**
	 * Brute force algorithm to find the maximum subarray sum.
	 * @param A array
	 * @param low start index of array
	 * @param high end index of array
	 * @return maximum subarray sum
	 *
	 * Time Complexity: O(n^2)
	 */
	public static int findMaximumSubarraySumBruteForce(int[] A, int low, int high) {
		int left = 0, right = 0, i, j;
		int maxSum = Integer.MIN_VALUE, sum;

		for (i = low; i <= high; i++) {
			sum = 0;
			for (j = i; j <= high; j++) {
				sum += A[j];

				if (maxSum < sum) {
					maxSum = sum;
					left = i;
					right = j;
				}
			}
			
		}

		return maxSum;
	}

	// Test program
	public static void main(String[] args) {
		int[] A = {-2, -5, 6, -2, -3, 1, 5, -6};	// Result: 7
		int maximumSubarraySum = findMaximumSubarraySum(A, 0, A.length - 1);
		System.out.println(maximumSubarraySum);
	}
}