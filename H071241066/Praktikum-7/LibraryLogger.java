import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LibraryLogger {
    private List<String> logs;

    public LibraryLogger() {
        logs = new ArrayList<>();
    }

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logEntry = String.format("%s %s", timestamp, activity);
        logs.add(logEntry);
        return logEntry;
    }

    public String getLogs() {
        return String.join("\n", logs);
    }

    public void clearLogs() {
        logs.clear();
    }
}
