public abstract class LibraryItem {
    public String title;
    public int itemId;
    public boolean isBorrowed;

    public LibraryItem(String title, int itemId, boolean isBorrowed) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = isBorrowed;
    }

    public abstract String getDescription();

    public abstract String borrowItem(int days);

    public abstract double calculateFine(int daysLate);

    public String returnItem() {
        this.isBorrowed = false;
        return this.title + " dikembalikan";
    }

}
