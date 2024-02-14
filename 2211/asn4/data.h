// CS2211a 2023, Section 1
// Assignment 4
// Sangjae Lee
// 251276506
// SLEE2883
// Nov 14th 2023

typedef struct {char *name; int num;} Key;
typedef struct {Key key; int data;} Node;
Key key_construct(char *in_name, int in_num);
int key_comp(Key key1, Key key2);
void print_key(Key key);
void print_node(Node node);
