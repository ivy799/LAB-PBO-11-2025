import java.util.List;
import java.util.ArrayList;

public class Member {
    public String name;
    public int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        if (item == null || item.isBorrowed) {
            throw new IllegalStateException("item tidak tersedia untuk dipinjam");
        }
        String borrowResult = item.borrowItem(days);
        borrowedItems.add(item);
        return borrowResult;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            return "Item tidak ditemukan dalam daftar pinjaman.";
        }
        item.returnItems();
        borrowedItems.remove(item);
        double fine = item.calculateFine(daysLate);
        return "Item " + item.tittle + " berhasil dikembalikan dengan denda: Rp. " + fine;

    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("tidak ada item yang dipinjam");
        } else {
            System.out.println("+------+----------------+");
            System.out.println("| ID   | Judul          |");
            System.out.println("+------+----------------+");
            for (int i = 0; i < borrowedItems.size(); i++) {
                LibraryItem item = borrowedItems.get(i);
                System.out.printf("| %-4d| %-16s|\n", item.itemId, item.tittle);
            }
            System.out.println("+------+----------------+");
        }
    }
}
