package controllers;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.Assessment;
import models.Member;
import models.StudentMember;
import models.PremiumMember;
import models.Trainer;
import utils.Analytics;

/**
 * This class is the template for a Gym. It is a concrete class that operates between:
 * the inheritance heirarchy classes(Person, Member, Premium Member, Student Member,
 * Trainer) and assessment class.
 * the menu controller.
 *
 *
 * The class details stored for a gym API include:
 *      ArrayList Member
 *      ArrayList Trainer
 *
 * Along with the standard constructors, getters, setters and toString methods listed below, there are
 * specific methods that:
 * !!!!Currently do not have any additional methods here!!!!
 *
 * Created by Robert Alexander on 29/04/2017.
 */

public class GymApi {

    private ArrayList<Member> members = new ArrayList();
    private ArrayList<Trainer> trainers = new ArrayList();


    //********************************************************************************
    //  SETTERS
    //********************************************************************************

    /**
     * This method adds a member to the array list of members.
     * @param member There is no validation on adding a member to the array.
     */
    public void addMember(Member member)
    {
        members.add(member);
    }


    /**
     * This method adds a trainer to the array list of trainers.
     * @param trainer There is no validation on adding a trainer to the array.
     */
    public void addTrainer(Trainer trainer)
    {
        trainers.add(trainer);
    }

    //********************************************************************************
    //  GETTERS
    //********************************************************************************

    /**
     * Return the number of members in the array list of members.
     * @return the number of members in the array list of members.
     */
    public int numberOfMembers()
    {
        return members.size();
    }

    /**
     * Return the number of trainers in the array list of trainers.
     * @return the number of trainers in the array list of trainers.
     */
    public int numberOfTrainers()
    {
        return trainers.size();
    }

    /**
     * Return the array list of members.
     * @return the array list of members.
     */
    public ArrayList<Member> getMembers() {
        return members;
    }

    /**
     * Return the array list of trainers.
     * @return the array list of trainers.
     */
    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    /**
     * Checks if a valid member resides at this index in the Member arrayList.
     * @param index The index number that is being checked
     * @return True if the index is valid, otherwise return false
     */
    public boolean isValidMemberIndex (int index)
    {
        //Return true if the index passed as a parameter is a valid index for the member's array list
        if ((members.size() > 0) && (members.size() > index) && (index >= 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Checks if a valid trainer resides at this index in the Trainer arrayList.
     * @param index The index number that is being checked
     * @return True if the index is valid, otherwise return false
     */
    public boolean isValidTrainerIndex (int index)
    {
        if ((trainers.size() > 0) && (trainers.size() > index) && (index >= 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns a member based on a search using the member's e-mail as the input.
     * @param emailEntered The e-mail of the member being requested.
     * @return The member with this e-mail.
     */
    public Member searchMembersByEmail(String emailEntered)
    {
        //Finds a member based on an e-mail entered. If no match, return null
        //use... member.getEmail Then, if that string.equals emailEntered, return it. But search all e-mail strings!
        //String searchByMail = new String("");
        if (members.size() > 0) {
            // try members members members!!
            int i = 0;
            while (i < members.size()) {
                if (members.get(i).getEmail().equals(emailEntered)) {
                    return members.get(i);
                }
                i++;

            }
            return null;
        }

        return null;
    }


    /**
     * Returns a string of all the members names who match the search, using name as the input.
     * @param nameEntered The name which will be used to search through all member names.
     * @return A list of all the names which partially match the name used in the search parameters.
     */
    public String searchMembersByName (String nameEntered)
    {
        //Return list of members who's name partially or entirely matches entered name. If no members in gym,
        //return note indicating this. If no there are members, but no matches, return message
        //for this separately.
        String searchByName = new String("");
        if (members.size() > 0)
        {
            for (int i = 0; i < numberOfMembers(); i++)
            {
                //Member member = members.get(i);
                if (members.get(i).getName().toLowerCase().contains(nameEntered.toLowerCase()))
                {
                    searchByName += members.get(i).getName() + "\n";

                }
            }
            if (searchByName.equals(""))
            {
                return "There are no members matching your search criteria.";
            }
            else
            {
                return searchByName;
            }

        }
        else
        {
            return "There are no members in this gym.";
        }



    }

    //Perhaps this should be public Trainer, since it is for trainer, not person e-mails only?

    /**
     * Returns a trainer based on a search using the trainer's e-mail as the input.
     * @param emailEntered The e-mail of the trainer being requested.
     * @return The trainer with this e-mail.
     */
    public Trainer searchTrainersByEmail (String emailEntered)
    {
        //Returns the trainer based on e-mail entered. If no match, return null.
        String searchByMail = new String("");
        if (trainers.size() > 0)
        {
            // try members members members!!
            for (Trainer trainer : trainers)
            {
                if (emailEntered.equals(trainer.getEmail()))
                {
                    //searchByMail += searchByMail + trainer.getName();
                    return trainer;

                }
                else
                {
                    return null;
                }

            }
        }
        else
        {
            return null;
        }
        return null;
    }

    /**
     * Returns a list of all the members in this gym.
     * @return list of all the members in this gym.
     */
    public String listMembers()
    {
        //If members.size > 0. String listing all members in gym. If none, indicate this.
        if(members.size() > 0)
        {
            String listOfMembers = "";
            for (int i = 0; i < numberOfMembers(); i++)
            {
                listOfMembers += i + ": " + members.get(i).toString() + "\n";
            }
            return listOfMembers;
        }
        else
        {
            return "There are no members in this gym.";
        }
    }

    /**
     * Returns a list of all the members in this gym, with an ideal weight based on their latest assessment.
     * @return list of all the members in this gym, with an ideal weight based on their latest assessment
     */
    public String listMembersWithIdealWeight()
    {
        //Return string containing all the members details in the gym, who have ideal weight based
        //on latest assessment weight(devine method). If no members in gym, return indicating this.
        //If there are members, but none have ideal weight, return message for this separately.
        if(members.size() > 0)
        {
            String idealWeightMembers = "";
            for (Member member: members)
            {
                if (Analytics.isIdealBodyWeight(member, member.latestAssessment()))
                {
                    idealWeightMembers += member.toString() + "\n";
                }

                //boolean memberCurrentIdeal = Analytics.isIdealBodyWeight(member, assessment);

                //if (memberCurrentIdeal == true)
                //{
                //    String idealMember = "" + Member.toString();

                //}


                //idealWeightMembers += i + ": " + members.get(i) + "\n";
            }

            if (idealWeightMembers.equals(""))
            {
                return "There are currently no members in the gym with an ideal weight.";
            }
            else
            {
                return idealWeightMembers;
            }
        }
        else
        {
            return "There are no members in this gym.";
        }
    }

    /**
     * Returns a list of all the members in this gym,  who have a BMI category that fully or partially matches
     * the category searched by the trainer.
     * @param category The BMI category being checked.
     * @return a list of all members in this gym, who have a BMI category that fully or partiaully matches the
     * category searched by the trainer.
     */
    public String listMembersBySpecificBMICategory (String category)
    {
        //String containing all members details in the gym whose BMI category (based on latest assessment weight)
        // partially or entirely matches category. If no members, return message. If members, but no partial
        //or full match, return message.
        if (members.size() > 0){
            String listOfMembers = "";
            for (Member member: members){
                //?rba? member.getlatest assessment
                if (Analytics.determineBMICategory(Analytics.calculateBMI(member, member.latestAssessment())).toUpperCase().contains(category.toUpperCase())){
                    listOfMembers += member.toString() + "\n";
                }
            }
            if (listOfMembers.equals("")){
                return "There are no members in the gym in this BMI category";
            }
            return listOfMembers;
        }
        else{
            return "There are no members in the gym";
        }
    }

    /**
     * Returns a list of all member's details in both Imperial and Metric.
     * @return list of all member's details in both Imperial and Metric
     */
    public String listMemberDetailsImperialAndMetric()
    {
        if (members.size() > 0){
            String listOfMembers = "";
            for (Member member: members){
                listOfMembers += member.getName() + ":\t\t"
                        + member.getWeight() + " kg ("
                        + Analytics.convertWeightKGtoPounds(member.latestAssessment()) + " lbs)\t\t"
                        + member.getHeight() + " metres ("
                        + Analytics.convertHeightMetersToInches(member) + " inches)."
                        + "\n";
            }
            return listOfMembers;
        }
        else{
            return "There are no members in the gym.";
        }
    }

    /**
     * Load date for a gym.
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public void load () throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("gym.xml"));
        trainers = (ArrayList<Trainer>) is.readObject();
        members = (ArrayList<Member>) is.readObject();

        is.close();
    }

    /**
     * Saves data for the gym.
     * @throws Exception
     */
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("gym.xml"));
        out.writeObject(members);
        out.writeObject(trainers);
        out.close();
    }
}