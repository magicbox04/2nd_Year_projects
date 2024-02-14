// CS2211a 2023, Section 1
// Assignment 5
// Sangjae Lee
// 251276506
// SLEE2883
// Nov 27th 2023

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "datatype.h"

//Create and initialize a key with dynamic memory allocation
Key key_ini(void)
{
    Key key = (Key)malloc(sizeof(Key_struct));
    key -> key1 = NULL;
    key -> key2 = 0;
    
    return key;
}

// Set dynamic allocation memory and copy string and set integer
void key_set(Key key, Key1 key1, Key2 key2)
{
    key -> key1 = strdup(key1);
    key -> key2 = key2;
}

// Compare two keys
int key_comp(Key key1, Key key2)
{
    int comp = strcmp(key1->key1, key2->key1);
    
    if (comp == 0)
    {
        if (key1->key2 < key2->key2)
        {
            return -1;
        }
        else if(key1->key2 > key2->key2)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    return comp;
}

// print key with string first
void key_print1(Key key)
{
    printf("%s\n", key->key1);
    printf("%d\n", key->key2);
}

// print key with number first
void key_print2(Key key)
{
    printf("%d\n", key->key2);
    printf("%s\n", key->key1);
}

// free key
void key_free(Key key)
{
    free(key);
    key = NULL;
}

// Create and initialize a data with dynamic memory allocation
Data data_ini(void)
{
    Data data = (Data)malloc(sizeof(float));
    
    return data;
}

// Assign value of data with intdata.
void data_set(Data data, float intdata)
{
    *data = intdata;
}

// Print a data
void data_print(Data data)
{
    printf("%f\n", *data);
}

// Free memory allocated for data
void data_free(Data data)
{
    free(data);
    data = NULL;
}
