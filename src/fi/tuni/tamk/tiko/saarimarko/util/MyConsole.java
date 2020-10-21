package fi.tuni.tamk.tiko.saarimarko.util;

import java.io.Console;  

/**
* This class contains console related methods.
*
* This class was made for school project and is quite limited in usability.
*
* @author Marko Saari
*/

public class MyConsole {

    /**
    * allows user to give one integer that is then returned
    *
    * If user doesn't input integer, error message is displayed and user needs to try again.
    * Method uses try and catch in order to see if the input is integer.
    * 
    * @param errorMessage is displayed if user fails to give integer
    * @return returns the number that user gave
    */
    public static int readInt(String errorMessage) {
        Console c = System.console(); 
        boolean checker = true;
        int input=0;
        while(checker) {
            boolean isInt = true;
            try {
            input = Integer.parseInt(c.readLine());
            } catch(NumberFormatException e) {
            System.out.println(errorMessage);
            isInt = false;
            }
            if(isInt == true) {
                checker = false;
            }
        }
        return input;
    }

    /**
    * allows user to give one integer in defined range which is then returned
    *
    * If user doesn't give passable integer, error message is displayed and user needs to try again.
    * Method uses try and catch in order to see if the input is integer.
    * Afterwards if statement is used to see if the value is in the range defined by the arguments.
    * 
    * @param min defines the minimum value for the integer
    * @param max defines the maximum value for the integer
    * @param errorMessageNonNumeric is displayed if user fails to give integer
    * @param errorMessageNonMinAndMax is displyed if the given integer isn't in the range defined by parameters
    * @return returns the number that user gave
    */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        Console c = System.console(); 
        boolean checker = true;
        int input=0;
        while(checker) {
            boolean isInt = true;
            try {
            input = Integer.parseInt(c.readLine());
            } catch(NumberFormatException e) {
            System.out.println(errorMessageNonNumeric);
            isInt = false;
            }
            if(isInt == true) {
                if(input>=min && input<=max) {
                    checker = false;
                }
                else {
                    System.out.println(errorMessageNonMinAndMax);
                }
            }
        }
        return input;
    }
}