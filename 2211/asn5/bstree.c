// CS2211a 2023, Section 1
// Assignment 5
// Sangjae Lee
// 251276506
// SLEE2883
// Nov 27th 2023

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include "bstree.h"

// helper function to check if a node is a leaf
bool is_leaf(BStree_node *node)
{
    if (node == NULL)
    {
        return true;
    }
    else if (node->left == NULL && node->right == NULL && node->key == NULL && node->data == NULL)
    {
        return true;
    }
    
    return false;
}

// recursive helper function for bst insert
// Insert data with key into bst. If key is in bst, then do nothing.
void binsert_helper(BStree_node **node, Key key, Data data)
{
    if (is_leaf(*node) == true)
    {
        *node = new_node(key, data);
    } 
    else
    {
        int comp = key_comp(key,(*node)->key);
        
        if (comp < 0)
        {
            binsert_helper(&((*node)->left), key, data);
        }
        else if (comp > 0)
        {
            binsert_helper(&((*node)->right), key, data);
        }
        else
        {
            return;
        }
    }
}

// recursive helper function for bst search
// If key is in bst, return key’s associated data. If key is not in bst, return NULL
Data bsearch_helper(BStree_node **node, Key key)
{
    if (is_leaf(*node) == true)
    {
        return NULL;
    }
    else
    {
        int comp = key_comp(key, (*node)->key);
        if (comp == 0)
        {
            return (*node)->data;
        }
        else if (comp < 0)
        {
            return bsearch_helper(&((*node)->left), key);
        }
        else
        {
            return bsearch_helper(&((*node)->right), key);
        }
    }
}

// recursive helper function for bst treverse
// In order traversal of bst and print each node’s key and data.
void btreverse_helper(BStree_node **node)
{
    if (is_leaf(*node) == false)
    {
        btreverse_helper(&(*node)->left);
        printf("%3d      %-25s %.0f\n",(*node)->key->key2, (*node)->key->key1, *((*node)->data));
        btreverse_helper(&(*node)->right);
    }
}

// recursive helper function for bst free
// Free all the dynamically allocated memory of bst.
void bfree_helper(BStree_node **node)
{
    if (is_leaf(*node) == false)
    {
        bfree_helper(&(*node)->left);
        bfree_helper(&(*node)->right);
        key_free((*node)->key);
        data_free((*node)->data);
        free(*node);
        *node = NULL;
    }
    else
    {
        key_free((*node)->key);
        (*node)->key = NULL;
        data_free((*node)->data);
        (*node)->data = NULL;
        free(*node);
        *node = NULL;
    }
}

// Helper function that creats a new node with two leaves.
BStree_node *new_node(Key key, Data data)
{
    BStree_node *node = (BStree_node*)malloc(sizeof(BStree_node));
    BStree_node *left = (BStree_node*)malloc(sizeof(BStree_node));
    BStree_node *right = (BStree_node*)malloc(sizeof(BStree_node));
    
    left->key = NULL;
    left->data = NULL;
    left->left = NULL;
    left->right = NULL;
    
    right->key = NULL;
    right->data = NULL;
    right->left = NULL;
    right->right = NULL;
    
    node->key = key;
    node->data = data;
    node->left = left;
    node->right = right;
    
    return node;
}

// Allocate memory of type BStree node*, set the value to NULL
// Return a pointer to the allocated memory
BStree bstree_ini(void)
{
    BStree bst = (BStree) malloc( sizeof(BStree_node*));
    *bst = NULL;
    
    return bst;
}

// Insert data with key into bst. If key is in bst, then do nothing
void bstree_insert(BStree bst, Key key, Data data)
{
    binsert_helper(bst, key, data);
}

// If key is in bst, return key’s associated data. If key is not in bst, return NULL.
Data bstree_search(BStree bst, Key key)
{
    return bsearch_helper(bst, key);
}

// In order traversal of bst and print each node’s key and data
void bstree_traverse(BStree bst)
{
    btreverse_helper(bst);
}

// Free all the dynamically allocated memory of bst.
void bstree_free(BStree bst)
{
    bfree_helper(bst);
    free (bst);
    bst = NULL;
}
