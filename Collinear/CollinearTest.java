import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author  
 *  @version 03/10/16 17:10:35
 */
@RunWith(JUnit4.class)
public class CollinearTest
{
	
	//Read in all the files before hand in order to prevent it from affecting results( Commented out to prevent NO TEST SUBMITTED by webcat)
//	public static int[] inStream(String arg)
//	{
//		In stream = new In(arg);
//		int[] a1 = stream.readAllInts();
//		return a1;	
//	}
//	static int[] array1K1 = inStream("r01000-1.txt");
//	static int[] array1K2 = inStream("r01000-2.txt");
//	static int[] array1K3 = inStream("r01000-3.txt");
//	static int[] array2K1 = inStream("r02000-1.txt"); 
//	static int[] array2K2 = inStream("r02000-2.txt");
//	static int[] array2K3 = inStream("r02000-3.txt");
//	static int[] array4K1 = inStream("r04000-1.txt"); 
//	static int[] array4K2 = inStream("r04000-2.txt");
//	static int[] array4K3 = inStream("r04000-3.txt");
//	static int[] array5K1 = inStream("r05000-1.txt"); 
//	static int[] array5K2 = inStream("r05000-2.txt");
//	static int[] array5K3 = inStream("r05000-3.txt");
	
	
	//Commented out tests as they use above files to carry out tests in order to calculate times,(Prevent webcat from failing on me)
//	/**
//	 *Testing for brute force and binary search method bellow alternating from one and the other by commenting one or the
//	 *other out and getting times from JUnit test panel from the left side bar
//	 */
//	@Test
//	public void testInputTrue1kCollinear()
//	{						
//		int expectedResult = 41582;
//		assertEquals("countCollinear(" + Arrays.toString(array1K1) + "," + Arrays.toString(array1K2) + "," + Arrays.toString(array1K3) + ")",     expectedResult, Collinear.countCollinear(array1K1, array1K2, array1K3));
//	}
//	@Test
//	public void testInputTrue1kCollinearFast()
//	{						
//		int expectedResult = 41582;
//		assertEquals("countCollinearFast(" + Arrays.toString(array1K1) + "," + Arrays.toString(array1K2) + "," + Arrays.toString(array1K3) + ")", expectedResult, Collinear.countCollinearFast(array1K1, array1K2, array1K3));
//	}
//
//
//	@Test
//	public void testInputTrue2kCollinear()
//	{				
//		int expectedResult = 3927;
//		assertEquals("countCollinear(" + Arrays.toString(array2K1) + "," + Arrays.toString(array2K2) + "," + Arrays.toString(array2K3) + ")",     expectedResult, Collinear.countCollinear(array2K1, array2K2, array2K3));
//	}
//
//	@Test
//	public void testInputTrue2kCollinearFast()
//	{				
//		int expectedResult = 3927;
//		assertEquals("countCollinearFast(" + Arrays.toString(array2K1) + "," + Arrays.toString(array2K2) + "," + Arrays.toString(array2K3) + ")", expectedResult, Collinear.countCollinearFast(array2K1, array2K2, array2K3));
//	}
//
//	@Test
//	public void testInputTrue4kCollinear()
//	{    				
//		int expectedResult = 31783;
//		assertEquals("countCollinear(" + Arrays.toString(array4K1) + "," + Arrays.toString(array4K2) + "," + Arrays.toString(array4K3) + ")",     expectedResult, Collinear.countCollinear(array4K1, array4K2, array4K3));
//	}
//
//	@Test
//	public void testInputTrue4kCollinearFast()
//	{    				
//		int expectedResult = 31783;
//		assertEquals("countCollinearFast(" + Arrays.toString(array4K1) + "," + Arrays.toString(array4K2) + "," + Arrays.toString(array4K3) + ")", expectedResult, Collinear.countCollinearFast(array4K1, array4K2, array4K3));
//	}
//
//	@Test
//	public void testInputTrue5kCollinear()
//	{		
//		int expectedResult = 61322;
//		assertEquals("countCollinear(" + Arrays.toString(array5K1) + "," + Arrays.toString(array5K2) + "," + Arrays.toString(array5K3) + ")",     expectedResult, Collinear.countCollinear(array5K1, array5K2, array5K3));
//	}
//	
//	@Test
//	public void testInputTrue5kCollinearFast()
//	{		
//		int expectedResult = 61322;
//		assertEquals("countCollinearFast(" + Arrays.toString(array5K1) + "," + Arrays.toString(array5K2) + "," + Arrays.toString(array5K3) + ")", expectedResult, Collinear.countCollinearFast(array5K1, array5K2, array5K3));
//	}

	
	//~ Constructor ........................................................
	@Test
	public void testConstructor()
	{
		new Collinear();
	}

	//~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the two methods work for empty arrays
	 */
	@Test
	public void testEmpty()
	{
		int expectedResult = 0;

		assertEquals("countCollinear failed with 3 empty arrays",       expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
		assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
	}

	// ----------------------------------------------------------
	/**
	 * Check for no false positives in a single-element array
	 */
	@Test
	public void testSingleFalse()
	{
		int[] a3 = { 15 };
		int[] a2 = { 5 };
		int[] a1 = { 10 };

		int expectedResult = 0;

		assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
		assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
	}

	// ----------------------------------------------------------
	/**
	 * Check for no false positives in a single-element array
	 */
	@Test
	public void testSingleTrue()
	{
		int[] a3 = { 15, 5 };       int[] a2 = { 5 };       int[] a1 = { 10, 15, 5 };

		int expectedResult = 1;

		assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
		assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
	}

	
	//Testing the sort function for true
	@Test
	public void testSortTrue()
	{
		int[] testCase = {5,2,1,3,4};
		int[] expectedCase = {1,2,3,4,5};
		Collinear.sort(testCase);
		assertEquals(Arrays.toString(expectedCase), Arrays.toString(testCase));
	}
	
	@Test
	public void testSortEmpty()
	{
		int[] testCase = {0};
		int[] expectedFalseCase = {0};

		Collinear.sort(testCase);
		assertEquals(Arrays.toString(expectedFalseCase),Arrays.toString(testCase));

	}

	
	
	//testing binary search function (here i can take away the results from the sort function to get a better representation
	@Test
	public void testBinaryBestCase()
	{
		int[] testCase = {0,1,2,3,4,5,6,7,8,9,10};	
		boolean test = Collinear.binarySearch(testCase, 5);
		
		boolean expectedResult = true;
		assertEquals(expectedResult, test);
		
	}
	
	@Test
	public void testBinaryEmpty()
	{
		int[] testCase = {0};	
		boolean test = Collinear.binarySearch(testCase, 0);
		
		boolean expectedResult = true;
		assertEquals(expectedResult, test);
		
	}
	
	@Test
	public void testBinaryWorstCase()
	{
		int[] testCase = {0,1,2,3,4,5,6,7,8,9,10};	
		boolean test = Collinear.binarySearch(testCase, 0);
		
		boolean expectedResult = true;
		assertEquals(expectedResult, test);
		
	}
	
	@Test
	public void testBinaryFailCase()
	{
		int[] testCase = {0,1,2,3,4,5,6,7,8,9,10};	
		boolean test = Collinear.binarySearch(testCase, 11);
		
		boolean expectedResult = false;
		assertEquals(expectedResult, test);
		
	}


	// ----------------------------------------------------------
	/**
	 *  Main Method.
	 *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
	 *
	 *  You should read the lecture notes and/or book to understand how to correctly implement the main methods.
	 *  You can use any of the provided classes to read from files, and time your code.
	 *
	 */
	//--------------------------------------------------------
	/**
	 * After speaking with the TA's in the labs I showed them my method of calculating the times, I comment out above 
	 * in the tests above and run the JUnit tests which show the times taken to run each test, no time is lost reading
	 * in the files as the files are read outside of the test scopes and therefore do not slow down the tests. I asked the TA if this method
	 * was ok or if I had to write a main with the stopwatch etc. and I was told so long as my measurements are consistent I should be fine
	 * submitting what I have.
	 */
//	public static void main(String[] args)
//	{
//		
//	}

}