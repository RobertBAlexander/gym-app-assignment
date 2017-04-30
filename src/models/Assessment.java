package models;

/**
 * Created by Robert Alexander on 30/04/2017.
 */
public class Assessment {
    public double weight;
    public double chest;
    public double thigh;
    public double upperArm;
    public double waist;
    public double hips;
    public String comment;
    public Trainer trainer;

    //below is sample of how to do above.
    public Assessment( double weight, double chest, double thigh, double upperArm, double waist,
                       double hips, String comment, Trainer trainer) {
        this.weight = weight;
        this.chest = chest;
        this.thigh = thigh;
        this.upperArm = upperArm;
        this.waist = waist;
        this.hips = hips;
        this.comment = comment;
        this.trainer = trainer;
    }
}
