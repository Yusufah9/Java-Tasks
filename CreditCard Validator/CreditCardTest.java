import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CreditCardTest {

    @Test
    public void testConstructorAndGetters() {
        CreditCard card = new CreditCard("4388576018402626");
        assertEquals("4388576018402626", card.getCardNumber());
        assertEquals(16, card.getCardLength());
        assertEquals("Visa Cards", card.getCardType());
        assertArrayEquals(new int[]{4, 3, 8, 8, 5, 7, 6, 0, 1, 8, 4, 0, 2, 6, 2, 6}, card.getCardDigits());
    }

    @Test
    public void testSetterUpdatesArrayAndType() {
        CreditCard card = new CreditCard("4388576018402626");
        card.setCardNumber("5399831619698483");
        assertEquals("5399831619698483", card.getCardNumber());
        assertEquals("MasterCard", card.getCardType());
        assertArrayEquals(new int[]{5, 3, 9, 9, 8, 3, 1, 6, 1, 9, 6, 9, 8, 4, 8, 3}, card.getCardDigits());
    }

    @Test
    public void testCalculateDoubleEvenPlaces() {
        CreditCard card = new CreditCard("4388576018402626");
        assertEquals(37, card.calculateDoubleEvenPlaces());
    }

    @Test
    public void testCalculateOddPlaces() {
        CreditCard card = new CreditCard("4388576018402626");
        assertEquals(38, card.calculateOddPlaces());
    }

    @Test
    public void testIsValid() {
        CreditCard invalidCard = new CreditCard("4388576018402626");
        assertFalse(invalidCard.isValid());
        assertEquals("Invalid", invalidCard.getValidityStatus());

        CreditCard validCard = new CreditCard("4388576018410707");
        assertTrue(validCard.isValid());
        assertEquals("Valid", validCard.getValidityStatus());
    }
}
