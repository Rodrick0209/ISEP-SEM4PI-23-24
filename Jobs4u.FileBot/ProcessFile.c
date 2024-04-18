#include "header.h"



int getCandidateNumber(const char *filename) {
    char *filename_copy = strdup(filename);
    char *token;
    int applicationNumber;
    // get the first token
    token = strtok(filename_copy, "-");
    // convert the token to an integer
    applicationNumber = atoi(token);
    free(filename_copy);
    return applicationNumber;
}



char* getJobApplicationReference(const char *filename){
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


void ensure_JobOpening_directory_exists(const char *dir) {

  char path[256];
  sprintf(path, "%s/%s",output_directory, dir);


  struct stat st = {0};

  if (stat(path, &st) == -1) {
      mkdir(path, 0700);
  }
}

void ensure_Application_directory_exists(const char *dirJobOpening,int dirApplication) {

  char path[256];
  sprintf(path, "%s/%s/%d",output_directory, dirJobOpening,dirApplication);


  struct stat st = {0};

  if (stat(path, &st) == -1) {
      mkdir(path, 0700);
  }
}



void moveFile(const char *filename,const char *dir,int dirApplication) {
  char path[256];
  sprintf(path, "%s/%s",input_directory, filename);

  char newPath[256];
  sprintf(newPath, "%s/%s/%d/%s",output_directory, dir, dirApplication,filename);

  if (rename(path, newPath) != 0) {
      printf("Could not move file %s to %s\n", path, newPath);
  }
}

void processCandidateFile(char file_names[][MAX_FILENAME], int array_size) {


  char* jobReference = getJobApplicationReference(file_names[0]);
  int applicationNumber = getCandidateNumber(file_names[0]);


  ensure_JobOpening_directory_exists(jobReference);
  ensure_Application_directory_exists(jobReference,applicationNumber);

  for (int i = 0; i < array_size; i++)
  {
    moveFile(file_names[i],jobReference, applicationNumber);
  }

}
