package controllers;

import java.util.ArrayList;
import models.Member;
import models.Trainer;

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

    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;

    /**
     * Constructor for objects of class GymAPI
     * @param members There is no validation on the array list of members.
     * @param trainers There is no validation on the array list of trainers.
     */
  public GymApi (ArrayList<Member> members, ArrayList<Trainer> trainers)
  {
    members = new ArrayList<>();
    trainers = new ArrayList<>();
  }

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
}