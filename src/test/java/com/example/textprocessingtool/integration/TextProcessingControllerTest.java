package com.example.textprocessingtool.integration;

import com.example.textprocessingtool.controller.TextProcessingController;
import com.example.textprocessingtool.service.TextProcessingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TextProcessingController.class)
public class TextProcessingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TextProcessingService textProcessingService;

    @Test
    public void testProcessText() throws Exception {
        String text = "apple banana apple";
        String regex = "apple";
        String expected = "apple apple";
        when(textProcessingService.processTextWithRegex(text, regex)).thenReturn(expected);

        mockMvc.perform(post("/text/processText")
                        .param("text", text)
                        .param("regex", regex))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void testSearchPattern() throws Exception {
        String text = "apple banana apple";
        String regex = "banana";
        String expected = "banana";
        when(textProcessingService.searchPatternInText(text, regex)).thenReturn(expected);

        mockMvc.perform(post("/text/searchPattern")
                        .param("text", text)
                        .param("regex", regex))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void testReplaceText() throws Exception {
        String text = "apple banana apple";
        String regex = "apple";
        String replacement = "orange";
        String expected = "orange banana orange";
        when(textProcessingService.replaceTextInString(text, regex, replacement)).thenReturn(expected);

        mockMvc.perform(post("/text/replaceText")
                        .param("text", text)
                        .param("regex", regex)
                        .param("replacement", replacement))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void testHighlightMatches() throws Exception {
        String text = "apple banana apple";
        String regex = "apple";
        String expected = "<mark>apple</mark> banana <mark>apple</mark>";
        when(textProcessingService.highlightMatches(text, regex)).thenReturn(expected);

        mockMvc.perform(post("/text/highlightMatches")
                        .param("text", text)
                        .param("regex", regex))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void testManageCollectionAddToList() throws Exception {
        String type = "list";
        String operation = "add";
        String data = "item1";
        String expected = "Added to list: item1";
        when(textProcessingService.manageDataCollection(type, operation, data)).thenReturn(expected);

        mockMvc.perform(post("/text/manageCollection")
                        .param("type", type)
                        .param("operation", operation)
                        .param("data", data))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }
}
