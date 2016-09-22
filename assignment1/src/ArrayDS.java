

/**
 * Created by mkravtsova on 9/20/16.
 */
public class ArrayDS {

    public int[] randArray;


    MergeSort mergeSort = new MergeSort();

    // Constructor
    public ArrayDS(int userMax){
        userMax = userMax;
        randArray = new int[userMax];
    }


    public void addToArray(int randomNumber, int i){

        randArray[i] = randomNumber;

    }

    public int counter(int counter){
        counter++;
    }

    public void mergeSortArray(){
        mergeSort.mergeSort(randArray, 0, randArray.length - 1);
        System.out.println("Does it come here? ");
        System.out.println(counter);
        if (counter >= 5) {
            for(int i=randArray.length-1; i >= 0; i--){
                System.out.println(randArray[i]);
            }
        } else {
            for(int i=0; i < randArray.length; i++){
                System.out.print(randArray[i] + " ");
            }
        }

    }

    public void deleteArray(int index, int[] randArray) {
        int[] copy = new int[randArray.length - 1];

        for(int i = 0; i < randArray.length; i++){
            if (randArray[i] == index) {
                System.arraycopy(randArray, 0, copy, i, randArray.length-1);
                System.arraycopy(randArray, i+1, copy, i, randArray.length-i-1);
            }
        }
    }
}
