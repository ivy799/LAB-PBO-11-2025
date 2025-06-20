public class produk {
    String id;
    String nama;
    int stok;
    double harga;

    void cekstok(){
        if (this.stok == 0) {
            System.out.println("tidak tesedia"); 
        }
        else {
            System.out.println(" tesedia");
        }
    }
    public static void main(String[] args) {
        produk soal2 = new produk();
        soal2.stok = 0;
        soal2.cekstok();
    }
    
}
