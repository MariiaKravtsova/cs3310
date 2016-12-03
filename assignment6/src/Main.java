import javax.imageio.IIOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {

    public ArrayList studentList = new ArrayList();

    public static void main(String[] args) {
        int choice;
        Scanner user_input = new Scanner(System.in);

        Hashing hashing = new Hashing();

        choice = 0;

//        try {
//            File studentsFile = new File("names.txt");
//
//            if (!studentsFile.exists()) {
//                studentsFile.createNewFile();
//
//        } catch(IOException e){
//              System.err.println("Problem writing to the file statsTest.txt");
//        }

        while (choice != 5) {
            System.out.println();
            System.out.println("----------- MENU ------------");
            System.out.println("1. Add a student");
            System.out.println("2. Find a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Print all students");
            System.out.println("5. Exit");
            System.out.println();
            System.out.println("Please enter a number from the menu: ");
            choice = Integer.parseInt(user_input.next());

            switch (choice) {
                case 1:
                    hashing.add("Ana");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }


        }
    }

}
