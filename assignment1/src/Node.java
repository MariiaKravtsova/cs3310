/**
 * Created by mkravtsova on 9/24/16.
 */
public class Node {

    Node next;
    Node previous;
    int value;

    // Constructor
    public Node(int value) {
        this.value = value;

    }

    public Node(){
        value = 0;
        next = null;
        previous = null;
    }

}

