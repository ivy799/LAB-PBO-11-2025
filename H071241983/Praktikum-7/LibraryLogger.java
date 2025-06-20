
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LibraryLogger {
    private ArrayList<String> logs = new ArrayList<>();
    private final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);
        String logEntry = timestamp + " " + activity;
        logs.add(logEntry);
        return "Aktivitas berhasil dicatat: " + logEntry;
    }

    public String getLogs() {
        if (logs.isEmpty()) {
            return "Tidak ada log";
        }
        return String.join("\n", logs);
    }

    public void clearLogs() {
        logs.clear();
    }

    public String logBorrowActivity(String itemType, String itemTitle, String memberName) {
        String activity = itemType + " " + itemTitle + " dipinjam oleh " + memberName;
        return logActivity(activity);
    }

    public String logReturnActivity(String itemType, String itemTitle, String memberName) {
        String activity = itemType + "  " + itemTitle + " dikembalikan oleh " + memberName;
        return logActivity(activity);
    }
}