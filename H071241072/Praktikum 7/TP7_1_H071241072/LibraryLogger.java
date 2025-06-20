package tp7;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LibraryLogger {
    private List<String> logs = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String logActivity(String activity) {
        String log = LocalDateTime.now().format(formatter) + " " + activity;
        logs.add(log);
        return log;
    }

    public String getLogs() {
        return logs.isEmpty() ? "Tidak Ada Log Aktivitas" : String.join("\n", logs);
    }

    public void clearLogs() {
        logs.clear();
    }
}