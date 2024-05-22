package jobs4u.base.candidateManagement.application.WordsCount;
import jobs4u.base.candidateManagement.domain.WordsCount;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WordCounter {
    private ConcurrentMap<String, WordsCount> wordCountMap;

    public WordCounter() {
        wordCountMap = new ConcurrentHashMap<>();
    }

    public void countWordsFromChunk(String chunk, String fileName) {
        String[] words = chunk.split("[^a-zA-Z]+");
        for (String word : words) {
            word = word.toLowerCase().trim();
            if (!word.isEmpty()) {
                String finalWord = word;
                wordCountMap.compute(word, (k, v) -> {
                    if (v == null) {
                        v = new WordsCount(finalWord);
                    }
                    v.incrementCount();
                    v.addFile(fileName);
                    return v;
                });
            }
        }
    }

    public List<WordsCount> getWordCounts() {
        return new ArrayList<>(wordCountMap.values());
    }
}
