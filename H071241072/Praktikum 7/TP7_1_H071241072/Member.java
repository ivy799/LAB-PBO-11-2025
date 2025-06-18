package tp7;

import java.util.List;
import java.util.ArrayList;

class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }
    public Member(){
        
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed())
            throw new IllegalStateException("Item tidak tersedia.");
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item))
            return "Item tidak ditemukan dalam daftar pinjaman.";
        borrowedItems.remove(item);
        String result = item.returnItem();
        double fine = item.calculateFine(daysLate);
        return result + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine).replace(',', '.');
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }

        System.out.println("+------+--------------------------+");
        System.out.printf("| %-4s | %-24s |\n", "ID", "Judul");
        System.out.println("+------+--------------------------+");
        borrowedItems.forEach(item -> System.out.printf("| %-4d | %-24s |\n", item.getItemId(), item.getTitle()));
        System.out.println("+------+--------------------------+");
    
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }
}