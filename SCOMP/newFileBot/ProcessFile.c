#include "header.h"
#include <ctype.h>

// Remove non-printable characters from a string
void remove_non_printable_chars(char* str) {
    char* i = str;
    char* j = str;
    while(*i) {
        if(isprint((unsigned char)*i)) {
            *j++ = *i;
        }
        i++;
    }
    *j = 0;
}

// Get the candidate number from the filename (first number)
int getCandidateNumber(const char *filename) {
    char *filename_copy = strdup(filename);
    char *token;
    int applicationNumber;
    // get the first token
    token = strtok(filename_copy, "-");
    // convert the token to an integer
    applicationNumber = atoi(token);
    free(filename_copy);
    // return the candidate number
    return applicationNumber;
}


// Get the job application reference from the first line of the file
char* getJobApplicationReference(const char *filename, const char *input_directory){
  char path[256];
  sprintf(path, "%s/%s",input_directory, filename);

    static char firstLine[256];
    FILE *file = fopen(path, "r");
    if (file == NULL) {
        printf("Could not open file %s\n", path);
        return NULL;
    }

    if (fgets(firstLine, sizeof(firstLine), file) == NULL) {
        printf("Could not read from file %s\n", path);
        fclose(file);
        return NULL;
    }

    fclose(file);

    remove_non_printable_chars(firstLine);

    return firstLine;
}


// Ensure that the directory for the job opening exists
void ensure_JobOpening_directory_exists(const char *dir, const char *output_directory) {

  char path[256];
  sprintf(path, "%s/%s",output_directory, dir);


  struct stat st = {0};

  if (stat(path, &st) == -1) {
      mkdir(path, 0700);
  }
}

// Ensure that the directory for the application exists
void ensure_Application_directory_exists(const char *dirJobOpening,int dirApplication, const char *output_directory) {

  char path[256];
  sprintf(path, "%s/%s/%d",output_directory, dirJobOpening,dirApplication);


  struct stat st = {0};

  if (stat(path, &st) == -1) {
      mkdir(path, 0700);
  }
}


// Move the file to the appropriate directory
void moveFile(const char *filename,const char *dir,int dirApplication, const char *input_directory, const char *output_directory) {
  char path[256];
  sprintf(path, "%s/%s",input_directory, filename);

  char newPath[256];
  sprintf(newPath, "%s/%s/%d/%s",output_directory, dir, dirApplication,filename);

  if (rename(path, newPath) != 0) {
      printf("Could not move file %s to %s\n", path, newPath);
  }
}


// Function that call all the functions above to process the candidate files
void processCandidateFile(char file_names[][MAX_SIZE], int array_size,const char *input,const char *output) {


  char* jobReference = getJobApplicationReference(file_names[0],input);
  int applicationNumber = getCandidateNumber(file_names[0]);


  ensure_JobOpening_directory_exists(jobReference,output);
  ensure_Application_directory_exists(jobReference,applicationNumber,output);

  for (int i = 0; i < array_size; i++)
  {
    moveFile(file_names[i],jobReference, applicationNumber,input,output);
  }

}

