#include "header.h"



// Structure to hold candidate information
struct Candidate {
    char number[MAX_FILENAME];
    char jobReference[MAX_FILENAME]; // Added to store job reference
    char files[MAX_FILES][MAX_FILENAME];
    int fileCount;
};

struct Candidate report_data[MAX_CANDIDATES];


int candidateCount;


// Function to generate the report file
void generateReport() {
    candidateCount = countCandidatures();
    loadCandidateInfo();

    FILE *reportFile = fopen("report.txt", "w");
    if (reportFile == NULL) {
        perror("Failed to open report file");
        return;
    }

    fprintf(reportFile, "Candidate Report\n\n");

    // Iterate through each candidate and write their information to the report
    for (int i = 0; i < candidateCount; i++) {
        fprintf(reportFile, "Candidate Number: %s\n", report_data[i].number);
        fprintf(reportFile, "Job Reference: %s\n", report_data[i].jobReference);
        fprintf(reportFile, "Path: %s\\%s\\%s\n", output_directory ,report_data[i].number, report_data[i].jobReference);
        fprintf(reportFile, "Files:\n");
        for (int j = 0; j < report_data[i].fileCount; j++) {
            fprintf(reportFile, "- %s\n", report_data[i].files[j]);
        }
        fprintf(reportFile, "\n");
    }

    fclose(reportFile);
}


int countCandidatures() {
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
void loadCandidateInfo() {
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
                        strcpy(report_data[candidateIndex].number, rootEntry->d_name); // Candidate number
                        strcpy(report_data[candidateIndex].jobReference, jobEntry->d_name); // Job reference
                        report_data[candidateIndex].fileCount = countFilesInDirectory(jobFullPath); // Count files in candidate directory
                        loadFilesInDirectory(jobFullPath, report_data[candidateIndex].files); // Load file names into report_data array

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
void loadFilesInDirectory(const char *dirPath, char files[MAX_FILES][MAX_FILENAME]) {
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

