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

        LinkedList<String> addLinkedList = new LinkedList<String>();

        addLinkedList.add("a");
        addLinkedList.add("c");
        addLinkedList.add("b");
        addLinkedList.add("d");
        addLinkedList.add("e");
        addLinkedList.add("f");
        addLinkedList.add("g");

        System.out.print("\n" + addLinkedList.nodeToString());

    }
}
