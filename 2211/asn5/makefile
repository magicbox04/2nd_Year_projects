
mymatrix: main.o datatype.o bstree.o matrix.o
	cc -o mymatrix main.o datatype.o bstree.o matrix.o

main.o: main.c
	cc -c main.c

datatype.o: datatype.c datatype.h
	cc -c datatype.c

bstree.o: bstree.c bstree.h
	cc -c bstree.c

matrix.o: matrix.c matrix.h
	cc -c matrix.c

clean:
	rm -f mymatrix *.o core
