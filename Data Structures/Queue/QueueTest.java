package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    private Queue myQueue;
    
    @BeforeEach
    public void startWith(){
        myQueue = new Queue();
    }

    @Test
    public void testThatQueueDontHaveAnyElements() {
        assertTrue(myQueue.isEmpty());
    }

    @Test
    public void testThatIAddedAStringAndQueueIsNotEmpty(){
        assertTrue(myQueue.isEmpty());
        myQueue.add("Yusuf");
        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void testThatTheAddedQueueReturnsThatA_valueExists(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add("Yusuf"));
        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void testThatIAddedTwoStringsInTheQueue(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add("Yusuf"));
        assertFalse(myQueue.isEmpty());
        assertTrue(myQueue.add("Umaru"));
    }

    @Test
    public void testThatIAddedThreeStringsInTheQueue(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add("Yusuf"));
        assertFalse(myQueue.isEmpty());
        assertTrue(myQueue.add("Umaru"));
        assertTrue(myQueue.add("Yaru"));
    }

    @Test
    public void testThatIAddedFiveStringsInFormOfNamesInTheQueue(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add("Yusuf"));
        assertFalse(myQueue.isEmpty());
        assertTrue(myQueue.add("Umaru"));
        assertTrue(myQueue.add("Yaru"));
        assertTrue(myQueue.add("Ali"));
        assertTrue(myQueue.add("Fatima"));
    }

    @Test
    public void testThatIAddedFiveStringsInTheQueueAndTheListIsFull_AndICannotAddAnother(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add("Yusuf"));
        assertFalse(myQueue.isEmpty());
        assertTrue(myQueue.add("Umaru"));
        assertTrue(myQueue.add("Yaru"));
        assertTrue(myQueue.add("Ali"));
        assertTrue(myQueue.add("Fatima"));
        assertThrows(IllegalArgumentException.class,() -> myQueue.add("Zayd"));
    }

    @Test
    public void testThatIAddedTwoStringsAndRetrievesTheFirstOne(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add("Yusuf"));
        assertFalse(myQueue.isEmpty());
        assertTrue(myQueue.add("Umaru"));
        assertEquals(myQueue.element(), "Yusuf");
    }

    @Test
    public void testThatRetrievingAnElementFromEmptyQueueThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> myQueue.element());
    }

    @Test
    public void testThatIAddAStringUsingOfferAndQueueIsNotEmpty(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.offer("Yusuf"));
        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void testThatIAddTwoStringsUsingOfferAndQueueIsNotEmpty(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.offer("Yusuf"));
        assertTrue(myQueue.offer("Umaru"));
        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void testThatQueueIsFullUsingOfferAndReturnsFalseForExtraAddition(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.offer("Yusuf"));
        assertTrue(myQueue.offer("Umaru"));
        assertTrue(myQueue.offer("Yaru"));
        assertTrue(myQueue.offer("Ali"));
        assertTrue(myQueue.offer("Fatima"));
        assertFalse(myQueue.offer("Zayd"));
    }

    @Test
    public void testThatIAddTwoStringsUsingAddAndThirdUsingOffer(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add("Yusuf"));
        assertTrue(myQueue.add("Umaru"));
        assertTrue(myQueue.offer("Yaru"));
        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void testThatQueueFullUsingOfferThrowsExceptionWhenAddingWithAdd(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.offer("Yusuf"));
        assertTrue(myQueue.offer("Umaru"));
        assertTrue(myQueue.offer("Yaru"));
        assertTrue(myQueue.offer("Ali"));
        assertTrue(myQueue.offer("Fatima"));
        assertThrows(IllegalArgumentException.class,() -> myQueue.add("Zayd"));
    }

    @Test
    public void testThatQueueFullUsingMixedOfferAndAddThrowsExceptionOnOverflow(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.offer("Yusuf"));
        assertTrue(myQueue.add("Umaru"));
        assertTrue(myQueue.offer("Yaru"));
        assertTrue(myQueue.add("Ali"));
        assertTrue(myQueue.offer("Fatima"));
        assertThrows(IllegalArgumentException.class,() -> myQueue.add("Zayd"));
    }

    @Test
    public void testThatPeekRetrievesTheFirstElementWithoutRemovingIt(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.offer("Yusuf"));
        assertTrue(myQueue.add("Umaru"));
        assertTrue(myQueue.offer("Yaru"));

        assertEquals(myQueue.peek(), "Yusuf");
    }

    @Test
    public void testThatPeekingAnEmptyQueueReturnsNull(){
        assertTrue(myQueue.isEmpty());
        assertNull(myQueue.peek());
    }

    @Test
    public void testThatPollRetrievesAndRemovesTheFirstElement(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add("Yusuf"));
        assertTrue(myQueue.add("Umaru"));
        assertFalse(myQueue.isEmpty());
        assertEquals(myQueue.poll(), "Yusuf");
    }

    @Test
    public void testThatPollRetrievesAndRemovesMultipleElementsInOrder(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add("Yusuf"));
        assertTrue(myQueue.add("Umaru"));
        assertTrue(myQueue.add("Yaru"));
        assertFalse(myQueue.isEmpty());
        assertEquals(myQueue.poll(), "Yusuf");
        assertEquals(myQueue.poll(), "Umaru");
    }

    @Test
    public void testThatPollingAnEmptyQueueReturnsNull(){
        assertTrue(myQueue.isEmpty());
        assertNull(myQueue.poll());
    }

    @Test
    public void testThatRemoveRetrievesAndRemovesAnElement(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.add("Yusuf"));
        assertEquals(myQueue.remove(), "Yusuf");
    }

    @Test
    public void testThatRemovingFromAFullQueueExhaustsAllElementsAndThrowsExceptionWhenEmpty(){
        assertTrue(myQueue.isEmpty());
        assertTrue(myQueue.offer("Yusuf"));
        assertTrue(myQueue.offer("Umaru"));
        assertTrue(myQueue.offer("Yaru"));
        assertTrue(myQueue.offer("Ali"));
        assertTrue(myQueue.offer("Fatima"));
        assertEquals(myQueue.remove(), "Yusuf");
        assertEquals(myQueue.remove(), "Umaru");
        assertEquals(myQueue.remove(), "Yaru");
        assertEquals(myQueue.remove(), "Ali");
        assertEquals(myQueue.remove(), "Fatima");
        assertThrows(IllegalArgumentException.class,() -> myQueue.remove());
    }
}
