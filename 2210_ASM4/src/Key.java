/**
 * Key creates a key for the record
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : November 17  2023
 * Last Edited : November 16 2023
 * Professor : Professor Narayan
 */

public class Key 
{
	/**
	 *	Instance variable to indicate the label part of the key
	 */
	private String label;
	/**
	 *	Instance variable to indicate the type part of the key
	 */
	private int type;
	
	/**
	 * A constructor which initializes a new Key
	 * @param thelabel the label to be stored in the key
	 * @param theType the type to be stored in the key
	 */
	public Key(String thelabel, int theType)
	{
		this.label = thelabel.toLowerCase();
		this.type = theType;
	}
	
	/**
	 * getter for the label
	 * @return Returns label
	 */
	public String getLabel()
	{
		return this.label;
	}
	
	/**
	 * getter for the type
	 * @return Returns type
	 */
	public int getType()
	{
		return this.type;
	}
	
	/**
	 * compares the two keys 
	 * @param k the key that is being compared with this key
	 * @return Returns 0 if this Key object = k, returns -1 if this
	 * Key object < k, and it returns 1 otherwise
	 */
	public int compareTo(Key k)
	{
		if (this.label.equals(k.label))
		{
			if (this.type == k.type)
			{
				return 0;
			}
			else if (this.type < k.type)
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
		else if (this.label.compareTo(k.label) < 0)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
}
