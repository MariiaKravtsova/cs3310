/**
 * <h1>Assignment 4</h1>
 * <h2>CS 3310</h2>
 *
 * This application takes user input and based on that sorts
 * the file NameList.txt which is included in the directory.
 * The sort choices are Bubble, Insertion, Selection and Merge.
 * These sorts are available for Array Lists and Linked Lists.
 * This implementation is inspired by Algorithms by Segwick
 * @author: Mariia Kravtsova
 * @since: November 13, 2016
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception{

        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> testList = new LinkedList<String>();

        Scanner reader = new Scanner(System.in);
        int userInput;

        Scanner s = new Scanner(new File("NameList.txt"));
        while (s.hasNext()) {
            String name = s.next();
            arrayList.add(name);
            testList.add(name);
        }
        s.close();

        System.out.println("1. Bubble Sort Array List");
        System.out.println("2. Insertion Sort Array List");
        System.out.println("3. Selection Sort Array List");
        System.out.println("4. Merge Sort Array List");
        System.out.println("5. Bubble Sort Linked List");
        System.out.println("6. Insertion Sort Linked List");
        System.out.println("7. Selection Sort Linked List");
        System.out.println("8. Merge Sort Linked List");
        System.out.println("Please enter a number: ");
        userInput = reader.nextInt();

        switch (userInput) {
            case 1:
                System.out.println("Unsorted: " + arrayList);
                System.out.println("Bubble Sort: " + BubbleSortAL.bubbleSort(arrayList));
                break;
            case 2:
                System.out.println("Unsorted: " + arrayList);
                System.out.println("Insertion Sort: " + InsertionSortAL.insertionSort(arrayList));
                break;
            case 3:
                System.out.println("Unsorted: " + arrayList);
                System.out.println("Selection Sort: " + SelectionSortAL.selectionSort(arrayList));
                break;
            case 4:
                System.out.println("Unsorted: " + arrayList);
                System.out.println("Merge Sort: " + MergeSortAL.mergeSort(arrayList));
                break;
            case 5:
                System.out.println("Unsorted: " + testList.toString());
                LinkedList.bubbleSort(testList);
                System.out.println("Bubble Sort: " + testList.toString());
                break;
            case 6:
                System.out.println("Unsorted: " + testList.toString());
                LinkedList.insertionSort(testList);
                System.out.println("Insertion Sort: " + testList.toString());
                break;
            case 7:
                System.out.println("Unsorted: " + testList.toString());
                LinkedList.selectionSort(testList);
                System.out.println("Selection Sort: " + testList.toString());
                break;
            case 8:
                System.out.println("Merge Sort is currently under maintenance.");
                break;
        }


    }
}
