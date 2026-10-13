


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    private Map myMap;

    @BeforeEach
    public void startWith() {
        myMap = new Map();
    }

    @Test
    public void testThatMapIsEmpty() {
        assertTrue(myMap.isEmpty());
    }

    @Test
    public void testThatIPutKeyAndValueAndRetrieveIt() {
        assertTrue(myMap.isEmpty());
        myMap.put("ID01", "Yusuf");
        assertFalse(myMap.isEmpty());
        assertEquals(1, myMap.size());
        assertEquals("Yusuf", myMap.get("ID01"));
    }

    @Test
    public void testThatIPutMultipleKeysAndValues() {
        myMap.put("ID01", "Yusuf");
        myMap.put("ID02", "Umaru");
        assertEquals(2, myMap.size());
        assertEquals("Umaru", myMap.get("ID02"));
    }

    @Test
    public void testThatPuttingExistingKeyUpdatesItsValue() {
        myMap.put("ID01", "Yusuf");
        myMap.put("ID01", "Fatima"); 
        assertEquals(1, myMap.size());
        assertEquals("Fatima", myMap.get("ID01"));
    }
}
