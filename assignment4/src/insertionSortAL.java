import java.util.*;

/**
 * This class implements Insertion Sort with a built in Array list.
 * It creates an Array list from the list that was passed into the Insertion Sort method.
 * It iterates through the list, finds the smallest item by comparing current and next,
 * then swaps the items if need be by using built in set() method.
 * Then returns the ordered list.
 */
public class InsertionSortAL {

    /*
     * Find the smallest element then rewrite the elements
     * @param list Array List of type T
     * @return array Sorted List
     */
    public static <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> list) {

        ArrayList<T> array = new ArrayList<T>(list);
        int i;
        int j;
        T current;

        for (i = 1; i < array.size(); i++) {
            current = array.get(i);
            for (j = i - 1; j >= 0 && (current.compareTo(array.get(j)) < 0); j--) {
                array.set(j+1, array.get(j));
            }
            array.set(j+1, current);
        }

        return array;
    }
}
