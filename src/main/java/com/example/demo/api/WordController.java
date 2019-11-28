package com.example.demo.api;

import com.example.demo.Model.Word;
import com.example.demo.Service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/test")
@RestController
public class WordController {
    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService){
        this.wordService = wordService;
    }

    @GetMapping
    public List<Word> getAllWords(){
        return wordService.selectAllWords();
    }

    @GetMapping(path = "{chars}")
        public Word getWordByChars(@PathVariable("chars") String chars){
            return wordService.selectWordByChars(chars)
                .orElse(null);
    }

    @PostMapping
    public void addWord(@RequestBody @Valid @NonNull Word word){
        wordService.addWord(word);
    }

    @DeleteMapping(path = "{chars}")
    public int deleteWordByChars(@PathVariable("chars") String chars){
        return wordService.deleteWordByChars(chars);
    }

    @PutMapping(path = "{chars}")
    public int updateWordByChars(@PathVariable("chars") String chars, @Valid @NonNull @RequestBody Word wordToUpdate){
        return wordService.updateWordByChars(chars,wordToUpdate);
    }
}
