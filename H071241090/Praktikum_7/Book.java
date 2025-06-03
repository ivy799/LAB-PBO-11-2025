package Praktikum_7;

public class Book extends LibraryItem {
    protected String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sudah dipinjam.");
        }
        if (days > 14) {
            throw new IllegalArgumentException("Buku hanya bisa dipinjam maksimal 14 hari.");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }

    public void printBooks() {
        System.out.println(getDescription());
    }

}
