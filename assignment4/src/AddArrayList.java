import java.util.Arrays;

/**
 * Created by mkravtsova on 11/6/16.
 */

public class AddArrayList<E> {
    private int size = 0;
    private Object elements[];
    private static final int MINIMUM_SIZE = 5;

    public AddArrayList() {
        elements = new Object[MINIMUM_SIZE];
    }

    public void add(E element) {
        int newSize;
        if (size == elements.length) {
            newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }

        elements[size++] = element;

    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        } else {
            return (E) elements[index];
        }
    }

    public int getSize() {
        return size;
    }

}
