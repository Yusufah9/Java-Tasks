

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private LinkedList myList;

    @BeforeEach
    public void startWith() {
        myList = new LinkedList();
    }

    @Test
    public void testThatLinkedListIsEmpty() {
        assertTrue(myList.isEmpty());
    }

    @Test
    public void testThatIAddAnElementAndListIsNotEmpty() {
        assertTrue(myList.isEmpty());
        myList.add("Yusuf");
        assertFalse(myList.isEmpty());
        assertEquals(1, myList.size());
    }

    @Test
    public void testThatIAddMultipleElementsAndGetThemByIndex() {
        myList.add("Yusuf");
        myList.add("Umaru");
        myList.add("Yaru");

        assertEquals(3, myList.size());
        assertEquals("Yusuf", myList.get(0));
        assertEquals("Umaru", myList.get(1));
        assertEquals("Yaru", myList.get(2));
    }

    @Test
    public void testGetInvalidIndexThrowsException() {
        myList.add("Yusuf");
        assertThrows(IllegalArgumentException.class, () -> myList.get(5));
    }
}
