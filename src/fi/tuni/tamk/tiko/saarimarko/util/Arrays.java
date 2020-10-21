
package fi.tuni.tamk.tiko.saarimarko.util;

/**
* This Class contains array related methods.
*
* This class was made for school project and is quite limited in usability.
*
* @author Marko Saari
*/

public class Arrays {

    /**
    * tells if the given array contains dublicate numbers.
    * 
    * @param array the array that is to being checked
    * @return a boolean that tells if the array has dublicates
    */
    public static boolean hasDublicate(int [] array) {
        boolean dublicates = false;
        for(int i=0; i<(array.length-1); i++) {
            for(int j=i+1; j<array.length; j++) {
                if(array[i]==array[j]) {
                    dublicates = true;
                }
            }
        }
        return dublicates;
    }

    /**
    * tells if numbers are in the defined range of values.
    *
    * this function returns either true of false depending on given array and values.
    * 
    * @param array the array that is to being checked
    * @param min determines the smallest passable value
    * @param max determines the largest passable value
    * @return a boolean that tells if the array has numbers that are too big or small
    */
    public static boolean areInRange(int [] array, int min, int max) {
        boolean passable = true;
        for(int i=0; i<(array.length-1); i++) {
            if(array[i]<min || array[i]>max) {
                passable = false;
            }
        }
        return passable;
    }

    /**
    * Changes String array into int array 
    *
    * All of the contents in the given array have to be convertable into integers.
    * 
    * @param array the array that is to be changed into int type array
    * @return the resulting int type array
    */
    public static int [] toIntArray(String [] array) {
        int intArray[] = new int[array.length];
        for(int i=0; i<array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }

    /**
    * Checks if the given value exists in the given array.
    *
    * Number and array are both of integer type.
    * Method stops upon finding the value or at the end of the array.
    * 
    * @param value the integer that the method tries to find
    * @param array the array that is being searched
    * @return tells whether or not the integer was found
    */
    public static boolean contains(int value, int [] array) {
        boolean found=false;
        for(int i=0; (i<array.length) && !found; i++) {
            if(array[i]==value) {
                found=true;
            }
        }
        return found;
    }

    /**
    * Tells how many numbers the two arrays have in common
    *
    * Returned number and arrays are all of integer type.
    * Size of the arrays doesn't matter.
    * Arrays need to contain uniquie values or method doesn't work properly.
    * Works with arrays of all sizes without requiring their sizes to be even.
    * 
    * @param array1 the first array that contains unique integers
    * @param array2 the second array
    * @return returns the number of pairs
    */
    public static int hitAmount(int [] array1, int [] array2) {
        int hits=0;
        for(int i=0; i<array1.length; i++) {
            for(int j=0; j<array2.length; j++) {
                if(array1[i]==array2[j]) {
                    hits++;
                }
            }
        }
        return hits;
    }

    /**
    * Removes selected index from the given array
    *
    * array and index both need to be of integer type.
    * note that indexes start from 0.
    * 
    * @param original original array
    * @param index the index which we want to remove
    * @return returns the new array
    */
    public static int[] removeIndex(int [] original, int index) {
        int updated[] = new int[original.length-1];
        int offset=0;
        for(int i=0; i<original.length; i++) {
            if(i!=index) {
                updated[i-offset] = original[i];
            }
            else {
                offset=1;
            }

        }
        return updated;
    }
}