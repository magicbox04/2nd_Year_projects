// CS2211a 2023, Section 1
// Assignment 3
// Sangjae Lee
// 251276506
// SLEE2883
// Oct 20th 2023

#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <stdbool.h>

// Input: none, read from stdin
// Effect: get the next operator of the expression this operator can be +, -, or ’\n’
// ’\n’ indicates the end of the expression input and leading spaces before the operator should be skipped
// Output: return the next operator of the expression.
char get_op(void)
{
    char oper;
    
    while (1)
    {
        // get input
        oper = getchar();
        if (oper == ' ' || oper == '\t' || isdigit(oper) != 0)
        {
            continue;
        }
        else if (oper == '+' || oper == '-' || oper == '\n')
        {
            break;
        }
        else
        {
            printf("invalid operator\n");
            exit(EXIT_FAILURE);
        }
    }
    
    if(oper == '+' || oper == '-' || oper == '\n')
    {
        return oper;
    }
    return '0';
}

// Input: none, read from stdin
// Effect: get the next numeric value of the expression
// Output: return the next numeric value of the expression.
float get_num(void)
{
    int i = 0;
    char arr [100];
    bool started = false;
    
    while (1)
    {
        char oper;
        char temp;
        oper = getchar();
        
        if (oper == '\n')
        {
            ungetc(oper, stdin);
        }
        if (oper == ' ' || oper == '\t')
        {
            continue;
        }
        if (isdigit(oper) == 0 && started == false)
        {
            temp = getchar();
            if (temp == '\n')
            {
                printf("invalid input\n");
                exit(EXIT_FAILURE);
            }
            else
            {
                ungetc(temp, stdin);
            }
        }
        if ((oper == '-' || oper =='+') &&  started == true)
        {
            ungetc(oper, stdin);
            arr[i] = '\0';
            return atof(arr);
        }
        else if (oper == '-' || oper =='.' || oper == '+' || isdigit(oper) != 0)
        {
            started = true;
            arr[i] = oper;
            i++;
            continue;
        }
       
        else
        {
            arr[i] = '\0';
            ungetc(oper, stdin);
            return atof(arr);
        }        
    }
    
    return 0.0;
}

// Input: ’sub_exp’: the value at the beginning of current stdin.
// The rest of the simple arithmetic expression will be read in from stdin
// Effect: the simple arithmetic expression is evaluated using recursion
// Output: this function returns the value of the simple arithmetic expression
float sub_sim_exp(float sub_exp)
{
    char next_op = get_op();
    
    if (next_op == '\n')
    {
        return sub_exp;
    }
    else if (next_op == '+' || next_op == '-')
    {
        float next_num = get_num();
        if (next_op == '+')
        {
            return sub_sim_exp(sub_exp + next_num);
        }
        else if (next_op == '-')
        {
            return sub_sim_exp(sub_exp - next_num);
        }
    }
    exit(EXIT_FAILURE);
    return 0.0;
}

// Input: none, the simple arithmetic expression will be read in from stdin
// Effect: the simple arithmetic expression is evaluated using a recursive function
// Output: this function returns the value of the simple arithmetic expression
float sim_exp(void)
{
    float num = get_num();
    return sub_sim_exp(num);
}

//main
int main(int argc, const char * argv[])
{
    while(1)
    {
        char input = ' ';
        printf("enter input\n");
        printf("%f\n",sim_exp());
        printf ("Y for continuing inputting a simple arithmetic expression and N for quit \n");
        // empty stdin
        while (getchar() != '\n');
        // if continue or not
        scanf("%c",&input);
        if (input == 'y'||input == 'Y')
        {
            getchar();
            input = ' ';
        }
        else if (input == 'n'||input == 'N')
        {
            exit(EXIT_FAILURE);
        }
    }
    
    return 0;
}
