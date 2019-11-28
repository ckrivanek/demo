package com.example.demo.Dao;

import com.example.demo.Model.Word;

import java.util.List;
import java.util.Optional;

public interface WordDao {
    int insertWord(Word word, String definition);
    default int insertWord(Word word){
        return insertWord(word, "N/A");
    }
    Optional<Word> selectWordByChars(String Chars);
    List<Word> selectAllWords();
    int deleteWordByChars(String chars);
    int updateWordByChars(String chars, Word word);
}
