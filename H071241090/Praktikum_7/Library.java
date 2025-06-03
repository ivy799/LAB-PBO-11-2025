package Praktikum_7;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item; 
            }
        }
        throw new NoSuchElementException("Item tidak ditemukan dengan ID " + itemId);
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        throw new NoSuchElementException("Member tidak ditemukan dengan ID " + memberId);
    }

    public String getLibraryStatus() {
    StringBuilder sb = new StringBuilder();
    
    sb.append("+--------+-----------+-----------+\n");
    sb.append("| ID     | Judul     | Status    |\n");
    sb.append("+--------+-----------+-----------+\n");
    
    for (LibraryItem item : items) {
        String status = item.getIsBorrowed() ? "Dipinjam" : "Tersedia";
        sb.append(String.format("| %-6s | %-9s | %-9s |\n", item.getItemId(), item.getTitle(), status));
    }
    
    sb.append("+--------+-----------+-----------+\n");
    
    return sb.toString();
}

    public String getAllLogs() {
        return logger.getLogs();
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}
