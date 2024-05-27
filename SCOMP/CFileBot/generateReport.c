#include "header.h"
#include <dirent.h>


//add the interfaces of each function here
int countCandidatures(char *output_directory);
void loadCandidateInfo(char *output_directory);
int countFilesInDirectory(const char *dirPath);
void loadFilesInDirectory(const char *dirPath, char files[MAX_FILES][MAX_SIZE]);
void getEmailFromCandidateData(const char *filePath, char *email);
void generateReport(char *output_directory);

// Structure to hold candidate information
struct Candidate {
    char email[MAX_SIZE];
    char number[MAX_SIZE];
    char jobReference[MAX_SIZE]; // Added to store job reference
    char files[MAX_FILES][MAX_SIZE];
    char path[MAX_SIZE];
    int fileCount;
};

struct Candidate report_data[MAX_APPLICATIONS];
int candidateCount;

// Function to generate the report file

int countCandidatures(char *output_directory) {
    DIR *rootDir;
    struct dirent *rootEntry;
    struct stat rootStat;

    int jobDirectoryCount = 0;

    // Open the root directory
    if ((rootDir = opendir(output_directory)) == NULL) {
        perror("opendir");
        return -1; // error opening directory
    }

    // Loop through each entry in the root directory
    while ((rootEntry = readdir(rootDir)) != NULL) {
        char fullPath[1024]; // Adjust the size as per your requirement

        // Construct the full path for the entry
        sprintf(fullPath, "%s/%s", output_directory, rootEntry->d_name);

        // Get the file stat for the entry
        if (stat(fullPath, &rootStat) == -1) {
            perror("stat");
            continue;
        }

        // Check if the entry is a directory and not "." or ".."
        if (S_ISDIR(rootStat.st_mode) && strcmp(rootEntry->d_name, ".") != 0 && strcmp(rootEntry->d_name, "..") != 0) {
            // Open the Job directory
            DIR *jobDir;
            struct dirent *jobEntry;
            struct stat jobStat;

            char jobPath[1024]; // Adjust the size as per your requirement
            sprintf(jobPath, "%s/%s", output_directory, rootEntry->d_name);

            // Count directories inside the Job directory
            if ((jobDir = opendir(jobPath)) != NULL) {
                while ((jobEntry = readdir(jobDir)) != NULL) {
                    char jobFullPath[1024]; // Adjust the size as per your requirement
                    sprintf(jobFullPath, "%s/%s", jobPath, jobEntry->d_name);

                    if (stat(jobFullPath, &jobStat) == -1) {
                        perror("stat");
                        continue;
                    }

                    if (S_ISDIR(jobStat.st_mode) && strcmp(jobEntry->d_name, ".") != 0 && strcmp(jobEntry->d_name, "..") != 0) {
                        jobDirectoryCount++;
                    }
                }
                closedir(jobDir);
            }
        }
    }

    closedir(rootDir);
    return jobDirectoryCount;
}


// Function to load candidate information into the report_data struct
void loadCandidateInfo(char *output_directory) {
    DIR *rootDir;
    struct dirent *rootEntry;
    struct stat rootStat;

    // Open the root directory
    if ((rootDir = opendir(output_directory)) == NULL) {
        perror("opendir");
        return;
    }

    int candidateIndex = 0;

    // Loop through each entry in the root directory
    while ((rootEntry = readdir(rootDir)) != NULL) {
        char fullPath[1024]; // Adjust the size as per your requirement

        // Construct the full path for the entry
        sprintf(fullPath, "%s/%s", output_directory, rootEntry->d_name);

        // Get the file stat for the entry
        if (stat(fullPath, &rootStat) == -1) {
            perror("stat");
            continue;
        }

        // Check if the entry is a directory and not "." or ".."
        if (S_ISDIR(rootStat.st_mode) && strcmp(rootEntry->d_name, ".") != 0 && strcmp(rootEntry->d_name, "..") != 0) {
            // Open the Job directory
            DIR *jobDir;
            struct dirent *jobEntry;
            struct stat jobStat;

            char jobPath[1024]; // Adjust the size as per your requirement
            sprintf(jobPath, "%s/%s", output_directory, rootEntry->d_name);

            // Loop through each entry in the Job directory
            if ((jobDir = opendir(jobPath)) != NULL) {
                while ((jobEntry = readdir(jobDir)) != NULL) {
                    char jobFullPath[1024]; // Adjust the size as per your requirement
                    sprintf(jobFullPath, "%s/%s", jobPath, jobEntry->d_name);

                    if (stat(jobFullPath, &jobStat) == -1) {
                        perror("stat");
                        continue;
                    }

                    if (S_ISDIR(jobStat.st_mode) && strcmp(jobEntry->d_name, ".") != 0 && strcmp(jobEntry->d_name, "..") != 0) {
                        // Extract candidate information and store it in the report_data array
                        strcpy(report_data[candidateIndex].jobReference, rootEntry->d_name); // Candidate number
                        strcpy(report_data[candidateIndex].number, jobEntry->d_name); // Job reference
                        strcpy(report_data[candidateIndex].path, jobFullPath); // Path to candidate directory
                        report_data[candidateIndex].fileCount = countFilesInDirectory(jobFullPath); // Count files in candidate directory
                        loadFilesInDirectory(jobFullPath, report_data[candidateIndex].files); // Load file names into report_data array

                        char emailFilePath[1024];
                        sprintf(emailFilePath, "%s/%s-candidate-data.txt", jobFullPath, jobEntry->d_name); // Construct email file path
                        getEmailFromCandidateData(emailFilePath, report_data[candidateIndex].email); // Load email from file


                        candidateIndex++;
                    }
                }
                closedir(jobDir);
            }
        }
    }

    closedir(rootDir);
}

// Function to count files in a directory
int countFilesInDirectory(const char *dirPath) {
    int count = 0;
    DIR *dir;
    struct dirent *entry;

    if ((dir = opendir(dirPath)) != NULL) {
        while ((entry = readdir(dir)) != NULL) {
            if (entry->d_type == DT_REG) { // Regular file
                count++;
            }
        }
        closedir(dir);
    } else {
        perror("opendir");
    }

    return count;
}

// Function to load file names into an array
void loadFilesInDirectory(const char *dirPath, char files[MAX_FILES][MAX_SIZE]) {
    DIR *dir;
    struct dirent *entry;
    int index = 0;

    if ((dir = opendir(dirPath)) != NULL) {
        while ((entry = readdir(dir)) != NULL && index < MAX_FILES) {
            if (entry->d_type == DT_REG) { // Regular file
                strcpy(files[index], entry->d_name);
                index++;
            }
        }
        closedir(dir);
    } else {
        perror("opendir");
    }
}



// Function to load email from file
void getEmailFromCandidateData(const char *filePath, char *email) {
    FILE *emailFile = fopen(filePath, "r");
    if (emailFile == NULL) {
        perror("Failed to open email file");
        return;
    }

    // Skip the first line
    char buffer[MAX_SIZE];
    if (fgets(buffer, MAX_SIZE, emailFile) == NULL) {
        perror("Failed to read first line from email file");
        fclose(emailFile);
        return;
    }

    // Read the email data from the second line
    if (fgets(email, MAX_SIZE, emailFile) == NULL) {
        perror("Failed to read email from file");
    }

    fclose(emailFile);

    // Remove newline character if present
    char *newlinePos;
    if ((newlinePos = strchr(email, '\n')) != NULL)
        *newlinePos = '\0';
}


void generateReport(char *output_directory) {
    sleep(1);
    candidateCount = countCandidatures(output_directory);
    loadCandidateInfo(output_directory);

    char reportFilePath[MAX_SIZE];
    sprintf(reportFilePath, "%s/report.txt", output_directory); // Construct report file path

    FILE *reportFile = fopen(reportFilePath, "w");
    if (reportFile == NULL) {
        perror("Failed to open report file");
        return;
    }

    fprintf(reportFile, "Candidate Report\n\n");

    // Iterate through each candidate and write their information to the report
    for (int i = 0; i < candidateCount; i++) {
        fprintf(reportFile, "Candidate Email: %s\n", report_data[i].email);
        fprintf(reportFile, "Job Reference: %s\n", report_data[i].jobReference);
        fprintf(reportFile, "Candidate Number: %s\n", report_data[i].number);
        fprintf(reportFile, "Path: %s\n", report_data[i].path);

        fprintf(reportFile, "Files:\n");
        for (int j = 0; j < report_data[i].fileCount; j++) {
            fprintf(reportFile, "   - %s\n", report_data[i].files[j]);
        }
        fprintf(reportFile, "\n");
    }

    fclose(reportFile);
}
