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
        System.out.println(randArray[i]);

    }

    public void mergeSortArray(){
        mergeSort.sort(randArray);
    }
}
