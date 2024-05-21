package jobs4u.base.candidateManagement.application.WordsCount;

import jobs4u.base.candidateManagement.domain.WordsCount;
import jobs4u.base.jobApplications.domain.JobApplicationFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    private List<WordsCount> wordCount;

    public WordCounter() {
        wordCount = new ArrayList<>();
    }

    public void countWords(JobApplicationFile file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getPath().toString()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Use a regular expression to split by non-alphabetic characters
                String[] words = line.split("[^a-zA-Z]+");
                for (String word : words) {
                    word = word.toLowerCase().trim();
                    if (!word.isEmpty()) {

                        WordsCount wc = new WordsCount(word);
                        if (wordCount.contains(wc)) {
                            wordCount.get(wordCount.indexOf(wc)).incrementCount();
                            wordCount.get(wordCount.indexOf(wc)).addFile(file.getName());
                        } else {
                            wc.addFile(file.getName());
                            wc.incrementCount();
                            wordCount.add(wc);
                        }


                    }
                }
            }
        }
    }

    public List<WordsCount> getWordCounts() {
        return wordCount;
    }
}
