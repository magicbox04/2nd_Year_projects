// CS2211a 2023, Section 1
// Assignment number 2
// Sangjae Lee
// 251276506
// SLEE2883
// October 3rd  2023

#include <stdio.h>

// function to convert celsius and Fahrenheit
float CelsiusAndFahrenheit (void)
{
    char ch;
    float value;
    printf("C for conversion from Celsius to Fahrenheit and F for conversion from Fahrenheit to Celsius\n");
    scanf(" %c", &ch);
    
    // loop to determin what conversion user wants and return accordingly
    while (1)
    {
        if (ch == 'C' || ch == 'c')
        {
            printf("enter the value\n");
            scanf("%f", &value);
            
            return ((value * 1.8) + 32);
        }
        else if (ch == 'F' || ch == 'f')
        {
            printf("enter the value\n");
            scanf("%f", &value);
            
            return ((value - 32) / 1.8);
        }
        else
        {
            printf("reenter the correct input\n");
        }
    }
    return 0;
}

// function to convert centimeter and inch
float CentimeterAndInch (void)
{
    char ch;
    float value;
    printf("C for conversion from Centimetre to Inch and I for conversion from Inch to Centimetre\n");
    scanf(" %c", &ch);

    while (1)
    {
        if (ch == 'C' || ch == 'c')
        {
            printf("enter the value\n");
            scanf("%f", &value);
            
            return (value / 2.54);
        }
        else if (ch == 'I' || ch == 'i')
        {
            printf("enter the value\n");
            scanf("%f", &value);
            
            return (value * 2.54);
        }
        else
        {
            printf("reenter the correct input\n");
        }
    }
    return 0;
}

// function to convert kilometer and mile
float KilometerAndMile (void)
{
    char ch;
    float value;
    printf("K for conversion from Kilometer to Mile and M for conversion from Mile to Kilometer\n");
    
    scanf(" %c", &ch);
    while (1)
    {
        if (ch == 'K' || ch == 'k')
        {
            printf("enter the value\n");
            scanf("%f", &value);
            
            return (value * 0.621371);
        }
        else if (ch == 'M' || ch == 'm')
        {
            printf("enter the value\n");
            scanf("%f", &value);
            
            return (value / 0.621371);
        }
        else
        {
            printf("reenter the correct input\n");
        }
    }
    return 0;
}

// function to convert gallon and liter
float GallonAndLiter (void)
{
    char ch;
    float value;
    printf("G for conversion from Gallon to Liter and L for conversion from Liter to gallon\n");
    
    scanf(" %c", &ch);
    while (1)
    {
        if (ch == 'G' || ch == 'g')
        {
            printf("enter the value\n");
            scanf("%f", &value);
            
            return (value * 3.78541);
        }
        else if (ch == 'L' || ch == 'l')
        {
            printf("enter the value\n");
            scanf("%f", &value);
            
            return (value / 3.78541);
        }
        else
        {
            printf("reenter the correct input\n");
        }
    }
    return 0;
}

int main(int argc, const char * argv[])
{
    int input;
    while (input != 0)
   {
       
       printf("1 for conversion between Celsius and Fahrenheit\n");
       printf("2 for conversion between Centimetre and Inch\n");
       printf("3 for conversion between Kilometer and Mile\n");
       printf("4 for conversion between Gallon and Liter\n");
       printf("0 for quit\n");
       scanf("%d", &input);
       
       switch (input)
       {
           case 1:
               printf("%f\n", CelsiusAndFahrenheit());
               break;
           case 2:
               printf("%f\n", CentimeterAndInch());
               break;
           case 3:
               printf("%f\n", KilometerAndMile());
               break;
           case 4:
               printf("%f\n", GallonAndLiter());
               break;
           case 0:
               break;
           default:
               continue;
       }
   }
    return 0;
}

