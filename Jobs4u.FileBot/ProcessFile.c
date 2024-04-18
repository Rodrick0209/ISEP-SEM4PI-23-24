#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <dirent.h>
#include <signal.h>
#include <string.h>
#include <fcntl.h>
#include <ctype.h>

#define inputDirectory "input"
#define outputDirectory "output"
#define MAX_FILENAME 256



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

char* getJobApplicationReference(const char *filename){
  char path[256];
  sprintf(path, "%s/%s",inputDirectory, filename);

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
  sprintf(path, "%s/%s",outputDirectory, dir);


  struct stat st = {0};

  if (stat(path, &st) == -1) {
      mkdir(path, 0700);
  }
}

void ensure_Application_directory_exists(const char *dirJobOpening,int dirApplication) {

  char path[256];
  sprintf(path, "%s/%s/%d",outputDirectory, dirJobOpening,dirApplication);


  struct stat st = {0};

  if (stat(path, &st) == -1) {
      mkdir(path, 0700);
  }
}



void moveFile(const char *filename,const char *dir,int dirApplication) {
  char path[256];
  sprintf(path, "%s/%s",inputDirectory, filename);

  char newPath[256];
  sprintf(newPath, "%s/%s/%d/%s",outputDirectory, dir, dirApplication,filename);

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


/*

int main(){

  char file_names[MAX_FILES][MAX_FILENAME] = {"1-candidate-data.txt","1-big-file-1.txt", "1-cv.txt", "1-email.txt", "1-report-1.txt"};
  char file_names2[MAX_FILES][MAX_FILENAME] = {"2-candidate-data.txt","2-big-file1.txt",  "2-cv.txt", "2-email.txt", "2-letter.txt"};

  processCandidateFile(file_names, MAX_FILES);
  processCandidateFile(file_names2, MAX_FILES);

  return 0;
  return 0;
}

*/
