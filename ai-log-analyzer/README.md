# AI Log Analyzer

A Spring Boot application that leverages Google's Gemini AI to analyze application logs and identify potential root causes of issues.

## Features

- RESTful API for log analysis
- Integration with Google Gemini AI for intelligent log parsing
- Simple JSON-based request/response format
- Spring Boot framework for easy deployment and scalability
- Upload log file

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- A valid Google AI API key (obtain from [Google AI Studio](https://makersuite.google.com/app/apikey))

## Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd ai-log-analyzer
   ```

2. Configure the API key:
   - Open `src/main/resources/application.properties`
   - Replace the placeholder with your actual Google AI API key:
     ```
     gemini.api.key=YOUR_API_KEY_HERE
     ```

3. Build the project:
   ```bash
   mvn clean compile
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`.

## Usage

### API Endpoint

**POST** `/logs/analyze`

Send a POST request with JSON payload containing the logs to analyze.

#### Request Body
```json
{
  "logs": "Your application log content here"
}
```

#### Example Request (using curl)
```bash
curl -X POST http://localhost:8080/logs/analyze \
  -H "Content-Type: application/json" \
  -d '{"logs": "2023-10-01 10:00:00 ERROR com.example.MyClass - NullPointerException at line 45"}'
```

#### Response
The API returns a JSON string with the AI-generated analysis of the logs, identifying potential root causes and suggestions.

## Configuration

- **API Key**: Set your Google Gemini API key in `application.properties`
- **Port**: Default Spring Boot port is 8080 (configurable in `application.properties` if needed)

## Project Structure

```
ai-log-analyzer/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/shweta/ai_log_analyzer/
│   │   │       ├── AiLogAnalyzerApplication.java
│   │   │       ├── aiconfig/
│   │   │       │   └── GeminiClient.java
│   │   │       ├── controller/
│   │   │       │   └── LogController.java
│   │   │       ├── model/
│   │   │       │   └── LogRequest.java
│   │   │       └── service/
│   │   │           └── LogAnalysisService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── com/shweta/ai_log_analyzer/
│               └── AiLogAnalyzerApplicationTests.java
├── pom.xml
└── README.md
```

## Dependencies

- Spring Boot Web Starter
- Spring Boot DevTools
- Jackson (for JSON processing)

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Troubleshooting

- **404 Error on API Call**: Ensure your Google AI API key is valid and the Generative Language API is enabled in your Google Cloud Console.
- **Compilation Issues**: Verify Java 17 and Maven are installed correctly.
- **Port Conflicts**: If port 8080 is in use, modify `application.properties` to use a different port.</content>
<parameter name="filePath">C:\PROJECT\ai-log-analyzer\README.md


# important links

Verify which models your API key can access
https://generativelanguage.googleapis.com/v1beta/models
x-goog-api-key: YOUR_API_KEY
Verify API enablement (critical)
https://console.cloud.google.com/apis/library/generativelanguage.googleapis.com
Check quota page
https://console.cloud.google.com/apis/api/generativelanguage.googleapis.com/quotas
Enable the Gemini (Generative Language) API
https://console.cloud.google.com/apis/api/generativelanguage.googleapis.com/overview?project=356597501993
create ceredentials
https://console.cloud.google.com/apis/credentials?project=gemini-ai-log-analyzer-490317
