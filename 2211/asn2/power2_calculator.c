// CS2211a 2023, Section 1
// Assignment number 2
// Sangjae Lee
// 251276506
// SLEE2883
// October 2nd 2023

#include <stdio.h>

// Recursive function with logarithmic time complexity
unsigned long powTwo(int input)
{
    // base case
    if (input == 0)
    {
        return 1;
    }
    else
    {
        // Logarithmic time recursive case
        if (input % 2 == 0)
        {
            unsigned long temp = powTwo(input/2);
            return temp * temp;
        }
        else
        {
            unsigned long temp = powTwo((input-1)/2);
            return temp * temp * 2;
        }
    }
}

int main(int argc, const char * argv[])
{
    int input;

    while (1)
    {
        printf("Enter a non-negative integer exponent (0 to exit): ");
        scanf("%d", &input);

        if (input == 0)
        {
            break;
        }
        unsigned long result = powTwo(input);
        printf("%lu\n", result);
    }
    return 0;
}

