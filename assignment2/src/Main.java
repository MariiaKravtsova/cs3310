import java.io.BufferedReader;

/**
 * Created by mkravtsova on 10/4/16.
 */
public class Main {

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();

        QueueStack queueStack = new QueueStack();

        String s = "Borsch";
        System.out.println(s.compareTo("Borsch"));

        //BufferedReader br = new BufferedReader(new FileReader("file.txt"));

        stackQueue.enqueue(2);
        stackQueue.enqueue(4);
        stackQueue.enqueue(7);

        stackQueue.dequeue();


        stackQueue.printQueue();

        queueStack.push(3);
        queueStack.push(6);
        queueStack.push(1);
        queueStack.push("go");

        queueStack.printStack();

        queueStack.pop();




        queueStack.printStack();
    }

}
