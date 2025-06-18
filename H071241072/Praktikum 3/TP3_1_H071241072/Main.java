import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Senjata kn44 = new Senjata("KN-44", 35, "Assault Rifle");
        Senjata haymaker = new Senjata("Haymaker", 40, "Shotgun");
        Senjata vesper = new Senjata("Vesper", 30, "SMG");
        Senjata dingo = new Senjata("Dingo", 45, "LMG");

        Perk doubleTap = new Perk("Double Tap (x2 damage)");
        Perk juggernog = new Perk("Juggernog (+50 health)");
        Perk electricCherry = new Perk("Electric Cherry (+5 damage)");

        PrimisMember richtofen = new PrimisMember("Richtofen", 100, kn44, doubleTap);
        PrimisMember takeo = new PrimisMember("Takeo", 100, haymaker, juggernog);
        PrimisMember nikolai = new PrimisMember("Nikolai", 100, vesper, electricCherry);
        PrimisMember dempsey = new PrimisMember("Dempsey", 100, dingo, juggernog);

        PrimisMember[] crew = {richtofen, takeo, nikolai, dempsey};

        String[] zombieTypes = {
            "Zombie Normal", "Sprinter Zombie", "Heavy Zombie",
            "Hellhound", "Mutated Zombie", "Armored Zombie"
        };

        int ronde = 0;
        Random rand = new Random();

        while (!semuaCrewKO(crew)) {
            ronde++;

            // Ambil zombie secara acak
            String type = zombieTypes[rand.nextInt(zombieTypes.length)];
            int baseHealth = 0;
            int baseDamage = 0;

            // Set base stat per tipe
            switch (type) {
                case "Zombie Normal":
                    baseHealth = 50;
                    baseDamage = 10;
                    break;
                case "Sprinter Zombie":
                    baseHealth = 40;
                    baseDamage = 15;
                    break;
                case "Heavy Zombie":
                    baseHealth = 100;
                    baseDamage = 20;
                    break;
                case "Hellhound":
                    baseHealth = 30;
                    baseDamage = 25;
                    break;
                case "Mutated Zombie":
                    baseHealth = 90;
                    baseDamage = 30;
                    break;
                case "Armored Zombie":
                    baseHealth = 120;
                    baseDamage = 35;
                    break;
            }

            // Scaling stat berdasarkan ronde
            int zombieHealth = baseHealth + (ronde * 10);
            int zombieDamage = baseDamage + (ronde * 3);

            Zombie zombie = new Zombie(type, zombieHealth, zombieDamage);

            System.out.println("\n===== RONDE " + ronde + " =====");
            System.out.println("Musuh: " + zombie.nama + " | Health: " + zombie.health + " | Damage: " + zombie.damage);

            while (!zombie.isDead() && !semuaCrewKO(crew)) {
                for (PrimisMember member : crew) {
                    if (!member.isDead() && !zombie.isDead()) {
                        member.tembak(zombie);
                    }
                }
                for (PrimisMember member : crew) {
                    if (!member.isDead() && !zombie.isDead()) {
                        zombie.serang(member);
                    }
                }
            }

            if (zombie.isDead()) {
                System.out.println(">> " + zombie.nama + " telah dikalahkan!");
            }

            printStatusCrew(crew);

            if (semuaCrewKO(crew)) {
                System.out.println("Semua Primis Crew telah gugur!");
                break;
            }
        }

        System.out.println("Primis Crew bertahan sampai ronde ke-" + ronde + "!");
    }

    public static boolean semuaCrewKO(PrimisMember[] crew) {
        for (PrimisMember member : crew) {
            if (!member.isDead()) return false;
        }
        return true;
    }

    public static void printStatusCrew(PrimisMember[] crew) {
        for (PrimisMember member : crew) {
            member.status();
        }
    }
}