package library;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

public class LibraryLogger {
    List<String> logs;

    public LibraryLogger() {
        this.logs = new ArrayList<>();
    }

    public void logActivity(String activity) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);
        String logEntry = timestamp + " " + activity;
        logs.add(logEntry);
    }

    public String getLogs() {
        StringBuilder result = new StringBuilder();
        for (String log : logs) {
            result.append(log).append("\n");
        }
        return result.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}