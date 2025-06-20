public class Ore{
    String type;
    int hardness; 
    int mininglevel;

    public Ore(String type, int hardness, int miningLevel){
        this.type = type;
        this.hardness = hardness;
        this.mininglevel = miningLevel;

    }
    public String getDrop(){
        return type;

    }
}

