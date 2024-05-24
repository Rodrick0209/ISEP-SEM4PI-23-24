package jobs4u.base.candidateManagement.application.WordsCount;

import jobs4u.base.candidateManagement.domain.WordsCount;
import jobs4u.base.jobApplications.domain.JobApplicationFile;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ConcurrentMap;

public class WordCounter implements Runnable {
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
