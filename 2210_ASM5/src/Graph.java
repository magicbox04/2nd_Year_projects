/**
 * GraphNode creates a graph
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : December 7  2023
 * Last Edited : November 30 2023
 * Professor : Professor Narayan
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph  implements GraphADT
{
	/**
	 * Instance variable to indicate the edge matrix
	 */
	private GraphEdge[][] edgeMatrix;
	/**
	 * Instance variable to indicate the array of nodes
	 */
	private GraphNode[] nodeArr;
	/**
	 * Instance variable to indicate the size of the graph
	 */
	private int size;
	
	/**
	 * constructor for the graph
	 * 
	 * @param n the size of the graph being constructed
	 */
	public Graph(int n)
	{ 
		this.size = n;
		this.edgeMatrix = new GraphEdge[n][n];
		this.nodeArr = new GraphNode[n];
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				this.edgeMatrix[i][j] = null;
			}
			this.nodeArr[i] = new GraphNode(i);
		}
	}

	/**
	 * insets an edge to the graph
	 * 
	 * @param nodeu the first node of the edge
	 * @param nodev the second node of the edge
	 * @param type the type of the edge
	 * @param label the label of the edgae
	 * @throws GraphException if either node not there or edge already there
	 */
	public void insertEdge(GraphNode nodeu, GraphNode nodev, int type, String label) throws GraphException 
	{
		if (nodeu.getName() >= this.size || nodev.getName() >= this.size)
		{
			throw new GraphException ("one of the nodes don't exist");
		}
		else if (this.edgeMatrix[nodeu.getName()][nodev.getName()] != null 
				|| this.edgeMatrix[nodev.getName()][nodeu.getName()] != null)
		{
			throw new GraphException ("edge already exist");
		}
		else
		{
			this.edgeMatrix[nodeu.getName()][nodev.getName()] = new GraphEdge (nodeu, nodev, type, label);
			this.edgeMatrix[nodev.getName()][nodeu.getName()] = new GraphEdge (nodeu, nodev, type, label);
		}
	}

	/**
	 * getter for a node in graph
	 * 
	 * @param name the name of the node being searched
	 * @return returns the node with the name equal to the parameter
	 * @throws GraphException if the node does not exist
	 */
	public GraphNode getNode(int name) throws GraphException 
	{
		for (int i = 0; i < this.size; i++)
		{
			if (this.nodeArr[i].getName() == name)
			{
				return this.nodeArr[i];
			}
		}
		
		throw new GraphException ("the nodes don't exist");
	}

	/**
	 * creats an iterator of incident edges of a node
	 * 
	 * @param u a node that is being used to get the incident edges
	 * @return an iterator with all the incident edges. null if doesn't have any edges. 
	 * @throws GraphException if u is not a node
	 */
	public Iterator incidentEdges(GraphNode u) throws GraphException 
	{
		if (u.getName() >= this.size)
		{
			throw new GraphException ("the nodes don't exist");
		}
		else
		{
			List<GraphEdge> edges = new ArrayList<GraphEdge>();
			
			for (int i = 0; i < this.size; i++)
			{
				if (this.edgeMatrix[u.getName()][i] != null)
				{
					edges.add(this.edgeMatrix[u.getName()][i]);
				}
			}
			
			Iterator<GraphEdge> returnIter = edges.iterator();
			
			if (returnIter.hasNext() == false)
			{
				return null;
			}
			else
			{
				return returnIter;
			}
		}
	}

	/**
	 * gets the edge between two nodes
	 * 
	 * @param u first node of the edge
	 * @param v second node of the edge
	 * @return edge bewteen u and v
	 * @throws GraphException if no edge be or u v not in graph
	 */
	public GraphEdge getEdge(GraphNode u, GraphNode v) throws GraphException 
	{
		if (this.edgeMatrix[u.getName()][v.getName()] != null)
		{
			return this.edgeMatrix[u.getName()][v.getName()];
		}
		else
		{
			return null;
		}
	}

	/**
	 * check if u and v are adjacent
	 * 
	 * @param u first node of the edge
	 * @param v second node of the edge
	 * @return true if u v are adjacent and false if not
	 * @throws GraphException if u v not in graph
	 */
	public boolean areAdjacent(GraphNode u, GraphNode v) throws GraphException 
	{
		if (this.edgeMatrix[u.getName()][v.getName()] != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
