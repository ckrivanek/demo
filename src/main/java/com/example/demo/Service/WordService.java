package com.example.demo.Service;

import com.example.demo.Dao.WordDao;
import com.example.demo.Model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordService {
    private final WordDao wordDao;

    @Autowired
    public WordService(@Qualifier("WordDao") WordDao wordDao) {
        this.wordDao = wordDao;
    }

    public int addWord(Word word) {
        return wordDao.insertWord(word);
    }

    public Optional<Word> selectWordByChars(String chars) {
        return wordDao.selectWordByChars(chars);
    }

    public List<Word> selectAllWords() {
        return wordDao.selectAllWords();
    }

    public int deleteWordByChars(String chars) {
        return wordDao.deleteWordByChars(chars);
    }

    public int updateWordByChars(String chars, Word newWord) {
        return wordDao.updateWordByChars(chars,newWord);
    }
}
