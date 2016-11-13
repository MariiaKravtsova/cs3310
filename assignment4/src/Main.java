import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("a");

        System.out.println(arrayList);

        System.out.println("Selection Sort sorted : " + selectionSortAL.selectionSort(arrayList));

        System.out.println("Bubble Sort sorted: " + bubbleSortAL.bubbleSort(arrayList));

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
