package utils;

import java.util.Scanner;

/**
 * Created by Robert Alexander on 29/04/2017.
 *
 */
public class ScannerInput {

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