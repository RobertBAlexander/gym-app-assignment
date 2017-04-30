package controllers;

import java.util.ArrayList;
import models.Member;
import models.Trainer;

/**
 * Created by Robert Alexander on 29/04/2017.
 */
public class GymApi {

    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;

  public GymApi (ArrayList<Member> members, ArrayList<Trainer> trainers)
  {
    members = new ArrayList<>();
    trainers = new ArrayList<>();
  }

    public void addMember(Member member)
    {
        members.add(member);
    }

    public void addTrainer(Trainer trainer)
    {
        trainers.add(trainer);
    }

    public int numberOfMembers()
    {
        return members.size();
    }

    public int numberOfTrainers()
    {
        return trainers.size();
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }
}