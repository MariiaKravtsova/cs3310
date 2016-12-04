import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
/**
 *
 */
public class Hashing {

    // Satisfies the requirement of working with billion of data from the start
    private static final int SIZE = 2000000;

    private ArrayList<String> studentList = new ArrayList<String>(SIZE);
    private File studentFile = new File("studentsData.txt");

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

    public void buildArray(){
        int i;

        for (i = 0; i < SIZE; i++) {
            studentList.add(i, "null");
        }
    }

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

    public void findByValue(int hashValue) {

        if (!studentList.get(hashValue).equals("null")) {
            System.out.println("At value " + hashValue + " we can find " + studentList.get(hashValue));
        } else {
            System.out.println("Record doesn't exist.");
        }
    }

    public void findByName(String studentName) {
        int hash;
        int i;

        hash = 7;
        for (i = 0; i < studentName.length(); i++) {
            hash = hash^studentName.charAt(i);
        }
        if (!studentList.get(hash).equals("null")) {
            System.out.println(studentName + "'s hash value is at " + studentList.get(hash));
        } else {
            System.out.println("Record doesn't exist.");
        }
    }

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

    public void deleteByValue(int hashValue) {
        if (!studentList.get(hashValue).equals("null")) {
            studentList.set(hashValue, "null");
            System.out.println("Record deleted.");
        } else {
            System.out.println("Record doesn't exist.");
        }
    }

    public void printAll() {
        int i;
        for (i = 0; i < SIZE; i++) {
            if (!studentList.get(i).equals("null")){
                System.out.println(i + " " + studentList.get(i));
            }
        }
    }
}
