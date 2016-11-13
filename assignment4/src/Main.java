import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception{

        ArrayList<String> arrayList = new ArrayList<>();

        Scanner s = new Scanner(new File("NameList.txt"));
        while (s.hasNext()) {
            arrayList.add(s.next());
        }
        s.close();

        System.out.println("Unsorted: " + arrayList);

        System.out.println("Selection Sort: " + SelectionSortAL.selectionSort(arrayList));

        System.out.println("Bubble Sort: " + BubbleSortAL.bubbleSort(arrayList));

        System.out.println("Insertion Sort: " + InsertionSortAL.insertionSort(arrayList));

        System.out.println("Merge Sort: " + MergeSortAL.mergeSort(arrayList));

        LinkedList<String> testList = new LinkedList<String>();

        testList.add("a");
        testList.add("c");
        testList.add("b");
        testList.add("d");
        testList.add("e");
        testList.add("f");
        testList.add("g");

        System.out.println("Unsorted: " + testList.toString());

        LinkedList.bubbleSort(testList);

        System.out.println("Bubble Sort: " + testList.toString());

    }
}
