/**
 * Class that implements a queue of generics type T
 * methods include: isEmpty() that checks if the queue is empty
 * enqueue() takes in the node item to be add as first in
 * dequeue() removes first node item, getSize() returns the size of the queue
 * print() traverses through the queue with current
 */
public class NewQueue<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    /**
    * Construct Node of type T with item and next
    */
    private class Node<T> {
        T item;
        Node<T> next;
    }

    /**
    * @return boolean value if queue is empty
    */
    public boolean isEmpty() {
        return head == null;
    }

    /**
    * @param item of type T to be inserted first
    */
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

    /**
    * Remove first item from the queue and return item
    * @return item that is dequeued
    */
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }

        T item = head.item;
        head = head.next;

        size--;

        return item;
    }

    /**
    * @return size of the queue
    */
    public int getSize () {
        return size;
    }

    /**
    * Traverse through the queue using a current node
    */
    public void print() {
        System.out.println(" ");
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.item);
            current = current.next;
        }
    }
}
