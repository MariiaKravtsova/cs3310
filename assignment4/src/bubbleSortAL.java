import java.util.*;
/**
 * This class implements Bubble Sort with a built in Array list.
 * It creates an Array list from the list that was passed into the Bubble Sort method.
 * It iterates through the list, finds the smallest item by comparing current and next,
 * and swaps the items if need be by using built in set() method.
 * Then returns the ordered list.
 */
public class bubbleSortAL {
    /*
    * Find the smallest element then swap it.
    * @param list Array List of type T
    * @return orderedArray Sorted List
    */
    public static <T extends Comparable<T>> ArrayList<T> bubbleSort(ArrayList<T> list) {

        ArrayList<T> orderedList = new ArrayList<T>(list);
        int i;
        int j;
        boolean swapped = true;
        T current;

        // Iterates through the list until swapped
        for (i = 1; i < orderedList.size() & swapped; i++) {
            swapped = false;
            // Compare next to current, set them in the list
            for (j = 0; j < orderedList.size() - i; j++) {
                if (orderedList.get(j).compareTo(orderedList.get(j+1)) > 0 ) {
                    current = orderedList.get(j);
                    orderedList.set(j, orderedList.get(j+1));
                    orderedList.set(j+1, current);
                    swapped = true;
                }
            }
        }

        return orderedList;
    }

}
