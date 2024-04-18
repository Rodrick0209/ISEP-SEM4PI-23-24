CC=gcc
CFLAGS=-I.
DEPS = header.h
OBJ = main.o ProcessFile.o readConfig.o monitor_directory.o destributeFiles.o utils.o handleSignals.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

main: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

.PHONY: clean

clean:
	rm -f *.o main

run:
	./main