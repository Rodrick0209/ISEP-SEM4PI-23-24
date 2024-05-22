package jobs4u.base.candidateManagement.application;

import jobs4u.base.candidateManagement.application.WordsCount.FileChunkProcessor;
import jobs4u.base.candidateManagement.application.WordsCount.FileProcessor;
import jobs4u.base.candidateManagement.application.WordsCount.WordCounter;
import jobs4u.base.candidateManagement.domain.WordsCount;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CountTop20WordsService {

    private static final int CHUNK_SIZE = 5* 1024 * 1024; // 5MB chunk size

    public List<WordsCount> countTop20Words(JobApplication jobApplication) throws InterruptedException, IOException {
        List<JobApplicationFile> files = jobApplication.getFile();
        WordCounter wordCounter = new WordCounter();
        List<Thread> allThreads = new ArrayList<>();

        for (JobApplicationFile file : files) {
            long fileSize = file.getAsFile().length();
            long numChunks = (fileSize + CHUNK_SIZE - 1) / CHUNK_SIZE; // Calculate number of chunks

            for (int i = 0; i < numChunks; i++) {
                long start = i * CHUNK_SIZE;
                long end = Math.min(start + CHUNK_SIZE, fileSize);
                Thread thread = new Thread(new FileChunkProcessor(file, wordCounter, start, end));
                allThreads.add(thread);
                thread.start();
            }
        }

        for (Thread thread : allThreads) {
            thread.join();
        }

        return wordCounter.getWordCounts();
    }
}
