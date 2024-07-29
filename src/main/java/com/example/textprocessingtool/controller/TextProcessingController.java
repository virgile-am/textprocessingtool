package com.example.textprocessingtool.controller;

import com.example.textprocessingtool.service.TextProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/text")
public class TextProcessingController {

    @Autowired
    private TextProcessingService textProcessingService;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @PostMapping("/processText")
    public String processText(@RequestParam String text, @RequestParam String regex) {
        return textProcessingService.processTextWithRegex(text, regex);
    }

    @PostMapping("/searchPattern")
    public String searchPattern(@RequestParam String text, @RequestParam String regex) {
        return textProcessingService.searchPatternInText(text, regex);
    }

    @PostMapping("/replaceText")
    public String replaceText(@RequestParam String text, @RequestParam String regex, @RequestParam String replacement) {
        return textProcessingService.replaceTextInString(text, regex, replacement);
    }

    @PostMapping("/highlightMatches")
    public String highlightMatches(@RequestParam String text, @RequestParam String regex) {
        return textProcessingService.highlightMatches(text, regex);
    }

    @PostMapping("/manageCollection")
    public String manageCollection(@RequestParam String type, @RequestParam String operation, @RequestParam String data) {
        return textProcessingService.manageDataCollection(type, operation, data);
    }
}
