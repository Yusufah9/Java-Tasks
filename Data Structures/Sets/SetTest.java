

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set mySet;

    @BeforeEach
    public void startWith() {
        mySet = new Set();
    }

    @Test
    public void testThatSetIsEmpty() {
        assertTrue(mySet.isEmpty());
    }

    @Test
    public void testThatIAddElementReturnsTrue() {
        assertTrue(mySet.isEmpty());
        assertTrue(mySet.add("Yusuf"));
        assertFalse(mySet.isEmpty());
        assertEquals(1, mySet.size());
    }

    @Test
    public void testThatAddingDuplicateElementReturnsFalseAndDoesNotIncreaseSize() {
        assertTrue(mySet.add("Yusuf"));
        assertFalse(mySet.add("Yusuf"));
        assertEquals(1, mySet.size());
    }

    @Test
    public void testThatSetContainsExistingElement() {
        mySet.add("Umaru");
        assertTrue(mySet.contains("Umaru"));
        assertFalse(mySet.contains("Yaru"));
    }
}
