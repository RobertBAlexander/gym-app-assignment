package utils;

/**
 * Created by Robert Alexander on 29/04/2017.
 */
public class Analytics {

    /**
     * This method calcuates the BMI value for the member.
     *
     * The formula used for BMI is weight divided by the square of the height.
     *
     * @param member
     * @param assessment
     * @return the BMI value for the member. The number returned is reduced to two decimal places.
     */
    public static double calculateBMI (Member member, Assessment assessment)
    {
        if (this.height <= 0)
            return 0;
        else
        {
            return toTwoDecimalPlaces(this.startingWeight / (this.height * this.height));
        }
    }

    /**
     * This method determines the BMI category that the member belongs to.
     *
     *
     * The category is determined by the magnitude of the members BMI according to the following:
     *
     *      BMI less than 15 (exclusive)                        is VERY SEVERELY UNDERWEIGHT
     *      BMI between 15   (inclusive) and 16 (exclusive)     is SEVERELY UNDERWEIGHT
     *      BMI between 16   (inclusive) and18.5(exclusive)     is UNDERWEIGHT
     *      BMI between 18.5 (inclusive) and 25 (exclusive)     is NORMAL
     *      BMI between 25   (inclusive) and 30 (exclusive)     is OVERWEIGHT
     *      BMI between 30   (inclusive) and 35 (exclusive)     is MODERATELY OBESE
     *      BMI between 35   (inclusive) and 40 (exclusive)     is SEVERELY OBESE
     *      BMI above   40   (inclusive)                        is VERY SEVERELY OBESE
     * @param bmiValue
     * @return The BMI category is returned in the following format: "\"NORMAL\""
     */
    public static String determineBMICategory (double bmiValue)
    {
        double bmi = calculateBMI();

        if (bmi < 15)
        {
            return "\"VERY SEVERELY UNDERWEIGHT\"";
        }
        else if (bmi < 16)
        {
            return "\"SEVERELY UNDERWEIGHT\"";
        }
        else if (bmi < 18.5)
        {
            return "\"UNDERWEIGHT\"";
        }
        else if (bmi < 25)
        {
            return "\"NORMAL\"";
        }
        else if (bmi < 30)
        {
            return "\"OVERWEIGHT\"";
        }
        else if (bmi < 35)
        {
            return "\"MODERATELY OBESE\"";
        }
        else if (bmi < 40)
        {
            return "\"SEVERELY OBESE\"";
        }
        else return "\"VERY SEVERELY OBESE\"";
    }

    /**
     * This method returns the member height converted from meters to inches.
     *
     * @return member height converted from meters to inches using the formula: meters
     * multiplied by 39.37. The number returned is truncated to two decimal places.
     */
    public double convertHeightMetersToInches()
    {
        return toTwoDecimalPlaces(height * 39.37);
    }
    /**
     * This method returns a boolean to indicate if the member has an idea body weight based on the Devine formula.
     *
     * For men an ideal weight is: 50kg + 2.3kg for each inch over 5 feet.
     * For women an ideal weight is: 45.5kg + 2.3kg for each inch over 5 feet.
     * If no gender is specified, default to female calculation.
     * @param member
     * @param assessment
     * @return Returns true if the result of Devine formula is within 2kgs of (inclusive) of the
     * starting weight. False if outside this range.
     */
    public static boolean isIdealBodyWeight (Member member, Assessment assessment)
    {
    double fiveFeet = 60.0;
    double idealBodyWeight;

    double inches = convertHeightMetersToInches();

    if (inches <= fiveFeet)
      {
        if (gender.equals("M"))
        {
            idealBodyWeight = 50;
        }
        else
        {
            idealBodyWeight = 45.5;
        }
      }
      else
      {
        if (gender.equals("M"))
        {
            idealBodyWeight = 50 + ((inches - fiveFeet) * 2.3);
        }
        else
        {
            idealBodyWeight = 45.5 + ((inches - fiveFeet) * 2.3);
        }
      }
      return ( (idealBodyWeight <= (startingWeight + 2.0)) && (idealBodyWeight >= (startingWeight - 2.0)));
    }

    /**
     * This is a private helper method. It ensures that all double data returned from this class
     * is restricted to two decimal places. Note: this method does not  round.
     * @param num
     * @return This takes in a double and returns one that only goes to two decimal places.
     */
    private double toTwoDecimalPlaces ( double num)
    {
        return (int)(num * 100) / 100.0;
    }
}
