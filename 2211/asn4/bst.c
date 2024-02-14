// CS2211a 2023, Section 1
// Assignment 4
// Sangjae Lee
// 251276506
// SLEE2883
// Nov 14th 2023

#include <stdio.h>
#include <stdlib.h>
#include "bst.h"

// Input: ’size’: size of an array
// Output: a BStree,
// Effect: allocate memory for a Node array of size+1 for member tree_nodes
// allocate memory for an unsigned char array of size+1 for member is_free
// set all entries of is_free to 1
// set member size to ’size’;
BStree bstree_ini(int size)
{
    BStree returnTree;
    returnTree.tree_nodes = (Node*)malloc((size + 1) * sizeof(Node));
    returnTree.is_free = (unsigned char*)malloc((size + 1) * sizeof(unsigned char));
    
    for (int i = 0; i <= size; ++i)
    {
        returnTree.is_free[i] = 1;
    }
    
    returnTree.size = size;

    return returnTree;
}

// Input: ’bst’: a binary search tree
// ’key’: a Key
// ’data’: an integer
// 'index': the index of the array
// Effect: recursivly insert data and key inot ’bst’
// if ’key’ is already in ’bst’, do nothing
void binsert(BStree bst, Key key, int data, int index)
{
    // check for index out of bounds
    if (index > bst.size)
    {
        printf("Error: Index out of bounds\n");
        exit(1);
    }
    
    // insert if the location found
    if (index <= bst.size && bst.is_free[index] == 1)
    {
        bst.tree_nodes[index].key = key;
        bst.tree_nodes[index].data = data;
        bst.is_free[index] = 0;
    }
    // recursivly find the correct location
    else if(index <= bst.size)
    {
        int comp = key_comp(key, bst.tree_nodes[index].key);
        
        if (comp > 0)
        {
            binsert(bst, key, data, 2 * index + 1);
        }
        else if (comp < 0)
        {
            binsert(bst, key, data, 2 * index);
        }
    }
}

// Input: ’bst’: a binary search tree
// 'index': the index of array
// Effect: print all the nodes in bst using in order traversal recursivly
void inorder(BStree bst, int index)
{
    if (index <= bst.size && bst.is_free[index] == 0)
    {
        // Traverse the left subtree
        inorder(bst, 2 * index);

        // Visit the current node
        print_node(bst.tree_nodes[index]);

        // Traverse the right subtree
        inorder(bst, 2 * index + 1);
    }
}

// Input: ’bst’: a binary search tree
// ’key’: a Key
// ’data’: an integer
// Effect: ’data’ with ’key’ is inserted into ’bst’
// if ’key’ is already in ’bst’, do nothing
void bstree_insert(BStree bst, Key key, int data)
{
    binsert(bst, key, data, 1);
}
// Input: ’bst’: a binary search tree
// Effect: print all the nodes in bst using in order traversal
void bstree_traversal(BStree bst)
{
    inorder(bst, 1);
}
// Input: ’bst’: a binary search tree
// Effect: all dynamic memory used by bst are freed
void bstree_free(BStree bst)
{
    free(bst.is_free);
    free(bst.tree_nodes);
}
