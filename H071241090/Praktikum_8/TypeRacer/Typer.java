package Praktikum_8.TypeRacer;

class Typer extends Thread {
    private String botName, wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.wordsTyped = "";
        this.typeRacer = typeRacer;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setWpm(double wpm) {
        this.wpm = wpm;
    }

    public void addWordsTyped(String newWordsTyped) {
        this.wordsTyped += newWordsTyped + " ";
    }

    public String getWordsTyped() {
        return wordsTyped;
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }
    
    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");
        
        // TODO (1)
        // Buatlah variable howLongToType yang memuat waktu yang diperlukan typer
        double howLongToType = (60.0 / wpm) * 1000; // waktu per kata dalam milidetik
        
        // TODO (2)
        // Buatlah perulangan untuk menambahkan kata dengan method
        // addWordToTyped setelah interval waktu sebanyak howLongToType
        for (String word : wordsToType) {
            try {
                Thread.sleep((long) howLongToType);
                this.addWordsTyped(word);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        this.addWordsTyped("(Selesai)");
        
        // TODO (3)
        // Tambahkan typer yang telah selesai mengetik semua kata ke list typeRaceTabel 
        // yang ada di class typeRacer.
        typeRacer.addResult(this);
    }
}