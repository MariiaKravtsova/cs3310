import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int userMax;
        int i;
        int randomNumber;



        // Get user input of the max number generated
        Scanner user_input = new Scanner(System.in);

        System.out.print("Enter the max of the random list: ");
        userMax = Integer.parseInt(user_input.next()) + 1;

        // Generate random numbers
        Random rand = new Random();

        ArrayDS arrayDS = new ArrayDS(userMax);

        for(i = 1; i < (userMax); i++){
            randomNumber = rand.nextInt(userMax) + 1;
            arrayDS.addToArray(randomNumber, i);

        }
    }

}
