/**
 * Created by mkravtsova on 10/15/16.
 */
public class newStack<T> {

    private Node<T> head = null;
    private int size = 0;

    private class Node<T> {
        T item;
        Node<T> next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T item) {
        Node<T> temp = head;
        head = new Node<T>();
        head.item = item;
        head.next = temp;

        size++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        }
        T item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        }
        return head.item;
    }

    public void print() {
        Node<T> cur = head;
        while (cur != null) {
            System.out.print(cur.item);
            cur = cur.next;
        }
    }
}
