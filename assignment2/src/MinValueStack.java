
public class MinValueStack<T> {
    private NewStack<T> stack = new NewStack<T>();
    private Comparable<T> item;

    private int size = 0;

    private T minValue;



    public T getMinValue() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        }
        return minValue;
    }

    /*
    * Push method that takes in an item of type T to add to the stack
    * as last in item, by using a temp node as head, and increments
    * variable size each time
    * */
    public void push(Comparable<T> item) {

        if (stack.isEmpty() || (item.compareTo(minValue) < 0)) {

        }

        size++;
    }

    /*
    * Pop method that removes last item from the stack
    * Decrements size variable each time
    * @return item that was removed
    * */
    public Comparable<T> pop() {


        size--;

        return item;
    }


    /*
    * Print method that traverses the list using a node current
    * */
    public void print() {

    }
}
