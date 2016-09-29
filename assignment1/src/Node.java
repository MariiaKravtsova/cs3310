/**
 * Node class to create a node with next, previous and value
 */
public class Node {

    Node next;
    Node previous;
    int value;

    /**
     * Constructor for Node
     * @param value The value of the node we are passing in
     */
    public Node(int value) {
        this.value = value;

    }

    // Initialize my values in the constructor
    public Node(){
        value = 0;
        next = null;
        previous = null;
    }

}

