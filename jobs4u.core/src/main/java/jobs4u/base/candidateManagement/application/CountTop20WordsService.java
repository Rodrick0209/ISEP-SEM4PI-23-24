package jobs4u.base.candidateManagement.application;

import jobs4u.base.candidateManagement.application.WordsCount.WordCounter;
import jobs4u.base.candidateManagement.domain.WordsCount;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CountTop20WordsService {

    private static final int CHUNK_SIZE = 5 * 1024 * 1024; // 5MB chunk size

    public List<WordsCount> countTop20Words(JobApplication jobApplication) throws InterruptedException, IOException {
        // Get the files from the job application
        List<JobApplicationFile> files = jobApplication.getFile();

        // Create a concurrent map to store word counts
        ConcurrentMap<String, WordsCount> wordCountMap = new ConcurrentHashMap<>();

        // Create a list to hold all the threads
        List<Thread> allThreads = new ArrayList<>();

        // Iterate over each file
        for (JobApplicationFile file : files) {
            // Get the file size
            long fileSize = file.getAsFile().length();

            // Calculate the number of chunks based on file size and chunk size
            long numChunks = (fileSize + CHUNK_SIZE - 1) / CHUNK_SIZE;

            // Iterate over each chunk
            for (int i = 0; i < numChunks; i++) {
                // Calculate start and end positions for the chunk
                long start = i * CHUNK_SIZE;
                long end = Math.min(start + CHUNK_SIZE, fileSize);

                // Create a WordCounter instance for the chunk
                WordCounter wordCounter = new WordCounter(wordCountMap, file, start, end);

                // Create a thread for the WordCounter instance
                Thread thread = new Thread(wordCounter);

                // Add the thread to the list of all threads
                allThreads.add(thread);

                // Start the thread
                thread.start();
            }
        }

        // Wait for all threads to finish
        for (Thread thread : allThreads) {
            thread.join();
        }

        // Return the list of word counts
        return new ArrayList<>(wordCountMap.values());
    }
}
