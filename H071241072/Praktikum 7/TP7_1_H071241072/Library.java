package tp7;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        logger.logActivity(item.getTitle() + " berhasil ditambahkan");
        return item.getTitle() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream()
                .filter(i -> i.getItemId() == itemId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan."));
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("+------+--------------------------+-----------+\n");
        sb.append(String.format("| %-4s | %-24s | %-9s |\n", "ID", "Judul", "Status"));
        sb.append("+------+--------------------------+-----------+\n");

        items.forEach(item -> {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-4d | %-24s | %-9s |\n", item.getItemId(), item.getTitle(), status));
        });

        sb.append("+------+--------------------------+-----------+");
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public Member findMemberById(int memberId) {
        Member membertemp = new Member();
        for (Member member : members){
            if (memberId == member.getMemberId()){
                membertemp = member;
            }
            else{
                membertemp = null;
            }
        }
        return membertemp;
        // return members.stream()
        //         .filter(m -> m.getMemberId() == memberId)
        //         .findFirst()
        //         .orElseThrow(() -> new NoSuchElementException("Member dengan ID " + memberId + " tidak ditemukan."));
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}