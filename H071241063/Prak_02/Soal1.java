class Person{
    String name;
    int age;
    boolean isMale;

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    void setAge(int age){
        this.age = age;
    }

    int getAge(){
        return age;
    }

    void setGender(boolean isMale){
        this.isMale = isMale;
   
    }

    String getGender(){
        return (isMale) ? "Male" : "Female"; 
    }
}




public class Soal1{
    public static void main(String[] args) {
        Person wan = new Person();
        wan.setName("YUD BRYAWAN");
        wan.setAge(19);
        wan.setGender(false);

        System.out.println("name = " + wan.getName());
        System.out.println("age = " + wan.getAge());
        System.out.println("gender = " + wan.getGender());

    }
}