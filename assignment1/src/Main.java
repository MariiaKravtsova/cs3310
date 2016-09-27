/**
 * <h1>CS 3310: Data and File Structures</h1>
 * Professor: Dr. Gupta
 * @autor: Mariia Kravtsova
 * @since: September 27, 2016
 * Assignment 1: Generate random number, store it in linked list and array
 *               sort, delete, and insert the elements.
 */

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int userMax;
        int upperBound;
        int i;
        int randomNumber;

        // Get user input of the upper bound of the random numbers
        // and the max number generated
        Scanner upper_bound = new Scanner(System.in);
        Scanner max_number = new Scanner(System.in);

        System.out.print("Enter the upper bound for random numbers: ");
        upperBound = Integer.parseInt(upper_bound.next());

        System.out.print("Enter the number of random numbers to be generated: ");
        userMax = Integer.parseInt(max_number.next());

        // Generate and store random numbers, then proceed with the logic
        Random rand = new Random();

        ArrayDS arrayDS = new ArrayDS(userMax);

        LinkedListDS linkedListDS = new LinkedListDS();

        long firstPerformanceCounter = System.nanoTime();


        for(i = 0; i < (userMax); i++){

            randomNumber = rand.nextInt(upperBound) + 1;

            if (randomNumber > 50) {

                arrayDS.incrementCounter();
                linkedListDS.incrementCounter();

            }

            arrayDS.add(randomNumber, i);
            linkedListDS.add(randomNumber);

        }

        arrayDS.logic();
        linkedListDS.logic();
        
    }

}
