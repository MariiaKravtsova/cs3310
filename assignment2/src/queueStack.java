/**
 * Created by mkravtsova on 10/15/16.
 */
public class queueStack<T> {
    private newQueue<T> queue1 = new newQueue<T>();
    private newQueue<T> queue2 = new newQueue<T>();

    T top;

    public void push(T item){
        queue1.enqueue(item);
        top = item;

        queue1.print();
    }

    public void pop() {

        newQueue<T> temp = queue1;

        while (queue1.getSize() > 1) {
            top = queue1.dequeue();
            queue2.enqueue(top);
        }
        queue1.dequeue();

        queue1 = queue2;
        queue2 = temp;
        
    }

    public void printStack() {
        System.out.println(" ");
        queue2.print();

    }
}
