/**
 * Created by mkravtsova on 11/6/16.
 */

class Node<E> {
    E data;
    Node<E> next = null;

    public Node() {
        this.data = null;
        this.next = null;
    }

    public Node (E data) {
        this.data = data;
        this.next = null;
    }

}

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;



    LinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void add(E data) {
        Node<E> node = new Node<E>(data);

        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            tail.next = node;
            this.tail = tail.next;
        }
        size++;
    }

    public Node<E> get(int index) {
        Node<E> node = head;
        int i;

        for (i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    public int getSize() {
        return size;
    }

    public String nodeToString() {
        StringBuilder sb = new StringBuilder();
        Node p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString() + " ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        return sb.toString();
    }
}
