import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;

/**
 * <h1>CS 3310: Assignment 2</h1>
 * <h2>Professor Dr. Gupta</h2>
 *
 * Assignment includes implementation of stack - NewStack, implementation of queue - NewQueue
 * Implementation of stack using two queues - StackQueue, implementation of queue using two stacks - QueueStack
 * Implementation of a stack with current minimum value using two stacks - MinValueStack
 *
 * @author Mariia Kravtsova
 * @since 10-18-16
 *
 * Resources: Algorithms by Segwick, Stack Overflow
 */
public class Main {

    public static void main(String[] args) {

        StackQueue stackQueue = new StackQueue();

        QueueStack queueStack = new QueueStack();

        MinValueStack minValueStack = new MinValueStack();


        /*
        * Read the TestForStackAndQueue.txt file then enqueue, dequeue, push and pop
        */

        String line = "";
        Scanner scan= null;
        String[] split;
        int i = 0;
        String filename = "/Users/mkravtsova/Github/cs3310/assignment2/src/TestForStackAndQueue.txt";


        try {

            scan = new Scanner(new FileReader(filename));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNextLine()){

            line = scan.nextLine();

            split = line.split("\t");

            // Test enqueue
            for (i = 0; i < split.length; i++) {
                stackQueue.enqueue(split[i]);
            }
            System.out.print("Queue from Stacks enqueue:");
            stackQueue.printQueue();

            // Test dequeue
            for (i = 0; i < split.length; i++) {
                stackQueue.dequeue();
            }
            System.out.print("Queue from Stacks dequeue:");
            stackQueue.printQueue();

            // Test push
            for (i = 0; i < split.length; i++) {
                queueStack.push(split[i]);
            }
            System.out.print("Stack from Queues push:");
            queueStack.printStack();

            // Test pop
            for (i = 0; i < split.length; i++) {
                queueStack.pop();
            }
            System.out.print("Stack from Queues pop:");
            queueStack.printStack();
        }

    }


}
