package spelling;

import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size = 0;
    


    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should convert the 
	 * string to all lower case before you insert it. 
	 * 
	 * This method adds a word by creating and linking the necessary trie nodes 
	 * into the trie, as described outlined in the videos for this week. It 
	 * should appropriately use existing nodes in the trie, only creating new 
	 * nodes when necessary. E.g. If the word "no" is already in the trie, 
	 * then adding the word "now" would add only one additional node 
	 * (for the 'w').
	 * 
	 * @return true if the word was successfully added or false if it already exists
	 * in the dictionary.
	 */
	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
		
		if(word != null ) // || word != "")
    	{
    		//convert to lowercase
    		String lcase = word.toLowerCase();
    		
    		//test if word is already in the dictionary
    		if(isWord(lcase) == true)
    		{
    			return false;
    		}
         	//adding to trie
     		TrieNode current = root;
    		for(int i = 0; i < lcase.length(); i++)
    		{
    			//capture individual letters
    			char c = lcase.charAt(i);
    			//pass letters to test if they are in nodes
    			if(current.getChild(c) != null)
    			{
    				current = current.getChild(c);
    			}
    			else
    			{
    				current = current.insert(c);
    			}

    		}
    		//set end of word
    		current.setEndsWord(true);
    	    //increment number of words
    		size++;    	    
        	//added correctly
        	return true;
    	}
	    return false;
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
	    return this.size;
	}
	
	
	/** Returns whether the string is a word in the trie, using the algorithm
	 * described in the videos for this week. */
	@Override
	public boolean isWord(String s) 
	{
	    // TODO: Implement this method
		if(s != null)
		{
			String lcase = s.toLowerCase();
			TrieNode current = root;
			for(int i = 0; i < lcase.length(); i++)
			{
				char c = lcase.charAt(i);
				if(current.getChild(c) == null)
				{
					//character is not there
					return false;
				}
				//set current to the next child node
				current = current.getChild(c);
			}
			if(current.endsWord())
			{
				//is a word
				return true;
			}
			//not a word
			return false;
		}
		//not a word in this dictionary
		return false;
	}

	/** 
     * Return a list, in order of increasing (non-decreasing) word length,
     * containing the numCompletions shortest legal completions 
     * of the prefix string. All legal completions must be valid words in the 
     * dictionary. If the prefix itself is a valid word, it is included 
     * in the list of returned words. 
     * 
     * The list of completions must contain 
     * all of the shortest completions, but when there are ties, it may break 
     * them in any order. For example, if there the prefix string is "ste" and 
     * only the words "step", "stem", "stew", "steer" and "steep" are in the 
     * dictionary, when the user asks for 4 completions, the list must include 
     * "step", "stem" and "stew", but may include either the word 
     * "steer" or "steep".
     * 
     * If this string prefix is not in the trie, it returns an empty list.
     * 
     * @param prefix The text to use at the word stem
     * @param numCompletions The maximum number of predictions desired.
     * @return A list containing the up to numCompletions best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 
 
    	 //printing all the nodes
//    	 printTree();
    	 
    	List<String> completions = new ArrayList<String>();  // the list of completions
    	LinkedList<TrieNode> queue = new LinkedList<TrieNode>(); //Create a queue
    	String stem = prefix.toLowerCase(); //the prefix converted to lowercase
    	TrieNode current = root; //set temp TrieNode to point to root of Trie

   
		//Find the stem in the trie
	
		
		//The stem does not appear in the trie
		if(stem != "" && isWord(stem) == false)
		{
//			System.out.println("\"" + stem + "\" is not in the TRIE");

			return completions; //return empty list
			
		} //end if
		
		//Stem found
		else
		{
			//move current to Node holding last character of stem
			for(int i = 0; i < stem.length(); i++)
			{
				char c = stem.charAt(i);
				if(current.getChild(c) != null)
				{
					//set current to the next child node
					current = current.getChild(c);
				}
			}
			//add stem to queue
			queue.addLast(current);
			
		}
//		System.out.println(queue);
	
		//While the queue is not empty 
		//and you don't have enough completions:
		while( !queue.isEmpty() && numCompletions > completions.size()) 
		{
//			System.out.println("While Loop!");
			current = queue.remove(); // remove the first Node from the queue
			
			if(current != null)
			{
				if( isWord(current.getText()) ) //if it is a word
    			{
					String nodeWord = current.getText();
					System.out.println("Stem: " + nodeWord);
    				completions.add(current.getText()); //add it to the completions list
    			}// end if
				
				
				//Add all of its child nodes to the back of the queue
				
				TrieNode next = null;
		 		for (Character c : current.getValidNextCharacters()) {
		 			next = current.getChild(c);
		 			queue.addLast(next);
		 			System.out.println("Child nodes: " + next.getText());
		 		} 	//end for			
		 		
			} // end if
			
		} //end while
		
	
//		System.out.println("While Loop!");

		//reorder completions list in increasing order by length
//		completions.sort(Comparator.comparing(String::length));
		System.out.println(completions);
         return completions;
     }//end predictCompletions()
     
    

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	


}