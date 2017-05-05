package controllers;

import java.util.Date;
import java.util.Scanner;
import controllers.GymApi.*;
import models.*;
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
            addMember();

           // memberEmail = memEmail;
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

            addTrainer();
            runTrainerMenu();
        }


    }
/*
    //Going to try this another way, putting all in bottom of this class.
    private void addMember()
    {
        gym.addMember(readMemberDetails());
    }
*/


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
        System.out.println("Returning to main Member Menu");
        runMemberMenu();
    }

    private int progressSubMenu()
    {
        //TO DO:
        //View progress by weight, chest, thigh, upperArm, waist, hips.
        //This requires getting back something useable from member.sortedAssessmentDates and member.addAssessment!!
        System.out.println("\fMember Progress Menu");
        System.out.println("---------");
        System.out.println("  1) View weight progress");
        System.out.println("  2) View chest measurement progress");
        System.out.println("  3) View thigh measurement progress");
        System.out.println("  4) View upper arm measurement progress");
        System.out.println("  5) View waist measurement progress");
        System.out.println("  6) View hips measurement progress");
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
                case 1:    System.out.println("Weight progress");

                    break;
                case 2:    System.out.println("Chest progress");

                    break;
                case 3:    System.out.println("Thigh progress");

                    break;
                case 4:    System.out.println("Upper Arm progress");

                    break;
                case 5:    System.out.println("Waist progress");

                    break;
                case 6:    System.out.println("Hips progress");

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
        //TODO
        //can't do it this way, as trainer needs access to this same menu, and it must exit them back to previous menu,
        //not only member menu.
        System.out.println("Returning to main Member Menu");
        runMemberMenu();
    }

    private int trainerMenu()
    {
        System.out.println("\fTrainer Menu");
        System.out.println("---------");
        System.out.println("  1) Add a new member");
        System.out.println("  2) List all members");
        System.out.println("  3) Search for a member by e-mail");
        System.out.println("  4) Search for a member by name");
        System.out.println("  5) List members by ideal body weight");
        System.out.println("  6) List members by a specific BMI category");
        System.out.println("  7) Go to the assessment sub-menu");
        System.out.println("  8) Go to the reports sub-menu");
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
                case 1:     addMember();

                    break;
                case 2:     gym.listMembers();

                    break;
                case 3:     System.out.println("Please enter the e-mail of the member you want to search for.");
                            String emailSearch = input.nextLine();
                            gym.searchMembersByEmail(emailSearch);

                    break;
                case 4:     System.out.println("Please enter the name of the member you want to search for.");
                    String nameSearch = input.nextLine();
                    gym.searchMembersByName(nameSearch);

                    break;
                case 5:     //by ideal body weight
                    gym.listMembersWithIdealWeight();

                    break;
                case 6:     System.out.println("Please enter the specific BMI category you want to search for.");
                    String searchBMI = input.nextLine();
                    gym.listMembersBySpecificBMICategory (searchBMI);

                    break;
                case 7:     //call assessment sub-menu
                            runAssessmentMenu();

                    break;
                case 8:     //call reports sub-menu

                            runReportsMenu();

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

    private int assessmentMenu()
    {
        System.out.println("\fTrainer Menu");
        System.out.println("---------");
        System.out.println("  1) Add a new assessment for a member");
        System.out.println("  2) Update the comment on an assessment for a member");

        System.out.println("  0) Exit");
        System.out.println("==>> ");
        int option = input.nextInt();
        return option;
    }

    private void runAssessmentMenu()
    {
        int option = trainerMenu();
        while (option != 0){
            switch (option){
                case 1:     addNewAssessment();

                    break;

                case 2:     //Need the member, and assessment.
                    System.out.println("Please enter the name of the member of the assessment you want to update.");
                    String emailSearch = input.nextLine();
                    System.out.println("Please enter the new comment for the assessment you want to update.");
                    String newComment = input.nextLine();
                    gym.searchMembersByEmail(emailSearch).latestAssessment().setComment(newComment);

                    break;

                default:   System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine(); //2nd read for bug in Scanner; String read is ignored after reading int.
            //display the main menu again
            option = assessmentMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }


    private int reportsMenu()
    {
        System.out.println("\fTrainer Menu");
        System.out.println("---------");
        System.out.println("  1) View the progress of a specific member, by searching by member e-mail");
        System.out.println("  2) View the progress of a specific member, by searching by member name");
        System.out.println("  3) Overall members' report");

        System.out.println("  0) Exit");
        System.out.println("==>> ");
        int option = input.nextInt();
        return option;
    }

    private void runReportsMenu()
    {
        int option = trainerMenu();
        while (option != 0){
            switch (option){
                case 1:     System.out.println("this");
                //go to progress sub menu searching by email

                    break;
                case 2:     System.out.println("this");
                //go to progress sub menu searching by name

                    break;

                case 3:     System.out.println("this");
                    //send out ALL assessments from ALL members and return them all, sorted by member.

                    break;



                default:   System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine(); //2nd read for bug in Scanner; String read is ignored after reading int.
            //display the main menu again
            option = reportsMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }


    //===========================
    // HELPER / UTILITY METHODS
    //===========================



    private void addMember()
    {
        System.out.println("We need you to provide some details so that we can set up this account.");
        System.out.println("Please enter member name.");
        input.nextLine();
        String memName = input.nextLine();

        System.out.println("Please enter member e-mail address, making sure it has an '@' symbol.");
        String memEmail = input.nextLine();

        System.out.println("Please enter member address.");
        String memAddress = input.nextLine();

        System.out.println("Please enter member gender. Type 'M' for male, and 'F' for female.");
        //Possible that I need to do a char check here again. That means that gender should maybe be a char?
        //char memGender = input.next().charAt(0);
        String memGender = input.nextLine();

        System.out.println("Please enter member height, in meters. This means that a valid height is between 1.0 and 3.0 meters.");
        double memHeight = input.nextDouble();

        System.out.println("Please enter member current weight. This will be used as the starting weight, by which you can measure" +
                " progress. Starting weight should be in KG, and should be between 35 and 250.");
        double memWeight = input.nextDouble();

        System.out.println("Please state whether this is a Premium membership(P) or a Student membership(S)?");
        System.out.println("(P)remium or (S)tudent: ");
        char premiumOrStudent = input.next().charAt(0);

        //It may be that packages also need to be included here. Should I make them a part of the member,
        //or should they also be created and linked separately?
        if ((premiumOrStudent == 'S') || (premiumOrStudent == 's'))
        {
            System.out.println("Please enter name of College/University?");
            input.nextLine();
            String stuCampus = input.nextLine();
            System.out.println("Please enter student ID, as proof of student status: ");
            String stuID = input.nextLine();

            gym.addMember(new StudentMember(memName, memEmail, memAddress, memGender, memHeight,
                    memWeight, stuCampus, stuID));
            System.out.println("Thank you for registering, you will now be returned to the previous Menu.");
        }
        else if ((premiumOrStudent == 'P') || (premiumOrStudent == 'p'))
        {
            gym.addMember(new PremiumMember(memName, memEmail, memAddress, memGender, memHeight, memWeight));
            System.out.println("Thank you for registering, you will now be returned to the previous Menu.");
        }
        memberEmail = memEmail;

    }

    private void addTrainer()
    {
        System.out.println("We need you to provide some details so that we can set up your account.");
        System.out.println("Please enter your name.");
        input.nextLine();
        String trainName = input.nextLine();

        System.out.println("Please enter your e-mail address, making sure it has an '@' symbol.");
        String trainEmail = input.nextLine();

        System.out.println("Please enter your address.");
        String trainAddress = input.nextLine();

        System.out.println("Please enter your gender. Type 'M' for male, and 'F' for female.");
        //Possible that I need to do a char check here again. How to do that, if not in public Person(....)?
        String trainGender = input.nextLine();

        System.out.println("Please enter your speciality.");
        String trainSpeciality = input.nextLine();

        gym.addTrainer(new Trainer(trainName, trainEmail, trainAddress, trainGender, trainSpeciality));
        System.out.println("Thank you for registering, you will now be redirected to the Trainer Menu.");
        trainerEmail = trainEmail;
    }

    private void addNewAssessment()
    {
        System.out.println("Please enter the name of the member you want to make an assessment of.");
        String emailSearch = input.nextLine();

        System.out.println("Please enter the current weight of the member you are assessing.");
        double assessWeight = input.nextDouble();

        System.out.println("Please enter the current chest measurement of the member you are assessing.");
        double assessChest = input.nextDouble();

        System.out.println("Please enter the current thigh measurement of the member you are assessing.");
        double assessThigh = input.nextDouble();

        System.out.println("Please enter the current upper arm measurement of the member you are assessing.");
        double assessUpperArm = input.nextDouble();

        System.out.println("Please enter the current waist measurement of the member you are assessing.");
        double assessWaist = input.nextDouble();

        System.out.println("Please enter the current hips measurement of the member you are assessing.");
        double assessHips = input.nextDouble();

        System.out.println("What is your comment about this assessment on the member you are assessing?");
        String assessComment = input.nextLine();

        Assessment newAssessment = new Assessment(assessWeight, assessChest, assessThigh,
            assessUpperArm, assessWaist, assessHips, assessComment, gym.searchTrainersByEmail(trainerEmail));
        Date date = new Date();
        gym.searchMembersByEmail(emailSearch).addAssessment(date, newAssessment);

    }


    //Need to do code for chosenPackage here or in a new util. This is because you can have one package linked
    //with many members.
}
