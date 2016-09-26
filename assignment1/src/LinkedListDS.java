/**
 * Created by mkravtsova on 9/24/16.
 */
public class LinkedListDS {

    Node head;
    Node tail;
    Node temp;
    int size = 0;
    int counter = 0;


    // Constructor
    public LinkedListDS() {
        head = null;
    }

    public void incrementCounter() {
        counter++;
    }

    public void add(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;

        size++;
    }

//    public void insert(int item) {
//        Node newNode = new Node(item);
//        boolean found = false;
//
//        tail = null;
//        temp = head;
//
//        while(temp != null && !found) {
//            if (temp.value > item) {
//                found = true;
//            } else {
//                tail = temp;
//                temp = temp.next;
//            }
//        }
//
//        newNode.next = temp;
//
//        if (tail == null) {
//            head = newNode;
//            size++;
//        }
//        else {
//            tail.next = newNode;
//            size++;
//        }
//        System.out.print("Insert 10 to Linked List: ");
//        print();
//    }

    public void insert(int value) {
        Node nodeToInsert = new Node(value);
        Node something;
        something = head;
        int i;

        if (nodeToInsert.getValue() <= head.value) {
            nodeToInsert.next = head;
            head.previous = nodeToInsert;
            head = nodeToInsert;
        }
        else if (nodeToInsert.getValue() => tail.value) {

        }
        for (i = 0; i < size; i++) {
            if (something.getValue() <= nodeToInsert.getValue()) {
                something.previous = nodeToInsert;
                nodeToInsert.next = something;
                something.previous.next = something;
                something = something.next;
            }
        }

    }

    public void find(int position) {
        int i;
        Node something;

        something = head;

        for (i = 1; i < position; i++) {
            something = something.next;
        }
        delete(something);

    }

    public void delete(Node index) {
        if (index == head) {
            head = index.next;
            index.previous = null;
        }
        else if (index == tail) {
            tail = index.previous;
            tail.next = null;
            index.previous = null;
        } else {
            index.previous.next = index.next;
            index.next.previous = index.previous;
            index.previous = null;
            index.next = null;
        }
        size--;

        System.out.print("Deleted element Linked List: ");
        print();
    }

    public void print() {
        temp = head;

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node traverseNode(int index) {
        Node something;

        something = head;
        int i;

        if (index == 0) {
            return something;
        } else if (index == size-1) {
            something = tail;
            return something;
        } else {
            for (i = 0; i < index; i++) {
                something = something.next;
            }
            return something;
        }

    }



    public void bubbleSort(String order) {
        int i;

        for (i = 0; i < size; i++ ) {

            for (int j = 0; j < size - 1; j++) {

                if (order.equals("decreasing")) {
                    if (traverseNode(j).getValue() < traverseNode(j + 1).getValue()) {
                        swap(j);
                    }
                }

                if (order.equals("increasing")) {
                    if (traverseNode(j).getValue() > traverseNode(j + 1).getValue()) {
                        swap(j);
                    }
                }
            }
        }


    }

    public void swap(int a) {
        Node first = traverseNode(a);
        Node second = traverseNode(a + 1);
        Node something = new Node(traverseNode(a).getValue());

        something.previous = first.previous;
        something.next = first.next;

        first.previous = second;
        first.next = second.next;

        second.previous = something.previous;
        second.next = first;

        if (second.previous == null) {
            head = second;
        } else  {
            second.previous.next = second;
        }
        if (first.next == null) {
            tail = first;
        } else {
            first.next.previous = first;
        }
    }



    public void logic() {
        String increasing = "increasing";
        String decreasing = "decreasing";

        System.out.print("Original Linked List: ");
        print();

        if (counter > 5) {
            bubbleSort(increasing);

            find(5);

        } else {
           bubbleSort(decreasing);

            find(2);

        }

        System.out.print("Sorted Linked List: ");
        print();

        //insert(10);

    }

}
