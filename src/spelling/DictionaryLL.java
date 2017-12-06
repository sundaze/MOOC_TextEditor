package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	private int numWords = 0;
	
    // TODO: Add a constructor

	/** constructor */
	public DictionaryLL()
	{
		dict = new LinkedList<String>();
	}

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	
    	if(word != null)
    	{
    		//convert to lowercase
    		String lcase = word.toLowerCase();
//        	System.out.println(lcase);
    		if(this.isWord(lcase))
    		{
    			//word is already in dictionary
    			return false;
    		}
    		//adding to list
        	dict.add(lcase);
        	//increment word counter
        	numWords++;
        	
//        	System.out.println(numWords);
        	
        	//added correctly
        	return true;
    	}
    	
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // TODO: Implement this method
    	
    	
    
        return numWords;
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        //TODO: Implement this method
    	if(s != null)
    	{
    		String test = s.toLowerCase();
    		//search linked list
    		for(String item: dict)
    		{
    			if(item.compareTo(test) == 0)
    			{
    				//the two strings have the same characters
    				return true;
    			}
    		}
    		
    		
    	}
    	
        return false;
    }

   
    
}
