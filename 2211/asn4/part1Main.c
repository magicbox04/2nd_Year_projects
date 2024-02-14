// CS2211a 2023, Section 1
// Assignment 4
// Sangjae Lee
// 251276506
// SLEE2883
// Nov 14th 2023

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "bst.h"

int main(void)
{
    int size;
    int index = 0;
    
    scanf("%d", &size);

    // array to store pointer that will be freed after the code is done
    BStree bst = bstree_ini(size);
    char *allocated[size];
    for (int i = 0; i < size; ++i)
    {
        allocated[i] = NULL;
    }

    while (1)
    {
        int data;
        int number;
        char str[100];
        
        // get key
        if (scanf("%d ", &number) == EOF)
        {
            break;
        }
        fgets(str, sizeof(str), stdin);

        // get data
        scanf(" %d", &data);
        
        // get rid of \n
        size_t len = strlen(str);
        if (len > 0 && str[len - 1] == '\n')
        {
            str[len - 1] = '\0';
        }
        
        // store value in tree
        Key key;
        key.name = strdup(str);
        key.num = number;
        bstree_insert(bst, key, data);
        // store key in array
        allocated[index] = key.name;
        index++;
    }
    
    printf("\n");
    bstree_traversal(bst);
    // free the tree and key.names in array
    bstree_free(bst);
    for (int i = 0; allocated[i] != NULL; ++i)
    {
        free(allocated[i]);
    }
    
    return 0;
}
