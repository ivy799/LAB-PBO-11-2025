package library;

import java.util.List;

import items.LibraryItem;
import user.Member;

import java.util.ArrayList;

public class Library {
    public List<LibraryItem> items;
    public List<Member> members;
    public LibraryLogger logger;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        for (LibraryItem existingItem : items) {
            if (existingItem.itemId == item.itemId) {
                throw new IllegalArgumentException("Item dengan ID " + item.itemId + " sudah ada");
            }
        }
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.itemId == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan");
    }

    public void getLibraryStatus() {
        System.out.println("+-----+-----------+-----------+");
        System.out.println("| ID  | Judul     | Status    |");
        System.out.println("+-----+-----------+-----------+");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            System.out.printf("| %-3d | %-9s | %-9s |\n", item.itemId, item.title, status);
        }
        System.out.println("+-----+-----------+-----------+");
    }

    public String getAllLogs() {
        return logger.getLogs();
    }
}

class NoSuchElementException extends RuntimeException {
    public NoSuchElementException(String message) {
        super(message);
    }
}

class IllegalStateException extends RuntimeException {
    public IllegalStateException(String message) {
        super(message);
    }
}