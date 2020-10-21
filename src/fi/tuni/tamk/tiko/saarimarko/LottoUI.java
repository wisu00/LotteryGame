
package fi.tuni.tamk.tiko.saarimarko;

import fi.tuni.tamk.tiko.saarimarko.util.Math;
import fi.tuni.tamk.tiko.saarimarko.util.Arrays;
import fi.tuni.tamk.tiko.saarimarko.util.MyConsole;


/**
* This class contains a program that is used to simulate a game of lotto.
*
* The amount of required numbers as well as their range can be changed with the first three variables.
* Program get's array of numbers from user after which it will generate random number combinations, within 
* the set requirements. This is will go on until the arrays have exact same numbers. After that the amount
* of time used is displayed in weeks and years, where one week equals one try. If the time required was
* greater than 120 years the program will start the process again with the same user input.
*
* This program uses classes named: Math, Arrays and MyConsole.
*
* @author Marko Saari
*/

public class LottoUI {

    public static void main(String [] args) {
        int min = 1;
        int max = 40;
        int slots = 7;

        int numbers[] = selectNumbers(args, min, max, slots);
        boolean alive = true;
        do{
            int hits;
            int record=0;
            int weeks=0;
            int years=0;
            do{
                weeks++;
                int lotto[] = calculateLotto(min, max, slots);
                hits = Arrays.hitAmount(numbers, lotto);
                if(hits>record){
                    years=weeks/52;
                    record = hits;
                    System.out.println("Got " + record + "! Took " + years + " years");
                }
            } while(hits<slots);
            System.out.println("You won!");
            if(years>=120) {
                alive = false;
                System.out.println("But it took more than a lifetime so let's try again.");
            }
            else {
                alive = true;
                System.out.println("You won lotto during your lifetime!");
            }
        } while (!alive);
    }

    /**
    * fills out the numbers array 
    *
    * The arrays length is 7 and it contains unique integers in the defined range.
    * Method asks numbers from user until array is complete.  
    * 
    * @param slots is used to define the amount of users numbers.
    * @param min is used to define the smallest possible number
    * @param max is used to define the biggest possible number
    * @return returns complete array 
    */
    private static int[] selectNumbers(String [] input,int min, int max, int slots) {
        int numbers[] = new int[slots];
        if(input.length==slots) {
        numbers = Arrays.toIntArray(input);
            if(Arrays.hasDublicate(numbers) || !Arrays.areInRange(numbers, min, max)) {
                numbers = slowNumbers(min, max, slots);
            }
        }
        else {
            numbers = slowNumbers(min, max, slots);
        }
        return numbers;
    }

    /**
    * Prompts user to create array of numbers 
    *
    * The arrays size is determined by the amount of slots.
    * The given numbers need to be unique as well as within determined range.
    * Method asks numbers from user until the array is complete.  
    * 
    * @param slots is used to define the amount of users numbers.
    * @param min is used to define the smallest possible number
    * @param max is used to define the biggest possible number
    * @return returns complete array 
    */
    private static int[] slowNumbers(int min, int max, int slots) {
        int numbers[] = new int[slots];
        int num;
        for(int i=0; i<numbers.length; i++) {
            System.out.println("Please give unique number between [" + min + ", "+ max + "]");
            num = MyConsole.readInt(min, max, "please give number.", "Please give unique number between [" + min + ", "+ max + "]");
            boolean used = Arrays.contains(num, numbers);
            if(used) {
                System.out.println("Not a unique number!");
                i--;
            }
            else {
                numbers[i] = num;
            }
        }
        return numbers;
    }

    /**
    * Creates randomized array of numbers 
    *
    * The arrays length is 7 and it contains unique random integers between [1, 40].
    * Method uses list of all possible numbers which is then edited in order to stop
    * dublicates.    
    *
    * @param slots is used to define the amount of winning line's numbers.
    * @param min is used to define the smallest possible number
    * @param max is used to define the biggest possible number
    * @return returns complete array 
    */
    private static int[] calculateLotto(int min, int max, int slots) {
        int [] numbers = new int[max-1];
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = i+min;
        }
        int [] lotto = new int[slots];
        for(int i=0; i<slots; i++) {
            int index = Math.getRandom(0, numbers.length - 1);
            int randomNumber = numbers[index];
            lotto[i] = randomNumber;
            numbers = Arrays.removeIndex(numbers, index);
        }
        return lotto;
    }
}
