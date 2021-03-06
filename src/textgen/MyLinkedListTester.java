/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		
		String c = shortList.remove(0);
		assertEquals("Remove: check c is correct ", "A", c);
		assertEquals("Remove: check element 0 is correct ", "B", shortList.get(0));
		assertEquals("Remove: check size is correct ", 1, shortList.size());
		
		int b = longerList.remove(3);
		assertEquals("Remove: check b is correct ", 3, b);
		assertEquals("Remove: check element 4 is correct ", (Integer)5, longerList.get(4));
		assertEquals("Remove: check size is correct ", 9, longerList.size());
		
		
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		
		int testNum = 77;
		longerList.add(testNum);

//		for (int i = 0; i < longerList.size(); i++)
//		{
//			System.out.println(longerList.get(i));
//		}
			
		
//		System.out.println("Size = " + longerList.size());
		// test longer list contents
	
		assertEquals("AddEnd: Check added element",(Integer) testNum, longerList.get(longerList.size() - 1) );
		

		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		int count = 0;

		for (int i = 0; i < longerList.size; i++)
		{
			count++;
		}
	
		assertEquals("Size: Check size", count, longerList.size());
		
		
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		
		Integer testNum = 77;
		int index = 4;
		list1.add(index, testNum);
		longerList.add(index, testNum);
		
//		longerList.add(testNum);
		for (int i = 0; i < longerList.size(); i++)
		{
			System.out.println("test longerList " + longerList.get(i));
			System.out.println(" test longerList size = " + longerList.size());
		

		}
		for(int i = 0; i < list1.size(); i++)
		{
			System.out.println("test list1 " + list1.get(i));
			System.out.println(" test list1 size = " + list1.size());
		}
		assertEquals("AddAtIndex: Check index(" + index + ")", (Integer)testNum, longerList.get(index));
		assertEquals("AddAtIndex: Check index(" + index + ")", (Integer)testNum, list1.get(index));
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		Integer index = 1;
		String element = ";)";
		
		String result = shortList.set( index, element);
		
		assertEquals("Set: Check index(" + index + ")", element, shortList.get(1));
		assertEquals("Set: Check element ", "B", result);
		
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
	
	
}
