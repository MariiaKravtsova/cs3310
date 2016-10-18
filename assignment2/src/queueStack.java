/**
 * Class creates queue1 and queue2 from NewQueue
 * then it replicates the LIFO behavior of a Stack
 * by using methods push and pop
 */
public class QueueStack<T> {
    private NewQueue<T> queue1 = new NewQueue<T>();
    private NewQueue<T> queue2 = new NewQueue<T>();

    T top;

    /*
    * @param item of type T that adds the node to the stack which is a queue1
    * */
    public void push(T item){
        queue1.enqueue(item);
        top = item;
    }

    /*
    * Pop method that removes item from queue1
    * then puts the item to the queue2 and then swaps
    * queue2 with queue1
    * */
    public void pop() {

        NewQueue<T> temp = queue1;

        while (queue1.getSize() > 1) {
            top = queue1.dequeue();
            queue2.enqueue(top);
        }

        queue1.dequeue();

        queue1 = queue2;
        queue2 = temp;

    }

    /*
    * Print queue1 which mirrors the behaviour of a stack
    * */
    public void printStack() {

        if (queue1.isEmpty()){
            System.out.println("Stack is empty.");
        }
        queue1.print();

    }
}
