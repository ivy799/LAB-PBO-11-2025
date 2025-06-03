package Praktikum_7;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setBorrowedItems(List<LibraryItem> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<LibraryItem> getBorrowedItemsList() {
        return borrowedItems;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.getIsBorrowed()) {
            throw new IllegalStateException("Item sudah dipinjam.");
        }

        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            return "Item tidak ditemukan dalam daftar pinjaman.";
        }

        borrowedItems.remove(item);
        item.returnItem();
        double fine = item.calculateFine(daysLate);

        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
        } else {
        
            System.out.println("+--------+-----------+");
            System.out.println("| ID     | Judul     |");
            System.out.println("+--------+-----------+");
            
            for (LibraryItem item : borrowedItems) {
                System.out.printf("| %-6s | %-9s |\n", item.getItemId(), item.getTitle());
            }
            
            System.out.println("+--------+-----------+");
        }
    }

}
