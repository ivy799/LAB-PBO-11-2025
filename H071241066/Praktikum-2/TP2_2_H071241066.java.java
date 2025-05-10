public class nomor2 {
    String id;
    String nama;
    boolean stok;
    int harga;

    public String isTersedia(){
        return stok ? "Tersedia" : "Tidak tersedia";
    }

    public void TampilkanProduk(){
        System.out.println("id :" + id );
        System.out.println("nama barang: " + nama);
        System.out.println("stok " + isTersedia());
    }
    public static void main(String[] args) {
        nomor2 item = new nomor2();
        item.id = "001";
        item.nama = "laptop";
        item.stok = false;

        item.TampilkanProduk();

}
}
