class Person {
    String name;
    int age;
    boolean isMale;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            this.isMale = true;
        } else if (gender.equalsIgnoreCase("female")) {
            this.isMale = false;
        }
    }

    public String getGender() {
        if (this.isMale) {
            return "male";
        } else {
            return "female";
        }
    }
}

public class No1 {
    public static void main(String[] args) {
        Person person = new Person();

        person.setName("Ucup");
        person.setAge(14);
        person.setGender("male");

        System.out.println("Nama : " + person.getName());
        System.out.println("Umur : " + person.getAge());
        System.out.println("Gender : " + person.getGender());
    }
}