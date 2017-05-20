package models;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Robert Alexander on 20/05/2017.
 */
class StudentMemberTest {
    @org.junit.jupiter.api.Test
    void studentMember() throws Exception{
        StudentMember robert = new StudentMember("Robert", "robert@gmail.com", "Live in a house",
                "M", 1.5, 72, "c98h2ef9h", "WIT");
        assertEquals("Robert", robert.getName());
        assertEquals("robert@gmail.com", robert.getEmail());
        assertEquals("Live in a house", robert.getAddress());
        assertEquals("M", robert.getGender());
        assertEquals(1.5, robert.getHeight());
        assertEquals(72, robert.getWeight());
        assertEquals("c98h2ef9h", robert.getStudentID());
        assertEquals("WIT", robert.getCollegeName());



        StudentMember tom = new StudentMember("This is tom the gym with the really long name to test character length",
                "tom@longname.com", "He could live anywhere, really", "M", 2.9,
                249, "imastudent", "WIT");

    }

}