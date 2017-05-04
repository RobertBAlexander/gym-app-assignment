package controllers;

import java.util.Scanner;
import controllers.GymApi.*;
import models.Member;
import models.PremiumMember;
import models.Trainer;
import utils.Analytics;

/**
 * Created by Robert Alexander on 29/04/2017.
 */
public class MenuController {

    private Scanner input;
    private GymApi gym;
    String memberEmail = new String();
    String trainerEmail = new String();

    public static void main (String[] args)
    {
        new MenuController();
    }

    public MenuController()
    {
        try
        {
            gym.load();
        }
        catch (Exception e)
        {
            System.err.println("Error reading from file: " + e);
        }
        loginMenu();
    }

    private void loginMenu()
    {
        input = new Scanner(System.in);

        System.out.println("\fAre you a member of a trainer?");
        System.out.println("---------");
        System.out.println("  Type 'M' for member, and 'T' for trainer.");
        char personChar = input.next().charAt(0);
        String personType = "" + personChar;
        while ((personType.toUpperCase().equals("M")) && (personType.toUpperCase().equals("T")))
        {
            System.out.println("Invalid input, please type 'M' for member, or 'T' for trainer and press enter.");
            personChar = input.next().charAt(0);
            personType = "" + personChar;

        }
        System.out.println("Are you a returning user, or do you want to set up a new account?");
        System.out.println("---------");
        System.out.println("Type 'L' to log in to an existing account, or 'R' to register a new one.");
        char loginChar = input.next().charAt(0);
        String loginType = "" + loginChar;
        while ((loginType.toUpperCase().equals("L")) && (loginType.toUpperCase().equals("R")))
        {
            System.out.println("Invalid input, please type 'L' to login to your account," +
                    " or 'R' to register a new one, then press enter.");
            loginChar = input.next().charAt(0);
            loginType = "" + loginChar;
        }
        if ((loginType.toUpperCase().equals("L")) && (personType.toUpperCase().equals("M")))
        {
            System.out.println("Please enter your e-mail address.");
            memberEmail = input.nextLine();
            //I am going through API, then immediate search, but it is possible to do another way?
            if (gym.searchMembersByEmail(memberEmail) == null)
            {
                System.out.println("Access Denied");
                System.out.println("Exiting the program...");
                System.exit(0);
            }
            else
            {
                System.out.println("You have successfully logged in, " + gym.searchMembersByEmail(memberEmail) + ".");
                runMemberMenu();
            }
        }
        if ((loginType.toUpperCase().equals("R")) && (personType.toUpperCase().equals("M")))
        {
            System.out.println("We need you to provide some details so that we can set up your account.");
            System.out.println("Please enter your name.");
            String memName = input.nextLine();
            System.out.println("Please enter your e-mail address, making sure it has an '@' symbol.");
            String memEmail = input.nextLine();
            System.out.println("Please enter your address.");
            String memAddress = input.nextLine();
            System.out.println("Please enter your gender. Type 'M' for male, and 'F' for female.");
            //Possible that I need to do a char check here again. How to do that, if not in public Person(....)?
            String memGender = input.nextLine();
            System.out.println("Please enter your height, in meters. This means that a valid height is between 1.0 and 3.0 meters.");
            int memHeight = input.nextInt();
            System.out.println("Please enter your current weight. This will be used as your starting weight, by which you can measure" +
                    "your progress. Your starting weight should be in KG, and should be between 35 and 250.");
            int memWeight = input.nextInt();
            System.out.println("Are you are premium member");
            gym.addMember(new PremiumMember(memName, memEmail, memAddress, memGender, memHeight, memWeight));
            System.out.println("Thank you for registering, you will now be redirected to the member Menu.");

            memberEmail = memEmail;
            runMemberMenu();
        }

        if ((loginType.toUpperCase().equals("L")) && (personType.toUpperCase().equals("T")))
        {
            System.out.println("Please enter your e-mail address.");
            trainerEmail = input.nextLine();
            if (gym.searchTrainersByEmail(trainerEmail) == null)
            {
                System.out.println("Access Denied");
                System.out.println("Exiting the program...");
                System.exit(0);
            }
            else
            {
                System.out.println("You have successfully logged in, " + gym.searchTrainersByEmail(trainerEmail) + ".");
                runTrainerMenu();
            }
        }
        if ((loginType.toUpperCase().equals("R")) && (personType.toUpperCase().equals("T")))
        {
            System.out.println("We need you to provide some details so that we can set up your account.");
            System.out.println("Please enter your name.");
            String trainName = input.nextLine();
            System.out.println("Please enter your e-mail address, making sure it has an '@' symbol.");
            String trainEmail = input.nextLine();
            System.out.println("Please enter your address.");
            String trainAddress = input.nextLine();
            System.out.println("Please enter your gender. Type 'M' for male, and 'F' for female.");
            //Possible that I need to do a char check here again. How to do that, if not in public Person(....)?
            String trainGender = input.nextLine();
            System.out.println("Please enter your speiality.");
            String trainSpeciality = input.nextLine();
            gym.addTrainer(new Trainer(trainName, trainEmail, trainAddress, trainGender, trainSpeciality));
            System.out.println("Thank you for registering, you will now be redirected to the member Menu.");
            trainerEmail = trainEmail;
            runTrainerMenu();
        }


    }



    private int memberMenu()
    {
        System.out.println("\fMember Menu");
        System.out.println("---------");
        System.out.println("  1) View your profile");
        System.out.println("  2) Update your profile");
        System.out.println("  3) Go to progress sub-menu");
        System.out.println("  0) Exit");
        System.out.println("==>> ");
        int option = input.nextInt();
        return option;
    }
    /*
     * This is the method that controls the loop.
     */
    private void runMemberMenu(){
        int option = memberMenu();
        while (option != 0){
            switch (option){
                case 1:    gym.searchMembersByEmail(trainerEmail).toString();
                    break;
                case 2:    runMemberProfileMenu();
                    break;
                case 3:    runProgressSubMenu();
                    break;
                default:   System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine(); //2nd read for bug in Scanner; String read is ignored after reading int.
            //display the main menu again
            option = memberMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    private int memberProfileMenu()
    {
        System.out.println("\fMember Profile Menu");
        System.out.println("---------");
        System.out.println("Your current profile is:" + gym.searchMembersByEmail(memberEmail).toString());
        System.out.println("  1) Update Name");
        System.out.println("  2) Update e-mail address");
        System.out.println("  3) Update address");
        System.out.println("  4) Update gender");
        System.out.println("  5) Update height");
        System.out.println("  6) Update starting weight");
        System.out.println("  0) Exit to Member main menu");
        System.out.println("==>> ");
        int option = input.nextInt();
        return option;
    }
    /*
     * This is the method that controls the loop.
     */
    private void runMemberProfileMenu(){
        int option = memberProfileMenu();
        while (option != 0){
            switch (option){
                case 1:    System.out.println("Please enter your new name.");
                    String newName = input.nextLine();
                    gym.searchMembersByEmail(memberEmail).setName(newName);
                    break;
                case 2:    System.out.println("Please enter your new e-mail address.");
                    String newEmail = input.nextLine();
                    gym.searchMembersByEmail(memberEmail).setName(newEmail);
                    break;
                case 3:    System.out.println("Please enter your new address.");
                    String newAddress = input.nextLine();
                    gym.searchMembersByEmail(memberEmail).setName(newAddress);
                    break;
                case 4:    System.out.println("Please enter your new gender.");
                    String newGender = input.nextLine();
                    String newGen = new String();
                    if (newGender.length() <= 1)
                    {
                        newGen = newGender;
                    }
                    else
                    {
                        newGen = newGender.substring(0, 1);
                    }
                    gym.searchMembersByEmail(memberEmail).setGender(newGen);
                    break;
                case 5:    System.out.println("Please enter your new height.");
                    int newHeight = input.nextInt();
                    gym.searchMembersByEmail(memberEmail).setHeight(newHeight);
                    break;

                default:   System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine(); //2nd read for bug in Scanner; String read is ignored after reading int.
            //display the main menu again
            option = memberProfileMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    private int progressSubMenu()
    {
        //TO DO:
        //View progress by weight, chest, thigh, upperArm, waist, hips.
        //This requires getting back something useable from member.sortedAssessmentDates and member.addAssessment!!
        System.out.println("\fMember Progress Menu");
        System.out.println("---------");
        System.out.println("  1) Update Name");
        System.out.println("  2) Update e-mail address");
        System.out.println("  3) Update address");
        System.out.println("  4) Update gender");
        System.out.println("  5) Update height");
        System.out.println("  6) Update starting weight");
        System.out.println("  0) Exit to Member main menu");
        System.out.println("==>> ");
        int option = input.nextInt();
        return option;
    }

    private void runProgressSubMenu(){
        int option = progressSubMenu();
        while (option != 0){
            //TO DO:
            //View progress by weight, chest, thigh, upperArm, waist, hips.
            //This requires getting back something useable from member.sortedAssessmentDates and member.addAssessment!!
            switch (option){
                case 1:    System.out.println("Please enter your new name.");
                    //gym.searchMembersByEmail(memberEmail).setName() = input.nextLine();
                    break;
                case 2:    System.out.println("Please enter your new e-mail address.");
                    //Member.setEmail() = input.nextLine();
                    break;
                case 3:    System.out.println("Please enter your new address.");
                    //Member.setAddress() = input.nextLine();
                    break;
                case 4:    System.out.println("Please enter your new gender.");
                   // Member.setGender() = input.nextLine();
                    break;
                case 5:    System.out.println("Please enter your new height.");
                    //Member.setHeight() = input.nextInt();
                    break;
                case 6:    System.out.println("Please enter your new gender.");
                    //Member.setStartingWeight() = input.nextInt();
                    break;

                default:   System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine(); //2nd read for bug in Scanner; String read is ignored after reading int.
            //display the main menu again
            option = progressSubMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    private int trainerMenu()
    {
        System.out.println("\fMember Menu");
        System.out.println("---------");
        System.out.println("  1) View your profile");
        System.out.println("  2) Update your profile");
        System.out.println("  3) Go to progress sub-menu");
        System.out.println("  0) Exit");
        System.out.println("==>> ");
        int option = input.nextInt();
        return option;
    }
    /*
     * This is the method that controls the loop.
     */
    private void runTrainerMenu(){
        int option = trainerMenu();
        while (option != 0){
            switch (option){
                case 1:    gym.searchMembersByEmail(trainerEmail).toString();
                    break;
                case 2:    runMemberProfileMenu();
                    break;
                case 3:    runProgressSubMenu();
                    break;
                default:   System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine(); //2nd read for bug in Scanner; String read is ignored after reading int.
            //display the main menu again
            option = trainerMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }


}
