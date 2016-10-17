/**
 * Class NewStack using generics, that creates a node item with pointer next
 * methods include boolean isEmpty(), push() that takes node to insert lasts in
 * pop() that deletes node last out, peek that checks the top
 * print() that prints the current node
 */
public class NewStack<T> {

    private Node<T> head = null;
    private int size = 0;

    /*
    * Constructs node type T, with item and next
    * */
    private class Node<T> {
        T item;
        Node<T> next;
    }

    /*
    * @return boolean value that checks if stack is empty
    * */
    public boolean isEmpty() {
        return head == null;
    }

    /*
    * Push method that takes in an item of type T to add to the stack
    * as last in item, by using a temp node as head, and increments
    * variable size each time
    * @param item of type T to add last in the stack
    * */
    public void push(T item) {

        Node<T> temp = head;
        head = new Node<T>();

        head.item = item;
        head.next = temp;

        size++;
    }

    /*
    * Pop method that removes last item from the stack
    * Decrements size variable each time
    * @return item that was removed
    * */
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        }
        T item = head.item;
        head = head.next;

        size--;

        return item;
    }

    /*
    * Peek method that returns the top item in the stack
    * @return top item in the stack
    * */
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        }
        return head.item;
    }

    /*
    * Print method that traverses the list using a node current
    * */
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.item);
            current = current.next;
        }
    }
}
