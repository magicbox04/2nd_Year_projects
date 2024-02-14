/**
 * BSTNode creates a BST for the BSTDictionary
 * @author Sangjae Lee
 * @version 1.0
 * Due Date : November 17  2023
 * Last Edited : November 16 2023
 * Professor : Professor Narayan
 */

public class BinarySearchTree 
{
	/**
	 * Instance variable to indicate the root of the tree
	 */
	private BSTNode root;
	
	/**
	 * The constructor that creates a leaf node as the root of the tree.
	 */
	public BinarySearchTree()
	{
		this.root = new BSTNode(new Record(null, null));
	}
	
	/**
	 * getter for the root of the tree
	 * @return returns the root of the tree
	 */
	BSTNode getRoot()
	{
		return root;
	}
	
	/**
	 * search function that finds the node stored in the tree with a given key; 
	 * @param r the root of the subtree to be searched
	 * @param k the key for the node being searched
	 * @return returns the node if in tree, null if the key is not in the tree
	 */
	BSTNode get(BSTNode r, Key k)
	{
		if (r.isLeaf())
		{
			return null;
		}
		else
		{
			int comparison = r.getRecord().getKey().compareTo(k);
			
			if (comparison == 0)
			{
				return r;
			}
			else if (comparison == -1)
			{
				return get(r.getRightChild(), k);
			}
			else
			{
				return get(r.getLeftChild(), k);
			}
		}
	}
	
	/**
	 * Adds the record to the binary search tree 
	 * @param r the root of the subtree to be searched
	 * @param d the record of the new node being inserted
	 * @throws DictionaryException node with same key as d already in tree.
	 */
	void insert (BSTNode r, Record d) throws DictionaryException
	{
		if (r.isLeaf()) 
		{
			r.setRecord(d);
			BSTNode leftChild = new BSTNode(new Record(null,null));
	    	BSTNode rightChild = new BSTNode(new Record(null,null));
	    	
	    	leftChild.setParent(r);
	    	rightChild.setParent(r);
	    	r.setLeftChild(leftChild);
	    	r.setRightChild(rightChild);
	    	
	    } 
		else 
		{
			int comparison = r.getRecord().getKey().compareTo(d.getKey());
	
            if (comparison == 0) 
            {
            	throw new DictionaryException("Dictionary Error");
	        } 
            else if (comparison < 0) 
            {
                // base case 1
            	if (r.getRightChild().isLeaf() == true) 
                {
                	// add new node
            		BSTNode temp = new BSTNode(d);
                	BSTNode leftChild = new BSTNode(new Record(null,null));
        	    	BSTNode rightChild = new BSTNode(new Record(null,null));
        	    	
                	temp.setParent(r);
                	temp.setLeftChild(leftChild);
                	temp.setRightChild(rightChild);
                	leftChild.setParent(temp);
        	    	rightChild.setParent(temp);
                	r.setRightChild(temp);
                } 
            	// recursive case 1
                else 
                {
                    insert(r.getRightChild(), d);
                }
            } 
            else 
            {
            	// base case 2
                if (r.getLeftChild().isLeaf() == true) 
                {
                	// add new node
                	BSTNode temp = new BSTNode(d);
                	BSTNode leftChild = new BSTNode(new Record(null,null));
        	    	BSTNode rightChild = new BSTNode(new Record(null,null));
        	    	
                	temp.setParent(r);
                	temp.setLeftChild(leftChild);
                	temp.setRightChild(rightChild);
                	leftChild.setParent(temp);
        	    	rightChild.setParent(temp);
                	r.setLeftChild(temp);
                } 
                // recursive case 2
                else 
                {
                	insert(r.getLeftChild(), d);
                }
            }
        }
	}
	
	/**
	 * Adds the node with key k from the binary search tree 
	 * @param r the root of the subtree to be searched 
	 * @param k the key of the node that needs to be deleted
	 * @throws DictionaryException the tree does not store a record with the given key
	 */
	void remove (BSTNode r, Key k) throws DictionaryException
	{
		BSTNode target = get(r, k);
		if (target == null)
		{
        	throw new DictionaryException("Dictionary Error");
		}
		else 
		{
			// base case 1
			if (target.getLeftChild().isLeaf())
			{
				BSTNode temp = target.getRightChild();
				BSTNode parent = target.getParent();	
				
				if (parent != null)
				{
					target.setParent(null);
					if (parent.getRecord().getKey().compareTo(target.getRecord().getKey()) < 0)
					{
						parent.setRightChild(temp);
					}
					else
					{
						parent.setLeftChild(temp);
					}
					temp.setParent(parent);
				}
				else 
				{
					// if r is root
					r.setRecord(temp.getRecord());
	                r.setLeftChild(temp.getLeftChild());
	                r.setRightChild(temp.getRightChild());
	                r.setParent(temp.getParent());
				}
			}
			// base case 2
			else if(target.getRightChild().isLeaf())
			{
				BSTNode temp = target.getLeftChild();
				BSTNode parent = target.getParent();
				if (parent != null)
				{
					target.setParent(null);
					if (parent.getRecord().getKey().compareTo(target.getRecord().getKey()) < 0)
					{
						parent.setRightChild(temp);
					}
					else
					{
						parent.setLeftChild(temp);
					}
					temp.setParent(parent);
				}
				else
				{
					// if r is root
					r.setRecord(temp.getRecord());
	                r.setLeftChild(temp.getLeftChild());
	                r.setRightChild(temp.getRightChild());
	                r.setParent(temp.getParent());
				}
			}
			// recursive case
			else
			{
				// if internal node with no leafs
				BSTNode temp = smallest(target.getRightChild());
				target.setRecord(temp.getRecord());
				remove (temp, temp.getRecord().getKey());
			}
		}
	}
	
	/**
	 * Returns the successor of the given key in the tree with root r
	 * @param r the root of the subtree to be searched
	 * @param k the key being searched to find the successor
	 * @return returns the node with successor of k or null if the successor not in tree
	 */
	BSTNode successor(BSTNode r, Key k)
	{
		// base case 1
		if (r.isLeaf() == true)
		{
				BSTNode parent = r.getParent();
				
				while (parent != null && parent.getRecord().getKey().compareTo(k) < 0)
				{
					parent = parent.getParent();
				}
				
				return parent;
		}
		else
		{
			// base case 2
			if (r.getRecord().getKey().compareTo(k) == 0)
			{
				if (r.getRightChild().isLeaf() == false)
				{
					return smallest (r.getRightChild());
				}
				else
				{
					BSTNode parent = r.getParent();
					
					while (parent != null && parent.getRecord().getKey().compareTo(k) < 0)
					{
						parent = parent.getParent();
					}
					
					return parent;
				}
			}
			// recursive case
			else
			{
				if (r.getRecord().getKey().compareTo(k) < 0)
				{
					return successor(r.getRightChild(),k);
				}
				else
				{
					return successor(r.getLeftChild(),k);
				}
			}
		}
	}
	
	/**
	 * Returns the predecessor of the given key in the tree with root r
	 * @param r the root of the subtree to be searched
	 * @param k the key being searched to find the predecessor
	 * @return returns the node with predecessor of k or null if the predecessor not in tree
	 */
	BSTNode predecessor(BSTNode r, Key k)
	{
		// base case 1
		if (r.isLeaf() == true)
		{
				BSTNode parent = r.getParent();
				
				while (parent != null && parent.getRecord().getKey().compareTo(k) > 0)
				{
					parent = parent.getParent();
				}
				
				return parent;
		}
		else
		{
			// base case 2
			if (r.getRecord().getKey().compareTo(k) == 0)
			{
				if (r.getLeftChild().isLeaf() == false)
				{
					return largest (r.getLeftChild());
				}
				else
				{
					BSTNode parent = r.getParent();
					
					while (parent != null && parent.getRecord().getKey().compareTo(k) > 0)
					{
						parent = parent.getParent();
					}
					
					return parent;
				}
			}
			// recursive case
			else
			{
				if (r.getRecord().getKey().compareTo(k) < 0)
				{
					return predecessor(r.getRightChild(),k);
				}
				else
				{
					return predecessor(r.getLeftChild(),k);
				}
			}
		}
	}
	
	/**
	 * Finds the node with the smallest key.
	 * @param r the root of the subtree to be searched 
	 * @return the smallest key in tree with root r
	 */
	BSTNode smallest(BSTNode r)
	{
		if (r == null)
		{
			return null;
		}
		else
		{
			BSTNode temp = r;
			
			while (temp.isLeaf() == false)
			{
				temp = temp.getLeftChild();
			}
			
			return temp.getParent();
		}
	}
	
	/**
	 * Finds the node with the largest key.
	 * @param r the root of the subtree to be searched 
	 * @return the largest key in tree with root r
	 */
	BSTNode largest (BSTNode r)
	{
		if (r == null)
		{
			return null;
		}
		else
		{
			BSTNode temp = r;
			
			while (temp.isLeaf() == false)
			{
				temp = temp.getRightChild();
			}
			
			return temp.getParent();
		}
	}
}
