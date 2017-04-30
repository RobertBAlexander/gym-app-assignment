package models;

/**
 * Created by Robert Alexander on 27/04/2017.
 */
abstract public class Person {
    private String name;
    private String email;
    private String address;
    private String gender;

    public Person(String name, String email, String address, String gender) {
        if (name.length() <= 30)
        {
            this.name = name;
        }
        else
        {
            this.name = name.substring(0, 30);
        }

        String atSymbol = "@";
        if (email.contains(atSymbol))
        {
            this.email = email;
        }
        else
        {
            this.email = "Invalid Email";
        }
        this.address = address;
        if ((gender.toUpperCase().equals("M")) || (gender.toUpperCase().equals("F"))) {
            this.gender = gender.toUpperCase();
        }
        else
        {
            this.gender = "Unspecified";
        }
    }

    public void setEmail(String email) {
        String atSymbol = "@";
        if (email.contains(atSymbol))
        {
            this.email = email;
        }
        else
        {
            this.email = "Invalid Email";
        }
    }

    public void setName(String name) {
        if (name.length() <= 30)
        {
            this.name = name;
        }
        else
        {
            this.name = name.substring(0, 30);
        }

    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        if ((gender.toUpperCase().equals("M")) || (gender.toUpperCase().equals("F"))) {
            this.gender = gender.toUpperCase();
        }
        else
        {
            this.gender = "Unspecified";
        }
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        String str = "";

        str += (name + "\n");
        str += (email + "\n");
        str += (address + "\n");
        if((gender == "M") || (gender == "F")) {
            str += (gender += "\n");
        }
        return str;

    }
}
