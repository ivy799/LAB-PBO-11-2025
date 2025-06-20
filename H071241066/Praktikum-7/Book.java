public class Book extends LibraryItem {
    private String author;

    public Book(String tittle, int itemId, String author) {
        super(tittle, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku " + tittle + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan.");
        }
        if (days > 14) {
            throw new IllegalArgumentException("Maksimal peminjaman adalah 14 hari.");
        }
        isBorrowed = true;
        return tittle + " dipinjam selama " + days + " hari.";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }
}