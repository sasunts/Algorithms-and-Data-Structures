// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author  vahe sasunts 16316570
 *  @version 12/10/17 12:00
 *  
 *  
 */
class Collinear
{

	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
	 * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
	 * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
	 * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
	 * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a horizontal line.
	 *
	 * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
	 * A non-horizontal line will have to cross all three of these lines. Thus
	 * we are looking for 3 points, each in a1, a2, a3 which lie on the same
	 * line.
	 *
	 * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
	 * 
	 * x1(y2−y3)+x2(y3−y1)+x3(y1−y2)=0 
	 *
	 * In our case y1=1, y2=2, y3=3.
	 *
	 * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
	 *
	 * ----------------------------------------------------------
	 *
	 * Experimental Performance:
	 * -------------------------
	 *  Write the running time of the algorithm when run with the following input sizes
	 *  
	 *  Input Size N      Running Time (sec)
	 *  ------------------------------------
	 *  1000              0.362 s
	 *  2000              2.650 s
	 *  4000              20.304 s
	 *
	 *  Assuming that the running time of your algorithm is of the form aN^b,
	 *  estimate 'b' and 'a' by fitting a line to the experimental points:
	 *
	 *  b = 2.905
	 *  a = 6.93E-10 
	 *
	 *  What running time do you predict using your results for input size 5000?
	 *  What is the actual running time you get with such an input?
	 *  What is the error in percentage?
	 *
	 *  Error = ( (Actual time) - (Predicted time) ) * 100 / (Predicted time)
	 *
	 *  Input Size N      Predicted Running Time (sec)        Actual Running Time (sec)       Error (%)
	 *  ------------------------------------------------------------------------------------------------
	 *  5000              38.569 s                             39.822s                          3.25%
	 * 
	 *  Order of Growth
	 *  -------------------------
	 *
	 *  Calculate and write down the order of growth of your algorithm. You can use the asymptotic notation.
	 *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
	 *
	 *  Order of growth: N^3
	 *
	 *  Explanation: The order of growth for the brute force method is N^3 as it accesses a triple for loop  
	 *  to calculate the equation. For each integer stored in a1 it will check every combination of a2 and a3
	 *  manually and trigger the if statement below when a combination is collinear. Where going through a1 is N
	 *  and going through a2 is N and going through a3 is also N so if we multiply all together we get N^3
	 */
	static int countCollinear(int[] a1, int[] a2, int[] a3)
	{

		int count=0;
		//all combinations of a1
		for (int i=0;i<a1.length;i++)
		{
			//all combinations of a2
			for (int j =0;j<a2.length;j++)
			{
				//all combinations of a3
				for (int k=0; k<a3.length;k++)
				{
					    //x1*(y2−y3) + x2*(y3−y1) + x3*(y1−y2)=0 
					if ((a1[i]*(2-3))+(a2[j]*(3-1))+(a3[k]*(1-2))==0)
					{
						//number of collinear 
						count++;
					}
				}
			}
		}
		return count;
	}

	// ----------------------------------------------------------
	/**
	 * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
	 * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
	 * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
	 * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
	 * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
	 * @return the number of points which are collinear and do not lie on a horizontal line.
	 *
	 * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
	 * The performance of this method should be much better than that of the above method.
	 *
	 * Experimental Performance:
	 * -------------------------
	 *  Measure the running time of the algorithm when run with the following input sizes
	 *  
	 *  Input Size N      Running Time (sec)
	 *  ------------------------------------
	 *  1000              0.099 s	
	 *  2000              0.308 s
	 *  4000              1.040 s
	 *  5000              1.637 s
	 *
	 *
	 *  Compare Implementations:
	 *  ------------------------
	 *  Show the speedup achieved by this method, using the times you got from your experiments.
	 *
	 *  Input Size N      Speedup = (time of countCollinear)/(time of countCollinearFast)
	 *  ---------------------------------------------------------------------------------
	 *  1000              3.66
	 *  2000              8.603
	 *  4000              19.523
	 *  5000              24.326
	 *
	 *
	 *  Order of Growth
	 *  -------------------------
	 *
	 *  Calculate and write down the order of growth of your algorithm. You can use the asymptotic notation.
	 *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
	 *
	 *  Order of Growth: N^2logN
	 *
	 *  Explanation: The initial N^2 part of the order of growth comes from the sort function which has two 
	 *  loops and therefore is N^2 (where the sort function has two loops which is N*N =N^2). After the sort
	 *  function is called it then carries out binary search which is a logarithmic function. This is the case
	 *  as Binary search works by checking the mid point of an array and based on the value we are looking for
	 *  it will then search the mid point of the upper half or lower half of the array and do this until we
	 *  find the value or come to a conclusion that the value does not exist in this array.
	 */
	static int countCollinearFast(int[] a1, int[] a2, int[] a3)
	{
		sort(a3);
		int count = 0;
		for (int i =0;i<a1.length;i++)
		{
			for (int j =0;j<a2.length;j++)
			{
				// x= 2b -a (taken from formula above)
				int x = (2*(a2[j])-a1[i]);
				if(binarySearch(a3, x)==true)
				{
					count++;
				}
			}
		}
		return count;
	}

	// ----------------------------------------------------------
	/**
	 * Sorts an array of integers according to InsertionSort.
	 * This method is static, thus it can be called as Collinear.sort(a)
	 * @param a: An UNSORTED array of integers. 
	 * @return after the method returns, the array must be in ascending sorted order.
	 *
	 * ----------------------------------------------------------
	 *
	 * Approximate Mathematical Performance:
	 * -------------------------------------
	 *  Using an appropriate cost model, give the performance of your algorithm.
	 *  Explain your answer.
	 *
	 *  Performance: O(N^2)
	 *
	 *  Explanation: The best case scenario is if the array is already sorted in this case the algorithm will run through one iteration and 
	 *  finish quite fast, this will be calculated by O(N).
	 *  The exact opposite (worst case scenario) is if the array is in reverse order and therefore needs to run through the algorithm for
	 *  every iteration and this can be written as O(N^2).
	 *  Finally the average scenario is also written as O(N^2) this is because there is no exact constant to say how many iterations the 
	 *  algorithm will run and depending on the size of the array it can run very fast for small arrays or very slow for larger arrays.
	 *
	 */
	static void sort(int[] a)
	{
		int tempValue;
		for (int i = 0; i < a.length; i++) 
		{
			for(int j = i ; j > 0 ; j--)
			{
				if(a[j] < a[j-1])
				{
					tempValue = a[j];
					a[j] = a[j-1];
					a[j-1] = tempValue;
				}
			}
		}
	}

	// ----------------------------------------------------------
	/**
	 * Searches for an integer inside an array of integers.
	 * This method is static, thus it can be called as Collinear.binarySearch(a,x)
	 * @param a: A array of integers SORTED in ascending order.
	 * @param x: An integer.
	 * @return true if 'x' is contained in 'a'; false otherwise.
	 *
	 * ----------------------------------------------------------
	 *
	 * Approximate Mathematical Performance:
	 * -------------------------------------
	 *  Using an appropriate cost model, give the performance of your algorithm.
	 *  Explain your answer.
	 *
	 *  Performance: O(log N)
	 *
	 *  Explanation: Binary Search is very interesting as the best case scenario is that the number you are looking for is the very first element
	 *  (The mid point of the array) in this case it stops immediatley when it runs and finds the first number. this can be written as O(1).
	 *  The worst case scenario is if (depending on the size of the array) when it has to go half the array, then half of that half and so on,
	 *  until it has to go in the middle of 2 numbers. This means that it looked for a number as much as possible and in fact the number it is
	 *  looking for does not neccessarily have to be in the array which is the worst case scenario as it runs every iterations and comes to 
	 *  a conclusion at the very end of the algorithm. This is written as O(log N).
	 *  The average performance will also depend on the size of the array and hoq deep it has to go into halfing the array size. This is also not
	 *  a constant and can not be guaranteed and there for it is written as O(log N).
	 *
	 */
	static boolean binarySearch(int[] a, int x)
	{
		int lo = 0, hi = a.length-1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			if (x < a[mid]) hi = mid - 1;
			else if (x > a[mid]) lo = mid + 1;
			else return true;
		}
		return false;
	}
}
