package models;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Before;
//import org.junit.Test;
//import org.junit.After;
import java.util.*;

//import static org.junit.Assert.*;


/**
 * Created by Robert Alexander on 20/05/2017.
 */
public class TrainerTest {

    private StudentMember robert;

    private Trainer trainer1, trainer2;

    @org.junit.jupiter.api.Test

    public void test() {

        robert = new StudentMember("Robert", "robert@gmail.com", "Live in a house",
                "M", 1.5, 72, "WIT", "c98h2ef9h", "WIT");


        trainer1 = new Trainer("MrrT", "t@mail", "there", "m", "pity");
        trainer2 = new Trainer("MrsT", "Mrst@mail", "there", "f", "fool");

        assertEquals("Name: MrrT\nE-mail: t@mail\nAddress: there\nGender: M\nSpeciality: pity", trainer1.toString());
        assertEquals("Name: MrsT\nE-mail: Mrst@mail\nAddress: there\nGender: F\nSpeciality: fool", trainer2.toString());

    }
}
