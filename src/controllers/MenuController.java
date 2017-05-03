package controllers;

import java.util.Scanner;

/**
 * Created by Robert Alexander on 29/04/2017.
 */
public class MenuController {

    private Scanner input;
    private static GymApi gym;

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
        runMenu();
    }

    private String loginMenu()
    {
        System.out.println("\fAre you a member of a trainer?");
        System.out.println("---------");
        System.out.println("  Type 'M' for member, and 'T' for trainer.");
        char personChar = input.next().charAt(0);
        String personType = "" + personChar;
        while ((personType.toUpperCase() != "M") && (personType.toUpperCase() != "T"))
        {
            personChar = input.next().charAt(0);
            personType = "" + personChar;

        }
        if (personType.toUpperCase() != "M")
        {
            return "member login signup";
        }
        if (personType.toUpperCase() == "T")
        {
            return "trainer login signup";
        }
        else
        {
            return "invalid information. error.";
        }


    }

    /*
     * This is the method that controls the loop.
     */
    private void runMenu(){
        int option = loginMenu();
        while (option != 0){
            switch (option){
                case 1:    addProduct();
                    break;
                case 2:    System.out.println(store.listProducts());
                    break;
                case 3:    updateProduct();
                    break;
                case 4:    store.remove(getIndex());
                    break;
                case 5:    System.out.println(store.cheapestProduct());
                    break;
                case 6:    System.out.println(store.toString());
                    break;
                case 7:    try {
                    store.save();
                }
                catch (Exception e) {
                    System.err.println("Error writing to file: " + e);
                }
                    break;
                case 8:    try {
                    store.load();
                }
                catch (Exception e) {
                    System.err.println("Error reading from file: " + e);
                }
                    break;
                default:   System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine(); //2nd read for bug in Scanner; String read is ignored after reading int.
            //display the main menu again
            option = mainMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

}
