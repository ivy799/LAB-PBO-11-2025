package Praktikum_3;

public class Main {
    public static void main(String[] args) {
        Artis artis1 = new Artis("Tyler The Creator", "RnB", 18);
        Artis artis2 = new Artis("NIKI", "Pop Rock", 22);

        Coachella week1 = new Coachella("Coachella's Main Stage", 2025, "14 April",1000);
        Coachella week2 = new Coachella("Coachella's North Stage", 2025, "21 April",1500);

        week1.tampilkanLineUp();
        week1.tukarJadwal(week2);
        week1.addArtis(artis1);
        week1.addArtis(artis2);
        week1.tampilkanLineUp();

        Tiket tiket1 = new Tiket("reguler", 2);
        Tiket tiket2 = new Tiket("backstage", 1);

        week1.tiketFestival = tiket1; 
        week2.tiketFestival = tiket2; 

        week1.tampilkanDetailTiket();
        week2.tampilkanDetailTiket();
    }
}