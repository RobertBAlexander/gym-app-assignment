package models;

/**
 * Created by rober on 29/04/2017.
 */
public class PremiumMember extends Member{

    public PremiumMember( String name, String email, String address, String gender, double height, double startingWeight) {
        super(name, email, address, gender, height, startingWeight);

    }

    public void chosenPackage (String packageChoice)
    {
        //This is the package/deal that the premium member chose. There is a limited set of options here it seems.
        //"The chosen package is set to the value passed as a parameter. There is no validation on the
        //entered data.
        packageChoice = "Package 3";
    }

    @Override
    public String toString() {
        String str = "";
        str += (super.toString() + "\n");

        return str;
    }
}
