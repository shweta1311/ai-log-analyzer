package com.shweta.ai_log_analyzer.controller;

import com.shweta.ai_log_analyzer.model.LogRequest;
import com.shweta.ai_log_analyzer.service.LogAnalysisService;
import org.springframework.web.bind.annotation.*;

/*@RestController
public class LogController {
    @GetMapping("/")
    public String home() {
        return "AI Log Analyzer is running!";
    }

    @PostMapping("/analyze-logs")
    public String analyzeLogs(@RequestBody String logs) {
        // TODO: Implement log analysis logic here
        return "Log analysis started for: " + logs;
    }
}*/

@RestController
@RequestMapping("/logs")
public class LogController {

    private final LogAnalysisService service;

    public LogController(LogAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public String analyzeLogs(@RequestBody LogRequest request) {

        return service.analyzeLogs(request.getLogs());
    }
}