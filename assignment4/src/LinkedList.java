/**
 * Linked List has the implementation of the Node class, building the linked list and implementing
 * Bubble sort, Insertion Sort, Selection Sort and Merge Sort. The swaps are by value.
 * Unfortunately the merge sort and insertion sort are not completed due to the time constraints.
 * This implementation is inspired by Algorithms by Segwick
 */
public class LinkedList<T> {

    protected Node<T> head;
    protected int size;

    /**
     * constructor creates an empty list
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * @return int size is size of the list
     */
    public int size() {
        return size;
    }

    /**
     * @return head is the head of the linked list
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * @param value to add to the end of the list
     */
    public void add(T value) {
        head = addAtEnd(head, value);
        size++;
    }

    /* @param node in the location where to add the value
     * @param value to add to the end
     */
    private Node<T> addAtEnd(Node<T> node, T value) {
        if (node == null) {
            return new Node<T>(value, null);
        } else if (node.getNext() == null) {
            node.setNext(new Node<T>(value, null));
        } else {
            addAtEnd(node.getNext(), value);
        }
        return node;
    }

    private Node<T> getNode(int index) {
        Node<T> current = head;
        int count = 0;
        Node<T> temp;
        temp = null;

        while (current != null) {
            if (count == index) {
                return current;
            }
            count++;
            current = current.getNext();
        }
        return temp;
    }

    /*
     * @param position of item to be removed
     */
    public void remove(int position) {
        if ((position < 1) || (position > size)) {
            System.out.println("Invalid position.");
        }
        if (position == 1) {
            head = head.getNext();
        } else {
            Node<T> node = head;
            for (int i = 2; i < position; i++) {
                node = node.getNext();
            }

            node.setNext(node.getNext().getNext());
        }
        size--;
    }

    /*
    * @return a string of the stack
    */
    public String toString() {
        return toString(head);
    }

    /*
    * @return a string that is the entire list
    */
    private String toString(Node<T> node) {
        if (node == null) {
            return "";
        } else {
            return node.getValue() + " " + toString(node.getNext());
        }
    }

    /*
    * Implementation of the bubble sort. It iterates through the list and looks
    * at the values next to each other and swaps them based on the compareTo result
    * @param list to be sorted
    */
    public static <T extends Comparable<? super T>> void bubbleSort(LinkedList<T> list) {
        Node<T> node = list.getHead();
        T swap;
        int i;
        int j;

        for (i = 0; i < list.size(); i++) {
            for (j = 1; j < list.size() - i; j++) {
                if (node.getValue().compareTo(node.getNext().getValue()) > 0) {
                    swap = node.getNext().getValue();

                    node.getNext().setValue(node.getValue());
                    node.setValue(swap);
                }
                node = node.getNext();
            }
            node = list.getHead();
        }
    }

    /*
    * Implementation of the insertion sort. It iterates through the list and looks
    * at the values and swaps them.
    * @param list to be sorted
    */
    public static <T extends Comparable<? super T>> void insertionSort(LinkedList<T> list) {
        T swap;
        int i;
        int j;

        if (list.getHead() == null || list.getHead().getNext() == null) {
            return;
        }

        for (i= 1; i < list.size(); i++) {
            j = i;
            while (j > 0 && (list.getNode(j-1).getValue()).compareTo(list.getNode(j).getValue()) > 0) {

                swap = list.getNode(j).getValue();

                list.getNode(j).setValue(list.getNode(j-1).getValue());
                list.getNode(j-1).setValue(swap);

                j--;
            }
        }
    }

    /*
    * Implementation of the selection sort. It iterates through the list all the way while checking the value in the
    * list then doing the swap when the inner while loop is done.
    * @param list to be sorted
    */
    public static <T extends Comparable<? super T>> void selectionSort(LinkedList<T> list) {
        Node<T> start = list.getHead();
        Node<T> smallest;
        T swap;
        Node<T> node;

        while (start.getNext() != null) {
            smallest = start;
            node = start.getNext();
            while(node != null) {
                if (node.getValue().compareTo(smallest.getValue()) < 0) {
                    smallest = node;
                }
                node = node.getNext();
            }

            swap = smallest.getValue();

            smallest.setValue(start.getValue());
            start.setValue(swap);

            start = start.getNext();
        }

    }

    /*
    * Implementation of the merge sort. Unfortunately it is not finished and it is not implemented with the generics
    * mainly because when the swapping seemed too difficult I tried going to the basics, and then run out of time.
    * @param head of the node
    * @return Node of the sorted node
    */
    public Node mergeSort(Node head) {

        if (head == null || head.getNext() == null) {
            return head;
        }

        int count = 0;
        Node p = head;
        while (p.getNext() != null) {
            count++;
            p = p.getNext();
        }

        int middle = count / 2;
        Node l = head;
        Node r = null;
        Node temp = head;

        int half = 0;

        while (temp != null) {
            half++;
            Node next = temp.getNext();

            if (half == middle) {
                temp.setNext(null);
                r = next;
            }
            temp = next;
        }

        Node h1 = mergeSort(l);
        Node h2 = mergeSort(r);

        Node merged = mergeTwoLists(h1, h2);

        return merged;
    }

    public Node mergeTwoLists(Node l1, Node l2) {

        Node p1 = l1;
        Node p2 = l2;

        LinkedList mergeList = new LinkedList();
        LinkedList p = mergeList;

//        while (p1 != null && p2 != null) {
//            if (p2.getValue() > p1.getValue()) {
//                p.add(p1.getValue());
//                p1 = p1.getNext();
//            } else {
//                p.add(p2.getValue());
//                p2 = p2.getNext();
//            }
//
//        }

        while (p1 != null) {
            p.add(p1.getValue());
            p1 = p1.getNext();
        }
        while (p2 != null) {
            p.add(p2.getValue());
            p2 = p2.getNext();
        }

        return mergeList.head;
    }

}


/*
* Node class that has the methods to get information from the node
* setNext(), setValue(), getNext(), getValue()
*/
class Node<T> {
    private T item = null;
    private Node<T> nextNode = null;

    /*
    * constructs a node
    * @param item to be created
    * @param nextNode to be linked
    */
    public Node(T item, Node<T> nextNode) {
        this.item = item;
        this.nextNode = nextNode;
    }

    /*
    * @param next that sets the link to the next node
    */
    public void setNext(Node<T> next) {
        nextNode = next;
    }

    /*
    * @param item that sets the value of the item
    */
    public void setValue(T item) {
        this.item = item;
    }

    /*
    * @return nextNode the link to the next node
    */
    public Node<T> getNext() {
        return nextNode;
    }

    /*
    * @return T value of the node
    */
    public T getValue() {
        return item;
    }
}
