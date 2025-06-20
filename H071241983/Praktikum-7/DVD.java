
public class DVD extends LibraryItem {
    int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId, false);
        this.duration = duration;
    }

    @Override
    public String borrowItem(int days) {

        if (days > 7) {
            throw new IllegalArgumentException();
        } else if (isBorrowed) {
            throw new IllegalArgumentException();
        }

        return "DVD " + title + " berhasil dipinjam selama " + days + " hari";

    }

    @Override
    public double calculateFine(int daysLate) {
        return 25000 * daysLate;
    }

    @Override
    public String getDescription() {
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }

}
