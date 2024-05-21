package jobs4u.base.candidateManagement.application.WordsCount;

import jobs4u.base.jobApplications.domain.JobApplicationFile;

import java.io.File;
import java.io.IOException;

public class FileProcessor extends Thread {
    private JobApplicationFile file;
    private WordCounter wordCounter;

    public FileProcessor(JobApplicationFile file, WordCounter wordCounter) {
        this.file = file;
        this.wordCounter = wordCounter;
    }

    @Override
    public void run() {
        try {
            wordCounter.countWords(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
