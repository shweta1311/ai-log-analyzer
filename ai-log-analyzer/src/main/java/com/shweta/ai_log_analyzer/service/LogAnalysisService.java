package com.shweta.ai_log_analyzer.service;

import com.shweta.ai_log_analyzer.aiconfig.GeminiClient;
import org.springframework.stereotype.Service;

@Service
public class LogAnalysisService {
    private final GeminiClient geminiClient;

    public LogAnalysisService(GeminiClient geminiClient) {
        this.geminiClient = geminiClient;
    }

    public String analyzeLogs(String logs) {

        String prompt =
                "You are a production debugging assistant. " +
                        "Analyze the following application logs and identify the root cause of errors:\n\n"
                        + logs;

        return geminiClient.analyzeLogs(prompt);
    }
}
