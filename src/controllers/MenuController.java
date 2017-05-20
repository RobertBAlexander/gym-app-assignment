package controllers;

import java.util.Date;
import java.util.Scanner;
import controllers.GymApi.*;
import models.*;
import utils.Analytics;

import static utils.ScannerInput.validNextDouble;
import static utils.ScannerInput.validNextInt;

/**
 * This class runs the application and handles the GymApi with it's Members and Trainers.
 *
 * Created by Robert Alexander on 29/04/2017.
 */
public class MenuController {

    private Scanner input;
    private GymApi gym;
    private String memberEmail;
    private String trainerEmail;
    private boolean userIsMember = false;

    public static void main (String[] args)
    {
        new MenuController();
    }

    public MenuController()
    {
        //Immediately try to load any pre-existing gym file.
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

    /**
     * loginMenu() - This method displays the first menu that any user will encounter. It checks
     * if user is already a member or trainer, and if not it calls addMember() or addTrainer() to register them.
     * Once the user has created or logged in to their account, the user is sent to the appropriate menu.
     */
    private void loginMenu()
    {
        input = new Scanner(System.in);

        System.out.println("\fAre you a member of a trainer?");
        System.out.println("---------");
        System.out.println("  Type 'M' for member, and 'T' for trainer.");
        char personChar = input.next().charAt(0);
        String personType = "" + personChar;
        while ((!personType.toUpperCase().equals("M")) && (!personType.toUpperCase().equals("T")))
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
        while ((!loginType.toUpperCase().equals("L")) && (!loginType.toUpperCase().equals("R")))
        {
            System.out.println("Invalid input, please type 'L' to login to your account," +
                    " or 'R' to register a new one, then press enter.");
            loginChar = input.next().charAt(0);
            loginType = "" + loginChar;
        }
        if ((loginType.toUpperCase().equals("L")) && (personType.toUpperCase().equals("M")))
        {
            userIsMember = true;
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
            userIsMember = true;
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


    /**
     * memberMenu() - The menu users are sent to once their account is confirmed. This method displays
     * the member's menu choices for the application, reads the menu option that the member entered
     * and returns it.
     *
     * @return      the member's menu choice
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
        int option = validNextInt("==>> ");
        return option;
    }
    /**
     * This is the method that controls the member menu loop.
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
            //2nd read for bug in Scanner; String read is ignored after reading int.
            input.nextLine();
            //display the member menu again
            option = memberMenu();
        }
        //the user chose option 0, so exit the program

        //Immediately try to save any current gym data, then exit program.
        try
        {
            gym.save();
           }
        catch (Exception e)
        {
            System.err.println("Error reading from file: " + e);
        }

        System.out.println("Exiting... bye");
        System.exit(0);
    }

    /**
     * memberProfileMenu() - This method displays the member profile sub-menu, which allows members to
     * view and update their member details. This menu reads the menu option that the member entered and returns it.
     *
     * @return      the members menu choice
     */
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
        int option = validNextInt("==>> ");
        return option;
    }
    /**
     * This is the method that controls the member profile menu loop.
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
                    String newGen;
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
            //2nd read for bug in Scanner; String read is ignored after reading int.
            input.nextLine();
            //display the member profile menu again
            option = memberProfileMenu();
        }
        //the user chose option 0, so exits to the main Member Menu
        System.out.println("Returning to main Member Menu");
        runMemberMenu();
    }

    /**
     * progressSubMenu - This method displays the member progress sub-menu for the application,
     * reads the menu option that the user entered and returns it.
     *
     * @return      the users menu choice
     */
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
        //This needs to return trainer to trainer menu, and member to member menu!
        //must check user type, and code appropriately!
        System.out.println("  0) Exit to main menu");
        System.out.println("==>> ");
        int option = validNextInt("==>> ");
        return option;
    }

    /**
     * This is the method that controls the progress sub-menu loop.
     */
    private void runProgressSubMenu(){
        int option = progressSubMenu();
        while (option != 0){
            //TO DO:
            //View progress by weight, chest, thigh, upperArm, waist, hips.
            //This requires getting back something useable from member.sortedAssessmentDates and member.addAssessment!!
            switch (option){
                case 1:    System.out.println("Weight progress: ");
                    gym.searchMembersByEmail(memberEmail).chestAssessment();

                    //gym.searchMembersByEmail(memberEmail).sortedAssessmentDates().last();


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
        //Below sends member users back to the member menu when they exit, and trainer users back to
        // trainer menu when they exit.
        System.out.println("Returning to Main Menu");
        if ( !userIsMember)
        {
            runTrainerMenu();
        }
        else
        {
            runMemberMenu();
        }
    }

    /**
     * trainerMenu - The menu trainers are sent to once their account is confirmed. This method displays
     * the trainer's menu choices for the application, reads the menu option that the trainer entered
     * and returns it.
     *
     * @return the trainers menu choice
     */
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
        int option = validNextInt("==>> ");
        return option;
    }
    /**
     * This is the method that controls the trainer menu loop.
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
            //2nd read for bug in Scanner; String read is ignored after reading int.
            input.nextLine(); //2nd read for bug in Scanner; String read is ignored after reading int.
            //display the trainer menu again
            option = trainerMenu();
        }
        //the user chose option 0, so exit the program
        //Immediately try to save any current gym data, then exit program.
        try
        {
            gym.save();
        }
        catch (Exception e)
        {
            System.err.println("Error reading from file: " + e);
        }

        System.out.println("Exiting... bye");
        System.exit(0);
    }

    /**
     * assessmentMenu - The menu trainers are sent to when they want to add an assessment to a member. This method displays
     * the trainer's menu choices relating to member assessments, reads the menu option that the trainer entered
     * and returns it.
     *
     * @return the trainers menu choice
     */
    private int assessmentMenu()
    {
        System.out.println("\fTrainer's Assessment Menu");
        System.out.println("---------");
        System.out.println("  1) Add a new assessment for a member");
        System.out.println("  2) Update the comment on an assessment for a member");
        System.out.println("  0) Exit to main menu");
        System.out.println("==>> ");
        int option = validNextInt("==>> ");
        return option;
    }

    /**
     * This is the method that controls the assessment menu loop.
     */
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
        //the user chose option 0, so exit to trainer main menu
        System.out.println("Returning to main menu");
        runTrainerMenu();
    }


    /**
     * reportsMenu - This is the menu that trainers are sent to when they want to view the status reports of
     * members.This method displays the trainer's menu choices relating to member progress reports,
     *  reads the menu option that the trainer entered and returns it.
     *
     *
     * @return the trainers menu choice
     */
    private int reportsMenu()
    {
        System.out.println("\fProgress Report Menu");
        System.out.println("---------");
        System.out.println("  1) View the progress of a specific member, by searching by member e-mail");
        System.out.println("  2) View the progress of a specific member, by searching by member name");
        System.out.println("  3) Overall members' report");
        System.out.println("  0) Exit to main menu");
        System.out.println("==>> ");
        int option = validNextInt("==>> ");
        return option;
    }

    /**
     * This is the method that controls the reports menu loop.
     */
    private void runReportsMenu()
    {
        int option = trainerMenu();
        while (option != 0){
            switch (option){
                case 1:     System.out.println("Please enter the e-mail of the user you wish you check the progress of: ");
                String emailSearch = input.nextLine();
                if (gym.searchMembersByEmail(emailSearch) != null)
                {
                    memberEmail = emailSearch;
                    runProgressSubMenu();
                }
                else
                {
                    System.out.println("Invalid e-mail entered. Please try again, or search by name to see a list of" +
                            "possible member e-mail addresses.");
                }
                //TODO go to progress sub menu searching by email

                    break;
                case 2:     System.out.println("Please enter the name, or part of a name, of the member you are searching for");
                String nameSearch = input.nextLine();
                gym.searchMembersByName(nameSearch);
                //If that search returns no one by that name, it needs to check for that. This seems a bit mad really,
                    //just to avoid doing a proper search by name...?
                System.out.println("--------------------------------------------------");
                    System.out.println("Please review the  the e-mail address of the member you wish to check the progress of");
                //TODO go to progress sub menu searching by name

                    break;

                case 3:     System.out.println("this");
                    //TODO send out ALL assessments from ALL members and return them all, sorted by member.

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
        //the user chose option 0, so exit to trainer main menu
        System.out.println("Returning to main menu");
        runTrainerMenu();
    }


    //===========================
    // HELPER / UTILITY METHODS
    //===========================

    /**
     * Reads the member details from a user, and creates a new member from them.
     */
    private void addMember()
    {
        System.out.println("We need you to provide some details so that we can set up this account.");
        String memName = "";
        String memEmail = "";
        String memAddress = "";
        String memGender = "";
        double memHeight = 0;
        double memWeight = 0;
        char premiumOrStudent = 'n';
        String stuCampus = "";
        String stuID = "";

        while (memName == "") {
            System.out.println("Please enter member name.");
            input.nextLine();
            memName = input.nextLine();
        }

        while (memEmail == "") {
            //First check that it had an @, then check it does not already exist
            System.out.println("Please enter member e-mail address, making sure it has an '@' symbol, and is not in use" +
                    "by another member or trainer.");
            memEmail = input.nextLine();

            if (isValidEmail(memEmail))
            {

            }
            else
            {
                memEmail = "";
            }
            if (gym.searchMembersByEmail(memEmail) == null)
            {

            }
            else
            {
                //TODO Have this tell the user that this e-mail is already in use.
                memEmail = "";
            }
            if (gym.searchTrainersByEmail(memEmail) == null)
            {

            }
            else
            {
                //TODO Have this tell the user that this e-mail is already in use.
                memEmail = "";
            }

        }

        while ( memAddress == "") {
            System.out.println("Please enter member address.");
            memAddress = input.nextLine();
        }

        while ((memGender != "M") && (memGender != "F")) {
            System.out.println("Please enter member gender. Type 'M' for male, and 'F' for female.");
            //Possible that I need to do a char check here again. That means that gender should maybe be a char?
            //memGender = input.next().charAt(0);
            memGender = input.nextLine();
            memGender = memGender.toUpperCase();

        }

        while ((memHeight < 1) || (memHeight > 3)) {
            System.out.println("Please enter member height, in meters. This means that a valid height is between 1.0 and 3.0 meters.");
            memHeight = validNextDouble("==>> ");
        }

        while ((memWeight < 35) || (memWeight > 250)) {
            System.out.println("Please enter member current weight. This will be used as the starting weight, by which you can" +
            "measure progress. Starting weight should be in KG, and should be between 35 and 250.");
            memWeight = validNextDouble("==>> ");
        }

        while ((premiumOrStudent != 'P') && (premiumOrStudent != 'p') && (premiumOrStudent != 'S') && (premiumOrStudent != 's')) {
            System.out.println("Please state whether this is a Premium membership(P) or a Student membership(S)?");
            System.out.println("(P)remium or (S)tudent: ");
            premiumOrStudent = input.next().charAt(0);
        }

        //It may be that packages also need to be included here. Should I make them a part of the member,
        //or should they also be created and linked separately?
        if ((premiumOrStudent == 'S') || (premiumOrStudent == 's'))
        {
            while (stuCampus == "") {
                System.out.println("Please enter name of College/University?");
                input.nextLine();
                stuCampus = input.nextLine();
            }

            while (stuID == "") {
                System.out.println("Please enter student ID, as proof of student status: ");
                stuID = input.nextLine();
            }

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

    /**
     * Reads the trainer details from a user, and creates a new trainer from them.
     */
    private void addTrainer()
    {
        System.out.println("We need you to provide some details so that we can set up your account.");
        String trainName = "";
        String trainEmail = "";
        String trainAddress = "";
        String trainGender = "";
        String trainSpeciality = "";
        while (trainName == "") {
            System.out.println("Please enter your name. Names may be no more than 30 characters long.");
            input.nextLine();
            trainName = input.nextLine();
        }

        while (trainEmail == "") {
            System.out.println("Please enter trainer e-mail address, making sure it has an '@' symbol, and is not in use" +
                    "by another trainer or member.");
            trainEmail = input.nextLine();

            if (isValidEmail(trainEmail))
            {

            }
            else
            {
                trainEmail = "";
            }
            if (gym.searchMembersByEmail(trainEmail) == null)
            {

            }
            else
            {
                //TODO Have this tell the user that this e-mail is already in use.
                trainEmail = "";
            }
            if (gym.searchTrainersByEmail(trainEmail) == null)
            {

            }
            else
            {
                //TODO Have this tell the user that this e-mail is already in use.
                trainEmail = "";
            }
        }

        while (trainAddress == "") {
            System.out.println("Please enter your address.");
            trainAddress = input.nextLine();
        }

        while ((trainGender != "M") && (trainGender != "F")) {
            System.out.println("Please enter trainer gender. Type 'M' for male, and 'F' for female.");
            //Possible that I need to do a char check here again. That means that gender should maybe be a char?
            //memGender = input.next().charAt(0);
            trainGender = input.nextLine();
            trainGender = trainGender.toUpperCase();
        }

        while (trainSpeciality == "") {
            System.out.println("Please enter your speciality.");
            trainSpeciality = input.nextLine();
        }

        gym.addTrainer(new Trainer(trainName, trainEmail, trainAddress, trainGender, trainSpeciality));
        System.out.println("Thank you for registering, you will now be redirected to the Trainer Menu.");
        trainerEmail = trainEmail;
    }

    /**
     * Reads the assessment details from a user, and creates a new assessment from them.
     */
    private void addNewAssessment()
    {
        System.out.println("Please enter the name of the member you want to make an assessment of.");
        String emailSearch = input.nextLine();

        System.out.println("Please enter the current weight of the member you are assessing.");
        double assessWeight = validNextDouble("==>> ");

        System.out.println("Please enter the current chest measurement of the member you are assessing.");
        double assessChest = validNextDouble("==>> ");

        System.out.println("Please enter the current thigh measurement of the member you are assessing.");
        double assessThigh = validNextDouble("==>> ");

        System.out.println("Please enter the current upper arm measurement of the member you are assessing.");
        double assessUpperArm = validNextDouble("==>> ");

        System.out.println("Please enter the current waist measurement of the member you are assessing.");
        double assessWaist = validNextDouble("==>> ");

        System.out.println("Please enter the current hips measurement of the member you are assessing.");
        double assessHips = validNextDouble("==>> ");

        System.out.println("What is your comment about this assessment on the member you are assessing?");
        String assessComment = input.nextLine();

        Assessment newAssessment = new Assessment(assessWeight, assessChest, assessThigh,
            assessUpperArm, assessWaist, assessHips, assessComment, gym.searchTrainersByEmail(trainerEmail));
        Date date = new Date();
        gym.searchMembersByEmail(emailSearch).addAssessment(date, newAssessment);

    }


    //TODO Need to do code for chosenPackage here or in a new util. This is because you can have one package linked
    //with many members.

    public static boolean isValidEmail(String email)
    {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }




}