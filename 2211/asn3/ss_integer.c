// CS2211a 2023, Section 1
// Assignment 3
// Sangjae Lee
// 251276506
// SLEE2883
// Oct 20th 2023

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[])
{
    // array of numbers
    const char segements[10][3][3] =
    {
        {
            {' ', '_', ' '},
            {'|', ' ', '|'},
            {'|', '_', '|'}
        },
        {
            {' ', ' ', ' '},
            {' ', '|', ' '},
            {' ', '|', ' '}
        },
        {
            {' ', '_', ' '},
            {' ', '_', '|'},
            {'|', '_', ' '}
        },
        {
            {' ', '_', ' '},
            {' ', '_', '|'},
            {' ', '_', '|'}
        },
        {
            {' ', ' ', ' '},
            {'|', '_', '|'},
            {' ', ' ', '|'}
        },
        {
            {' ', '_', ' '},
            {'|', '_', ' '},
            {' ', '_', '|'}
        },
        {
            {' ', '_', ' '},
            {'|', '_', ' '},
            {'|', '_', '|'}
        },
        {
            {' ', '_', ' '},
            {' ', ' ', '|'},
            {' ', ' ', '|'}
        },
        {
            {' ', '_', ' '},
            {'|', '_', '|'},
            {'|', '_', '|'}
        },
        {
            {' ', '_', ' '},
            {'|', '_', '|'},
            {' ', ' ', '|'},
        }
    };
    
    while (1)
    {
        char input[] = " ";
        char contin;
        printf("give input\n");
        scanf("%s", input);
        
        for (int row = 0; row < 3; row++)
        {
            for (int i = 0; i < strlen(input); i++)
            {
                int digit = input[i] - '0';
                for (int col = 0; col < 3; col++)
                {
                    printf("%c", segements[digit][row][col]);
                }
            }
            printf("\n");
        }
        
        // check if continue
        printf("continue?");
	while (getchar() != '\n');
        scanf("%c", &contin);
        if (contin == 'y'||contin == 'Y')
        {
            continue;
        }
        else if (contin == 'n'||contin == 'N')
        {
            break;
        }
	else
	{
	    printf("invlaid input\n");
            break;
	}
    }
}

