/**
 * GraphNode creates a maze
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : December 7  2023
 * Last Edited : November 30 2023
 * Professor : Professor Narayan
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Maze 
{
	/**
	 * Instance variable to indicate the maze graph
	 */
	private Graph maze;
	/**
	 * Instance variable to indicate the scale of the maze
	 */
	private int scale;
	/**
	 * Instance variable to indicate the width of the maze
	 */
	private int width;
	/**
	 * Instance variable to indicate the length of the maze
	 */
	private int length;
	/**
	 * Instance variable to indicate the coin available for the maze
	 */
	private int coin;
	/**
	 * Instance variable to indicate the entrance of the maze
	 */
	private GraphNode entrance = null;
	/**
	 * Instance variable to indicate the exit of the maze
	 */
	private GraphNode exit = null;
	
	/**
	 * constructor for the maze
	 * 
	 * @param inputFile the file storing information about the maze
	 * @throws MazeException if the file doesn't exist
	 * @throws GraphException if there is something wrong with the graph
	 */
	public Maze(String inputFile) throws MazeException, GraphException
	{
		try 
		{
			Scanner scanner = new Scanner(new File(inputFile));
			this.scale = scanner.nextInt();
			this.width = scanner.nextInt();
			this.length = scanner.nextInt();
			this.coin = scanner.nextInt();
			int size = width * length;	
			this.maze = new Graph(size);
			
			for (int i = 0; i < (length*2 - 1); i++)
			{
				int numName = 0;
				String inputString = scanner.next();
				
				// even rows have node and edge
				if (i % 2 == 0)
				{
					for (int j = 0; j < (width * 2 - 1); j++)
					{   
						char inputChar = inputString.charAt(j);
						
						// even columns have nodes 
						if (j % 2 == 0)
						{
							GraphNode node;
							node = maze.getNode(width * i/2 + numName);
			    		   
							if (inputChar == 's' || inputChar == 'S')
							{
								this.entrance = node;

							}
							else if (inputChar == 'x' || inputChar == 'X')
							{
								this.exit = node;
							}
							
							numName++;
						}
						// odd columns have edges
						else
						{
							GraphNode node1 = maze.getNode(width * i/2 + numName - 1);
							GraphNode node2 = maze.getNode(width * i/2 + numName);
			    		   
							if (inputChar == 'c' || inputChar == 'C')
							{
								maze.insertEdge(node1, node2, 0, "corridor");	
							}
							else if(Character.isDigit(inputChar) == true)
			    		   	{
			    			   maze.insertEdge(node1, node2, Character.getNumericValue(inputChar), "door");
			    		   	}
						} 
					}
				}
				// odd rows have only edges
				else
				{ 
					for (int j = 0; j < (width*2 - 1); j++)
					{
						char inputChar = inputString.charAt(j);
						
						if (j%2 == 0)
						{
							GraphNode node1 = maze.getNode(width * ((i-1)/2) + numName);
							GraphNode node2 = maze.getNode(width * ((i+1)/2) + numName);
							
							if (inputChar == 'c' || inputChar == 'C')
							{
								maze.insertEdge(node1, node2, 0, "corridor");
							}
							else if(Character.isDigit(inputChar) == true)
							{
								maze.insertEdge(node1, node2, Character.getNumericValue(inputChar), "door");
							}
							
							numName++;
						}
					}
				}
			}
		scanner.close();
		}
		catch (FileNotFoundException e) 
		{
			throw new MazeException("Input file not found.");
		}
	}
	
	/**
	 * getter for the graph
	 * 
	 * @return the graph of the maze
	 * @throws MazeException when the graph is empty
	 */
	public Graph getGraph() throws MazeException
	{
		if (this.maze == null)
		{
			throw new MazeException("Graph Empty.");
		}
		return this.maze;
	}
	
	/**
	 * solves the maze and finds a path
	 * 
	 * @return an iterator that stores the order of nodes to solve the maze
	 * @throws GraphException if the maze construction had an error 
	 */
	public Iterator solve() throws GraphException
	{
		List<GraphNode> path = new ArrayList<GraphNode>();
		DFS(this.entrance, path, 0,coin);
		// use helper function DFS
		if (path.size() != 0)
		{
			Iterator<GraphNode> returnIter = path.iterator();
			return returnIter;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Do a depth first search on the maze
	 * 
	 * @param current current node
	 * @param path the path maze will take
	 * @param coinUsed coin used in the was
	 * @param maxCoin maximum coin available
	 * @return true if found an exit false if otherwise
	 * @throws GraphException if the maze construction had an error
	 */
	private void DFS(GraphNode current, List<GraphNode> path, int usedCoin, int maxCoin) throws GraphException
	{
		path.add(current);
		current.mark(true);
	    Iterator<GraphEdge> edges = maze.incidentEdges(current);
	    
	    while (edges.hasNext())
	    {
	    	if (path.get(path.size() - 1) == this.exit)
	    	{
	    		return;
	    	}
	    	else
	    	{
		    	GraphNode nextNode;
		    	GraphEdge pathEdge = edges.next();
		    	
		    	if (current == pathEdge.firstEndpoint())
		    	{
		    		nextNode = pathEdge.secondEndpoint();
		    	}
		    	else
		    	{
		    		nextNode = pathEdge.firstEndpoint();
		    	}
		    
		    	if (nextNode.isMarked() == false && usedCoin + pathEdge.getType() <= maxCoin)
		    	{
		    		if (nextNode.equals(exit))
		    		{
		    			path.add(nextNode);
		    			nextNode.mark(true);
		    			return;
		    		}
		    		
		    		DFS(nextNode, path, pathEdge.getType() + usedCoin, maxCoin);
		    	}
		    	else
		    	{
		    		continue;
		    	}
	    	}
	    }
	    
	    if (path.get(path.size() - 1) == this.exit)
    	{
	    	return;
    	}
	    else
	    {
	    	if (path.size() - 2 > -1)
		    {
			    GraphEdge preEdge = maze.getEdge(path.get(path.size() - 1), path.get(path.size() - 2));
			    
			    if (preEdge.getType() != 0)
			    {
			    	usedCoin -= preEdge.getType();
			    }
		    }
    	
		    path.remove(path.size() - 1);
		    current.mark(false);
		    return ;
	    }
	}
}	
