package jobs4u.base.candidateManagement.application;

import jobs4u.base.candidateManagement.domain.WordsCount;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationFile;

import java.io.IOException;
import java.io.RandomAccessFile;
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
                long start = (long) i * CHUNK_SIZE;
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



    private class WordCounter implements Runnable {
        // ConcurrentMap to store word counts
        private final ConcurrentMap<String, WordsCount> wordCountMap;

        // Input file to process
        private final JobApplicationFile file;

        // Start and end position of the chunk to process
        private final long start;
        private final long end;

        // Constructor
        public WordCounter(ConcurrentMap<String, WordsCount> wordCountMap, JobApplicationFile file, long start, long end) {
            this.wordCountMap = wordCountMap;
            this.file = file;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            try {
                // Method to count words in the chunk
                countWordsInChunk();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Method to count words in the chunk
        private void countWordsInChunk() throws IOException {
            try (RandomAccessFile raf = new RandomAccessFile(file.getAsFile(), "r")) {
                // Move to the start position
                raf.seek(start);

                // Read the chunk into a buffer
                byte[] buffer = new byte[(int) (end - start)];
                raf.read(buffer);

                // Convert the buffer to string (chunk)
                String chunk = new String(buffer);

                // Call the method to count words from the chunk
                countWordsFromChunk(chunk, file.getName());
            }
        }

        // Method to count words from the chunk
        private void countWordsFromChunk(String chunk, String fileName) {
            // Split the chunk into words using regex
            String[] words = chunk.split("[^a-zA-Z]+");

            // Iterate over each word
            for (String word : words) {
                // Convert to lowercase and trim whitespace
                word = word.toLowerCase().trim();

                // Check if the word is not empty
                if (!word.isEmpty()) {
                    // Final variable for lambda expression
                    String finalWord = word;

                    // Update word count map using concurrent compute method
                    wordCountMap.compute(word, (k, v) -> {
                        // If the word doesn't exist, create a new WordsCount object
                        if (v == null) {
                            v = new WordsCount(finalWord);
                        }
                        // Increment word count and add file name
                        v.incrementCount();
                        v.addFile(fileName);
                        return v;
                    });
                }
            }
        }
    }

}
