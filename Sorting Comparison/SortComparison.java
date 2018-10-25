import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Vahe Sasunts
 * @version HT 2018
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {
		double temp;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
		return a;
	}// end insertionsort

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	public static double[] numbers;
	static double[] quickSort(double a[]) {
		int number;
		if (a.length == 0) {
			return null;
		}
		numbers = a;
		number = a.length;
		sort(0, number - 1);
		return a;
	}

	private static void sort(int low, int high) {
		int i = low, j = high;

		double pivot = numbers[low + (high - low) / 2];

		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}
			while (numbers[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}

		if (low < j)
			sort(low, j);
		if (i < high)
			sort(i, high);
	}

	private static void exchange(int i, int j) {
		double temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	/**
	 * Sorts an array of doubles using Merge Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] mergeSort(double a[]) {
		double[] aux = new double[a.length];
		mergeSort(a, aux, 0, a.length - 1);
		return a;

	}// end mergesort

	private static void mergeSort(double[] a, double[] aux, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int mid = lo + (hi - lo) / 2;
		mergeSort(a, aux, lo, mid);
		mergeSort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(double[] a, double[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				a[k] = a[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * Sorts an array of doubles using Shell Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] shellSort(double a[]) {
		int N = a.length;
		int h = 1;

		while (h < N / 3) {
			h = (3 * h) + 1;
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && (a[j] < a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
		return a;
	}// end shellsort

	private static void exch(double[] a, int i, int j) {
		double swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {
		int n = a.length;

		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min_idx]) {
					min_idx = j;
				}
			}
			double temp = a[min_idx];
			a[min_idx] = a[i];
			a[i] = temp;
		}
		return a;
	}// end selectionsort

	/**
	 * Sorts an array of doubles using Bubble Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] bubbleSort(double a[]) {
		int n = a.length;
		double tmp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (a[j - 1] > a[j]) {
					tmp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = tmp;
				}
			}
		}
		return a;
	}// end bubblesort
	
	
	//All times taken by changing the tmp array to one of set arrays that are read in using the instream

//	public static double[] inStream(String arg) {
//		In stream = new In(arg);
//		double[] a1 = stream.readAllDoubles();
//		return a1;
//	}
//
//	static double[] arrayNumbers10 = inStream("numbers10.txt");
//	static double[] arrayNumbers100 = inStream("numbers100.txt");
//	static double[] arrayNumbers1000 = inStream("numbers1000.txt");
//	static double[] arrayNumbers1000Duplicates = inStream("numbers1000Duplicates.txt");
//	static double[] numbersNearlyOrdered1000 = inStream("numbersReverse1000.txt");
//	static double[] numbersReverse1000 = inStream("numbersReverse1000.txt");
//	static double[] numbersSorted1000 = inStream("numbersSorted1000.txt");
//
//	public static void main(String[] args) {
//		double[] tmp = numbersSorted1000;
//		long startTime = System.nanoTime();
//		SortComparison.insertionSort(tmp);
//		long endTime = System.nanoTime();
//		double totalTime = endTime - startTime;
//		System.out.println("Insert:10 Elapsed time in milliseconds: " + totalTime / 1000000 + "\n");
//		tmp = null;
//		startTime = 0;
//		endTime = 0;
//
//		tmp = numbersSorted1000;
//		startTime = System.nanoTime();
//		SortComparison.quickSort(tmp);
//		endTime = System.nanoTime();
//		totalTime = endTime - startTime;
//		System.out.println("Quick:10 Elapsed time in milliseconds: " + totalTime / 1000000 + "\n");
//		tmp = null;
//		startTime = 0;
//		endTime = 0;
//
//		tmp = numbersSorted1000;
//		startTime = System.nanoTime();
//		SortComparison.mergeSort(tmp);
//		endTime = System.nanoTime();
//		totalTime = endTime - startTime;
//		System.out.println("Merge:10 Elapsed time in milliseconds: " + totalTime / 1000000 + "\n");
//		tmp = null;
//		startTime = 0;
//		endTime = 0;
//
//		tmp = numbersSorted1000;
//		startTime = System.nanoTime();
//		SortComparison.shellSort(tmp);
//		endTime = System.nanoTime();
//		totalTime = endTime - startTime;
//		System.out.println("Shell:10 Elapsed time in milliseconds: " + totalTime / 1000000 + "\n");
//		tmp = null;
//		startTime = 0;
//		endTime = 0;
//
//		tmp = numbersSorted1000;
//		startTime = System.nanoTime();
//		SortComparison.selectionSort(tmp);
//		endTime = System.nanoTime();
//		totalTime = endTime - startTime;
//		System.out.println("Selection:10 Elapsed time in milliseconds: " + totalTime / 1000000 + "\n");
//		tmp = null;
//		startTime = 0;
//		endTime = 0;
//
//		tmp = numbersSorted1000;
//		startTime = System.nanoTime();
//		SortComparison.bubbleSort(tmp);
//		endTime = System.nanoTime();
//		totalTime = endTime - startTime;
//		System.out.println("Bubble:10 Elapsed time in milliseconds: " + totalTime / 1000000 + "\n");
//		tmp = null;
//		startTime = 0;
//		endTime = 0;
//
//	}

}// end class
