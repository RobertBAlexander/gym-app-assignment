package models;



/**
 * This class is the template for a single Assessment.
 *
 * The details stored for an Assessment include:
 *      weigth
 *      chest
 *      thigh
 *      upperArm
 *      waist
 *      hips
 *      comment
 *      trainer
 *
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


    /**
     * Constructor for objects of class Assessment.
     * @param weight There is no validation on the Assessment's weight.
     * @param chest There is no validation on the Assessment's chest.
     * @param thigh There is no validation on the Assessment's thigh.
     * @param upperArm There is no validation on the Assessment's upperArm.
     * @param waist There is no validation on the Assessment's waist.
     * @param hips There is no validation on the Assessment's hips.
     * @param comment There is no validation on the Assessment's comment.
     * @param trainer There is no validation on the Assessment's trainer.
     */
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

    //********************************************************************************
    //  SETTERS
    //********************************************************************************

    /**
     * Updates the assessment weight field. The Member's weight, as measured during this assessment.
     * @param weight There is no validation on the assessment weight.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Updates the assessment chest field. The Member's chest, as measured during this assessment.
     * @param chest There is no validation on the assessment chest.
     */
    public void setChest(double chest) {
        this.chest = chest;
    }

    /**
     * Updates the assessment thigh field. The Member's thigh, as measured during this assessment.
     * @param thigh There is no validation on the assessment thigh.
     */
    public void setThigh(double thigh) {
        this.thigh = thigh;
    }

    /**
     * Updates the assessment upperArm field. The Member's upperArm, as measured during this assessment.
     * @param upperArm There is no validation on the assessment upperArm.
     */
    public void setUpperArm(double upperArm) {
        this.upperArm = upperArm;
    }

    /**
     * Updates the assessment waist field. The Member's waist, as measured during this assessment.
     * @param waist There is no validation on the assessment waist.
     */
    public void setWaist(double waist) {
        this.waist = waist;
    }

    /**
     * Updates the assessment hips field. The Member's hips, as measured during this assessment.
     * @param hips There is no validation on the assessment hips.
     */
    public void setHips(double hips) {
        this.hips = hips;
    }

    /**
     * Updates the assessment comment field. The comment left by the Trainer about this Member,
     * written for this assessment.
     * @param comment There is no validation on the assessment comment.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Updates the assessment trainer field. The Member's person trainer.
     * @param trainer There is no validation on the assessment trainer.
     */
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    //********************************************************************************
    //  GETTERS
    //********************************************************************************

    /**
     * Returns the Assessment weight.
     * @return the assessment weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the assessment chest measurement.
     * @returnthe assessment chest measurement.
     */
    public double getChest() {
        return chest;
    }

    /**
     * Returns the assessment thigh measurement.
     * @return the assessment thigh measurement.
     */
    public double getThigh() {
        return thigh;
    }

    /**
     * Returns the assessment upperArm measurement.
     * @return the assessment upperArm measurement.
     */
    public double getUpperArm() {
        return upperArm;
    }

    /**
     * Returns the assessment waist measurement.
     * @return the assessment waist measurement.
     */
    public double getWaist() {
        return waist;
    }

    /**
     * Returns the assessment hips measurement.
     * @return the assessment hips measurement.
     */
    public double getHips() {
        return hips;
    }

    /**
     * Returns the assessment comment from trainer.
     * @return the assessment comment from trainer.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Returns the trainer who made assessment.
     * @return the trainer who made assessment.
     */
    public Trainer getTrainer() {
        return trainer;
    }

    /**
     * Returns a human-readable String representation of the object state.
     *
     * @return a string version of the Assessment object. The String returned
     * is similar to this structure:
     *
     * !!! Have not finalised structure!!!
     */
    @Override
    public String toString() {
        return "Assessment\n" +
                "weight=" + weight +
                ",\n chest=" + chest +
                ",\n thigh=" + thigh +
                ",\n upperArm=" + upperArm +
                ",\n waist=" + waist +
                ",\n hips=" + hips +
                ",\n comment='" + comment + '\'' +
                ",\n trainer=" + trainer.getName();
    }
}
