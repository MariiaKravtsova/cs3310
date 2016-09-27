/**
 * Doubly Linked List Data Structure
 * takes randomly generated number and creates doubly linked list
 * using bubble sort it sorts the linked list,
 * then deletes an element which is chosen based on the sorting order,
 * then inserts a new element of value 10
 */

public class LinkedListDS {

    Node head;
    Node tail;

    int size = 0;
    int counter = 0;


    // Constructor which assigns initializes head, tail and size
    public LinkedListDS() {
        head = null;
        tail = null;
        size = 0;
    }

    // Increments counter every time there is a number larger than 50
    public void incrementCounter() {
        counter++;
    }

    /**
    * Takes a value, in this case random number and adds a new node
    * @param value the value of the node to be created
    */
    public void add(int value) {

        Node newNode = new Node(value);

        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;

        size++;
    }

    /**
    * Takes a value and creates a node of it, then inserts it in
    * the sorted list of the ascending order
    * @param value to be inserted and
    * @param order that linked list is sorted in
    */
    public void insert(int value, String order) {
        Node nodeToInsert = new Node(value);
        Node temp;
        temp = head;
        int i;

        if (order.equals("increasing")) {
            if (nodeToInsert.value <= temp.value) {

                nodeToInsert.next = head;
                head.previous = nodeToInsert;
                head = nodeToInsert;

            }
            else if (nodeToInsert.value >= tail.value) {

                tail.next = nodeToInsert;
                nodeToInsert.previous = tail;
                tail = nodeToInsert;

            }
            else
            {
                while(!(nodeToInsert.value < temp.value)) {
                    if (temp.next != null) {
                        temp = temp.next;
                    }
                }
                nodeToInsert.next = temp;
                nodeToInsert.previous = temp.previous;
                temp.previous.next = nodeToInsert;
                temp.previous = nodeToInsert;
            }
        } else if (order.equals("decreasing")) {
            if (nodeToInsert.value >= temp.value) {

                nodeToInsert.next = head;
                head.previous = nodeToInsert;
                head = nodeToInsert;

            }
            else if (nodeToInsert.value <= tail.value) {

                tail.next = nodeToInsert;
                nodeToInsert.previous = tail;
                tail = nodeToInsert;

            }
            else
            {
                while(!(nodeToInsert.value > temp.value)) {
                    if (temp.next != null) {
                        temp = temp.next;
                    }
                }
                nodeToInsert.next = temp;
                nodeToInsert.previous = temp.previous;
                temp.previous.next = nodeToInsert;
                temp.previous = nodeToInsert;
            }
        }


        size++;

        System.out.print("Inserted 10 to Linked List: ");
        print();

    }

    /**
    * Takes a position of the node and moves the pointer until it finds it
    * then passes the index of that node to the delete method
    * @param position of the node to be deleted
    */
    public void find(int position) {
        int i;
        Node temp;

        temp = head;

        for (i = 1; i < position; i++) {
            temp = temp.next;
        }
        delete(temp);

    }

    /**
    * Removes the links pointed to this node and links the nodes appropriately
    * @param index that you would like to be deleted
    */
    public void delete(Node index) {
        if (size == 1) {
            head = null;
            tail = null;
        }
        else if (index == head) {
            head = index.next;
            index.previous = null;
        }
        else if (index == tail) {
            tail = tail.previous;
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

    // Traverses through the linked list and prints it
    public void print() {
        Node temp;
        temp = head;
        int i;

        for (i = 0; i < size; i++) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    /*
    * Traverses through the nodes
    * @param index The node to be traversed
    */
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

    /**
    * Takes in a string that specifies the sorting order
    * then sorts it using the bubble sort algorithm
    * element into swap method to handle comparisons appropriately
    * @param order The string that specifies the order
    */
     public void bubbleSort(String order) {
        int i;

        for (i = 0; i < size; i++ ) {

            for (int j = 0; j < size - 1; j++) {

                if (order.equals("decreasing")) {
                    if (traverseNode(j).value < traverseNode(j + 1).value) {
                        swap(j);
                    }
                }

                if (order.equals("increasing")) {
                    if (traverseNode(j).value > traverseNode(j + 1).value) {
                        swap(j);
                    }
                }
            }
        }

        System.out.print("Sorted Linked List: ");
        print();


    }

    /*
    * Swaps the adjacent elements of the bubble sort that are being compared
    * @param a To be swapped
    */
    public void swap(int a) {
        Node first = traverseNode(a);
        Node second = traverseNode(a + 1);
        Node something = new Node(traverseNode(a).value);

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


    /**
     * Provides the necessary values to the methods to satisfy
     * the condition of this assignment
     */
    public void logic() {
        String increasing = "increasing";
        String decreasing = "decreasing";

        System.out.print("Original Linked List: ");
        print();

        if (counter > 5) {
            bubbleSort(increasing);

            find(5);

            insert(10, increasing);

        } else {
           bubbleSort(decreasing);

            find(2);

            insert(10, decreasing);
        }

    }

}
