public class peerson {
    String name;
    int age;
    boolean isMale;

    void setname(String name){
        this.name = name;
    }
    String getname(){
        return name;
    }
    void setage(int age){
        this.age = age;
    }
    String getage(){
        return name;
    }
    void setGender(boolean isMale){
        this.isMale = isMale;
    }
    Boolean getGender(){
        return isMale;
    }
    public static void main(String[] args) {
        peerson soal1 = new peerson();
        soal1.setname("wan");
        soal1.setage(18);
        soal1.setGender(true);


        System.out.println(soal1.getGender());
        

    }
    



    
}
