package textgen;

import static org.junit.Assert.fail;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		
		//Create sentinel nodes
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
		//sets up pointers to the previous and next nodes
//		head.next = tail;
//		head.prev = null;
//		tail.next = null;
//		tail.prev = head;
		
		head.setNext(tail);
		tail.setPrev(head);
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		
		//Reject null elements	
		if(element == null)
		{
			throw new NullPointerException();
		}
		
		LLNode<E> temp;		

		//add to empty list
		if(head.next == tail) {

			//create new node

			 temp = new LLNode<E>(element);
			 temp.next = tail;
			 temp.prev = head;
			 head.next = temp;
			 tail.prev = temp;
			 
			 
		}
		//add to end of list
		else
		{

			temp = new LLNode<E>(element);
			temp.next = tail;
			temp.prev = tail.prev;
			tail.prev.next = temp;
			tail.prev = temp;
			
//				temp.setNext(tail);
//				temp.setPrev(tail.getPrev());
//				tail.setPrev(temp);
		}

		
		size++;
//		System.out.println("Size == " + size);
		return true;
		
	
		
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		
		//Check index bounds
		if(index < 0 || index >= (this.size() ) )
		{
 
			throw new IndexOutOfBoundsException();
		}
		
		//check if list is empty
		if(head.getNext() == tail)
		{
 
			throw new IndexOutOfBoundsException();
		}
 
		LLNode<E> temp = head;
		for(int i = 0; i < index + 1; i++)
		{
//			temp = temp.next;

			temp = temp.getNext();
		}
		
		
		return temp.getData();
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		//Check input parameters for appropriate data 
		if(index < 0 )
		{
			throw new IndexOutOfBoundsException();
		}
		else if(element == null)
		{
			throw new NullPointerException();
		}
		
		//Create the node
		LLNode<E> node;		
 
		
		//add to empty list
		if(head.getNext() == tail && tail.getPrev() == head)
		{
			System.out.println("Empty list!");
			//Instantiate new first node if requested index is 0
			if(index == 0) {
				System.out.println("Index is " + index);
				LLNode<E>temp = new LLNode<E>(element);
				temp.setNext(tail);
				temp.setPrev(head);
				head.setNext(temp);
				tail.setPrev(temp);
				//Set node to the new temp reference 
				node = temp;

			}
			//If index > 0
			else
			{
				System.out.println("Index is " + index);
				//Instantiate first node at index 0
				LLNode<E>temp = new LLNode<E>(null, head, tail);
//				temp.setNext(tail);
//				temp.setPrev(head);
				
				head.setNext(temp);
				tail.setPrev(temp);
				
				int listIndex = 0;
				System.out.println(listIndex);
				
				//Create additional nodes to fill out list to index requested
				for( int i = 0; i <  index; i++ )
				{	
					//Instantiate trailer node and set Next and Prev to same as temp

					LLNode<E> temp2 = new LLNode<E>(null);
					if(temp.getNext() != null && temp.getPrev() != null)
					{
						temp2.setNext(temp.getNext());
						temp2.setPrev(temp);
						temp.setNext(temp2);
						temp = temp2;
					}
					
					listIndex++;
					System.out.println(listIndex);
				}
				
				//Create new node at desired index
				node = new LLNode<E>(element, temp, tail);

				
				tail.setPrev(node);
	
				System.out.println("request: " + index + ", actual: " + listIndex );
			}
			
		}//end if(empty list)
		
		//add to pre-populated list
		else
		{
			System.out.println("Pre-populated list");
			
			LLNode<E> temp = head;
			
			System.out.println("this index= " + index + "; size = " + this.size());
			//Check if index exceeds current list size
			if(index < (this.size() ) )
			{
				
				//Move temp pointer to item before index desired
				for(int i = 0; i < index; i++)
				{
					if(temp.getNext() != null)
					{
						temp = temp.getNext();
						System.out.println(i);
					}
				
				}
				if(temp.getNext() != null)
				{
//					node = new LLNode<E>(element, temp, temp.getNext());
					node = new LLNode<E>(element);
					node.setNext(temp.getNext());
					node.setPrev(temp);
					(temp.getNext()).setPrev(node);
					temp.setNext(node);
				}
			}
			//Current size is less than index requested
			else
			{
				System.out.println("Move temp pointer to last item");
				//Move temp pointer from head to item before tail
				for(int i = 0; i < this.size(); i++)
				{
					if(temp.getNext() != null)
					{
						temp = temp.getNext();
						System.out.println(i);
					}
	
				}
//				temp.setNext(tail);

				//Create additional nodes to fill out list  next to index requested
				for( int i = (this.size() ); i <  index; i++ )
				{	
					//Instantiate trailer node 
				
					LLNode<E> temp2 = new LLNode<E>(null);
					System.out.println("new Node created");

					if(temp.getNext() != null)
					{ 
						temp2.setNext(temp.getNext());
						temp2.setPrev(temp);
						temp.setNext(temp2);
						temp = temp2;
					}
					
				}
				System.out.println("this index= " + index + "; size = " + this.size());
				
				node = new LLNode<E>(element);
				if(temp.getNext() != null)
				{
					System.out.println("Creating last node");

//					node = new LLNode<E>(element, temp, temp.getNext());
	
					node.setNext(temp.getNext());
					node.setPrev(temp);
					(temp.getNext()).setPrev(node);
					temp.setNext(node);
				}
				System.out.println("this index= " + index + "; size = " + this.size());
			}
		
			
		}
	
		
	
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		int count = 0;
		LLNode<E>temp = head;
		while(temp.getNext() != tail )
		{
			if(temp.getNext() != null)
			{
				temp = temp.getNext();
			}
			count++;
		}
//		System.out.println("Count size()= " + count);
		return count;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		
		if(index < 0 || index >= this.size())
		{
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> temp = head;
		//move temp pointer to correct index
		for(int i = 0; i <= index; i++)
		{
			if(temp.getNext() != null)
			{
				temp = temp.getNext();
			}
//			else
//			{
//				throw new NullPointerException();
//			}
		}
		//save data
		E result = temp.getData();
		if(temp.getNext() != null && temp.getPrev() != null)
		{
			//set item before remove to point to item after remove
			(temp.getPrev()).setNext(temp.getNext());
			//set item after remove to point to item before remove
			(temp.getNext()).setPrev(temp.getPrev());
			
		}
	
		size--;
		return result;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		
		//Check input parameters for appropriate data 
		if(index < 0 || index > this.size()	)
		{
			throw new IndexOutOfBoundsException();
		}
		else if(element == null)
		{
			throw new NullPointerException();
		}
		
		LLNode<E>temp = head;
		//move to index requested
		for(int i = 0; i <= index; i++)
		{ 
			if(temp.getNext() != null)
			{
				temp = temp.getNext();
			}
		}		
		//save initial data
		E result = temp.getData();
		//change data
		temp.setData(element);
		
		return result;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	/**Overloaded constructor with reference to previous and next nodes*/
	public LLNode(E e, LLNode<E> before, LLNode<E> after)
	{
		this.data = e;
		this.prev = before;
		this.next = after;
		
	}
	/**Retrieves the previous node*/
	public LLNode<E> getPrev()
	{
		return prev;
	}
	/**Retrieves the next node*/
	public LLNode<E> getNext()
	{
		
		return next;
	}
	/**Sets the previous node*/
	public void setPrev(LLNode<E> before)
	{
		prev = before;
	}
	/**Sets the next node*/
	public void setNext(LLNode<E> after)
	{
		 next = after;
	}
	/**Sets node data*/
	public void setData(E e)
	{
		this.data = e;
	}
	/**Retrieves node data*/
	public E getData()
	{
		return data;
	}
}
