/**
 * Class that replicates Queue behavior of FIFO by using two stacks
 * enqueue() method a
 */
public class StackQueue<T> {
        private NewStack<T> stack1 = new NewStack<T>();
        private NewStack<T> stack2 = new NewStack<T>();


    public void enqueue(T object) {
            stack1.push(object);
        }

    /*
    *
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
    *
    * */
    public void printQueue() {
        System.out.println(" ");
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
