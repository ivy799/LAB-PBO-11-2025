public class TP2_1_H071241010 {
    public String name;
    public int age;
    public String gender;

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

    public boolean isMale() {
        if (gender != null) {
            if (gender.equalsIgnoreCase("male")) {
                return true;
            } else if (gender.equalsIgnoreCase("female")) {
                return false;
            } else {
                throw new IllegalArgumentException("Gender must be either 'male' or 'female'.");
            }
        } else {
            throw new IllegalArgumentException("Gender has not been set.");
        }
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Gender must be either 'male' or 'female'.");
        }
    }

    public String getGender() {
        return gender;
    }

    public static void main(String[] args) {
        TP2_1_H071241010 orang1 = new TP2_1_H071241010();
        orang1.setName("Farel");
        orang1.setAge(20);

        try {
            orang1.setGender("mal");
            System.out.println(orang1.getName());
            System.out.println(orang1.getAge());
            System.out.println("Is male: " + orang1.isMale());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}