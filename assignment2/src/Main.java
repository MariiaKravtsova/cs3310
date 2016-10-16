/**
 * Created by mkravtsova on 10/4/16.
 */
public class Main {

    public static void main(String[] args) {
        stackQueue stackQueue = new stackQueue();

        queueStack queueStack = new queueStack();

        stackQueue.enqueue(2);
        stackQueue.enqueue(4);
        stackQueue.enqueue(7);
        stackQueue.enqueue(7);
        stackQueue.enqueue(7);
        stackQueue.enqueue(7);

        stackQueue.printQueue();

        queueStack.push(3);
        queueStack.push(6);
        queueStack.push(1);
        queueStack.push(5);

        queueStack.printStack();

    }

}
