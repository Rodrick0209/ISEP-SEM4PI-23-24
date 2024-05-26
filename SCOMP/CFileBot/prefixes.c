#include "header.h"
#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <string.h>
#include <ctype.h>

// Function to validate if the filename matches "<number>-candidate-data.txt"
bool validate_filename(const char *filename, char *prefix) {
    // Check if the filename matches the pattern "<number>-candidate-data.txt"
    // where <number> can be any sequence of digits
    int len = strlen(filename);
    if (len < 19) // Minimum length check
        return false;

    int i = 0;
    while (isdigit(filename[i])) {
        i++;
    }

    if (filename[i] != '-') // Check for hyphen after the number
        return false;

    if (strncmp(&filename[i + 1], "candidate-data.txt", 17) != 0) // Check for the rest of the filename
        return false;

    strncpy(prefix, filename, i);
    prefix[i] = '\0';

    return true;
}

// Function to get the prefixes of candidate data files
char** get_candidate_data_file_prefixes(const char *directory_path, int *count) {
    DIR *dir;
    struct dirent *ent;
    char **prefixes = NULL;
    *count = 0;

    // Open the specified directory
    if ((dir = opendir(directory_path)) != NULL) {
        // Iterate through all entries in the directory
        while ((ent = readdir(dir)) != NULL) {
            // Ignore the directories "." and ".."
            if (strcmp(ent->d_name, ".") != 0 && strcmp(ent->d_name, "..") != 0) {
                char prefix[256];
                // Check if the filename matches the pattern
                if (validate_filename(ent->d_name, prefix)) {
                    prefixes = realloc(prefixes, sizeof(char*) * (*count + 1));
                    prefixes[*count] = strdup(prefix);
                    (*count)++;
                }
            }
        }
        closedir(dir);
    } else {
        perror("Error opening directory");
        return NULL;
    }

    return prefixes;
}

