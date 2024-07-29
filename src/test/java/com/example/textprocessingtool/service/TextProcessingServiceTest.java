 package com.example.textprocessingtool.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextProcessingServiceTest {

    private TextProcessingService textProcessingService = new TextProcessingService();

    @Test
    public void testProcessTextWithRegex() {
        String text = "apple banana apple";
        String regex = "apple";
        String result = textProcessingService.processTextWithRegex(text, regex);
        assertEquals("apple apple", result);
    }

    @Test
    public void testSearchPatternInText() {
        String text = "apple banana apple";
        String pattern = "banana";
        String result = textProcessingService.searchPatternInText(text, pattern);
        assertEquals("banana", result);
    }

    @Test
    public void testReplaceTextInString() {
        String text = "apple banana apple";
        String target = "apple";
        String replacement = "orange";
        String result = textProcessingService.replaceTextInString(text, target, replacement);
        assertEquals("orange banana orange", result);
    }

    @Test
    public void testHighlightMatches() {
        String text = "apple banana apple";
        String regex = "apple";
        String result = textProcessingService.highlightMatches(text, regex);
        assertEquals("<mark>apple</mark> banana <mark>apple</mark>", result);
    }

    @Test
    public void testManageDataCollectionAddToList() {
        String type = "list";
        String operation = "add";
        String data = "item1";
        String result = textProcessingService.manageDataCollection(type, operation, data);
        assertEquals("Added to list: item1", result);
    }

    @Test
    public void testManageDataCollectionDeleteFromList() {
        String type = "list";
        String operation = "delete";
        String data = "item1";
        textProcessingService.manageDataCollection(type, "add", data);
        String result = textProcessingService.manageDataCollection(type, operation, data);
        assertEquals("Deleted from list: item1", result);
    }

    @Test
    public void testManageDataCollectionClearList() {
        String type = "list";
        String operation = "clear";
        String result = textProcessingService.manageDataCollection(type, operation, "");
        assertEquals("Cleared list.", result);
    }
}
