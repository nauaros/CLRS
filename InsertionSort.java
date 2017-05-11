class InsertionSort {

	static int[] addBinary(int A[], int B[]) {
		int C[] = new int[A.length + 1];
		int i, carry = 0;

		for (i = 0; i < A.length; i++) {
			C[i] = (A[i] + B[i] + carry) % 2;	// remainder
			carry = (A[i] + B[i] + carry) / 2;	// quotient
		}
		C[i] = carry;

		return C;
	}

	static int linearSearch(int A[], int v) {
		int i;
		for (i = 0; i < A.length; i++) {
			if (v == A[i])
				return i;
		}
		return -1;
	}

	static void reverseInsertionSort(int A[]) {
		int i, j, key;
		for (j = 1; j < A.length; j++) {
			key = A[j];
			i = j - 1;
			while (i > -1 && A[i] < key) {
				A[i + 1] = A[i];
				i = i - 1;
			}
			A[i + 1] = key;
		}
	}

	static void insertionSort(int A[]) {
		int i, j, key;
		for (j = 1; j < A.length; j++) {
			key = A[j];
			i = j - 1;
			while (i > -1 && A[i] > key) {
				A[i + 1] = A[i];
				i = i - 1;
			}
			A[i + 1] = key;
		}
	}

	static void selectionSort(int A[]) {
		int i, j, min, tmp;
		for (i = 0; i < A.length - 1; i++) {
			min = i;
			for (j = i + 1; j < A.length; j++) {
				if (A[j] < A[min]) {
					min = j;
				}
			}
			tmp = A[i];
			A[i] = A[min];
			A[min] = tmp;
		}
	}

	static void merge(int A[], int p, int q, int r) {
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

	static void merge_sort(int A[], int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(A, p, q);
			merge_sort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}

	public static void main(String args[]) {
		int A[] = {6, 3, 1, 6,8, 4, 6, 23, 66, 99, 11, 23, 16};

		merge_sort(A, 0, A.length - 1);

		print(A);
	}

	static void print(int A[]) {
		int i;
		for(i = 0; i < A.length; i++) {
			System.out.printf("%d ", A[i]);
		}
		System.out.printf("\n");
	}
}