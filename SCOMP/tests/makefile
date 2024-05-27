CC = gcc
CFLAGS = -Wall -Wextra
SRC = $(wildcard *.c ../CFileBot/readConfig.c ../CFileBot/ProcessFile.c)
OBJ = $(SRC:.c=.o)
EXEC = test_main

all: $(EXEC)
				
$(EXEC): $(OBJ)
				$(CC) $(CFLAGS) -o $@ $^

%.o: %.c
				$(CC) $(CFLAGS) -c $< -o $@

run: $(EXEC)
				./$(EXEC)

clean:
				rm -f $(OBJ) $(EXEC)

.PHONY: all run clean