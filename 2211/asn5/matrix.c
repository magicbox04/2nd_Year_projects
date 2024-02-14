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
#include "matrix.h"

// Matrix construction using bstree ini()
Matrix matrix_construction(void)
{
    Matrix matrix = bstree_ini();
    
    return matrix;
}

// If location (index1, index2) is defined in Matrix m, then return 1. Otherwise, return 0.
unsigned char matrix_index_in(Matrix m, Index1 index1, Index2 index2)
{
    Key key = key_ini();
    key_set(key, index1, index2);
    
    if (bstree_search(m, key) != NULL)
    {
        key_free(key);
        return '1';
    }
    else
    {
        key_free(key);
        return '0';
    }
}

// If location (index1, index2) is defined in Matrix m, then return a pointer to the associated
// value. Otherwise, return NULL.
const Value *matrix_get(Matrix m, Index1 index1, Index2 index2)
{
    Key key = key_ini();
    key_set(key, index1, index2);
    
    if (bstree_search(m, key) != NULL)
    {
        Value *value = bstree_search(m, key);
        key_free(key);
        return value;
    }
    else
    {
        key_free(key);
        return NULL;
    }
}

// Assign value to Matrix m at location (index1, index2). If that location already has value,
// then overwrite.
void matrix_set(Matrix m, Index1 index1, Index2 index2, Value value)
{
    Key key = key_ini();
    key_set(key, index1, index2);
    Data data = data_ini();
    data_set(data, value);
    if (bstree_search(m, key) == NULL)
    {
        bstree_insert(m, key, data);
    }
    else
    {
        Value *old_Value = bstree_search(m, key);
        *old_Value = value;
    }
}

// Print indices and values in the Matrix m (with bstree traverse()).
void matrix_list(Matrix m)
{
    bstree_traverse(m);
}

// Free allocated space (with bstree free()).
void matrix_destruction(Matrix m)
{
    bstree_free(m);
}
