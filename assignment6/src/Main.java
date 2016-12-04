import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        int choice;
        int value;
        String name;
        Scanner user_input = new Scanner(System.in);

        Hashing hashing = new Hashing();

        choice = 0;

        hashing.createFile();

        while (choice != 7) {
            System.out.println();
            System.out.println("----------- MENU ------------");
            System.out.println("1. Add a student");
            System.out.println("2. Find a student by name");
            System.out.println("3. Find a student by hash value");
            System.out.println("4. Delete a student by name");
            System.out.println("5. Delete a student by hash value");
            System.out.println("6. Print all students");
            System.out.println("7. Exit");
            System.out.println();
            System.out.println("Please enter a number from the menu: ");
            choice = Integer.parseInt(user_input.next());

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Please enter a name to add: ");
                    name = user_input.next();
                    hashing.add(name);
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Please enter a name to find: ");
                    name = user_input.next();
                    hashing.findByName(name);
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Please enter a value to look up: ");
                    value = Integer.parseInt(user_input.next());
                    hashing.findByValue(value);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Please enter a name to delete: ");
                    name = user_input.next();
                    hashing.deleteByName(name);
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Please enter a value to delete: ");
                    value = Integer.parseInt(user_input.next());
                    hashing.deleteByValue(value);
                    break;
                case 6:
                    hashing.printAll();
                    break;
            }


        }

        hashing.saveFile();
    }

}
