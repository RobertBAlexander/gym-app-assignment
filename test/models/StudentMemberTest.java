package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Created by Robert Alexander on 20/05/2017.
 */
public class StudentMemberTest {

    private StudentMember robert, tom, heatherlimit, overlimit, underlimit;

    @org.junit.jupiter.api.Test

    public void test()
    {

        robert = new StudentMember("Robert", "robert@gmail.com", "Live in a house",
                "M", 1.5, 72, "c98h2ef9h", "WIT");

        tom = new StudentMember("This is tom the guy with the really long name to test character length",
                "tom@longname.com", "He could live anywhere, really", "m", 2.9,
                249.99, "imastudent", "WIT");

        heatherlimit = new StudentMember("Heather isgoingtolimit 30 soon", "heather@heather",
                "house", "F", 3, 250, "stu", "AIT");

        overlimit = new StudentMember("Heather isgoingto limit 31 soon", "heather@mail",
                "house", "f", 3.01, 250.01, "stu", "AIT");
        underlimit = new StudentMember("Heatherisgoingtolimit 29 soon", "heather@under",
                "house", "q", 0.99, 34.99, "stude", "AIT");

        assertEquals("Robert", robert.getName());
        assertEquals("robert@gmail.com", robert.getEmail());
        assertEquals("Live in a house", robert.getAddress());
        assertEquals("M", robert.getGender());
        assertEquals(1.5, robert.getHeight());
        assertEquals(72, robert.getWeight());
        assertEquals("c98h2ef9h", robert.getStudentID());
        assertEquals("WIT", robert.getCollegeName());
        assertEquals("Name: Robert\nE-mail: robert@gmail.com\nAddress: Live in a house\nGender: M\nHeight: " +
                "1.5m\nStarting Weight: 72.0kg\nStudent ID: c98h2ef9h\nCollege Name: WIT", robert.toString());
        assertEquals("Name: This is tom the guy with the r\nE-mail: tom@longname.com\nAddress: He could live anywhere, really" +
                "\nGender: M\nHeight: 2.9m\nStarting Weight: 249.99kg\nStudent ID: imastudent\nCollege Name: WIT", tom.toString());
        assertEquals("Name: Heather isgoingtolimit 30 soon\nE-mail: heather@heather\nAddress: house" +
                "\nGender: F\nHeight: 3.0m\nStarting Weight: 250.0kg\nStudent ID: stu\nCollege Name: AIT", heatherlimit.toString());
        assertEquals("Name: Heather isgoingto limit 31 soo\nE-mail: heather@mail\nAddress: house" +
                "\nGender: F\nHeight: 0.0m\nStarting Weight: 0.0kg\nStudent ID: stu\nCollege Name: AIT", overlimit.toString());
        assertEquals("Name: Heatherisgoingtolimit 29 soon\nE-mail: heather@under\nAddress: house" +
                "\nGender: Unspecified\nHeight: 0.0m\nStarting Weight: 0.0kg\nStudent ID: stude\nCollege Name: AIT", underlimit.toString());
    }

  /*  @Test
    public void robTests()
    {
        tom = new StudentMember("Robert", "robert@gmail.com", "Live in a house",
                "M", 1.5, 72, "c98h2ef9h", "WIT");
        tom.setName("rob");
        tom.setEmail("rob@mail.com");
        tom.setAddress("This House");
        tom.setGender("f");
        tom.setHeight(2.9);
        tom.setStartingWeight(68.41);
        tom.setStudentID("w87.gwffeq");
        tom.setCollegeName("ABER");
        assertEquals("Name: Robert\nE-mail: robert@gmail.com\nAddress: Live in a house\nGender: M\nHeight: " +
                "1.5m\nWeight: 72.0kg\nStudent ID: c98h2ef9h\nCollege Name: WIT", robert.toString());
    }

*/


   /* public void setUp() throws Exception{
        robert = new StudentMember("Robert", "robert@gmail.com", "Live in a house",
                "M", 1.5, 72, "c98h2ef9h", "WIT");
        tom = new StudentMember("This is tom the guy with the really long name to test character length",
                "tom@longname.com", "He could live anywhere, really", "M", 2.9,
                249.99, "imastudent", "WIT");





        //StudentMember

    }



    public void testConstructors()
    {
        assertEquals("Robert", robert.getName());
        assertEquals("robert@gmail.com", robert.getEmail());
        assertEquals("Live in a house", robert.getAddress());
        assertEquals("M", robert.getGender());
        assertEquals(1.5, robert.getHeight());
        assertEquals(72, robert.getWeight());
        assertEquals("c98h2ef9h", robert.getStudentID());
        assertEquals("WIT", robert.getCollegeName());
        assertEquals("Name: Robert\nE-mail: robert@gmail.com\nAddress: Live in a house\nGender: M\nHeight: " +
                "1.5m\nWeight: 72.0kg\nStudent ID: c98h2ef9h\nCollege Name: WIT", robert.toString());
        robert.setName("rob");
        robert.setEmail("rob@mail.com");
        robert.setAddress("This House");
        robert.setGender("f");
        robert.setHeight(2.9);
        robert.setStartingWeight(68.41);
        robert.setStudentID("w87.gwffeq");
        robert.setCollegeName("ABER");
        assertEquals("Name: Robert\nE-mail: robert@gmail.com\nAddress: Live in a house\nGender: M\nHeight: " +
                "1.5m\nWeight: 72.0kg\nStudent ID: c98h2ef9h\nCollege Name: WIT", robert.toString());

        assertEquals("Name: This is tom the guy with the r\nE-mail: tom@longname.com\nAddress: He could live anywhere, really" +
                "\nGender: M\nHeight: 2.9m\nWeight: 249.99kg\nStudent ID: imastudent\nCollege Name: WIT", tom.toString());
        tom.setName("tom the guy with the re");
        tom.setEmail("tomishere");
        tom.setAddress("here");
        tom.setGender("female");
        tom.setHeight(3.1);
        tom.setStartingWeight(250.01);
        assertEquals("Name: This is tom the guy with the r\nE-mail: tom@longname.com\nAddress: herfgwrgwr" +
                "\nGender: Unspecified\nHeight: 0.0m\nWeight: 0.0kg\nStudent ID: imastudent\nCollege Name: WIT", tom.toString());
    }

    public void tearDown()
    {
    }*/

}