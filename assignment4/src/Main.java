public class Main {

    public static void main(String[] args) {

        AddArrayList<String> addArrayList = new AddArrayList<String>();
        AddLinkedList<String> addLinkedList = new AddLinkedList<String>();

        addArrayList.add("a");
        addArrayList.add("c");
        addArrayList.add("b");
        addArrayList.add("d");
        addArrayList.add("e");
        addArrayList.add("f");
        addArrayList.add("g");

        for (int i = 0; i < addArrayList.getSize(); i++) {
            System.out.print(addArrayList.get(i) + " ");
        }

        addLinkedList.add("a");
        addLinkedList.add("c");
        addLinkedList.add("b");
        addLinkedList.add("d");
        addLinkedList.add("e");
        addLinkedList.add("f");
        addLinkedList.add("g");

        System.out.print("\n" + addLinkedList.nodeToString());

    }
}
