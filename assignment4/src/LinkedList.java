/**
 *
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
     * @return Node<T> head is the head of the linked list
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

    /* @param	node of the list to which the value should be added
     * @param	value to add to the end of the list
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

    /* iterative implementation of the same method
     * @param	value to add to the end of the list
     */
    public void add2(T value) {
        if (head == null) {
            head = new Node<T>(value, null);
        } else {
            Node<T> node = head;

            while (node.getNext() != null) {
                node = node.getNext();
            }

            node.setNext(new Node<T>(value, null));
        }
        size++;
    }

    /*
     * @param	position of item to be removed
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

    /* convert the list to a printable string
    * @return a string representing the stack
    */
    public String toString() {
        return toString(head);
    }

    private String toString(Node<T> node) {
        if (node == null) {
            return "";
        } else {
            return node.getValue() + toString(node.getNext());
        }
    }

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

    public static <T extends Comparable<? super T>> void selectionSort(LinkedList<T> list) {
        Node<T> node = list.getHead();
        T smallest;
        int i;
        int j;

        for (i = 0; i < list.size() - 1 ; i++) {
            smallest = node.getValue();

            for (j = i + 1; j < list.size(); j++) {
                if (node.getValue().compareTo(smallest) < 0) {
                    smallest = node.getNext().getValue();
                }
            }

            
        }

    }
}



class Node<T> {
    private T item = null;
    private Node<T> nextNode = null;

    public Node(T item, Node<T> nextNode) {
        this.item = item;
        this.nextNode = nextNode;
    }

    public void setNext(Node<T> next) {
        nextNode = next;
    }

    public void setValue(T item) {
        this.item = item;
    }

    public Node<T> getNext() {
        return nextNode;
    }

    public T getValue() {
        return item;
    }
}
