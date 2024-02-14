// CS2211a 2023, Section 1
// Assignment 4
// Sangjae Lee
// 251276506
// SLEE2883
// Nov 14th 2023

#include <stdio.h>

int main(int argc, const char * argv[])
{
    long double e = 1;
    long double input;
    int n = 1;
    long int factorial = 1;
    // get input
    scanf("%Lf", &input);
    
    while (1)
    {
        // when 1/n! < input break
        if (1/(long double)factorial < input)
        {
            break;
        }
        
        factorial = 1;
        
        for(int i=1; i<= n; i++)
        {
            factorial *= i;
        }
        
        e+= 1/(long double)factorial;
        n++;
    }
    printf("%Lf\n", e);
}

