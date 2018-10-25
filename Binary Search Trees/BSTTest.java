import static org.junit.Assert.*;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 30/11/17 11:32:15
 *
 *  @author  Vahe Sasunts
 */

@RunWith(JUnit4.class)
public class BSTTest
{
	@Test
	public void testGet()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
	    bst.put(7, 7);     
	    bst.put(8, 7); 
	    bst.put(9, 7);
	    bst.get(9);
	    Integer result = 7;
	    assertEquals(result, bst.get(9));
	}
	
	@Test
	public void testGetNull()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
	    bst.get(9);
	    Integer result = null;
	    assertEquals(result, bst.get(9));
	}
	
	@Test
	public void testPutNull()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
	    bst.put(null,null);
	    Integer result = null;
	    assertEquals(result, bst.get(9));
	}
	
	@Test
	public void testHeight()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
	    bst.put(7, 7);     
	    bst.put(8, 7); 
	    bst.put(9, 7);
	    int result = 2;
	    assertEquals(result, bst.height());
	}
	
	@Test
	public void testMedian()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
	    bst.put(7, 7);     
	    bst.put(8, 7); 
	    bst.put(9, 7);
	    int result = bst.median();
	    assertEquals(result,8);
	}
	
	@Test
	public void testMedianNull()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
	    Integer result = bst.median();
	    assertEquals(result,null);
	}
	
  
	@Test
	public void testIsEmpty()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
	    boolean test = bst.isEmpty();
	    assertEquals(test,true);
	}
	
	@Test
	public void testIsntEmpty()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7,7);
	    boolean test = bst.isEmpty();
	    assertEquals(test,false);
	}
	
	@Test
	public void testPrintInOrder()
	{
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7, 7);    
	    bst.put(8, 8);   
	    bst.put(3, 3);   
	    bst.put(1, 1);      
	    bst.put(2, 2);      
	    bst.put(6, 6);      
	    bst.put(4, 4);      
	    bst.put(5, 5); 
	    String str = bst.printKeysInOrder();
	    assertEquals(str, "(((()1(()2()))3((()4(()5()))6()))7(()8()))");

	}

  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
    // System.out.println(bst.prettyPrintKeys());
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
     }
     
}

