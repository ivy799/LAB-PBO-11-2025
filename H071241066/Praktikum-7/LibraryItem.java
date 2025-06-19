public abstract class LibraryItem {
    protected String tittle;
    protected int itemId;
    protected boolean isBorrowed;

    public LibraryItem(String tittle, int itemId) {
        this.tittle = tittle;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public abstract String getDescription();

    public abstract String borrowItem(int days);

    public abstract double calculateFine(int daysLate);

    public String returnItems() {
        isBorrowed = false;
        return tittle + "dikembalikan";
    }

}