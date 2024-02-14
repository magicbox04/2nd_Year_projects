/**
 * HashDictionary implements the Dictionary ADT using a hash table and a hash function
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : Oct 18 2023 
 * Last Edited : Oct 18 2023
 * Professor : Professor Solis-Oba
 */
import java.util.LinkedList;	
public class HashDictionary implements DictionaryADT
{
	/**
	 * instant variables
	 */
	private int size;
	private LinkedList<Data>[] table;

	/**
	 * constructor for HashDictionary
	 * 
	 * @param size size of the hash dictionary
	 */
	public HashDictionary(int size)
	{
		this.size = size;
		this.table = new LinkedList[this.size];
		
		for (int i=0; i < size; i++)
		{
			this.table[i] = new LinkedList<Data>();
		}
	}
	
	/**
	 * Polynomial hash function
	 * 
	 * @param config the string with the information
	 * @return returns the converted hash
	 */
	// 
	private int hash(String config) 
	{
        int hash = (int) config.charAt(0);
        
        for (int i = 1; i < config.length(); i++)
        {
        	char c = config.charAt(i);
            hash = ((hash * 59) + (int) c) % this.size;
        }
        return hash;
    }
	
	/**
	 * method that adds record to the dictionary
	 * 
	 * @param record the data that is being put into the dictionary
	 * @return 0 if no collision 1 if collision
	 */
	public int put(Data record) throws DictionaryException
	{
		int index = hash(record.getConfiguration());
		LinkedList<Data> list = table[index];
		
		/**
		 * check for exception
		 */
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) != null)
			{
				if (list.get(i).getConfiguration().equals(record.getConfiguration()))
				{
					throw new DictionaryException();
				}
			}
		}
		list.add(record);
		
		/**
		 * checks for collision
		 */
		if (list.size() > 1)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * method to remove the record with the given config from the dictionary
	 * 
	 * @parem config the string that has to be removed
	 */
	//
	public void remove(String config) throws DictionaryException 
	{
		int index = hash(config);
		LinkedList<Data> list = table[index];
		
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) != null)
			{
				if (list.get(i).getConfiguration().equals(config))
				{
					list.remove(i);
					return;
				}
			}
		}
		throw new DictionaryException();
	}

	/**
	 * method to get the score stored in the record of the dictionary with key config
	 *
	 *@parem config the string that the user wants to get
	 *@return the score if in dictionary
	 *@return -1 if config is not in the dictionary.
	 */
	public int get(String config) 
	{
		int index = hash(config);
		LinkedList<Data> list = table[index];
		
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) != null)
			{
				if (list.get(i).getConfiguration().equals(config))
				{
					return list.get(i).getScore();
				}
			}
		}
		return -1;
	}
	
	/**
	 * method to find the number of Data objects stored in the dictionary
	 * 
	 * @return the number of objects
	 */
	public int numRecords() 
	{
		int count = 0;
		
		for (int i = 0; i < this.size; i++)
		{
			count += this.table[i].size();
		}
		return count;
	}
	
	
}
