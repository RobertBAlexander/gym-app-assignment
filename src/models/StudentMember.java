package models;

/**
 * This class is the template for a single Student Member. This is a subclass of the Member super class.
 *
 * The sub class details stored for a member include:
 *      StudentMember studentID
 *      StudentMember collegeName
 *
 * Along with the standard constructors, getters, setters and toString methods listed below, there are
 * specific methods that:
 * !!!!Currently do not have any additional methods here!!!!
 *
 * Created by Robert Alexander on 29/04/2017.
 */
public class StudentMember extends Member{
    private String studentID;
    private String collegeName;

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
     *
     * @param studentID There is no validation for the student's ID.
     *
     * @param collegeName There is no validation for the student's college name.
     */
    public StudentMember( String name, String email, String address, String gender, double height, double startingWeight,
            String memberPackage, String studentID, String collegeName) {
        super(name, email, address, gender, height, startingWeight, memberPackage);
        this.studentID = studentID;
        this.collegeName = collegeName;
    }

    //********************************************************************************
    //  SETTERS
    //********************************************************************************

    /**
     * This method updates the studentID field.
     * @param studentID There is no validation on the student's ID.
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * This method updates the college name field.
     * @param collegeName There is no validation on the student's college name.
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    //********************************************************************************
    //  GETTERS
    //********************************************************************************

    /**
     * Return the student member's student ID.
     * @return the student member's student ID.
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Return the student member's college name.
     * @return the student member's college name.
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * The chosen package is set to the value passed as a parameter. There is no validation on the entered data.
     * This is the concrete implementation of this method.
     * @param packageChoice The membership package chosen by this student member
     */
    public void chosenPackage (String packageChoice)
    {
        //This is the package/deal that the premium member chose. There is a limited set of options here it seems.
        //"The chosen package is set to the value passed as a parameter. There is no validation on the
        //entered data.

        packageChoice = "Package 3";
        //If no package associated with the college, default package is: "Package 3".
    }

    /**
     * Returns a human-readable String representation of the object state.
     *
     * @return a string version of the Student Member object, using information
     * from the Person and Member super classes. The String returned
     * is similar to this structure:
     *
     * !!! Have not finalised structure!!!
     */
    @Override
    public String toString() {
        String str = "";
        str += (super.toString() + "\n");
        str += ("Student ID: " + studentID + "\n");
        str += ("College Name: " + collegeName);

        return str;
    }
}
