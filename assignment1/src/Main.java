/**
 * <h1>CS 3310: Data and File Structures</h1>
 * Professor: Dr. Gupta
 * @autor: Mariia Kravtsova
 * @since: September 27, 2016
 * Assignment 1: Generate random number, store it in linked list and array
 *               sort, delete, and insert the elements.
 * Note: Please see the Javadoc in the javadoc folder
 */

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int userMax = 0;
        int upperBound = 0;
        int i;
        int j;
        int randomNumber;
        int runMax = 0;

        // Get user input of the upper bound of the random numbers
        // and the max number generated
        Scanner upper_bound = new Scanner(System.in);
        Scanner max_number = new Scanner(System.in);
        Scanner run_max = new Scanner(System.in);

        try {
            System.out.print("Enter the upper bound for random numbers: ");
            upperBound = Integer.parseInt(upper_bound.next());

            System.out.print("Enter the number of random numbers to be generated: ");
            userMax = Integer.parseInt(max_number.next());

            System.out.print("Enter the amount of time the program should run: ");
            runMax = Integer.parseInt(run_max.next());
        } catch (Exception e) {
            System.out.println("Enter a valid number.");
        }


        // Generate and store random numbers, then proceed with the logic
        Random rand = new Random();

        ArrayDS arrayDS = new ArrayDS(userMax);

        LinkedListDS linkedListDS = new LinkedListDS();

        /**
         * This for loop runs the program j to runMax amount of time (where runMax is user input)
         * The next for loop generates random numbers i to userMax (where userMax is user input)
         * The numbers are generated in the range 0 - upperBound (where upperBound is user input)
         */

        for (j = 0; j < runMax; j++) {
            for(i = 0; i < userMax; i++){

                randomNumber = rand.nextInt(upperBound) + 1;

                if (randomNumber > 50) {

                    arrayDS.incrementCounter();
                    linkedListDS.incrementCounter();

                }

                arrayDS.add(randomNumber, i);
                linkedListDS.add(randomNumber);

            }
        }


        arrayDS.logic();
        linkedListDS.logic();
        
    }

}
