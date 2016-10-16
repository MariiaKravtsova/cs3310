/**
 * Created by mkravtsova on 10/15/16.
 */
public class newQueue<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    private class Node<T> {
        T item;
        Node<T> next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T item) {
        Node<T> temp = tail;
        tail = new Node<T>();
        tail.item = item;
        tail.next = null;

        if (isEmpty()) {
            head = tail;
        } else {
            temp.next = tail;
        }

        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }

        T item = head.item;
        head = head.next;

        size--;

        return item;
    }

    public int getSize () {
        return size;
    }

    public void print() {
        System.out.println(" ");
        Node<T> cur = head;
        while (cur != null) {
            System.out.print(cur.item);
            cur = cur.next;
        }
    }
}
