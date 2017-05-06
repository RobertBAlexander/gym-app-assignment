package models;


import java.text.DateFormat;
import java.util.*;
import java.util.TreeSet;

import models.Assessment;


/**
 * This class is the template for a single Member. This is a super class for Premium Member
 * and Student Member, but is a subclass of the Person super class.
 *
 * The sub class details stored for a member include:
 *      Member Height
 *      Member Weight
 *
 * Along with the standard constructors, getters, setters and toString methods listed below, there are
 * specific methods that:
 * !!!!Currently do not have any additional methods here!!!!
 *
 * Created by Robert Alexander on 29/04/2017.
 */
abstract public class Member extends Person{
    private double height;
    private double startingWeight;
    //public String chosenPackage;
    HashMap<Date, Assessment> assessments = new HashMap<>();
    TreeSet<Date> assessmentTreeSet = new TreeSet<Date>();

    /**
     * Constructor for objects of class Member.
     *
     * @param name The name, and its validation, are called from the Person super class.
     *
     * @param email The e-mail, and its validation, are called from the Person super class.
     *
     * @param address The address is called from the Person super class.
     *
     * @param gender The gender, and its validation, are called from the Person super class.
     *
     * @param height The Person's height must be greater than or equal to 1 meter, and less
     *               than or equal to 3 meters.
     *
     * @param startingWeight The Person's weight upon joining the gym must be greater than or equal
     *               to 35kg, and less than or equal to 250kg.
     */
    public Member( String name, String email, String address, String gender, double height,
                   double startingWeight) {
        super(name, email, address, gender);
        if ((height >= 1) && (height <= 3))
        {
            this.height = height;
        }
        if ((startingWeight >= 35) && (startingWeight <= 250))
            this.startingWeight = startingWeight;
    }



    //********************************************************************************
    //  SETTERS
    //********************************************************************************

    /**
     * This method updates the height field.
     * @param height The Person's height must be greater than or equal to 1 meter, and less
     *               than or equal to 3 meters.
     */
    public void setHeight(double height) {
        if ((height >= 1) && (height <= 3))
        {
            this.height = height;
        }
    }
/*
    /**
     * This method updates the weight field. It should not be used, as weight should only be adjusted in assessments.
     * @param weight The Person's weight upon joining the gym must be greater than or equal
     *               to 35kg, and less than or equal to 250kg.

    public void setStartingWeight(double weight) {
        if ((startingWeight >= 35) && (startingWeight <= 250))
        this.startingWeight = startingWeight;
    }
    */


    /**
     * This method adds an assessment to member. The current date, and the details of an assessment should
     * be passed in.
     * @param date The current date. This should be created automatically.
     * @param assessment The assessment should contain current weight, chest, thigh, upperArm, waist, hips,
     *                   a comment by the trainer, and the trainer who performed the assessment.
     */
    public void addAssessment(Date date, Assessment assessment)
    {
        //need to do code for getting the current date, and also need to figure out
        //how I'm referring to assessments so that I can call them here.
        //assessments.put(currentDate, assessmentName)
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
        //Date currentDate = new Date();
        //date = dateFormat.format(currentDate);
        assessments.put(date, assessment);
    }

    //********************************************************************************
    //  GETTERS
    //********************************************************************************

    /**
     * Returns the member's height.
     * @return the member's height.
     */
    public double getHeight() {

        return height;
    }

    /**
     * Returns the member's starting weight.
     * @return the member's starting weight.
     */
    public double getWeight() {
        return startingWeight;
    }

    /**
     * Returns the latest assessment based on last entry (by calendar date).
     * @return the latest assessment based on last entry (by calendar date).
     */

    public Assessment latestAssessment() {
        /*
        //check all assessments for most recent by Date. Return latest assessment.
       /* for (int i = 0; i < numberOfMembers(); i++)
            {
                idealWeightMembers += i + ": " + members.get(i) + "\n";
            }
            return idealWeightMembers;


            if at the start, do:
            return assessment first();
            if at end, do:
            return assessment last();

            return SortedSet.last();
*/
        return null;
    }


    /**
     * Returns the assessments dates sorted in date order. (I can change out of sorted set if I want to do
     * this another way)
     * @return the assessments dates sorted in date order. (I can change out of sorted set if I want to do
     * this another way)
     */

   public SortedSet<Date> sortedAssessmentDates()
    {
        /*
        //Do not have <Date> working properly.
        SortedSet<Date> keys = new TreeSet(SortedSet(<Date, assessments>));
        keys.addAll(assessments);

        TreeSet(assessments<? extends assessments> );

        SortedSet s = Collections.synchronizedSortedSet(new TreeSet(assessments<? extends assessments> ));

        return Collections.sort(assessments, Date);


        //kind of like how list =array list.
        //strip dates off, then sort those dates.
        //what is the concrete class I use(like arraylist) figure out what concrete class in a set is sorted?
        // use key values of the hashmap?
        //make sure they are sorted by most recent first.
        */
        return null;
    }

    /**
     * The concrete implementation of this method will be completed in Member subclasses.
     * @param chosenPackage The membership package chosen by this member.
     */
    public abstract void chosenPackage(String chosenPackage);

    /**
     * Returns a human-readable String representation of the object state.
     *
     * @return a string version of the Member object, using information
     * from the Person super class. The String returned
     * is similar to this structure:
     *
     * !!! Have not finalised structure!!!
     */
    @Override
    public String toString() {
        String str = "";
        str += (super.toString() + "\n");
        str += (height + "\n");
        str += (startingWeight + "\n");

        return str;
    }
}
