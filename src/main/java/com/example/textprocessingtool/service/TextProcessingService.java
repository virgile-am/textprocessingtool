package com.example.textprocessingtool.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TextProcessingService {

    public String processTextWithRegex(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("[MATCHED]");
    }

    public String searchPatternInText(String text, String pattern) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            result.append(matcher.group()).append(" ");
        }
        return result.toString();
    }

    public String replaceTextInString(String text, String target, String replacement) {
        return text.replaceAll(target, replacement);
    }

    public String manageDataCollection(String type, String operation, String data) {
        // Implement your data management logic here
        return "Operation " + operation + " on " + type + " with data " + data + " completed.";
    }
}
