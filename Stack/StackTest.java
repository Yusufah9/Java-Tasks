import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private Stack myStack;
    @BeforeEach
    public void startWith(){
        myStack = new Stack();
    }
    @Test
    public void testThatStackIsEmpty() {
        assertTrue(myStack.isEmpty());
    }
    @Test
    public void testIPushXAndTheStackIsNotEmpty(){
        assertTrue(myStack.isEmpty());
        myStack.push("Yusuf");
        assertFalse(myStack.isEmpty());
    }
    @Test
    public void testIPushXAndPopTheStackIsEmpty(){
        assertTrue(myStack.isEmpty());
        myStack.push("Yusuf");
        assertFalse(myStack.isEmpty());
        myStack.pop();
        assertTrue(myStack.isEmpty());
    }
    @Test
    public void testIPushXYAndPopYX(){
        assertTrue(myStack.isEmpty());
        myStack.push("Yusuf");
        myStack.push("Umaru");
        assertFalse(myStack.isEmpty());

        assertFalse(myStack.isEmpty());
        assertEquals("Umaru", myStack.pop());
        assertEquals("Yusuf", myStack.pop());

    }
    @Test
    public void testPopEmptyStackThrowsException(){
        assertTrue(myStack.isEmpty());
        assertThrows(IllegalArgumentException.class,() -> myStack.pop());
    }
    @Test
    public void testPush3ElementsPeekToCheckTheLastElement(){
        assertTrue(myStack.isEmpty());
        myStack.push("Semicolon");
        myStack.push("Yusuf");
        myStack.push("Umaru");

        assertEquals("Opeyemi", myStack.peek());
    }
    @Test
    public void push3ElementsPop1PeekToCheckTheElementOnTop(){
        assertTrue(myStack.isEmpty());
        myStack.push("Umaru");
        myStack.push("Umaru");
        myStack.push("Yusuf");
        myStack.pop();
        assertEquals("Yaru", myStack.peek());
    }
    @Test
    public void peekAnEmptyStackThrowsException(){
        assertTrue(myStack.isEmpty());
        assertThrows(IllegalArgumentException.class,() -> myStack.peek());
    }
    @Test
    public void searchForXReturnsThePositionInStack(){
        assertTrue(myStack.isEmpty());
        myStack.push("Yaru");
        myStack.push("Umaru");
        myStack.push("YUsuf");

        assertEquals(1, myStack.search("Yusuf"));
    }
    @Test
    public void searchForYReturnsMinus1_YNotInTheStack(){
        assertTrue(myStack.isEmpty());
        myStack.push("  Umaru");
        myStack.push("Yusuf");

        assertEquals(-1, myStack.search("Ayodeji"));
    }
}
