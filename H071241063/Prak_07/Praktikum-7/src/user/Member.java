package user;

import java.util.List;

import items.LibraryItem;
import java.util.ArrayList;

public class Member {
    public String name;
    public int memberId;
    List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        try {

            String result = item.borrowItem(days);
            borrowedItems.add(item);
            return result;
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public String returnItem(LibraryItem item, int daysLate) {
        boolean found = false;
        for (LibraryItem borrowedItem : borrowedItems) {
            if (borrowedItem.itemId == item.itemId) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Anggota " + name + " tidak meminjam item dengan ID " + item.itemId);
        }

        borrowedItems.remove(item);
        item.returnItem();
        double fine = item.calculateFine(daysLate);
        java.text.DecimalFormat formatter = new java.text.DecimalFormat("#,###");
        String formattedFine = formatter.format(fine);

        return "Item " + item.title + " berhasil dikembalikan dengan denda: Rp " + formattedFine;
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }

        System.out.println("+-----+-----------+");
        System.out.println("| ID  | Judul     |");
        System.out.println("+-----+-----------+");
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-3d | %-9s |\n", item.itemId, item.title);
        }
        System.out.println("+-----+-----------+");
    }
}