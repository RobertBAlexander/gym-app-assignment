package models;

/**
 * Created by Robert Alexander on 29/04/2017.
 */
public class Trainer extends Person{
    private String speciality;

    public Trainer( String name, String email, String address, String gender, String speciality) {
        super(name, email, address, gender);
        this.speciality = speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }



    @Override
    public String toString() {
        String str = "";
        str += (super.toString() + "\n");
        str += (speciality + "\n");

        return str;
    }
}
