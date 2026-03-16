package com.shweta.ai_log_analyzer.controller;

import com.shweta.ai_log_analyzer.model.AnalysisResponse;
import com.shweta.ai_log_analyzer.model.LogRequest;
import com.shweta.ai_log_analyzer.service.LogAnalysisService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/health")
    public String health() {
        return "Service is running";
    }

    @PostMapping("/analyze")
    public String analyzeLogs(@RequestBody LogRequest request) {

        return service.analyzeLogs(request.getLogs());
    }

    @PostMapping("/upload")
    public AnalysisResponse uploadLogs(@RequestParam("file") MultipartFile file) {

        try {
            String logs = new String(file.getBytes());

            return service.analyzeLogs_refined(logs);

        } catch (Exception e) {
            AnalysisResponse errorResponse = new AnalysisResponse();
            errorResponse.setRootCause("File processing error");
            errorResponse.setSuggestion("Unable to process the uploaded file: " + e.getMessage());
            return errorResponse;
        }
    }
}