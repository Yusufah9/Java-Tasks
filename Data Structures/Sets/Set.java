

public class Set {
    private Object[] elements = new Object[5];
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(Object element) {
        if (contains(element)) {
            return false;
        }
        if (size == elements.length) {
            throw new IllegalArgumentException("Set is full");
        }
        elements[size++] = element;
        return true;
    }

    public boolean contains(Object element) {
        for (int count = 0; count < size; count++) {
            if (elements[count].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
}
