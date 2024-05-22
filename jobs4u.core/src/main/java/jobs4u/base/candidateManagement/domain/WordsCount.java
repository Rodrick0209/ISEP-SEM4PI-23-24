package jobs4u.base.candidateManagement.domain;

import eapli.framework.validations.Preconditions;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WordsCount {
    @Getter
    private String word;
    @Getter
    private int count;
    @Getter
    private List<String> files;

    public WordsCount(String word, int count, List<String> files) {
        Preconditions.noneNull(word);
        this.word = word;
        this.count = count;
        this.files = files;
    }

    public WordsCount(String word) {
        Preconditions.nonEmpty(word);
        this.word = word;
        this.count = 0;
        this.files = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordsCount that = (WordsCount) o;
        return Objects.equals(word, that.word);
    }

    public synchronized void incrementCount() {
        this.count++;
    }

    public synchronized void addFile(String file) {
        if (!this.files.contains(file)){
            this.files.add(file);
        }

    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    public List<String> getFiles() {
        return files;
    }



}
