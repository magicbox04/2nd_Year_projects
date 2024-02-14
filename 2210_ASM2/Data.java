/**
 * Data represents the records that will be stored in the HashDictionary
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : Oct 18 2023 
 * Last Edited : Oct 18 2023
 * Professor : Professor Solis-Oba
 */
public class Data 
{
	/**
	 * instant variables
	 */
	private String config;
	private int score;
	
	/**
	 * constuctor for Data
	 * @param config the string configuration of the data
	 * @param score the score of the data
	 */
	public Data(String config, int score)
	{
		this.config = config;
		this.score = score;
	}
	
	/**
	 * method that gets the configuration stored in this Data object.
	 * 
	 * @return the configuration stored in this Data object.
	 */
	public String getConfiguration()
	{
		return config;
	}
	
	/**
	 * method that gets the score stored in this Data object.
	 * 
	 * @return the score stored in this Data object.
	 */
	public int getScore()
	{
		return score;
	}
}
