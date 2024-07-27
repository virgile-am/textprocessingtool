package com.example.textprocessingtool.controller;

import com.example.textprocessingtool.service.TextProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/text")
public class TextProcessingController {

    @Autowired
    private TextProcessingService textProcessingService;

    @GetMapping("/")
    public String home() {
        return "index"; // JSP file: src/main/webapp/WEB-INF/views/index.jsp
    }

    @PostMapping("/processText")
    public String processText(@RequestParam("text") String text, @RequestParam("regex") String regex, Model model) {
        String result = textProcessingService.processTextWithRegex(text, regex);
        model.addAttribute("result", result);
        return "result"; // JSP file: src/main/webapp/WEB-INF/views/result.jsp
    }

    @PostMapping("/searchPattern")
    public String searchPattern(@RequestParam("searchText") String text, @RequestParam("pattern") String pattern, Model model) {
        String result = textProcessingService.searchPatternInText(text, pattern);
        model.addAttribute("result", result);
        return "result"; // JSP file: src/main/webapp/WEB-INF/views/result.jsp
    }

    @PostMapping("/replaceText")
    public String replaceText(@RequestParam("replaceText") String text, @RequestParam("target") String target, @RequestParam("replacement") String replacement, Model model) {
        String result = textProcessingService.replaceTextInString(text, target, replacement);
        model.addAttribute("result", result);
        return "result"; // JSP file: src/main/webapp/WEB-INF/views/result.jsp
    }

    @PostMapping("/manageCollection")
    public String manageCollection(@RequestParam("type") String type, @RequestParam("operation") String operation, @RequestParam("data") String data, Model model) {
        String result = textProcessingService.manageDataCollection(type, operation, data);
        model.addAttribute("result", result);
        return "result"; // JSP file: src/main/webapp/WEB-INF/views/result.jsp
    }
}
