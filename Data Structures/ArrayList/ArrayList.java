

package tdd;

public class ArrayList {
    private int elementCount;
    private Object[] elementData = new Object[10];

    public boolean isEmpty() {
        return elementCount == 0;
    }

    public void add(Object element) {
        if (elementCount == elementData.length) {
            grow();
        }
        elementData[elementCount++] = element;
    }

    public int size() {
        return elementCount;
    }

    public void remove(int givenIndex) {
        if (givenIndex < 0 || givenIndex >= elementCount) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        for (int index = givenIndex; index < elementCount - 1; index++) {
            elementData[index] = elementData[index + 1];
        }
        elementData[elementCount - 1] = null;
        elementCount--;
    }

    public Object get(int index) {
        if (index < 0 || index >= elementCount) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return elementData[index];
    }

    public void removeAll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("List is already empty");
        }
        for (int index = 0; index < elementCount; index++) {
            elementData[index] = null;
        }
        elementCount = 0;
    }

    private void grow() {
        Object[] temporaryStorage = elementData;
        elementData = new Object[elementData.length + (elementData.length / 2)];
        for (int index = 0; index < temporaryStorage.length; index++) {
            elementData[index] = temporaryStorage[index];
        }
    }
}
