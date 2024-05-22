package jobs4u.base.candidateManagement.application.WordsCount;

import jobs4u.base.jobApplications.domain.JobApplicationFile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileChunkProcessor implements Runnable {
    private JobApplicationFile file;
    private WordCounter wordCounter;
    private long start;
    private long end;

    public FileChunkProcessor(JobApplicationFile file, WordCounter wordCounter, long start, long end) {
        this.file = file;
        this.wordCounter = wordCounter;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            countWordsInChunk();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void countWordsInChunk() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file.getAsFile(), "r")) {
            raf.seek(start);
            byte[] buffer = new byte[(int) (end - start)];
            raf.read(buffer);
            String chunk = new String(buffer);
            wordCounter.countWordsFromChunk(chunk, file.getName());
        }
    }
}

