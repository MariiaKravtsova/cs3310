/**
 * <h1>Assignment 5 part 2</h1>
 * <h2>CS 3310</h2>
 *
 * This application takes a txt file, and based on the instructions
 * in the file is inserts, searches, deletes, and prints the binary search tree
 * in postorder, inorder and preorder
 * @author: Mariia Kravtsova
 * @since: December 1, 2016
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        binaryStreeImplicit bs = new binaryStreeImplicit();

        /**
         * Reads the txt file provided, splits the ine into two parts based on function and data
         * then applies the function on the data. The delete method is not working fully
         */
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/mkravtsova/Github/cs3310/assignment5/src/hw5cs3310F16data.txt"))) {
            String line;
            String[] array1;
            String[] array2;

            mydata record = new mydata();

            while ((line = br.readLine()) != null) {
                array1 = line.split(":", 2);

                if (array1[0].equals("Insert")) {


                    array2 = array1[1].split(",");

                    record.stuName = array2[0];
                    record.courseNumber = Integer.parseInt(array2[1].trim());
                    record.grade = array2[2].charAt(0);

                    bs.insert(record);
                    System.out.println("Record " + record.stuName + " was inserted.");

//                } else if (array1[0].equals("Search")) {
//
//                    array2 = array1[1].split(",");
//                    mydata record1 = new mydata();
//
//                    record.stuName = array2[0];
//                    record.courseNumber = 0;
//                    record.grade = 'A';
//
//                    System.out.println("Record found at " + bs.search(record));
//
//                } else if (array1[0].equals("Delete")) {
//
//                    array2 = array1[1].split(",");
//                    mydata record2 = new mydata();
//
//                    record.stuName = array2[0];
//                    record.courseNumber = 0;
//                    record.grade = 'A';
//
//                    System.out.println("Record delete at " + bs.delete(record));
//
//                } else if (array1[0].equals("Postorder")) {

                    System.out.println();
                    System.out.println("Postorder:");
                    bs.postorderTraversal(0);

                } else if (array1[0].equals("Inorder")) {

                    System.out.println();
                    System.out.println("InOrder:");
                    bs.inorderTraversal(0);

                } else if (array1[0].equals("Preorder")) {

                    System.out.println();
                    System.out.println("Preorder:");
                    bs.preorderTraversal(0);

                }

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }


    }
}
