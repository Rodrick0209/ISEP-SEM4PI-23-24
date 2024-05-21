package jobs4u.base.candidateManagement.application;

import jobs4u.base.candidateManagement.application.WordsCount.FileProcessor;
import jobs4u.base.candidateManagement.application.WordsCount.WordCounter;
import jobs4u.base.candidateManagement.domain.WordsCount;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationFile;


import java.util.List;


public class CountTop20WordsService {

    public List<WordsCount> countTop20Words(JobApplication jobApplication) throws InterruptedException {

        List<JobApplicationFile> files = jobApplication.getFile();

        WordCounter wordCounter = new WordCounter();

        Thread[] takersThreads = new Thread[files.size()]; // Create an array of Thread objects

        // Create and start threads
        for (int i = 0; i < files.size(); i++) {
            //print thread id
            takersThreads[i] = new Thread(new FileProcessor(files.get(i),wordCounter)); // Instantiate each Thread
            takersThreads[i].start(); // Start the thread
        }

        // Join all threads
        for (Thread thread : takersThreads) {
            thread.join();
        }

        // Get word counts from WordCounter

        return wordCounter.getWordCounts();

        // Sort word counts by frequency (descending order)

    }
}
