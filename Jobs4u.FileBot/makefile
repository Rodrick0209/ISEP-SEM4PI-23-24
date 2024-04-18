CC=gcc
CFLAGS=-I.
DEPS = header.h
OBJ = main.o ProcessFile.o readConfig.o destributeFiles.o utils.o handleSignals.o generateReport.o
OBJ1 = monitor_directory.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

main: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

monitor_directory: $(OBJ1)
	$(CC) -o $@ $^ $(CFLAGS)


.PHONY: clean

clean:
	rm -f *.o main

run:
	./main
	