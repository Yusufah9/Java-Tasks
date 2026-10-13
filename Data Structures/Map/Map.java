

public class Map {
    private String[] keys = new String[5];
    private String[] values = new String[5];
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(String key, String value) {
        for (int count = 0; count < size; count++) {
            if (keys[count].equals(key)) {
                values[count] = value; 
                return;
            }
        }
        if (size == keys.length) {
            throw new IllegalArgumentException("Map is full");
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    public String get(String key) {
        for (int count = 0; count < size; count++) {
            if (keys[count].equals(key)) {
                return values[count];
            }
        }
        return null;
    }

    public int size() {
        return size;
    }
}
