// package Tugas.Lab_pekan_2;

public class no1 {
    public String name;
    public int age;
    public boolean isMale;

    public void setName(String name){
        this.name = name;
    }
    public String getname(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setGender(boolean isMale){
        this.isMale = isMale;
    }
    public String getGender(){
        return isMale ? "Male" : "Female";
    }

    public static void main(String[] args) {
        no1 p = new no1();
        p.setName("Aco");
        p.setAge(20);
        p.setGender(true);
        System.out.println("Name: " + p.getname());
        System.out.println("Age: " + p.getAge());
        System.out.println("Gender: " + p.getGender());
    }
}