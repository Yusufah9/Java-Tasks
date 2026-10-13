
public class Queue {
    private int count;
    private int headOfArray = 0;
    private String[] names = new String[5];

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean add(String element) {
        if (count == names.length) {
            throw new IllegalArgumentException("Queue is full");
        }
        names[count++] = element;
        return true;
    }

    public String element() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is Empty");
        }
        return names[headOfArray];
    }

    public boolean offer(String element) {
        if (count == names.length) {
            return false;
        }
        names[count++] = element;
        return true;
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return names[headOfArray];
    }

    public String poll() {
        if (isEmpty()) {
            return null;
        }
        String element = names[headOfArray];
        names[headOfArray] = null; 
        headOfArray++;
        count--;
        return element;
    }

    public String remove() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty Queue");
        }
        String element = names[headOfArray];
        names[headOfArray] = null; 
        headOfArray++;
        count--;
        return element;
    }
}
