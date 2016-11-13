import java.util.*;
/**
 * This class implements Bubble Sort with a built in Array list.
 * It creates an Array list from the list that was passed into the Bubble Sort method.
 * It iterates through the list, finds the smallest item by comparing current and next,
 * and swaps the items if need be by using built in set() method.
 * Then returns the ordered list.
 */
public class BubbleSortAL {
    /*
    * Find the smallest element then swap it.
    * @param list Array List of type T
    * @return array Sorted List
    */
    public static <T extends Comparable<T>> ArrayList<T> bubbleSort(ArrayList<T> list) {

        ArrayList<T> array = new ArrayList<T>(list);
        int i;
        int j;
        boolean swapped = true;
        T current;

        // Iterates through the list until swapped
        for (i = 1; i < array.size() & swapped; i++) {
            swapped = false;
            // Compare next to current, set them in the list
            for (j = 0; j < array.size() - i; j++) {
                if (array.get(j).compareTo(array.get(j+1)) > 0 ) {
                    current = array.get(j);
                    array.set(j, array.get(j+1));
                    array.set(j+1, current);
                    swapped = true;
                }
            }
        }

        return array;
    }

}
