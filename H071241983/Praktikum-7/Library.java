
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Library {
    private ArrayList<LibraryItem> items = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    public LibraryLogger logger;

    public Library(LibraryLogger logger) {
        this.logger = logger;
    }

    public String addItem(LibraryItem libraryItem) {
        items.add(libraryItem);
        return libraryItem.title + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem libraryItem : items) {
            if (libraryItem.itemId == itemId) {
                return libraryItem;
            }
        }

        throw new NoSuchElementException("Item tidak ditemukan");
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }

        throw new NoSuchElementException("Member tidak ditemukan");
    }

    public void getLibraryStatus() {
        System.out.println("+-----+-----------------+");
        System.out.println("| ID  | Judul  | Status |");
        System.out.println("+-----+-----------------+");
        for (LibraryItem libraryItem : items) {
            String status = libraryItem.isBorrowed ? "Dipinjam" : "Tersedia";

            System.out.printf("| %s | %s | %s |\n", libraryItem.itemId, libraryItem.title, status);
        }
        System.out.println("+-----+-----------------+");
    }

    public String addMember(String name, String memberId) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama member tidak boleh kosong");
        }
        if (memberId == null || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("ID member tidak boleh kosong");
        }

        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                throw new IllegalStateException("Member dengan ID " + memberId + " sudah terdaftar");
            }
        }

        Member newMember = new Member(name, memberId);
        members.add(newMember);

        String logMessage = "Anggota berhasil ditambahkan: " + name + " (ID: " + memberId + ")";
        logger.logActivity(logMessage);

        return logMessage;
    }

    public void showBorrowedItemsByMember(String memberId) {
        Member member = members.stream()
                .filter(m -> m.getMemberId().equals(memberId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ID Member Tidak Ditemukan"));

        member.getBorrowedItems();
    }

}
