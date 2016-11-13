import java.util.*;

/**
 * This class implements Merge Sort with a built in Array list.
 */
public class MergeSortAL {


    public static <T extends Comparable<T>> ArrayList<T> mergeSort(ArrayList<T> list) {

        ArrayList<T> sorted = new ArrayList<T>();
        ArrayList<T> left = new ArrayList<T>();
        ArrayList<T> right = new ArrayList<T>();

        int middle = list.size() / 2;
        int i;
        int j;

        if (list.size() <= 1) {
            return list;
        } else {
            for (i = 0; i <= middle - 1; i++){
                left.add(list.get(i));
            }
            for (j = middle; j < list.size(); j++) {
                right.add(list.get(j));
            }
            left = mergeSort(left);
            right = mergeSort(right);

            if ((left.get(left.size() - 1)).compareTo(right.get(0)) <= 0) {
                left.addAll(right);
                return left;
            }
            sorted = merge(left, right);

            return sorted;
        }
    }

    public static <T extends Comparable<T>> ArrayList<T> merge(ArrayList<T> left, ArrayList<T> right) {

        ArrayList<T> result = new ArrayList<T>();

        while (left.size() > 0 & right.size() > 0) {
            if (left.get(0).compareTo(right.get(0)) <= 0) {
                result.add(left.remove(0));
            } else {
                result.add(right.remove(0));
            }
        }

        if (left.size() > 0) {
            result.addAll(left);
        }
        if (right.size() > 0) {
            result.addAll(right);
        }

        return result;
    }

}