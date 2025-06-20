import java.util.ArrayList;

public class Member {
    public String name;
    private String memberId;
    private ArrayList<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String borrow(LibraryItem libraryItem, int days) {
        if (libraryItem.isBorrowed) {
            throw new IllegalStateException("Item tidak tersedia (sudah dipinjam)");
        }

        String status = libraryItem.borrowItem(days);

        borrowedItems.add(libraryItem);

        return status;
    }

    public String returnItem(LibraryItem libraryItem, int daysLate) {
        libraryItem.returnItem();

        double fine = libraryItem.calculateFine(daysLate);

        borrowedItems.remove(libraryItem);

        return "Item " + libraryItem.title + " berhasil dikembalikan dengan denda: Rp " + fine;
    }

    public void getBorrowedItems() {
        System.out.println("+-----+--------+");
        System.out.println("| ID  | Judul  |");
        System.out.println("+-----+--------+");
        for (LibraryItem libraryItem : borrowedItems) {
            System.out.printf("| %s | %s |\n", libraryItem.itemId, libraryItem.title);
        }
        System.out.println("+-----+--------+");

    }

}
