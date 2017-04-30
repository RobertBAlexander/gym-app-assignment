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

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public void setThigh(double thigh) {
        this.thigh = thigh;
    }

    public void setUpperArm(double upperArm) {
        this.upperArm = upperArm;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public void setHips(double hips) {
        this.hips = hips;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public double getWeight() {
        return weight;
    }

    public double getChest() {
        return chest;
    }

    public double getThigh() {
        return thigh;
    }

    public double getUpperArm() {
        return upperArm;
    }

    public double getWaist() {
        return waist;
    }

    public double getHips() {
        return hips;
    }

    public String getComment() {
        return comment;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "weight=" + weight +
                ", chest=" + chest +
                ", thigh=" + thigh +
                ", upperArm=" + upperArm +
                ", waist=" + waist +
                ", hips=" + hips +
                ", comment='" + comment + '\'' +
                ", trainer=" + trainer +
                '}';
    }
}
