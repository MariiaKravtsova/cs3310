/**
 * Created by mkravtsova on 10/4/16.
 */
public class ImplementedLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * A Constructor to initialize variables head, tail, size
     */
    public ImplementedLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public Node<T> getNode(int index) {

        Node<T> temp = head;
        int i;

        if (index > size || index < 0) {
            System.out.println("Index is out of bound.");
            return null;
        } else {

            for (i = 0; i < index; i++) {
                temp = temp.getNext();
            }

        }

        return temp;
    }

    public void add(T data, int index) {

        Node<T> temp = new Node<T>(data);
        Node<T> previous = getNode(index-2);

        if ((index - 1) > size || index <= 0) {
            System.out.println("Index out of bound.");
            return;
        }
        if (index == 1) {
            temp.setNext(head);
            head = temp;
        } else {
            temp.setNext(previous.getNext());
            previous.setNext(temp);
            if ((index - 1) == size) {
                tail = temp;
            }
        }

        size++;
    }

    public String printList() {
        String result = "";
        int i;

        for (i=0; i < size; i++) {
            result += "Node (" + (i+1) + ") : " + getNode(i).getData() + "\n";
        }

        return result;
     }

}
