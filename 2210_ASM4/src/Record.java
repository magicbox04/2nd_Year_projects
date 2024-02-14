/**
 * Record creates a record for the tree node
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : November 17  2023
 * Last Edited : November 16 2023
 * Professor : Professor Narayan
 */

public class Record 
{
	/**
	 * Instance variable to indicate the key part of the record
	 */
	private Key theKey;
	/**
	 * Instance variable to indicate the data part of the record
	 */
	private String data;
	
	/**
	 * A constructor which initializes a Record object
	 * @param k the key to be stored in the record
	 * @param theData the data to be stored in the record
	 */
	public Record(Key k, String theData) 
	{
		this.theKey = k;
		this.data = theData;
	}
	
	/**
	 * getter for the key
	 * @return returns the key of the record
	 */
	public Key getKey()
	{
		return this.theKey;
	}
	
	/**
	 * getter for the data
	 * @return returns the data of the record
	 */
	public String getDataItem()
	{
		return this.data;
	}
}
