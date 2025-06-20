import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class Library {
    public List<LibraryItem> items = new ArrayList<>();
    public List<Member> members = new ArrayList<>();
    public LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        logger.logActivity(String.format("Item %s berhasil ditambahkan", item.tittle));
        return String.format("Item %s berhasil ditambahkan", item.tittle);
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream()
                .filter(item -> item.itemId == itemId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item dengan ID tersebut tidak ditemukan."));
    }

    public String getLibraryStatus() {
        System.out.println("+------+----------------------------------------------------+-----------+");
        System.out.println("| ID   | Judul                                              | Status    |");
        System.out.println("+------+----------------------------------------------------+-----------+");
        if (items == null || items.isEmpty()) {
            System.out.println("|      Tidak ada data tersedia                              |");
        } else {
            for (int i = 0; i < items.size(); i++) {
                LibraryItem item = items.get(i);
                String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
                String judul = item.tittle;
                if (judul.length() > 50) {
                    judul = judul.substring(0, 47) + "...";
                    System.out.println("| " + item.itemId + " | " + judul + " | " + status + " |");
                } else {
                    System.out.printf("| %-4d | %-51s| %-10s|\n", item.itemId, judul, status);
                }
            }
        }
        System.out.println("+------+----------------------------------------------------+-----------+");

        return "";
    }

    public String getAllLogs() {
        String logs = logger.getLogs();
        return logs.isEmpty() ? "Tidak ada log aktivitas." : logs;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryLogger getLogger() {
        return logger;
    }

    public List<Member> getMembers() {
        return members;
    }

    public boolean isItemIdExist(int id) {
        return items.stream().anyMatch(item -> item.itemId == id);
    }

    public boolean isMemberIdExist(int id) {
        return members.stream().anyMatch(member -> member.memberId == id);
    }
}
