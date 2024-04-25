CC = gcc
CFLAGS = -Wall -Wextra
SRC = $(wildcard *.c)
OBJ = $(SRC:.c=.o)
EXEC = test_main

all: $(EXEC)
		
$(EXEC): $(OBJ)
		$(CC) $(CFLAGS) -o $@ $^ ../FileBot/utils.c 

%.o: %.c
		$(CC) $(CFLAGS) -c $< -o $@

run: $(EXEC)
		./$(EXEC)

clean:
		rm -f $(OBJ) $(EXEC)

.PHONY: all run clean