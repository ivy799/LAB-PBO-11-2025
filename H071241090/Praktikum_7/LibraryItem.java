package Praktikum_7;

abstract class LibraryItem {
    protected String title;
    protected int itemId;
    protected Boolean isBorrowed;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(Boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
    
    public abstract String getDescription();

    public abstract String borrowItem(int days);

    public abstract double calculateFine(int daysLate);

    public String returnItem(){
        isBorrowed = false;
        return title + " telah dikembalikan";
    }

}
