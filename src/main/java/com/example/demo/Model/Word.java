package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Word {

    @NotBlank
    private final String chars;
    private final String definition;

    public Word(@JsonProperty("chars") String chars, @JsonProperty("definition") String definition) {
        this.definition = definition;
        this.chars = chars;
    }

    public String getChars(){
        return this.chars;
    }

    public String getDefinition(){
        return this.definition;
    }
}
