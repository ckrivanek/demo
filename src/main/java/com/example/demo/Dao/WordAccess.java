package com.example.demo.Dao;

import com.example.demo.Model.Word;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("WordDao")
public class WordAccess implements WordDao{
    private static List<Word> DB = new ArrayList<>();

    @Override
    public int insertWord(Word word, String definition) {
        DB.add(new Word(word.getChars(), definition));
        return 1;
    }

    @Override
    public Optional<Word> selectWordByChars(String chars) {
        return DB.stream()
                .filter(person -> person.getChars().equals(chars))
                .findFirst();
    }

    @Override
    public List<Word> selectAllWords() {
        return DB;
    }

    @Override
    public int deleteWordByChars(String chars) {
        Optional<Word> wordMaybe = selectWordByChars(chars);
        if(wordMaybe.isEmpty()){
            return 0;
        }
        DB.remove(wordMaybe.get());
        return 1;
    }

    @Override
    public int updateWordByChars(String chars, Word word) {
        return selectWordByChars(chars)
                .map(w -> {
                    int indexOfWordToUpdate = DB.indexOf(w);
                    if(indexOfWordToUpdate >= 0){
                        DB.set(indexOfWordToUpdate, new Word(chars, word.getDefinition()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
