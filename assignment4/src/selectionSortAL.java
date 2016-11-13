import java.util.*;
/**
 * This class implements Selection Sort with a built in Array list.
 * It creates an Array list from the list that was passed into the Selection Sort method.
 * It iterates through the list, finds the smallest item by comparing current and next,
 * then swaps the items if need be by using built in set() method.
 * Then returns the ordered list.
 */
public class SelectionSortAL {

    /*
     * Find the smallest element then rewrite the elements
     * @param list Array List of type T
     * @return array Sorted List
     */
    public static <T extends Comparable<T>> ArrayList<T> selectionSort(ArrayList<T> list) {

        ArrayList<T> array = new ArrayList<T>(list);
        int i;
        int j;
        int position;
        T smallest;

        // Iterate through the list - 1 and rewrite elements
        for (i = 0; i < array.size() - 1 ; i++) {
            smallest = array.get(i);
            position = i;

            // Compare elements and replace the smallest and its position
            for (j = i + 1; j < array.size(); j++) {
                if (array.get(j).compareTo(smallest) < 0) {
                    smallest = array.get(j);
                    position = j;
                }
            }

            // Rewrite the elements
            array.set(position, array.get(i));
            array.set(i, smallest);
        }

        return array;
    }
}
