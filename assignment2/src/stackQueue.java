/**
 * Class that replicates Queue behavior of FIFO by using two stacks
 * enqueue() method a
 */
public class StackQueue<T> {

        private NewStack<T> stack1 = new NewStack<T>();
        private NewStack<T> stack2 = new NewStack<T>();

    /*
    * Enqueue method that add last item onto the stack1
    * */
    public void enqueue(T item) {
            stack1.push(item);
        }

    /*
    * Dequeue method that removes elements from stack1 and puts them onto stack2
    * @return stack2.pop() which is item to be removed
    * */
    public T dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return null;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    /*
    * Printing the stack2 that replicate dequeue behaviour
    * */
    public void printQueue() {
        System.out.println();
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.print();
    }
}
