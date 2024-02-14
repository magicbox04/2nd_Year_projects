// CS2211a 2023, Section 1
// Assignment 4
// Sangjae Lee
// 251276506
// SLEE2883
// Nov 14th 2023

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "data.h"

// Input: ’in_name’: a string ends with ’\0’
// ’in_num’: an integer
// Output: a Key,
// Effect: copy in_name to Key’s name
// set Key’s num to be in_num
Key key_construct(char *in_name, int in_num)
{
    Key returnKey;
    returnKey.name = in_name;
    returnKey.num = in_num;
    
    return returnKey;
}
// Input: ’key1’ and ’key2’ are two Keys
// Output: if return value < 0, then key1 < key2,
// if return value = 0, then key1 = key2,
// if return value > 0, then key1 > key2,
// Note: use strcmp() to compare key1.name and key2.name
// if key1.name = key2.name, then compare key1.num with key2.num
int key_comp(Key key1, Key key2)
{
    int strcmpVal = strcmp(key1.name, key2.name);
    
    if (strcmpVal == 0)
    {
        if (key1.num == key2.num)
        {
            return 0;
        }
        else if (key1.num > key2.num)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    
    return strcmpVal;
}
// Input: ’key’: a Key
// Effect: key.num key.name are printed
void print_key(Key key)
{
    printf("%-3d %-25s", key.num, key.name);
}
// Input: ’node’: a node
// Effect: node.key is printed and then the node.data is printed
void print_node(Node node)
{
    print_key(node.key);
    printf("%-10d\n", node.data);
}
