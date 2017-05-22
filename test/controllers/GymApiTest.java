package controllers;

import models.Assessment;
import models.StudentMember;
import models.Trainer;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Robert Alexander on 22/05/2017.
 */
class GymApiTest {

    private GymApi gym;
    private StudentMember robert, tom, heatherlimit, overlimit, underlimit;
    private Assessment assess1, assess2;
    private Trainer trainer1;

    @org.junit.jupiter.api.Test

    public void test()
    {

        gym = new GymApi();

        robert = new StudentMember("Robert", "robert@gmail.com", "Live in a house",
                "M", 1.5, 72, "WIT", "c98h2ef9h", "WIT");

        tom = new StudentMember("This is tom the guy with the really long name to test character length",
                "tom@longname.com", "He could live anywhere, really", "m", 2.9,
                249.99, "WIT", "imastudent", "WIT");

        heatherlimit = new StudentMember("Heather isgoingtolimit 30 soon", "heather@heather",
                "house", "F", 3, 250, "WIT","stu", "AIT");

        overlimit = new StudentMember("Heather isgoingto limit 31 soon", "heather@mail",
                "house", "f", 3.01, 250.01, "WIT", "stu", "AIT");
        underlimit = new StudentMember("Heatherisgoingtolimit 29 soon", "heather@under",
                "house", "q", 0.99, 34.99, "WIT", "stude", "AIT");

        trainer1 = new Trainer("MrrT", "t@mail","there", "m", "pity");

        assess1 = new Assessment(91, 38, 34, 38, 39, 30, "Nice job", trainer1);
        assess2 = new Assessment(51, 34, 9, 34, 34, 98, "Not Nice job", trainer1);

        gym.addMember(robert);
        gym.addMember(tom);
        gym.addMember(heatherlimit);
        gym.addMember(overlimit);
        gym.addMember(underlimit);
        gym.addTrainer(trainer1);



        assertEquals(5, gym.numberOfMembers());
        assertEquals(1, gym.numberOfTrainers());
        assertEquals("[Name: Robert\n" +
                "E-mail: robert@gmail.com\n" +
                "Address: Live in a house\n" +
                "Gender: M\n" +
                "Height: 1.5m\n" +
                "Starting Weight: 72.0kg\n" +
                "Member Package: WIT\n" +
                "Student ID: c98h2ef9h\n" +
                "College Name: WIT, Name: This is tom the guy with the r\n" +
                "E-mail: tom@longname.com\n" +
                "Address: He could live anywhere, really\n" +
                "Gender: M\n" +
                "Height: 2.9m\n" +
                "Starting Weight: 249.99kg\n" +
                "Member Package: WIT\n" +
                "Student ID: imastudent\n" +
                "College Name: WIT, Name: Heather isgoingtolimit 30 soon\n" +
                "E-mail: heather@heather\n" +
                "Address: house\n" +
                "Gender: F\n" +
                "Height: 3.0m\n" +
                "Starting Weight: 250.0kg\n" +
                "Member Package: WIT\n" +
                "Student ID: stu\n" +
                "College Name: AIT, Name: Heather isgoingto limit 31 soo\n" +
                "E-mail: heather@mail\n" +
                "Address: house\n" +
                "Gender: F\n" +
                "Height: 0.0m\n" +
                "Starting Weight: 0.0kg\n" +
                "Member Package: WIT\n" +
                "Student ID: stu\n" +
                "College Name: AIT, Name: Heatherisgoingtolimit 29 soon\n" +
                "E-mail: heather@under\n" +
                "Address: house\n" +
                "Gender: Unspecified\n" +
                "Height: 0.0m\n" +
                "Starting Weight: 0.0kg\n" +
                "Member Package: WIT\n" +
                "Student ID: stude\n" +
                "College Name: AIT]", gym.getMembers().toString());
        assertEquals("[Name: MrrT\n" +
                "E-mail: t@mail\n" +
                "Address: there\n" +
                "Gender: M\n" +
                "Speciality: pity]", gym.getTrainers().toString());
        assertEquals(true, gym.isValidMemberIndex(0));
        assertEquals(true, gym.isValidMemberIndex(1));
        assertEquals(true, gym.isValidMemberIndex(4));
        assertEquals(false, gym.isValidMemberIndex(5));
        assertEquals(false, gym.isValidMemberIndex(-1));

        assertEquals(true, gym.isValidTrainerIndex(0));
        assertEquals(false, gym.isValidTrainerIndex(1));
        assertEquals(false, gym.isValidTrainerIndex(4));
        assertEquals(false, gym.isValidTrainerIndex(5));
        assertEquals(false, gym.isValidTrainerIndex(-1));

        assertEquals("robert@gmail.com", gym.searchMembersByEmail("robert@gmail.com").getEmail());
        assertEquals("heather@under", gym.searchMembersByEmail("heather@under").getEmail());
        assertEquals(null, gym.searchMembersByEmail("heaitig"));

        assertEquals("Robert\n", gym.searchMembersByName("robert"));
        assertEquals("Heather isgoingtolimit 30 soon\n" +
                "Heather isgoingto limit 31 soo\n" +
                "Heatherisgoingtolimit 29 soon\n", gym.searchMembersByName("Heather"));
        assertEquals("There are no members matching your search criteria.", gym.searchMembersByName("riddddt"));

        assertEquals("t@mail", gym.searchTrainersByEmail("t@mail").getEmail());
        assertEquals(null, gym.searchTrainersByEmail("MrT"));

        assertEquals("0: Name: Robert\n" +
                "E-mail: robert@gmail.com\n" +
                "Address: Live in a house\n" +
                "Gender: M\n" +
                "Height: 1.5m\n" +
                "Starting Weight: 72.0kg\n" +
                "Member Package: WIT\n" +
                "Student ID: c98h2ef9h\n" +
                "College Name: WIT\n" +
                "1: Name: This is tom the guy with the r\n" +
                "E-mail: tom@longname.com\n" +
                "Address: He could live anywhere, really\n" +
                "Gender: M\n" +
                "Height: 2.9m\n" +
                "Starting Weight: 249.99kg\n" +
                "Member Package: WIT\n" +
                "Student ID: imastudent\n" +
                "College Name: WIT\n" +
                "2: Name: Heather isgoingtolimit 30 soon\n" +
                "E-mail: heather@heather\n" +
                "Address: house\n" +
                "Gender: F\n" +
                "Height: 3.0m\n" +
                "Starting Weight: 250.0kg\n" +
                "Member Package: WIT\n" +
                "Student ID: stu\n" +
                "College Name: AIT\n" +
                "3: Name: Heather isgoingto limit 31 soo\n" +
                "E-mail: heather@mail\n" +
                "Address: house\n" +
                "Gender: F\n" +
                "Height: 0.0m\n" +
                "Starting Weight: 0.0kg\n" +
                "Member Package: WIT\n" +
                "Student ID: stu\n" +
                "College Name: AIT\n" +
                "4: Name: Heatherisgoingtolimit 29 soon\n" +
                "E-mail: heather@under\n" +
                "Address: house\n" +
                "Gender: Unspecified\n" +
                "Height: 0.0m\n" +
                "Starting Weight: 0.0kg\n" +
                "Member Package: WIT\n" +
                "Student ID: stude\n" +
                "College Name: AIT\n", gym.listMembers());

        //assertEquals("This doesn't work", gym.listMembersWithIdealWeight());

        //assertEquals("things", gym.listMembersBySpecificBMICategory("Obese"));



    }





}