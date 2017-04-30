package models;

/**
 * Created by rober on 29/04/2017.
 */
public class StudentMember extends Member{
    private String studentID;
    private String collegeName;

    public StudentMember( String name, String email, String address, String gender, double height, double startingWeight,
                          String studentID, String collegeName) {
        super(name, email, address, gender, height, startingWeight);
        this.studentID = studentID;
        this.collegeName = collegeName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void chosenPackage (String packageChoice)
    {
        //This is the package/deal that the premium member chose. There is a limited set of options here it seems.
        //"The chosen package is set to the value passed as a parameter. There is no validation on the
        //entered data.

        packageChoice = "Package 3";
        //If no package associated with the college, default package is: "Package 3".
    }

    @Override
    public String toString() {
        String str = "";
        str += (super.toString() + "\n");
        str += (studentID + "\n");
        str += (collegeName + "\n");

        return str;
    }
}
