import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Vahe Sasunts
 *  @version HT 2018
 *  
 *  --ALL TIMES ARE IN MILLISECONDS--
 * -----------------------------------------------------------------------------
 * 						| Insert | Quick | Merge | Shell | Selection | Bubble |
 * 10 Random			| 0.007  | 0.025 | 0.065 | 0.009 |   0.009   | 0.008  |
 * 100 Random			| 0.234  | 0.990 | 0.780 | 0.024 |   0.147   | 0.183  |
 * 1000 Random			| 8.530  | 11.903| 33.369| 0.234 |   5.514   | 10.649 | 
 * 1000 Few Unique		| 7.321  | 0.656 | 25.512| 0.255 |   5.322   | 7.378  |
 * 1000 Nearly Ordered	| 5.557  | 0.341 | 2.399 | 0.243 |   27.657  | 6.293  | 
 * 1000 Reverse Ordered	| 7.507  | 0.381 | 2.231 | 0.585 |   7.355   | 13.473 |
 * 1000 sorted			| 5.487  | 0.615 | 2.382 | 0.310 |   29.805  | 5.802  |
 * ----------------------------------------------------------------------------
 *  1. Which of the sorting algorithms does the order of input have an impact on? Why?
 *  
 *  From my results I can see that merge sort has the biggest difference in terms of a random input compared to a sorted input
 *  I think this is the case as merge sort divides the arrays and sorts them but since the random inputs need to be all sorted
 *  and the sorted one only divides then merges back without the need to sort them as they are sorted.
 *  
 *	2. Which algorithm has the biggest difference between the best and worst performance, based
 *  on the type of input, for the input of size 1000? Why?
 *  
 *  Again from my results merge sort is clearly showing the biggest difference in performance, this is once again because merge sort 
 *  divides the arrays up and has to merge again and the random input is resource intensive compared to the other inputs.
 * 
 *  3. Which algorithm has the best/worst scalability, ie, the difference in performance time based
 *  on the input size? Please consider only input files with random order for this answer.
 *  
 *  From my results I think that shell sort has the best scalability as results remain consistently fast.
 *  For the worst scalability I think merge sort as once the input size increases then the result increases drastically.
 *  
 *  4. Which algorithm is the fastest for each of the 7 input files? 
 *  
 *  From my results it is clear to see that shell sort is the fastest.
 *  
 *  
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] array = {};
		SortComparison.insertionSort(array);
		SortComparison.quickSort(array);
		SortComparison.mergeSort(array);
		SortComparison.shellSort(array);
		SortComparison.selectionSort(array);
		SortComparison.bubbleSort(array);
    }


    @Test
	public void testInsertionSort() {
		double[] test = { 1, 7, 6, 2, 3, 4, 0, 5};
		double[] result = SortComparison.insertionSort(test);
		double[] expectedResult = { 0, 1, 2, 3, 4, 5, 6, 7 };
		assertEquals(Arrays.toString(result), Arrays.toString(expectedResult));
	}
    
    @Test
	public void testQuickSort() {
    	double[] test = { 1, 7, 6, 2, 3, 4, 0, 5};
		double[] result = SortComparison.quickSort(test);
		double[] expectedResult = { 0, 1, 2, 3, 4, 5, 6, 7 };
		assertEquals(Arrays.toString(result), Arrays.toString(expectedResult));
	}
    
    @Test
	public void testMergeSort() {
    	double[] test = { 1, 7, 6, 2, 3, 4, 0, 5};
		double[] result = SortComparison.mergeSort(test);
		double[] expectedResult = { 0, 1, 2, 3, 4, 5, 6, 7 };
		assertEquals(Arrays.toString(result), Arrays.toString(expectedResult));
	}
    
    @Test
	public void testShellSort() {
    	double[] test = {1, 7, 6, 2, 3, 4, 0, 5};
		double[] result = SortComparison.shellSort(test);
		double[] expectedResult = {0, 1, 2, 3, 4, 5, 6, 7};
		assertEquals(Arrays.toString(result), Arrays.toString(expectedResult));
	}
    
    @Test
	public void testSelectionSort() {
    	double[] test = { 1, 7, 6, 2, 3, 4, 0, 5};
		double[] result = SortComparison.selectionSort(test);
		double[] expectedResult = { 0, 1, 2, 3, 4, 5, 6, 7 };
		assertEquals(Arrays.toString(result), Arrays.toString(expectedResult));
	}
    
    @Test
	public void testBubbleSort() {
    	double[] test = { 1, 7, 6, 2, 3, 4, 0, 5};
		double[] result = SortComparison.bubbleSort(test);
		double[] expectedResult = { 0, 1, 2, 3, 4, 5, 6, 7 };
		assertEquals(Arrays.toString(result), Arrays.toString(expectedResult));
	}

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
    }

}
