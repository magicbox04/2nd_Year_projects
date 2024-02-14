/**
 * GraphNode creates a node for the graph
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : December 7  2023
 * Last Edited : November 30 2023
 * Professor : Professor Narayan
 */

public class GraphNode 
{
	/**
	 * Instance variable to indicate if the node is marked
	 */
	private boolean mark;
	/**
	 * Instance variable to indicate the name of the Node
	 */
	private int name;
	
	/**
	 * Constructor that creates a node
	 * 
	 * @param name the name of the node
	 */
	public GraphNode(int name)
	{
		this.mark = false;
		this.name = name;
	}
	
	/**
	 * setter for the node
	 * 
	 * @param mark the mark that 
	 */
	public void mark(boolean mark)
	{
		this.mark = mark;
	}
	
	/**
	 * getter for the mark
	 * 
	 * @return the mark of the node
	 */
	public boolean isMarked()
	{
		return this.mark;
	}
	
	/**
	 * getter for the name
	 * 
	 * @return the name of the node
	 */
	public int getName()
	{
		return this.name;
	}
}
