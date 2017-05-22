package models;

/**
 *This class is the template for a single Premium Member. This is a subclass of the Member super class.
 *
 *
 * Along with the standard constructors, getters, setters and toString methods listed below, there are
 * specific methods that:
 * !!!!Currently do not have any additional methods here!!!!
 *
 * Created by Robert Alexander on 29/04/2017.
 */
public class PremiumMember extends Member{

    /**
     * Constructor for objects of class Premium Member.
     *
     * @param name The name, and its validation, are called from the Person super class.
     *
     * @param email The e-mail, and its validation, are called from the Person super class.
     *
     * @param address The address is called from the Person super class.
     *
     * @param gender The gender, and its validation, are called from the Person super class.
     *
     * @param height The height, and it's validation, are called from the Member super class.
     *
     * @param startingWeight The starting weight and it's validation, are called from the Member super class.
     */
    public PremiumMember( String name, String email, String address, String gender, double height, double startingWeight,
                          String memberPackage) {
        super(name, email, address, gender, height, startingWeight, memberPackage);

    }

    /**
     * The chosen package is set to the value passed as a parameter. There is no validation on the entered data.
     * This is the concrete implementation of this method.
     * @param packageChoice The membership package chosen by this premium member
     */
    public void chosenPackage (String packageChoice)
    {
        //This is the package/deal that the premium member chose. There is a limited set of options here it seems.
        //"The chosen package is set to the value passed as a parameter. There is no validation on the
        //entered data.
        packageChoice = "Package 3";
    }

    /**
     * Returns a human-readable String representation of the object state.
     *
     * @return a string version of the Premium Member object, using information
     * from the Person and Member super classes. The String returned
     * is similar to this structure:
     *
     * !!! Have not finalised structure!!!
     */
    @Override
    public String toString() {
        String str = "";
        str += (super.toString() + "\n");

        return str;
    }
}
