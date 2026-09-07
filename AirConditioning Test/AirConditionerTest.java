
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirConditionerTest {

    @Test
    public void testThatAirConditionerIsOffByDefault() {
        AirConditioner airConditioner = new AirConditioner();
        boolean expected = false;
        boolean actual = airConditioner.isOn();
        assertEquals(expected, actual);
    }

    @Test
    public void testThatAirConditionerCanBeTurnedOn() {
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        boolean expected = true;
        boolean actual = airConditioner.isOn();
        assertEquals(expected, actual);
    }

    @Test
    public void testThatAirConditionerCanBeTurnedOff() {
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        airConditioner.turnOff();
        boolean expected = false;
        boolean actual = airConditioner.isOn();
        assertEquals(expected, actual);
    }

    @Test
    public void testThatInitialTemperatureIsSixteen() {
        AirConditioner airConditioner = new AirConditioner();
        int expected = 16;
        int actual = airConditioner.getTemperature();
        assertEquals(expected, actual);
    }

    @Test
    public void testThatTemperatureIncreasesWhenOn() {
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        airConditioner.increaseTemperature();
        int expected = 17;
        int actual = airConditioner.getTemperature();
        assertEquals(expected, actual);
    }

    @Test
    public void testThatTemperatureDecreasesWhenOn() {
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        airConditioner.increaseTemperature();
        airConditioner.decreaseTemperature();
        int expected = 16;
        int actual = airConditioner.getTemperature();
        assertEquals(expected, actual);
    }

    @Test
    public void testThatTemperatureCannotExceedThirty() {
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        for (int index = 0; index < 20; index++) {
            airConditioner.increaseTemperature();
        }
        int expected = 30;
        int actual = airConditioner.getTemperature();
        assertEquals(expected, actual);
    }

    @Test
    public void testThatTemperatureCannotGoBelowSixteen() {
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        airConditioner.decreaseTemperature();
        int expected = 16;
        int actual = airConditioner.getTemperature();
        assertEquals(expected, actual);
    }

    @Test
    public void testThatTemperatureDoesNotIncreaseWhenOff() {
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.increaseTemperature();
        int expected = 16;
        int actual = airConditioner.getTemperature();
        assertEquals(expected, actual);
    }

    @Test
    public void testThatTemperatureDoesNotDecreaseWhenOff() {
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        airConditioner.increaseTemperature();
        airConditioner.turnOff();
        airConditioner.decreaseTemperature();
        int expected = 17;
        int actual = airConditioner.getTemperature();
        assertEquals(expected, actual);
    }
}
