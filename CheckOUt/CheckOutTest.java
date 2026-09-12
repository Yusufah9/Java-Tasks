import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckOutTest {

    @Test
    public void testThatICalculateSubTotal() {
        String[] items = {"Parfait", "Rice"};
        double[] prices = {2100.0, 550.0};
        int[] quantities = {2, 2};

        CheckOut checkOut = new CheckOut(items, prices, quantities);

        double expectedSubTotal = 5300.0;
        double actualSubTotal = checkOut.calculateSubTotal();

        assertEquals(expectedSubTotal, actualSubTotal, 0.001);
    }

    @Test
    public void testCalculateDiscount() {
        String[] items = {"Parfait", "Rice"};
        double[] prices = {2100.0, 550.0};
        int[] quantities = {2, 2};

        CheckOut checkOut = new CheckOut(items, prices, quantities);

        double expectedDiscount = 424.0;
        double actualDiscount = checkOut.calculateDiscount(8.0);

        assertEquals(expectedDiscount, actualDiscount, 0.001);
    }

    @Test
    public void testCalculateVAT() {
        String[] items = {"Parfait", "Rice"};
        double[] prices = {2100.0, 550.0};
        int[] quantities = {2, 2};

        CheckOut checkOut = new CheckOut(items, prices, quantities);

        double expectedVAT = 397.5;
        double actualVAT = checkOut.calculateVAT();

        assertEquals(expectedVAT, actualVAT, 0.001);
    }

    @Test
    public void testCalculateBillTotal() {
        String[] items = {"Parfait", "Rice"};
        double[] prices = {2100.0, 550.0};
        int[] quantities = {2, 2};

        CheckOut checkOut = new CheckOut(items, prices, quantities);

        double expectedBillTotal = 5273.5;
        double actualBillTotal = checkOut.calculateBillTotal(8.0);

        assertEquals(expectedBillTotal, actualBillTotal, 0.001);
    }
}

//   javac -cp "junit-platform-console-standalone-1.11.0.jar:." CheckOut.java CheckOutTest.java


//   java -jar junit-platform-console-standalone-1.11.0.jar --class-path . --select-class CheckOutTest