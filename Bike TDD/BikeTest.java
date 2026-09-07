
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {

    @Test
    public void testTurnOnAndOff() {
        Bike bike = new Bike();

        bike.turnOn();
        assertTrue(bike.isBikeEngineOn());

        bike.turnOff();
        assertFalse(bike.isBikeEngineOn());
    }

    @Test
    public void testAccelerateGearOne() {
        Bike bike = new Bike();
        bike.turnOn();
        bike.setSpeed(15);

        bike.accelerate();

        int expected = 16;
        int actual = bike.getSpeed();
        assertEquals(expected, actual);
    }

    @Test
    public void testAccelerateGearTwo() {
        Bike bike = new Bike();
        bike.turnOn();
        bike.setSpeed(24);

        bike.accelerate();

        int expected = 26;
        int actual = bike.getSpeed();
        assertEquals(expected, actual);
    }

    @Test
    public void testAccelerateGearThree() {
        Bike bike = new Bike();
        bike.turnOn();
        bike.setSpeed(35);

        bike.accelerate();

        int expected = 38;
        int actual = bike.getSpeed();
        assertEquals(expected, actual);
    }

    @Test
    public void testAccelerateGearFour() {
        Bike bike = new Bike();
        bike.turnOn();
        bike.setSpeed(44);

        bike.accelerate();

        int expected = 48;
        int actual = bike.getSpeed();
        assertEquals(expected, actual);
    }

    @Test
    public void testDecelerateGearOne() {
        Bike bike = new Bike();
        bike.turnOn();
        bike.setSpeed(15);

        bike.decelerate();

        int expected = 14;
        int actual = bike.getSpeed();
        assertEquals(expected, actual);
    }

    @Test
    public void testDecelerateGearTwo() {
        Bike bike = new Bike();
        bike.turnOn();
        bike.setSpeed(24);

        bike.decelerate();

        int expected = 22;
        int actual = bike.getSpeed();
        assertEquals(expected, actual);
    }

    @Test
    public void testDecelerateGearThree() {
        Bike bike = new Bike();
        bike.turnOn();
        bike.setSpeed(35);

        bike.decelerate();

        int expected = 32;
        int actual = bike.getSpeed();
        assertEquals(expected, actual);
    }

    @Test
    public void testDecelerateGearFour() {
        Bike bike = new Bike();
        bike.turnOn();
        bike.setSpeed(44);

        bike.decelerate();

        int expected = 40;
        int actual = bike.getSpeed();
        assertEquals(expected, actual);
    }
}

// javac -cp "junit-platform-console-standalone-1.11.0.jar:." Bike.java BikeTest.java

// java -jar junit-platform-console-standalone-1.11.0.jar --class-path . --select-class BikeTest
