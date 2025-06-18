class person{
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

    void getGender(boolean isMale){
        this.isMale = isMale;
    }

    String getGender(){
        return (isMale) ? "Male" : "Female";
        
    }
}

public class person{
    peblic static void main(String[] args) {
        person yud = new pesong();
        yud.setName("yud bryawan");
        yud.setAge(19);
        yud.setGender(false);

        System.out.println("name = " + yud.getName());
        System.out.println("age = " + yud.getAge());
        System.out.println("gender = " + yud.getGender());

    }
}
    


    
