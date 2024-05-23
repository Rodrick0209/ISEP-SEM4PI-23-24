CC=gcc
CFLAGS=-I.
DEPS = header.h
OBJ = main.o readConfig.o init_sem.o init_shm.o shm_operations.o files.o
OBJ1 = monitor_directory.o
OBJ2 = child.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

main: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)
	 make monitor_directory
	 make child

monitor_directory: $(OBJ1)
	$(CC) -o $@ $^ $(CFLAGS)

child: $(OBJ2)
	$(CC) -o $@ $^ $(CFLAGS)

.PHONY: clean

clean:
	rm -f *.o main
	rm -f *.o monitor_directory
	rm -f *.o child

run:
	./main
	