

package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private ArrayList list;

    @BeforeEach
    public void startWith() {
        list = new ArrayList();
    }

    @Test
    public void testThatTheArrayListIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testThatICan_AddA_NumbertoTheList() {
        assertTrue(list.isEmpty());
        list.add(5);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testThatICan_Add_TwoNumberstoTheList() {
        assertTrue(list.isEmpty());
        list.add(5);
        list.add(7);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testThatTheListCanStillAddA_Head_To_IncreaseTheSizeOfTheArrayList() {
        assertTrue(list.isEmpty());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add("head");
        list.add(11);
        list.add(12);
        list.add(13);
        assertEquals(13, list.size());
    }

    @Test
    public void testThatANumber_CanBeRemoveAtAnIndeOfTheList() {
        assertTrue(list.isEmpty());
        list.add(12);
        list.add(22);
        list.add(31);
        list.add(42);
        list.add(10);
        list.add(24);
        list.add(21);
        list.add(43);
        list.remove(3);
        assertEquals(7, list.size());
    }

    @Test
    public void testThatIRemoveAtIndexAndTheListShrinks() {
        assertTrue(list.isEmpty());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        assertEquals(13, list.size());
        list.remove(4);
        list.remove(3);
        list.remove(9);
        list.remove(6);
        assertEquals(9, list.size());
    }

    @Test
    public void testThatIRemoveFromEmptyList() {
        assertTrue(list.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> list.remove(2));
    }

    @Test
    public void testIGetXFromItsIndex() {
        assertTrue(list.isEmpty());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(3, list.get(2));
    }

    @Test
    public void testThatICan_RemoveAllTheValuesThatIhave() {
        assertTrue(list.isEmpty());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.removeAll();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testThatIcan_RemoveFromTheEmptyList() {
        assertTrue(list.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> list.removeAll());
    }
}
