/**
 * Created by mkravtsova on 10/4/16.
 */
public class Main {

    public static void main(String[] args) {

        ImplementedLinkedList<Integer> implementedLinkedList = new ImplementedLinkedList<Integer>();

        implementedLinkedList.add(5, 1);
        implementedLinkedList.add(8, 2);
        implementedLinkedList.add(4, 3);

        implementedLinkedList.printList();
    }

}
