package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.io.IOException;

public class SuggestionEngineTest {
    private SuggestionEngine suggestionEngine;

    @Test
    public void testGenerateSuggestions() {
        suggestionEngine = new SuggestionEngine();
        try {
            suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String word = "crroect";
        String expectedSuggestions = "correct\narrect";
        String actualSuggestions = suggestionEngine.generateSuggestions(word);
        assertEquals(expectedSuggestions, actualSuggestions);
    }

    @Test
    public void testGenerateSuggestions_NoSuggestions() {
        suggestionEngine = new SuggestionEngine();
        try {
            suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String word = "correct";
        String expectedSuggestions = "";
        String actualSuggestions = suggestionEngine.generateSuggestions(word);
        assertEquals(expectedSuggestions, actualSuggestions);
    }

    @Test
    public void testGenerateSuggestions_EmptyWord() {
        suggestionEngine = new SuggestionEngine();
        try {
            suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String word = "";
        String expectedSuggestions = "a\nb\nc\nd\ne\nf\ng\nh\ni\nj";
        String actualSuggestions = suggestionEngine.generateSuggestions(word);
        assertEquals(expectedSuggestions, actualSuggestions);
    }

    @Test
    public void testGenerateSuggestions_WhiteSpace() {
        suggestionEngine = new SuggestionEngine();
        try {
            suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String word = " ";
        String expectedSuggestions = "a\nb\nc\nd\ne\nf\ng\nh\ni\nj";
        String actualSuggestions = suggestionEngine.generateSuggestions(word);
        assertEquals(expectedSuggestions, actualSuggestions);
    }
}