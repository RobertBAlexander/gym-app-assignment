package utils;

import java.util.Scanner;

/**
 * Created by Robert Alexander on 29/04/2017.
 *
 * This utility class is used within the application to obtain user input from the console.
 *
 * The class uses the following public static methods:
 *
 *   validNextInt(prompt)  : Displays the prompt and returns a valid integer number entered by the user.
 *   validNextChar(prompt) : Displays the prompt and returns a valid character entered by the user.
 */
public class ScannerInput {


    /**
     * This method displays the specified prompt on screen and returns a
     * valid integer number entered by the user.
     * If the user enters nothing, or an invalid integer, then the prompting continues until the
     * user makes an entry that is valid.
     *
     * @param prompt text that will be displayed on screen.
     * @return The integer number, if valid, entered by the user.
     */
    @SuppressWarnings("resource")
    public static int validNextInt(String prompt) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print(prompt);
                return input.nextInt();
            }
            catch (Exception e) {
                input.nextLine(); //swallows the buffer contents
                System.err.println("\tEnter a number please.");
            }
        }  while (true);

    }

    /**
     * This method displays the specified prompt on screen and returns a
     * valid double number entered by the user.
     * If the user enters nothing, or an invalid double, then the prompting continues until the
     * user makes an entry that is valid.
     *
     *
     * @param prompt text that will be displayed on screen.
     * @return The double number, if valid, entered by the user.
     */
    @SuppressWarnings("resource")
    public static double validNextDouble(String prompt) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print(prompt);
                return input.nextDouble();
            }
            catch (Exception e) {
                input.nextLine(); //swallows the buffer contents
                System.err.println("\tEnter a decimal number please.");
            }
        }  while (true);

    }

}