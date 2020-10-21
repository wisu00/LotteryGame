package fi.tuni.tamk.tiko.saarimarko.util;


/**
* This class contains math related methods.
*
* This class was made for school project and is quite limited in usability.
*
* @author Marko Saari
*/

public class Math {

    /**
    * Returns a random number between the two given numbers. 
    *
    * The returned number is integer type. The two given numbers should
    * also be of the integer type. The given numbers are included in the  
    * range of possible outcomes.
    * 
    * @param min the integer which determines the smallest possible value
    * @param max the integer which determines the largest possible value
    * @return random integer between two given integers
    */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}