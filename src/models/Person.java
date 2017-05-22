package models;

/**
 * This class is the template for a single Person. This is a super class for Member and Trainer.
 *
 * The details stored for a member include:
 *      Member Name
 *      Member e-mail
 *      Member Address
 *      Member Gender
 *
 * Along with the standard constructors, getters, setters and toString methods listed below, there are
 * specific methods that:
 * !!!!Currently do not have any additional methods here!!!!
 *
 * Created by Robert Alexander on 27/04/2017.
 */
abstract public class Person {
    private String name;
    private String email;
    private String address;
    private String gender;


    /**
     * Constructor for objects of class Person.
     *
     * @param name The Person's name should be no more than 30 characters. If the
     *             entered name exceeds 30 characters, the extra characters will be
     *             truncated and only the first 30 characters will be used.
     *
     * @param email The Person's e-mail should contain an '@' symbol. No other
     *              validation is required.
     *
     * @param address There is no validation on the member's address.
     *
     * @param gender The member's gender can be either "M" or "F". lower case entries
     *               will be changed to upper case. If not specified, this will default
     *               to "Unspecified".
     */
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

        if ((gender.equals("M")) || (gender.equals("F"))){
            this.gender = gender.toUpperCase();
        } else if (gender.equals("m"))
        {
            this.gender = "M";
        }
        else if (gender.equals("f"))
        {
            this.gender = "F";
        }
        else {
            this.gender = "Unspecified";
        }

    }

    //********************************************************************************
    //  SETTERS
    //********************************************************************************



    /**
     * This method updates the email field.
     * @param email The Person's e-mail must contain an '@' symbol.
     */
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

    /**
     * This method updates the name field.
     * @param name The person's name should be no longer tha n30 characters. If
     *             the entered name exceeds 30 cahracters, the extra characters
     *             will be truncated and only the first 30 characters will be used.
     */
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

    /**
     * This method updates the address field.
     * @param address There is no validation on the member's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method updates the gender field.
     * @param gender The member's gender can be either "M" or "F". lower case entries
     *               will be changed to upper case. If not specified, this will default
     *               to "Unspecified".
     */
    public void setGender(String gender) {
        if ((gender.equals("M")) || (gender.equals("F"))){
            this.gender = gender.toUpperCase();
        } else if (gender.equals("m"))
        {
            this.gender = "M";
        }
        else if (gender.equals("f"))
        {
            this.gender = "F";
        }
        else {
            this.gender = "Unspecified";
        }
    }

    //********************************************************************************
    //  GETTERS
    //********************************************************************************

    /**
     * Returns the e-mail of the Person.
     * @return the Person's e-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the name of the Person.
     * @return the Person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the address of the Person.
     * @return the Person's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the gender of the Person.
     * @return the Person's gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Returns a human-readable String representation of the object state.
     *
     * @return a string version of the Person object. The String returned
     * is similar to this structure:
     *
     * !!! Have not finalised structure!!!
     */
    @Override
    public String toString() {
        String str = "";

        str += ("Name: " + name + "\n");
        str += ("E-mail: " + email + "\n");
        str += ("Address: " + address + "\n");
        if((gender == "M") || (gender == "F")) {
            str += ("Gender: " + gender);
        }
        else
        {
            str += "Gender: Unspecified";
        }
        return str;

    }
}
