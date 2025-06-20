
public class Book extends LibraryItem {
    public String author;

    public Book(int itemId, String title, String author) {
        super(title, itemId, false);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 14) {
            throw new IllegalArgumentException("Durasi peminjaman tidak boleh lebih dari 14 hari");
        } else if (isBorrowed) {
            throw new IllegalArgumentException("Barang masih dipinjam");
        }

        return "Buku " + title + " berhasil dipinjam selama " + days + " hari";

    }

    @Override
    public double calculateFine(int daysLate) {
        return 10000 * daysLate;
    }

}
