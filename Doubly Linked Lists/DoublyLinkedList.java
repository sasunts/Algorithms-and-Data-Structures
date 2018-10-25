import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 13/10/17 18:15
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{
	
	public int size = 0;


	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode
	{
		public final T data; // this field should never be updated. It gets its
		// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 * @param theData : data of type T, to be stored in the node
		 * @param prevNode : the previous Node in the Doubly Linked List
		 * @param nextNode : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
		{
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;

	/**
	 * Constructor
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() 
	{
		head = null;
		tail = null;
	}



	/**
	 * Tests if the doubly linked list is empty
	 * @return true if list is empty, and false otherwise
	 *
	 * Worst-case asymptotic runtime cost: O(1)
	 *
	 * Justification:
	 *  This is an instant procedure. All it takes is for the function to run once and check if there is anything stored in "head"
	 *  There are no loops of any kind which makes this function streamline and very very quick! Near instant speed is its worst case 
	 *  scenario as it is a binary function it will either be yes or a no. No further calculations or runs are needed. 
	 */
	public boolean isEmpty()
	{
		if (head==null)
		{
			return true;
		}
		return false;
	}


	/**
	 * Inserts an element in the doubly linked list
	 * @param pos : The integer location at which the new data should be
	 *      inserted in the list. We assume that the first position in the list
	 *      is 0 (zero). If pos is less than 0 then add to the head of the list.
	 *      If pos is greater or equal to the size of the list then add the
	 *      element at the end of the list.
	 * @param data : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 * Worst-case asymptotic runtime cost: O(N)
	 *
	 * Justification:
	 *  Here the majority of the code is ran instantly however when we reach the else statement we create a sum in the program. This effectivley
	 *  means that the the runtime is O(1) * O(N) which is O(N). Sicnce there are no more loops the worst case scenario is that of O(N) and 
	 *  nothing more.
	 *  
	 */
	public void insertBefore( int pos, T data ) 
	{
		DLLNode newNode = new DLLNode(data, null, null);
		DLLNode tmp = head;
		DLLNode previous = null;
		if (isEmpty()) 
		{
			head = newNode;
			tail = newNode;
			size++;
		} 
		else if(pos<=0)
		{
			newNode.next = head;
			head = newNode;
			newNode.next.prev = head;
			size++;
		}
		else
		{
			for(int i = 0; i<pos && tmp.next!=null; i++)
			{
				previous = tmp;
				tmp = tmp.next;
			}
			if(tmp.next==null)
			{
				tmp.next = newNode;
				newNode.prev = tmp;
				tail = newNode;
				size++;
				return;
			}
			newNode.prev = previous;
			previous.next = newNode;
			newNode.next = tmp;
			tmp.prev = newNode;
			size++;
		}
		return;
	}

	/**
	 * Returns the data stored at a particular position
	 * @param pos : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
	 *
	 * Worst-case asymptotic runtime cost: O(N)
	 *
	 * Justification:
	 *  The majority of this code is very straight forward and completes the task instantly, however once we enter a for loop we have a sum of N
	 *  The is multiplied by 1 to get N. There is only one loop which means that the worst case scenario is O(N). 
	 *
	 * Worst-case precise runtime cost: Tn = c1(0) + c2(0) + c3(2+N+2N) + c4(N) + c5(2+2N)
	 * Simplified down to: Tn = 4+6N
	 * Cost model is: ~6N
	 *
	 * Justification:
	 *  Based on the lecture slides I was able to identify the occurences of how many times certain operations occurred and where these 
	 *  operations varied and I then simplified this equation to get 4+6N and looking at the slides I noticed that the constant is discarded
	 *  therefore I was left with ~6N.
	 *  The 6N comes from the multiple of times a varied calculation takes place in the worst case scenario.
	 *  
	 */
	public T get(int pos) 
	{
		if(pos>size-1 || isEmpty() || pos<0 )
		{
			return null;
		}

		DLLNode found = head;
		DLLNode iterate = found;
		if(pos == 0)
		{
			return found.data; 
		}
		for(int i = 1; i <= size; i++)
		{
			iterate = found.next;
			found = iterate;
			if(i == pos)
			{
				return found.data;
			}
		}

		return null;
	}

	/**
	 * Deletes the element of the list at position pos.
	 * First element in the list has position 0. If pos points outside the
	 * elements of the list then no modification happens to the list.
	 * @param pos : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified. 
	 *
	 * Worst-case asymptotic runtime cost: O(N)
	 *
	 * Justification:
	 *  Just like above I only have one for loop and this is the reason why the worst case runtime is O(N). Since the majority of the 
	 *  code is ran instantly, the code slows down once we reach the for loop in the else if statement.
	 *  
	 */
	public boolean deleteAt(int pos) 
	{
		if(pos < 0 || pos > size-1 || isEmpty())
		{
			return false;
		}

		DLLNode delete = head;
		DLLNode temp = delete;

		if (pos == 0)
		{
			if (size == 1)
			{ 
				head = null;
				tail = null;
				size--;
				return true;
			}
			else
			{ 
				delete = head;
				head = head.next;
				head.prev = null;
				delete = null;
				size--;
				return true;
			}
		}
		else if (pos > 0 && pos <= size)
		{
			temp = head;
			for (int i = 0; i < pos; i++) 
			{
				temp = temp.next; 
			}
			if (temp.next == null) 
			{
				tail = temp.prev; 
				tail.next = null; 
				size--;
				return true;
			}
			else
			{
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				size--;
				return true;
			}                        
		}
		return false;
	}

	/**
	 * Reverses the list.
	 * If the list contains "A", "B", "C", "D" before the method is called
	 * Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 * Worst-case asymptotic runtime cost: O(N)
	 *
	 * Justification:
	 *  Once again we have one very quick and simple loop which iterates through the list once. This is why the worst case scenario is O(N)
	 *  the rest of the code has a runtime of O(1). 
	 */
	public void reverse()
	{
		if(isEmpty())
		{
			return;
		}
		DLLNode temp = head;
		head = tail;
		tail = temp;

		DLLNode pointer=head; 

		while(pointer!=null)
		{ 
			temp=pointer.next; 
			pointer.next=pointer.prev; 
			pointer.prev=temp;
			pointer=pointer.next;
		}
	}


	/*----------------------- STACK */
	/**
	 * This method should behave like the usual push method of a Stack ADT.
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to push on the stack
	 *
	 * Worst-case asymptotic runtime cost: O(N)
	 *
	 * Justification:
	 *  since my insertBefore() function is being called the worst case scenario is essentially the exact same as above.
	 */
	public void push(T item) 
	{
		insertBefore(size, item);
	}

	/**
	 * This method should behave like the usual pop method of a Stack ADT.
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 * Worst-case asymptotic runtime cost: O(N)
	 *
	 * Justification:
	 *  just like push the pop fuction calls a previous function (deleteAt()) which has a worst case scenario of O(N).
	 */
	public T pop() 
	{
		if(isEmpty())
		{
			return null;
		}
		T data = get(size-1);
		deleteAt(size-1);

		return data;
	}

	/*----------------------- QUEUE */

	/**
	 * This method should behave like the usual enqueue method of a Queue ADT.
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @param item : the item to be enqueued to the stack
	 *
	 * Worst-case asymptotic runtime cost: O(N)
	 *
	 * Justification:
	 *  it is identical to push hence the worst case runtime is the same
	 */
	
	public void enqueue(T item) 
	{
		insertBefore(size,item);
	}

	/**
	 * This method should behave like the usual dequeue method of a Queue ADT.
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 * How exactly this will be represented in the Doubly Linked List is up to the programmer.
	 * @return the earliest item inserted with a push; or null when the list is empty.
	 *
	 * Worst-case asymptotic runtime cost: O(1)
	 *
	 * Justification:
	 *  Even though I am calling the function deleteAt() which has a worst case runtime of O(N), the dequeue function actually takes
	 *  O(1) as the value to be dequeded is at position 1 which in my deleteAt() function this carries out the deletion without having
	 *  to enter a loop, there is an if statement for position 1 deletion and the function ends before hand. The get() function is also the
	 *  same where an if statement for position 1 is called before hand and does not need to enter any loops and therefore it too has an impact 
	 *  of O(1) which in total the dequeue is O(1) * O(1) which is O(1).
	 */
	
	public T dequeue() 
	{
		if(isEmpty())
		{
			return null;
		}
		T data = get(0);
		deleteAt(0);
		return data;
	}


	/**
	 * @return a string with the elements of the list as a comma-separated
	 * list, from beginning to end
	 *
	 * Worst-case asymptotic runtime cost:   Theta(n)
	 *
	 * Justification:
	 *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
	 *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
	 *  Thus, every one iteration of the for-loop will have cost Theta(1).
	 *  Suppose the doubly-linked list has 'n' elements.
	 *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
	 */
	public String toString() 
	{
		StringBuilder s = new StringBuilder();
		boolean isFirst = true; 

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next)
		{
			if (!isFirst)
			{
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}


}