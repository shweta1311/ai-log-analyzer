package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @GetMapping("/")
    public String home() {
        return "AI Log Analyzer is running!";
    }

    @PostMapping("/analyze-logs")
    public String analyzeLogs(@RequestBody String logs) {

        System.out.println("Logs received:");
        System.out.println(logs);

        return "Logs received successfully";
    }
}
