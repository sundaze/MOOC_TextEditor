package spelling;

import java.util.TreeSet;



/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;

   private String data;

//   private TreeSet left;
//   private TreeSet right;
   
	
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
   
   /**default constructor */
   public DictionaryBST()
   {
	   dict = new TreeSet<String>();
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
    		String lcase = word.toLowerCase();
//        	System.out.println(lcase);
    		if(this.isWord(lcase))
    		{
    			//word is already in dictionary
    			return false;
    		}
        	//implement BST
        	if(dict != null)
        	{
        		dict.add(lcase);
        		//added word correctly
            	return true;
        	}
        	        
    	}
    	
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
    	if( !dict.isEmpty())
    	{
    		   return dict.size();
    	}
     
    	return 0;
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	//TODO: Implement this method
    	
    	if(s != null)
    	{
    		String test = s.toLowerCase();
    		
    		if(dict.contains(test))
    		{
    			//word is in dictionary
    			return true;
    		}
    	}
    	//word is not found
        return false;
    }

}
