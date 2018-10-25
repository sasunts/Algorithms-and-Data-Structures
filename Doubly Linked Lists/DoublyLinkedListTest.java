import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author vahe sasunts 
 *  @version 01/11/16 16:59
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
	//~ Constructor ........................................................
	@Test
	public void testConstructor()
	{
		new DoublyLinkedList<Integer>();
	}

	//~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check if the insertBefore works
	 */
	@Test
	public void testInsertBefore()
	{
		// test non-empty list
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);

		testDLL.insertBefore(0,4);
		assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
		testDLL.insertBefore(1,5);
		assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
		testDLL.insertBefore(2,6);       
		assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
		testDLL.insertBefore(-1,7);        
		assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
		testDLL.insertBefore(7,8);        
		assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
		testDLL.insertBefore(700,9);        
		assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

		// test empty list
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);        
		assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(10,1);        
		assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
		testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(-10,1);        
		assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
	}

	@Test
	public void testPush()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();

		testDLL.push(1);
		testDLL.push(5);
		testDLL.push(2);
		assertEquals("1,5,2", testDLL.toString());
	}

	@Test
	public void testPop()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(1);
		testDLL.push(5);
		testDLL.push(2);
		testDLL.pop();
		testDLL.pop();
		testDLL.pop();
		testDLL.pop();
		assertEquals("",testDLL.toString());
	}


	@Test 
	public void testEnqueue()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.enqueue(1);
		testDLL.enqueue(2);
		testDLL.enqueue(3);
		assertEquals("1,2,3", testDLL.toString());
	}

	@Test 
	public void testDequeue()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.enqueue(0);
		testDLL.enqueue(1);
		testDLL.enqueue(2);
		testDLL.dequeue();
		testDLL.dequeue();
		testDLL.dequeue();
		testDLL.dequeue();
		System.out.println(testDLL.toString());
		assertEquals("",testDLL.toString());
	}

	@Test
	public void testToString()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.insertBefore(0,1);
		testDLL.insertBefore(1,2);
		testDLL.insertBefore(2,3);
		assertEquals("1,2,3",testDLL.toString());
	}

	@Test
	public void testIsEmpty()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		boolean value = testDLL.isEmpty();
		assertEquals(true, value);
	}

	@Test
	public void testReverse()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(1);
		testDLL.push(5);
		testDLL.push(2);
		testDLL.reverse();
		assertEquals("2,5,1",testDLL.toString());
	}

	@Test
	public void testGet() 
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(1);
		testDLL.push(5);
		testDLL.push(2);
		Integer value = testDLL.get(1);
		boolean isEquals = false;
		if (value == 5)
		{
			isEquals = true;
		}
		assertEquals(true,isEquals);
	}
	@Test
	public void testGet1Item() 
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(1);
		Integer value = testDLL.get(1);
		boolean isEquals = false;
		if (value == null)
		{
			isEquals = true;
		}
		assertEquals(true,isEquals);
	}

	@Test
	public void testDeleteAt()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.push(1);
		testDLL.push(5);
		testDLL.push(2);
		testDLL.push(8);
		testDLL.push(9);
		testDLL.deleteAt(0);
		testDLL.deleteAt(1);
		testDLL.deleteAt(2);
		assertEquals("5,8",testDLL.toString());
	}

	@Test
	public void testDeleteAtEmpty()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		boolean test = testDLL.deleteAt(1);
		assertEquals(false, test);
	}

	@Test
	public void testGetEmpty() 
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		Integer value =testDLL.get(0);
		assertEquals(null,value);
	}

	@Test
	public void testReverseEmpty()
	{
		DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		testDLL.reverse();
		assertEquals("",testDLL.toString());
	}


}
