

/**
 * Created by mkravtsova on 9/20/16.
 */
public class ArrayDS {

    public int[] randArray;
    public int[] deletedArray;

    int counter = 0;

    // Constructor
    public ArrayDS(int userMax){

        randArray = new int[userMax];

    }


    public void add(int randomNumber, int i){

        randArray[i] = randomNumber;

    }

    public void incrementCounter(){

        counter++;

    }


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


    public void insert(int value, int[] randArray, String order)
    {
        int[] copy = new int[randArray.length + 1];
        int i;
        boolean inserted = false;

        for (i = 0; i < copy.length; i++) {
            if (order.equals("decreasing")) {
                if (!inserted) {
                    if (randArray[i] < value) {
                        copy[i] = value;
                        inserted = true;
                    }
                    else {
                        copy[i] = randArray[i];
                    }
                } else {

                    copy[i] = randArray[i-1];

                }
            }
            if (order.equals("increasing")) {
                if (!inserted) {
                    if (randArray[i] > value) {
                        copy[i] = value;
                        inserted = true;
                    }
                    else {
                        copy[i] = randArray[i];
                    }
                } else {

                    copy[i] = randArray[i-1];

                }
            }


        }

        System.out.print("Insert 10 to Array: ");
        print(copy);
    }

    public void print(int[] randArray){
        for (int i = 0; i < randArray.length; i++){
            System.out.print(randArray[i] + " ");
        }
        System.out.println("Done.");
        System.out.println();
    }

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
