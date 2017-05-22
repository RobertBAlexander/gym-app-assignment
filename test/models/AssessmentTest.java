package models;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Robert Alexander on 22/05/2017.
 */
class AssessmentTest {

    private StudentMember robert, tom, heatherlimit, overlimit, underlimit;
    private Assessment assess1, assess2;
    private Trainer trainer1;

    @org.junit.jupiter.api.Test
    public void test()
    {
        robert = new StudentMember("Robert", "robert@gmail.com", "Live in a house",
                "M", 1.5, 72, "WIT", "c98h2ef9h", "WIT");

        trainer1 = new Trainer("MrrT", "t@mail","there", "m", "pity");

        assess1 = new Assessment(91, 38, 34, 38, 39, 30, "Nice job", trainer1);
        assess2 = new Assessment(51, 34, 9, 34, 34, 98, "Not Nice job", trainer1);

        assertEquals("Assessment\n" +
                "weight=" + 91.0 +
                ",\n chest=" + 38.0 +
                ",\n thigh=" + 34.0 +
                ",\n upperArm=" + 38.0 +
                ",\n waist=" + 39.0 +
                ",\n hips=" + 30.0 +
                ",\n comment='" + "Nice job" + '\'' +
                ",\n trainer=" + trainer1.getName(), assess1.toString());

        assertEquals("Assessment\n" +
                "weight=" + 51.0 +
                ",\n chest=" + 34.0 +
                ",\n thigh=" + 9.0 +
                ",\n upperArm=" + 34.0 +
                ",\n waist=" + 34.0 +
                ",\n hips=" + 98.0 +
                ",\n comment='" + "Not Nice job" + '\'' +
                ",\n trainer=" + trainer1.getName(), assess2.toString());
    }

}