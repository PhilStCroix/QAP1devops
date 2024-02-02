package com.keyin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.io.IOException;

public class SuggestionEngineTest {
    private SuggestionEngine suggestionEngine;

    @BeforeEach
    public void setUp() {
        suggestionEngine = new SuggestionEngine();
        try {
            suggestionEngine.loadDictionaryData(Paths.get(ClassLoader.getSystemResource("words.txt").toURI()));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGenerateSuggestions() {
        String word = "crroect";
        String expectedSuggestions = "correct\narrect";
        String actualSuggestions = suggestionEngine.generateSuggestions(word);
        assertEquals(expectedSuggestions, actualSuggestions);
    }

    @Test
    public void testGenerateSuggestions_NoSuggestions() {
        String word = "correct";
        String expectedSuggestions = "";
        String actualSuggestions = suggestionEngine.generateSuggestions(word);
        assertEquals(expectedSuggestions, actualSuggestions);
    }

    @Test
    public void testGenerateSuggestions_EmptyWord() {
        String word = "";
        String expectedSuggestions = "a\nb\nc\nd\ne\nf\ng\nh\ni\nj";
        String actualSuggestions = suggestionEngine.generateSuggestions(word);
        assertEquals(expectedSuggestions, actualSuggestions);
    }

    @Test
    public void testGenerateSuggestions_WhiteSpace() {
        String word = " ";
        String expectedSuggestions = "a\nb\nc\nd\ne\nf\ng\nh\ni\nj";
        String actualSuggestions = suggestionEngine.generateSuggestions(word);
        assertEquals(expectedSuggestions, actualSuggestions);
    }
}