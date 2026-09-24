import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLowestCommonMultiples {
    @Test
    public void testLowestCommonMultiple() {
        int[] numbers = {8, 10, 24};
        LowestCommonMultiples lcmCalculator = new LowestCommonMultiples(numbers);
        int result = lcmCalculator.calculateLcm();
        assertEquals(120, result);
    }
}

