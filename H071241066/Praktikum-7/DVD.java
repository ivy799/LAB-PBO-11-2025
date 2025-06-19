public class DVD extends LibraryItem {
    private int duration;

    public DVD(String tittle, int itemId, int duration) {
        super(tittle, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD " + tittle + ", durasi: " + duration + " menit, ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("DVD sudah dipinjam dan belum dikelmbalikan.");
        }
        if (days > 7) {
            throw new IllegalArgumentException("Maksimal peminjaman untuk DVD adalah 7 hari.");
        }
        isBorrowed = true;
        return tittle + "dipinjam selama " + days + "hari.";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }
}