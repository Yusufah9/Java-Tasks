

public class LinkedList {
    private Node head;
    private int size;

    private static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        Node current = head;
        for (int count = 0; count < index; count++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }
}
