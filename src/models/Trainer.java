package models;

/**
 *  * This class is the template for a single Trainer. This is a subclass of the Person super class.
 *
 * The sub class details stored for a trainer include:
 *      Trainer speciality
 *
 * Along with the standard constructors, getters, setters and toString methods listed below, there are
 * specific methods that:
 * !!!!Currently do not have any additional methods here!!!!
 *
 * Created by Robert Alexander on 29/04/2017.
 */
public class Trainer extends Person{
    private String speciality;

    /**
     * Constructor for objects of class Trainer.
     *
     * @param name The name, and its validation, are called from the Person super class.
     *
     * @param email The e-mail, and its validation, are called from the Person super class.
     *
     * @param address The address is called from the Person super class.
     *
     * @param gender The gender, and its validation, are called from the Person super class.
     *
     * @param speciality There is no validation for the trainer's speciality.
     *
     */
    public Trainer( String name, String email, String address, String gender, String speciality) {
        super(name, email, address, gender);
        this.speciality = speciality;
    }

    //********************************************************************************
    //  SETTERS
    //********************************************************************************

    /**
     * This method updates the speciality field.
     * @param speciality There is no validation for the trainer's speciality.
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //********************************************************************************
    //  GETTERS
    //********************************************************************************

    /**
     * Returns the trainer's speciality.
     * @return the trainer's speciality.
     */
    public String getSpeciality() {
        return speciality;
    }


    /**
     * Returns a human-readable String representation of the object state.
     *
     * @return a string version of the Trainer object, using information
     * from the Person super class. The String returned
     * is similar to this structure:
     *
     * !!! Have not finalised structure!!!
     */
    @Override
    public String toString() {
        String str = "";
        str += (super.toString() + "\n");
        str += (speciality + "\n");

        return str;
    }
}
