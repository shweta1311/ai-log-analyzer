package com.shweta.ai_log_analyzer.service;

import com.shweta.ai_log_analyzer.aiconfig.GeminiClient;
import com.shweta.ai_log_analyzer.model.AnalysisResponse;
import org.springframework.stereotype.Service;

@Service
public class LogAnalysisService {
    private final GeminiClient geminiClient;

    public LogAnalysisService(GeminiClient geminiClient) {
        this.geminiClient = geminiClient;
    }

    public String analyzeLogs(String logs) {

        String filteredLogs = extractImportantLogs(logs);

        String prompt =
                "You are a production debugging assistant. " +
                        "Analyze the following application logs and identify the root cause of errors:\n\n"
                        + filteredLogs;

        return geminiClient.analyzeLogs(prompt);
    }


    public AnalysisResponse analyzeLogs_refined(String logs) {

        String filteredLogs = extractImportantLogs_refined(logs);

        // fallback if filtering removed everything
        if (filteredLogs.isBlank()) {
            filteredLogs = logs;
        }
        String prompt = """
            You are an SRE debugging assistant.
            
            Analyze the following application logs.
            
            Return ONLY in this format:
            
            RootCause: <short root cause>
            Suggestion: <short fix>
            
            Logs:
            """ + filteredLogs;

        String aiResult = geminiClient.analyzeLogs(prompt);

        AnalysisResponse response = new AnalysisResponse();
        response.setRootCause(aiResult);
        response.setSuggestion("Review service dependencies and investigate related stack traces.");

        return response;
    }

    private String extractImportantLogs(String logs) {

        StringBuilder filtered = new StringBuilder();

        String[] lines = logs.split("\n");

        for (String line : lines) {

            if (line.contains("ERROR") ||
                    line.contains("WARN") ||
                    line.contains("Exception")) {

                filtered.append(line).append("\n");
            }
        }

        return filtered.toString();
    }

    private String extractImportantLogs_refined(String logs) {

        StringBuilder filtered = new StringBuilder();

        String[] lines = logs.split("\n");

        for (String line : lines) {

            if (line.contains("ERROR") ||
                    line.contains("WARN") ||
                    line.contains("Exception") ||
                    line.contains("Timeout") ||
                    line.contains("Connection refused")) {

                filtered.append(line).append("\n");
            }
        }

        return filtered.toString();
    }
}
