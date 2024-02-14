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

int main(void)
{
    Matrix matrix = matrix_construction();
    
    while (1)
    {
        int number;
        char str[100];
        
        // get key
        if (scanf("%d ", &number) == EOF)
        {
            break;
        }
        fgets(str, sizeof(str), stdin);
        
        size_t len = strlen(str);
        if (len > 0 && str[len - 1] == '\n')
        {
            str[len - 1] = '\0';
        }
        
        // insert if not there, overwrite if it is there
        if (matrix_index_in(matrix, str, number) == '0')
        {
            matrix_set(matrix, str, number, 1);
        }
        else
        {
            const Value * old_value = matrix_get(matrix, str, number);
            Value new_value = *old_value + 1;
            matrix_set(matrix, str, number, new_value);
        }
    }
    
    // print output
    printf("Number        Street          Occurrence\n");
    matrix_list(matrix);
    
    // free memory
    matrix_destruction(matrix);
}
