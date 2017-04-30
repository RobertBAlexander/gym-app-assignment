package models;

/**
 * Created by Robert Alexander on 29/04/2017.
 */
abstract public class Member extends Person{
    private double height;
    private double startingWeight;

    //This code doesn't work. user calls on
    public Member( String name, String email, String address, String gender, double height, double startingWeight) {
        super(name, email, address, gender);
        if ((height >= 1) && (height <= 3))
        {
            this.height = height;
        }
        if ((startingWeight >= 35) && (startingWeight <= 250))
            this.startingWeight = startingWeight;
    }


    public void setHeight(double height) {
        if ((height >= 1) && (height <= 3))
        {
            this.height = height;
        }
    }

    public void setStartingWeight(double weight) {
        if ((startingWeight >= 35) && (startingWeight <= 250))
        this.startingWeight = startingWeight;
    }

    public double getHeight() {

        return height;
    }

    public double getWeight() {
        return startingWeight;
    }

    /*public Assessment latestAssessment {
        return assessment;
    }

    public SortedSet<Date> sortedAssessmentDates()
    {

    }*/

    public abstract void chosenPackage(String chosenPackage);

    @Override
    public String toString() {
        String str = "";
        str += (super.toString() + "\n");
        str += (height + "\n");
        str += (startingWeight + "\n");

        return str;
    }
}
