// CS2211a 2023, Section 1
// Assignment 5
// Sangjae Lee
// 251276506
// SLEE2883
// Nov 27th 2023

#include "datatype.h"
typedef struct BStree_node
{
    Key key;
    Data data;
    struct BStree_node *left;
    struct BStree_node *right;
} BStree_node;
typedef BStree_node** BStree;

BStree bstree_ini(void);
void bstree_insert(BStree bst, Key key, Data data);
BStree_node *new_node(Key key, Data data);
Data bstree_search(BStree bst, Key key);
void bstree_traverse(BStree bst);
void bstree_free(BStree bst);

