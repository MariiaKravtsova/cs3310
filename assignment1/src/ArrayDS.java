/**
 * Primitive Array Data Structure
 * takes randomly generated number and creates an array
 * using bubble sort it sorts the array,
 * then deletes an element which is chosen based on the sorting order,
 * then inserts a new element of value 10
 */
public class ArrayDS {

    public int[] randArray;
    public int[] deletedArray;

    int counter = 0;

    /**
    * Constructor that takes in the user input of the
    * amount of numbers to be generated and creates an array of that size
    */
    public ArrayDS(int userMax){

        randArray = new int[userMax];

    }

    // Takes in the random number, and its position and inserts it into an array
    public void add(int randomNumber, int i){

        randArray[i] = randomNumber;

    }

    // Increments counter every time there is a number larger than 50
    public void incrementCounter(){

        counter++;

    }

    /**
    * takes in the array and the order to be sorted and runs through a bubble sort
    * loops through each value and swaps them if necessary
    */
    public void bubbleSort(int[] randArray, String order) {
        int i;
        int j;
        int swap;

        for (i = 0; i < randArray.length; i++) {
            for (j = 0; j < (randArray.length - 1); j++) {
                if (order.equals("decreasing")) {
                    if (randArray[j] < randArray[j+1]) {
                        swap = randArray[j];
                        randArray[j] = randArray[j+1];
                        randArray[j+1] = swap;
                    }
                }
                if (order.equals("increasing")) {
                    if (randArray[j] > randArray[j+1]) {
                        swap = randArray[j];
                        randArray[j] = randArray[j+1];
                        randArray[j+1] = swap;
                    }
                }
            }
        }

    }

    /**
    * takes in the index of the array to be deleted and array
    * creates another array of which size is shorter by 1 and
    * copies each index skipping the index to be deleted
    */
    public void delete(int index, int[] originalArray) {
        deletedArray = new int[originalArray.length - 1];
        index--;

        for (int i = 0; i < deletedArray.length; i++) {

            if (i >= index) {
                deletedArray[i] = originalArray[i + 1];

            } else {
                deletedArray[i] = originalArray[i];

            }

        }

        System.out.print("Deleted Array: ");
        print(deletedArray);

    }

    /**
     * takes in the value to be inserted, the sorted array and the sort order
     * then based on the sort order places the value and copies
     * the values to a new array named copy
     */
    public void insert(int value, int[] randArray, String order)
    {
        int[] copy = new int[randArray.length + 1];
        int i;
        boolean inserted = false;

        for (i = 0; i < copy.length; i++) {
            if (!inserted) {
                if ((order.equals("decreasing") && (randArray[i] < value)) ||
                        (order.equals("increasing") && (randArray[i] > value))) {

                        copy[i] = value;
                        inserted = true;
                    } else {
                        copy[i] = randArray[i];
                    }
                } else {

                    copy[i] = randArray[i - 1];

                }
            }


        System.out.print("Insert Array: ");
        print(copy);


    }

    // Iterate through the array and print
    public void print(int[] randArray){

        for (int i = 0; i < randArray.length; i++){

            System.out.print(randArray[i] + " ");

        }

        System.out.println();
    }

    /**
     * Provides the necessary values to the methods to satisfy
     * the condition of this assignment
     */
    public void logic() {
        String increasing = "increasing";
        String decreasing = "decreasing";

        System.out.print("Original Array: ");
        print(randArray);

        if (counter > 5) {
            bubbleSort(randArray, increasing);

            System.out.print("Sorted Array: ");
            print(randArray);

            delete(5, randArray);

            insert(10, deletedArray, increasing);

        } else {
            bubbleSort(randArray, decreasing);

            System.out.print("Sorted Array: ");
            print(randArray);

            delete(2, randArray);

            insert(10, deletedArray, decreasing);

        }


    }
}
