 package com.example.textprocessingtool.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TextProcessingService {

    public String processTextWithRegex(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            result.append(matcher.group()).append(" ");
        }

        return result.toString().trim();
    }

    public String searchPatternInText(String text, String pattern) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            result.append(matcher.group()).append(" ");
        }

        return result.toString().trim();
    }

    public String replaceTextInString(String text, String target, String replacement) {
        return text.replaceAll(target, replacement);
    }

    public String highlightMatches(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(result, "<mark>" + matcher.group() + "</mark>");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public String manageDataCollection(String type, String operation, String data) {
        switch (type.toLowerCase()) {
            case "list":
                return manageListCollection(operation, data);
            case "set":
                return manageSetCollection(operation, data);
            case "map":
                return manageMapCollection(operation, data);
            default:
                return "Invalid collection type.";
        }
    }

    private String manageListCollection(String operation, String data) {
        List<String> list = new ArrayList<>();
        switch (operation.toLowerCase()) {
            case "add":
                list.add(data);
                return "Added to list: " + data;
            case "delete":
                list.remove(data);
                return "Deleted from list: " + data;
            case "clear":
                list.clear();
                return "Cleared list.";
            default:
                return "Invalid operation for list.";
        }
    }

    private String manageSetCollection(String operation, String data) {
        // Implement set collection management logic
        return "Operation " + operation + " on set with data " + data + " completed.";
    }

    private String manageMapCollection(String operation, String data) {
        // Implement map collection management logic
        return "Operation " + operation + " on map with data " + data + " completed.";
    }
}
//checking
