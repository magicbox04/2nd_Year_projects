/**
 * BSTNode creates a tree node for the BST
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : November 17  2023
 * Last Edited : November 16 2023
 * Professor : Professor Narayan
 */

public class BSTDictionary implements BSTDictionaryADT 
{
	/**
	 * Instance variable to indicate the BST
	 */
	private BinarySearchTree tree;
	
	/**
	 * The constructor that creates a BSTDictionary.
	 */
	public BSTDictionary()
	{
		this.tree = new BinarySearchTree();	
	}
	
	/**
	 * Returns the Record with key k, or null if the Record is not in the dictionary.
	 * @param k the key to find in the tree 
	 */
	public Record get (Key k)
	{
		BSTNode resultNode = tree.get(tree.getRoot(), k);
	    
	    if (resultNode != null) 
	    {
	        return resultNode.getRecord();
	    }
	    else 
	    {
	        return null; 
	    }
	}
	
	/**
	 * Inserts d into the ordered dictionary. 
	 * @throws DictionaryException Record with the same Key as d is already in the dictionary
	 */
	public void put (Record d) throws DictionaryException
	{
		try 
		{
            tree.insert(tree.getRoot(), d);
        } 
		catch (DictionaryException e) 
		{
            throw new DictionaryException("Record with same key already in tree");
        }
	}
	
	/**
	 * Removes the Record with Key k from the dictionary
	 * @throws DictionaryException the Record is not in the dictionary
	 */
	public void remove (Key k) throws DictionaryException
	{
		try 
		{
            tree.remove(tree.getRoot(), k);
        } 
		catch (DictionaryException e) 
		{
            throw new DictionaryException("Record with same key already in tree");
        }
	}
	
	/**
	 * Returns the successor of k
	 * @param k the key to be used to find the successor
	 * @return returns the successor if there, null if not
	 */
	public Record successor (Key k)
	{
		BSTNode temp = tree.successor(tree.getRoot(), k);
		if (temp == null)
		{
			return null;
		}
		else
		{
			return temp.getRecord();
		}
	}
	
	/**
	 * Returns the predecessor of k
	 * @param k the key to be used to find the predecessor
	 * @return returns the predecessor if there, null if not
	 */
	public Record predecessor (Key k)
	{
		BSTNode temp = tree.predecessor(tree.getRoot(), k);
		if (temp == null)
		{
			return null;
		}
		else
		{
			return temp.getRecord();
		}
	}
	
	/**
	 * gets the Record with smallest key
	 * @return Returns the Record with smallest key if null if empty
	 */
	public Record smallest ()
	{
		BSTNode temp = tree.smallest(tree.getRoot());
		if (temp == null)
		{
			return null;
		}
		else
		{
			return temp.getRecord();
		}
	}
	
	/**
	 * gets the Record with largest key
	 * @return Returns the Record with largest key if null if empty
	 */
	public Record largest ()
	{
		BSTNode temp = tree.largest(tree.getRoot());
		if (temp == null)
		{
			return null;
		}
		else
		{
			return temp.getRecord();
		}
	}
}
