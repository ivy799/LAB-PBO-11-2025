public class nomor1 {
    String name;
    int age;
    boolean isMale;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }
    public String getGender() {
        if (isMale){
            return "Male";
        } else{
            return "Female";
        }
    }
    public static void main(String[] args) {
        nomor1 orang = new nomor1();
        orang.setName("eryn");
        orang.setAge(19);
        orang.setGender(false);

        System.out.println("nama:" + orang.getName());
        System.err.println(orang.getGender());
    }    
}
