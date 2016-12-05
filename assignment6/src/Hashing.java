/**
 * Class that creates a file, or copies data from the file into an array list
 * It contains methods to add, find, delete and print the hashed student names
 */

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Hashing {

    // Assuming no names will be repeated
    private static final int SIZE = 65535;

    private ArrayList<String> studentList = new ArrayList<String>(SIZE);
    private File studentFile = new File("studentsData.txt");

    /**
     * create a file named studentsData.txt and fill up the array list with null
     * if the file does exist just fill up the array
     * @throws FileNotFoundException since it is required
     */
    public void createFile() throws FileNotFoundException {

        boolean created = false;
        Scanner reader;

        if (studentFile.exists()) {
            reader = new Scanner(studentFile);
            while (reader.hasNext()){
                studentList.add(reader.next());
            }
            reader.close();
        } else {
            try {
                created = studentFile.createNewFile();
                if(created){
                    buildArray();
                    System.out.println("File created successfully.");
                }
                else{
                    System.out.println("File cannot be created.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * add a strung null for every position
     */
    public void buildArray(){
        int i;

        for (i = 0; i < SIZE; i++) {
            studentList.add(i, "null");
        }
    }

    /**
     * Write each item in the arraylist to the file on new line
     */
    public void saveFile() {
        try {
            FileWriter writer = new FileWriter(studentFile);
            for(String str: studentList) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Add the student name by replacing the null string
     * with the student name at a hashed index
     * @param studentName the name of the student to add
     */
    public void add(String studentName) {
        int hash;
        int i;

        hash = 7;
        for (i = 0; i < studentName.length(); i++) {
            hash = hash^studentName.charAt(i);
        }
        System.out.print(hash);
        studentList.set(hash, studentName);
    }

    /**
     * Fetch record at the value of the hashing
     * @param hashValue the hashed value user is looking for
     */
    public void findByValue(int hashValue) {

        if (!studentList.get(hashValue).equals("null")) {
            System.out.println("At value " + hashValue + " we found " + studentList.get(hashValue));
        } else {
            System.out.println("Record doesn't exist.");
        }
    }

    /**
     * Hash the name, then fetch record at the value of the hashing
     * @param studentName the name of the student to look for
     */
    public void findByName(String studentName) {
        int hash;
        int i;

        hash = 7;
        for (i = 0; i < studentName.length(); i++) {
            hash = hash^studentName.charAt(i);
        }
        if (!studentList.get(hash).equals("null")) {
            System.out.println(studentName + "'s hash value is at " + hash);
        } else {
            System.out.println("Record doesn't exist.");
        }
    }

    /**
     * Hash the name, then replace the record at that index with null
     * @param studentName the name of the student the record to delete
     */
    public void deleteByName(String studentName) {
        int hash;
        int i;

        hash = 7;
        for (i = 0; i < studentName.length(); i++) {
            hash = hash^studentName.charAt(i);
        }
        if (!studentList.get(hash).equals("null")) {
            studentList.set(hash, "null");
            System.out.println("Record deleted.");
        } else {
            System.out.println("Record doesn't exist.");
        }
    }

    /**
     * Set the value of null at the hashed value
     * @param hashValue the index we are deleting the student name at
     */
    public void deleteByValue(int hashValue) {
        if (!studentList.get(hashValue).equals("null")) {
            studentList.set(hashValue, "null");
            System.out.println("Record deleted.");
        } else {
            System.out.println("Record doesn't exist.");
        }
    }

    /**
     * Printing the list of all records that are not null
     */
    public void printAll() {
        int i;
        for (i = 0; i < SIZE; i++) {
            if (!studentList.get(i).equals("null")){
                System.out.println(i + " " + studentList.get(i));
            }
        }
    }
}
