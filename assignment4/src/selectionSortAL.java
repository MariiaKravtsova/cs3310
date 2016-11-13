import java.util.*;
/**
 * This class implements Selection Sort with a built in Array list.
 * It creates an Array list from the list that was passed into the Selection Sort method.
 * It iterates through the list, finds the smallest item by comparing current and next,
 * then swaps the items if need be by using built in set() method.
 * Then returns the ordered list.
 */
public class selectionSortAL {

    /*
     * Find the smallest element then rewrite the elements
     * @param list Array List of type T
     * @return orderedArray Sorted List
     */
    public static <T extends Comparable<T>> ArrayList<T> selectionSort(ArrayList<T> list) {

        ArrayList<T> orderedArray = new ArrayList<T>(list);
        int i;
        int j;
        int position;
        T smallest;

        // Iterate through the list - 1 and rewrite elements
        for (i = 0; i < orderedArray.size() - 1 ; i++) {
            smallest = orderedArray.get(i);
            position = i;

            // Compare elements and replace the smallest and its position
            for (j = i + 1; j < orderedArray.size(); j++) {
                if (orderedArray.get(j).compareTo(smallest) < 0) {
                    smallest = orderedArray.get(j);
                    position = j;
                }
            }

            // Rewrite the elements
            orderedArray.set(position, orderedArray.get(i));
            orderedArray.set(i, smallest);
        }

        return orderedArray;
    }
}
