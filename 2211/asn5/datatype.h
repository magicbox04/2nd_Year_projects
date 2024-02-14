// CS2211a 2023, Section 1
// Assignment 5
// Sangjae Lee
// 251276506
// SLEE2883
// Nov 27th 2023

typedef float* Data;
typedef char* Key1;
typedef int Key2;
typedef struct 
{
    Key1 key1;
    Key2 key2;
} Key_struct;
typedef Key_struct* Key;

Key key_ini(void);
void key_set(Key key, Key1 key1, Key2 key2);
int key_comp(Key key1, Key key2);
void key_print1(Key key);
void key_print2(Key key);
void key_free(Key key);
Data data_ini(void);
void data_set(Data data, float intdata);
void data_print(Data data);
void data_free(Data data);

