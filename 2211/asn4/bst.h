// CS2211a 2023, Section 1
// Assignment 4
// Sangjae Lee
// 251276506
// SLEE2883
// Nov 14th 2023

#include "data.h"

typedef struct {Node *tree_nodes; unsigned char *is_free; int size;} BStree;
BStree bstree_ini(int size);
void bstree_insert(BStree bst, Key key, int data);
void bstree_traversal(BStree bst);
void bstree_free(BStree bst);
