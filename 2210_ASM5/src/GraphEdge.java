/**
 * GraphNode creates an edge for the graph
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : December 7  2023
 * Last Edited : November 30 2023
 * Professor : Professor Narayan
 */

public class GraphEdge 
{
	/**
	 * Instance variable to indicate if the first node
	 */
	private GraphNode u;
	/**
	 * Instance variable to indicate if the second node
	 */
	private GraphNode v;
	/**
	 * Instance variable to indicate if the type of the edge
	 */
	private int type;
	/**
	 * Instance variable to indicate if the label of the edge
	 */
	private String label;
	
	/**
	 * constructor for the edge
	 * 
	 * @param u first node of the edge
	 * @param v	second node of the edge
	 * @param type the type of the edge
	 * @param label the label of the edge
	 */
	public GraphEdge(GraphNode u, GraphNode v, int type, String label)
	{
		this.u = u;
		this.v = v;
		this.type = type;
		this.label = label;
	}
	
	/**
	 * getter for the first end point
	 * 
	 * @return first end point
	 */
	public GraphNode firstEndpoint()
	{
		return this.u;
	}
	
	/**
	 * getter for the second end point
	 * 
	 * @return second end point
	 */
	public GraphNode secondEndpoint()
	{
		return this.v;
	}
	
	/**
	 * getter for the type
	 * 
	 * @return type of the edge
	 */
	public int getType()
	{
		return this.type;
	}
	
	/**
	 * setter for the type
	 * 
	 * @param newType the type that is going to be assigned to the edge
	 */
	public void setType(int newType)
	{
		this.type = newType;
	}
	
	/**
	 * getter for the label
	 * 
	 * @return the label of the edge
	 */
	public String getLabel()
	{
		return this.label;
	}
	
	/**
	 * setter for the label
	 * 
	 * @param newLabel the new label that is being assigned
	 */
	public void setLabel(String newLabel)
	{
		this.label = newLabel;
	}
}
