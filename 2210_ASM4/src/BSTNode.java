/**
 * BSTNode creates a tree node for the BST
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : November 17  2023
 * Last Edited : November 16 2023
 * Professor : Professor Narayan
 */

public class BSTNode 
{
	/**
	 * Instance variable to indicate the record part of the Node
	 */
	private Record record;
	/**
	 * Instance variable to indicate the left child part of the node
	 */
	private BSTNode leftNode;
	/**
	 * Instance variable to indicate the right child part of the node
	 */
	private BSTNode rightNode;
	/**
	 * Instance variable to indicate the parent part of the node
	 */
	private BSTNode parentNode;

	/**
	 * A constructor which initializes a BSTNode object
	 * @param item the record to be stored in the Node
	 */
	public BSTNode(Record item)
	{
		this.record = item;
		this.leftNode = null;
		this.rightNode = null;
		this.parentNode = null;
	}
	
	/**
	 * getter for the record 
	 * @return returns the record of the Node
	 */
	public Record getRecord()
	{
		return this.record;
	}
	
	/**
	 * Setter for the record
	 * @param d Record that will be set as the record of this object
	 */
	public void setRecord (Record d)
	{
		this.record = d;
	}
	
	/**
	 * getter for the leftNode
	 * @return returns the left child of the node
	 */
	public BSTNode getLeftChild()
	{
		return this.leftNode;
	}
	
	/**
	 * getter for the rightNode
	 * @return returns the right child of the node
	 */
	public BSTNode getRightChild()
	{
		return this.rightNode;
	}
	
	/**
	 * getter for the parentNode
	 * @return returns the parent of the node
	 */
	public BSTNode getParent()
	{
		return this.parentNode;
	}
	
	/**
	 * setter for the leftNode
	 * @param u node that will be set as the left child of this object
	 */
	public void setLeftChild(BSTNode u)
	{
		this.leftNode = u;
	}
	
	/**
	 * setter for the rightNode
	 * @param u node that will be set as the right child of this object
	 */
	public void setRightChild(BSTNode u)
	{
		this.rightNode = u;
	}
	
	/**
	 * setter for the parent
	 * @param u node that will be set as the parent of this object
	 */
	public void setParent(BSTNode u)
	{
		this.parentNode = u;
	}
	
	/**
	 * checks if the node is a leaf
	 * @return true if leaf false if not
	 */
	public boolean isLeaf()
	{
		if (this.leftNode == null && this.rightNode == null && 
				this.record.getKey() == null && this.record.getDataItem() == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
