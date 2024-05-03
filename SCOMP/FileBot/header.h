#ifndef MY_HEADER_H
#define MY_HEADER_H

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <dirent.h>
#include <signal.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>



#define CONFIG_FILE "configFile"
#define MAX_CHILDREN 3
#define MAX_FILENAME 256
#define MAX_FILES 20
#define MAX_CANDIDATES 1000

// Global variables
extern char input_directory[MAX_FILENAME];
extern char output_directory[MAX_FILENAME];
extern char report_file[MAX_FILENAME];
extern int worker_children;
extern int check_interval;
extern int **pipes;       // Array of pipes, one for each child process
extern int *child_status; // Array to keep track of whether each child is busy
extern int processed_ids[MAX_FILES];
extern int num_ids;
extern int fd[2];
extern int num_files;
extern int *child_pids;




// Function ProcessFile.c
void ensure_JobOpening_directory_exists(const char *dir);
void processCandidateFile(char file_names[][MAX_FILENAME], int array_size);
char* getJobApplicationReference(const char *filename);
int getCandidateNumber(const char *filename);
void moveFile(const char *filename,const char *dir,int dirApplication);
void ensure_Application_directory_exists(const char *dirJobOpening,int dirApplication);


// Function readConfig.c
void read_config();

// Function monitorDirectory.c
void monitor_directory();

// Function distributeFiles.c
void distribute_files();

// Function utils.c
void allocate_memory();
void free_memory();
bool id_exists(int id);
void add_id(int id);
int count_unique_identifiers(const char *input_directory);
void remove_non_printable_chars(char* str);
bool reorganize_array(char files[MAX_FILES][MAX_FILENAME], int fileCount);
int getChildIndex();
void inicializa();


//Function handleSignals.c
void handle_fileFoundSignal(int signo, siginfo_t *sinfo, void *context);
void handle_childWorkFinishedSignal(int signo, siginfo_t *sinfo, void *context);
void sigint_handler(int signo, siginfo_t *sinfo, void *context);


// Function generateReport.c
void generateReport();
int countCandidatures();
void loadCandidateInfo();
int countFilesInDirectory(const char *dirPath);
void loadFilesInDirectory(const char *dirPath, char files[MAX_FILES][MAX_FILENAME]);
void getEmailFromCandidateData(const char *filePath, char *email);



#endif // MY_HEADER_H