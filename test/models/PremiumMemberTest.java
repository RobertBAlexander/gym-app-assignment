package models;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Before;
//import org.junit.Test;
//import org.junit.After;
import java.util.*;

/**
 * Created by Robert Alexander on 22/05/2017.
 */
    public class PremiumMemberTest {


        private PremiumMember robert, tom, heatherlimit, overlimit, underlimit;
        private Assessment assess1, assess2;
        private Trainer trainer1;

        @org.junit.jupiter.api.Test

        public void test()
        {

            robert = new PremiumMember("Robert", "robert@gmail.com", "Live in a house",
                    "M", 1.5, 72,"WIT");

            tom = new PremiumMember("This is tom the guy with the really long name to test character length",
                    "tom@longname.com", "He could live anywhere, really", "m", 2.9,
                    249.99,  "Package 1");

            heatherlimit = new PremiumMember("Heather isgoingtolimit 30 soon", "heather@heather",
                    "house", "F", 3, 250, "Package 2");

            overlimit = new PremiumMember("Heather isgoingto limit 31 soon", "heather@mail",
                    "house", "f", 3.01, 250.01, "Package 3");
            underlimit = new PremiumMember("Heatherisgoingtolimit 29 soon", "heather@under",
                    "house", "q", 0.99, 34.99, "Package 2");

            trainer1 = new Trainer("MrrT", "t@mail","there", "m", "pity");

            assertEquals("Robert", robert.getName());
            assertEquals("robert@gmail.com", robert.getEmail());
            assertEquals("Live in a house", robert.getAddress());
            assertEquals("M", robert.getGender());
            assertEquals(1.5, robert.getHeight());
            assertEquals(72, robert.getWeight());
            assertEquals("Name: Robert\nE-mail: robert@gmail.com\nAddress: Live in a house\nGender: M\nHeight: " +
                    "1.5m\nStarting Weight: 72.0kg\nMember Package: WIT", robert.toString());
            assertEquals("Name: This is tom the guy with the r\nE-mail: tom@longname.com\nAddress: He could live anywhere, really" +
                    "\nGender: M\nHeight: 2.9m\nStarting Weight: 249.99kg\nMember Package: Package 1", tom.toString());
            assertEquals("Name: Heather isgoingtolimit 30 soon\nE-mail: heather@heather\nAddress: house" +
                    "\nGender: F\nHeight: 3.0m\nStarting Weight: 250.0kg\nMember Package: Package 2", heatherlimit.toString());
            assertEquals("Name: Heather isgoingto limit 31 soo\nE-mail: heather@mail\nAddress: house" +
                    "\nGender: F\nHeight: 0.0m\nStarting Weight: 0.0kg\nMember Package: Package 3", overlimit.toString());
            assertEquals("Name: Heatherisgoingtolimit 29 soon\nE-mail: heather@under\nAddress: house" +
                    "\nGender: Unspecified\nHeight: 0.0m\nStarting Weight: 0.0kg\nMember Package: Package 2", underlimit.toString());

        }
}