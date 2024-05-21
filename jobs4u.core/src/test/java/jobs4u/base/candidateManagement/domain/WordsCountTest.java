package jobs4u.base.candidateManagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordsCountTest {

    @Test
    void createWordsCount() {
        WordsCount wordsCount = new WordsCount("word");
        assertEquals("word", wordsCount.getWord());
        assertEquals(0, wordsCount.getCount());
        assertTrue(wordsCount.getFiles().isEmpty());
    }

    @Test
    void createWordsCountEmptyFails() {
        //should give error
        assertThrows(IllegalArgumentException.class, () ->new WordsCount(""));
    }

    @Test
    void incrementWorks() {
        WordsCount wordsCount = new WordsCount("word");
        wordsCount.incrementCount();
        assertEquals(1, wordsCount.getCount());
        wordsCount.incrementCount();
        assertEquals(2, wordsCount.getCount());
        wordsCount.incrementCount();
        assertEquals(3, wordsCount.getCount());
        wordsCount.incrementCount();wordsCount.incrementCount();
        assertEquals(5, wordsCount.getCount());


    }

    @Test
    void addFileWorks() {
        WordsCount wordsCount = new WordsCount("word");
        //should give error
        wordsCount.addFile("file1");
        wordsCount.addFile("file2");
        assertEquals(2, wordsCount.getFiles().size());
    }


}