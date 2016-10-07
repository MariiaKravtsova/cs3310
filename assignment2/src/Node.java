/**
 * Created by mkravtsova on 10/7/16.
 */

public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * A constructor
     * @param dataValue object that includes value of the node
     */
    public Node(T dataValue){
        this.next = null;
        this.data = dataValue;
    }

    /**
     * A method to return data of the node of type of E
     * @return data object that is stored in the Node
     */
    public T getData() {
        return data;
    }

    /**
     * A method to return the next node to current node
     * @return next as an object of the next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * A method to set the value passed as next node
     * @param nextValue object that is the value to be stored into next
     */
    public void setNext(Node<T> nextValue) {
        next = nextValue;
    }
}
